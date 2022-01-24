/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.bookmarks;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;

import android.content.Context;
import android.util.Log;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.styleabletoast.StyleableToast;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppBookmarkUtils {

    public static String JSON_FILE = "app_bookmarks.json";
    public static String JSON_OBJECT_KEY = "object_key";
    public static String JSON_OBJECT_TITLE = "object_title";
    public static String JSON_OBJECT_SUMMARY = "object_summary";

    private static void modifyJson(Context context) throws IOException {
        File fileToBeModified = new File(context.getApplicationContext().getFilesDir(), JSON_FILE);
        StringBuilder oldContent = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            String line = reader.readLine();
            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }

            StringBuilder stringBuilder = new StringBuilder(oldContent.toString());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String newContent = stringBuilder.toString();

            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } finally {
            assert reader != null;
            assert writer != null;
            reader.close();
            writer.close();
        }
    }

    private static void finalCheck(Context context, File inputFile) throws IOException {
        File tempFile2 = new File(context.getApplicationContext().getFilesDir(), "temp2_" + JSON_FILE);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile2));
        String line;

        int counter = 0;
        while ((line = reader.readLine()) != null) {
            counter++;
            if (counter == (AppUtils.countLineBufferedReader(inputFile) - 1) && AppUtils.getCharCount(line, ',') == 3) {
                StringBuilder stringBuilder = new StringBuilder(line);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                printWriter.println(stringBuilder);
            } else {
                printWriter.println(line);
            }
            printWriter.flush();
        }
        reader.close();
        printWriter.close();

        //Delete the original file
        if (!inputFile.delete()) {
            Log.e(LOG_TAG, context.getResources().getString(R.string.app_error_file_delete));
            return;
        }

        //Rename the new file to the filename the original file had.
        if (!tempFile2.renameTo(inputFile)) {
            Log.e(LOG_TAG, context.getResources().getString(R.string.app_error_file_rename));
        }
    }

    private static JSONObject generateJSONObject (String object_key, String object_title, String object_summary) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_OBJECT_KEY, object_key);
        jsonObject.put(JSON_OBJECT_TITLE, object_title);
        jsonObject.put(JSON_OBJECT_SUMMARY, object_summary);
        return jsonObject;
    }

    public static void addBookmark (Context context, String object_key, String object_title, String object_summary) throws IOException, JSONException {
        File jsonFile = new File(context.getApplicationContext().getFilesDir(), JSON_FILE);

        if (!jsonFile.exists()) {
            FileWriter writer = new FileWriter(jsonFile);
            writer.write("[" + "\n" + generateJSONObject(object_key, object_title, object_summary).toString() + "\n" + "]");
            writer.close();
        } else {
            FileWriter writer2 = new FileWriter(jsonFile, true);
            AppUtils.removeLastLine(jsonFile);
            if (AppUtils.countLineBufferedReader(jsonFile) < 2) {
                writer2.append("\n").append(generateJSONObject(object_key, object_title, object_summary).toString()).append("\n").append("]");
            } else {
                modifyJson(context);
                writer2.append("," + "\n").append(generateJSONObject(object_key, object_title, object_summary).toString()).append("\n").append("]");
            }

            writer2.close();
        }

        new StyleableToast.Builder(context)
                .text(context.getString(R.string.app_bookmark_added))
                .textBold()
                .iconStart(AppUtils.getIconWarning())
                .show();
    }

    public static void removeBookmark (Context context, String object_key, String object_title, String object_summary) throws IOException, JSONException {
        File inputFile = new File(context.getApplicationContext().getFilesDir(), JSON_FILE);
        if (!inputFile.isFile()) {
            Log.e(LOG_TAG, context.getResources().getString(R.string.app_error_file));
            return;
        }
        //Construct the new file that will later be renamed to the original filename.
        File tempFile = new File(context.getApplicationContext().getFilesDir(), "temp_" + JSON_FILE);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line;

        //Read from the original file and write to the new
        //unless content matches data to be removed.
        while ((line = br.readLine()) != null) {
            if (!line.contains(generateJSONObject(object_key, object_title, object_summary).toString())) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.close();
        br.close();

        //Delete the original file
        if (!inputFile.delete()) {
            Log.e(LOG_TAG, context.getResources().getString(R.string.app_error_file_delete));
            return;
        }

        finalCheck(context, tempFile);

        //Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(inputFile)) {
            Log.e(LOG_TAG, context.getResources().getString(R.string.app_error_file_rename));
            return;
        }

        new StyleableToast.Builder(context)
                .text(context.getString(R.string.app_bookmark_removed))
                .textBold()
                .iconStart(AppUtils.getIconWarning())
                .show();
    }

    public static boolean checkIfBookmarkExist (Context context, String object_key) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(context.getApplicationContext().getFilesDir(), JSON_FILE)));
        String line;
        boolean output = false;
        while ((line = reader.readLine()) != null) {
            if (line.contains(object_key)) {
                output = true;
            }
        }
        reader.close();
        return output;
    }
}
