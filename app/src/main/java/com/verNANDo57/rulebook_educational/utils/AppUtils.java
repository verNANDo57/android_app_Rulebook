/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.annotation.AnimRes;

import com.google.android.material.snackbar.Snackbar;
import com.verNANDo57.rulebook_educational.extradata.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class AppUtils {

    public static int PACKAGEMANAGER_GET_APP_VERISON_NAME = 0;
    public static int PACKAGEMANAGER_GET_APP_VERISON_CODE = 1;

    public static PackageInfo pInfo;

    public static String LOG_TAG = "RULEBOOK_APP";
    public static String EXTRA_DATA_KEY = "rule_key";
    public static String EXTRA_DATA_POSITION = "rule_position";
    public static String EXTRA_DATA_TITLE = "rule_title";
    public static String EXTRA_DATA_SUMMARY = "rule_summary";

    // Thanks to this function, we can read a text file
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * Use this function to highlight a text in TextView
     *
     * @param tv              TextView or Edittext or Button (or derived from TextView)
     * @param textToHighlight Text to highlight
     */
    public static void setHighLightedText(Context context, TextView tv, String textToHighlight) {
        String tvt = tv.getText().toString();
        int ofe = tvt.indexOf(textToHighlight);
        Spannable wordToSpan = new SpannableString(tv.getText());
        for (int ofs = 0; ofs < tvt.length() && ofe != -1; ofs = ofe + 1) {
            ofe = tvt.indexOf(textToHighlight, ofs);
            if (ofe == -1)
                break;
            else {
                // Set background color
                wordToSpan.setSpan(new BackgroundColorSpan(context.getResources().getColor(R.color.app_text)), ofe, ofe + textToHighlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                // Set foreground color
                wordToSpan.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.app_custom_background)), ofe, ofe + textToHighlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                // Apply changes
                tv.setText(wordToSpan, TextView.BufferType.SPANNABLE);
            }
        }
    }

    /**
     * Use this function to reset text color in TextView
     *
     * @param tv               TextView or Edittext or Button (or derived from TextView)
     * @param textToResetColor Text to reset
     */
    public static void resetHighLightedText(Context context, TextView tv, String textToResetColor) {
        String tvt = tv.getText().toString();
        int ofe = tvt.indexOf(textToResetColor);
        Spannable wordToSpan = new SpannableString(tv.getText());
        for (int ofs = 0; ofs < tvt.length() && ofe != -1; ofs = ofe + 1) {
            ofe = tvt.indexOf(textToResetColor, ofs);
            if (ofe == -1)
                break;
            else {
                // Reset background color
                wordToSpan.setSpan(new BackgroundColorSpan(0), ofe, ofe + textToResetColor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                // Reset foreground color
                wordToSpan.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.app_text)), ofe, ofe + textToResetColor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                // Apply changes
                tv.setText(wordToSpan, TextView.BufferType.SPANNABLE);
            }
        }
    }

    /**
     * Using this function we can copy files (uses java.nio)
     *
     * @param sourceFile is the file that will be copied
     * @param destinationFile is the copy of sourceFile
     * @throws IOException - for cases when something interrupts the process
     */
    public static void copyFileUsingNIO(File sourceFile, File destinationFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(destinationFile);
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            inChannel.close();
            outChannel.close();
            inputStream.close();
            outputStream.close();
        }
    }

    public static void copyFileFromAssets(Context context, View rootView, String inputFileDir, String inputFile, String outputFileDir, String outputFile, boolean useSDCard) {
        try {
            // Create output dir if needed
            new File(getStorageAbsolutePath(context, useSDCard) + outputFileDir).mkdirs();
            // Initialize output file
            File output = new File(getStorageAbsolutePath(context, useSDCard) + outputFileDir + outputFile);
            if (!output.exists()) {
                InputStream in;
                OutputStream out;
                in = context.getAssets().open(inputFileDir + inputFile);
                out = new FileOutputStream(output);

                byte[] buffer = new byte[1024];
                int read;
                while((read = in.read(buffer)) != -1){
                    out.write(buffer, 0, read);
                }

                Snackbar.make(rootView, context.getString(R.string.app_saved) + ":" + output.getAbsolutePath(), Snackbar.LENGTH_LONG).show();

                out.flush();
                out.close();
            } else {
                Snackbar.make(rootView, context.getString(R.string.app_saved_already) + ":" + output.getAbsolutePath(), Snackbar.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(LOG_TAG, context.getResources().getString(R.string.app_error_while_saving_file), e);
            Snackbar.make(rootView, context.getString(R.string.app_error_while_saving_file), Snackbar.LENGTH_LONG).show();
        }
    }

    /* Using this function we can get storage absolute path */
    public static String getStorageAbsolutePath(Context context, boolean useSDCard) {
        // Works on API 24+
        File[] dirs = context.getExternalFilesDirs(null);
        StringBuilder outputStorage;
        int slashCount;

        // Firstly, check if SDCard exist, to avoid issues
        if (checkIfSDCardExists() && useSDCard) {
            // Use SDCard if user wants to
            outputStorage = new StringBuilder(dirs[1].getAbsolutePath());
            slashCount = 2;
        } else {
            outputStorage = new StringBuilder(dirs[0].getAbsolutePath());
            slashCount = 3;
        }

        // Process
        int charsCounter = outputStorage.length();
        int slashCounter = getCharCount(outputStorage, '/');

        for (int i=1;slashCounter!=slashCount;i++) {
            if(outputStorage.charAt(charsCounter - i) == '/') {
                slashCounter = slashCounter - 1;
            }
            outputStorage.deleteCharAt(charsCounter-i);
        }

        return outputStorage.toString();
    }

    /* Using this function we can check, if SDCard is inserted */
    public static boolean checkIfSDCardExists() {
        return Environment.isExternalStorageRemovable() && Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /* Using this function we can remove all files inside one folder */
    public static void removeFolderRecursive(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            for (File child : Objects.requireNonNull(dir.listFiles())) {
                removeFolderRecursive(child);
            }
        }
        dir.delete();
    }

    /* Using these functions we can remove last line of any text file */
    public static void removeLastLine(String name) throws IOException {
        RandomAccessFile f = new RandomAccessFile(name, "rw");
        long length = f.length() - 1;
        byte b;
        do {
            length -= 1;
            f.seek(length);
            b = f.readByte();
        } while(b != 10 && length > 0);
        if (length == 0) {
            f.setLength(length);
        } else {
            f.setLength(length + 1);
        }
        f.close();
    }

    public static void removeLastLine(File file) throws IOException {
        RandomAccessFile f = new RandomAccessFile(file, "rw");
        long length = f.length() - 1;
        byte b;
        do {
            length -= 1;
            f.seek(length);
            b = f.readByte();
        } while(b != 10 && length > 0);
        f.setLength(length);
        f.close();
    }

    /* This function uses BufferedReader to read line by line and increases the count. */
    public static long countLineBufferedReader(File fileName) throws IOException {
        long lines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
    }

    /* Using these functions we can count occurrences of a char in a string */
    public static int getCharCount(String text, char someChar) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == someChar) {
                count++;
            }
        }
        return count;
    }

    public static int getCharCount(StringBuilder stringBuilder, char someChar) {
        int count = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == someChar) {
                count++;
            }
        }
        return count;
    }

    /**
     * U can use this function to set animation to any view
     * firstly, u need to define your view, then animator_mode, then [Float] move value (optional)
     */
    public static int TRANSLATE_DIRECTION_RIGHT = 1;
    public static int TRANSLATE_DIRECTION_LEFT = 2;
    public static int TRANSLATE_DIRECTION_BOTTOM = 3;
    public static int TRANSLATE_DIRECTION_TOP = 4;
    public static void setTranslateAnimation(View view, int mode) {
        if (mode == TRANSLATE_DIRECTION_RIGHT) {
            TranslateAnimation animate = new TranslateAnimation(
                    view.getWidth(), 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        } else if (mode == TRANSLATE_DIRECTION_LEFT) {
            float mode_value_reference = view.getWidth() - (view.getWidth() * 2);

            TranslateAnimation animate = new TranslateAnimation(
                    mode_value_reference, 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        } else if (mode == TRANSLATE_DIRECTION_BOTTOM) {
            TranslateAnimation animate = new TranslateAnimation(
                    0, 0, 0, view.getHeight());
            animate.setDuration(250);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        } else if (mode == TRANSLATE_DIRECTION_TOP) {
            TranslateAnimation animate = new TranslateAnimation(
                    0, 0, view.getHeight(), 0);
            animate.setDuration(250);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        }
    }

    public static void setTranslateAnimation(View view, int mode, Float move_value) {
        if (mode == TRANSLATE_DIRECTION_RIGHT) {
            TranslateAnimation animate = new TranslateAnimation(
                    move_value, 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        } else if (mode == TRANSLATE_DIRECTION_LEFT) {
            float mode_value_reference = move_value - (move_value * 2);

            TranslateAnimation animate = new TranslateAnimation(
                    mode_value_reference, 0, 0, 0);
            animate.setDuration(600);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        } else if (mode == TRANSLATE_DIRECTION_BOTTOM) {
            TranslateAnimation animate = new TranslateAnimation(
                    0, 0, 0, move_value);
            animate.setDuration(250);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        } else if (mode == TRANSLATE_DIRECTION_TOP) {
            TranslateAnimation animate = new TranslateAnimation(
                    0, 0, move_value, 0);
            animate.setDuration(250);
            animate.setFillAfter(false);
            view.startAnimation(animate);
        }
    }

    public static void setAnimationToViewFromResources(Context context, View view, @AnimRes int anim_file) {
        Animation animation = AnimationUtils.loadAnimation(context, anim_file);
        view.startAnimation(animation);
    }

    public static float dpToPx(Context context, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    /**
     *  This simple function have been created for fetching app's info (VerisionName or VersionCode).
     *  It returns String, so his return value can be used instead of any string which defined in strings.xml and etc.
     *
     *  For Example:
     *      anyTextView.setText(Utils.getApplicationVersionInfo( [CONTEXT] , PACKAGEMANAGER_GET_APP_VERISON_NAME);
     *  Or:
     *     anyTextView.setText(Utils.getApplicationVersionInfo( [CONTEXT] , PACKAGEMANAGER_GET_APP_VERISON_CODE);
     *
     * @param context - ApplicationContext is needed for fetching app information
     * @param info_mode - Using this parameter we can choose between app version code and app version name
     * @return - returns version code or version name as a string
     */
    public static String getApplicationVersionInfo(Context context, int info_mode) {
        //Define output that will be used in the return statement
        String output_info = null;

        //Setup PackageInfo fetcher
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(AppUtils.LOG_TAG, context.getString(R.string.app_error_occurred));
            e.printStackTrace();
        }

        //Grab Info
        if (info_mode==PACKAGEMANAGER_GET_APP_VERISON_NAME) {
            output_info=pInfo.versionName;
        } else if (info_mode==PACKAGEMANAGER_GET_APP_VERISON_CODE)  {
            output_info=String.valueOf(pInfo.versionCode);
        }
        
        //Define return statement
        return output_info;
    }

    /**
     * @param context
     *
     * Using this function we can find out which theme is being used.
     * This method is needed because of DayNight engine.
     * Since user can use FOLLOW_SYSTEM or AUTO_BATTERY option, we can't just use AppCompatDelegate to find out which theme is being used.
     *
     * Returns TRUE if dark theme is being used, otherwise it returns FALSE.
     */
    public static boolean darkModeIsEnabled(Context context) {
        switch (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                return true;
            case Configuration.UI_MODE_NIGHT_NO:
                return false;
        }
        return false;
    }

    /**
     * Using this function we can calculate available number of columns, given a desired column width.
     * @param context - needed for getting display metrics
     * @param columnWidthDp - column width dp 0_o
     * @return - returns number of columns as integer
     */
    public static int calculateNumberOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (screenWidthDp / columnWidthDp + 0.5);
    }

    /**
     * Using this function we can take full screenshot of view (using bitmap)
     * @param context - Context
     * @param height - height of view
     * @param width - width of view
     * @param view - view we want take a screenshot of
     *
     * @return the bmp file
     */
    public static Bitmap getBitmapFromView(Context context, View view, int height, int width) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(context.getResources().getColor(R.color.app_custom_background));
        }
        view.draw(canvas);
        return bitmap;
    }
}
