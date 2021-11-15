package com.verNANDo57.rulebook_educational;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.annotation.AnimRes;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.styleabletoast.StyleableToast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AppUtils {

    public static int PACKAGEMANAGER_GET_APP_VERISON_NAME = 2;
    public static int PACKAGEMANAGER_GET_APP_VERISON_CODE = 4;

    public static PackageInfo pInfo;

    public static String LOG_TAG = "RULEBOOK_APP";

    //Thanks to this method, we can read a text file
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * use this method to highlight a text in TextView
     *
     * @param tv              TextView or Edittext or Button (or derived from TextView)
     * @param textToHighlight Text to highlight
     */
    public static void setHighLightedText(TextView tv, String textToHighlight) {
        String tvt = tv.getText().toString();
        int ofe = tvt.indexOf(textToHighlight, 0);
        Spannable wordToSpan = new SpannableString(tv.getText());
        for (int ofs = 0; ofs < tvt.length() && ofe != -1; ofs = ofe + 1) {
            ofe = tvt.indexOf(textToHighlight, ofs);
            if (ofe == -1)
                break;
            else {
                // set color here
                wordToSpan.setSpan(new BackgroundColorSpan(0xFFFFFF00), ofe, ofe + textToHighlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                tv.setText(wordToSpan, TextView.BufferType.SPANNABLE);
            }
        }
    }

    public static void resetHighLightedText(TextView tv, String textToResetColor) {
        String tvt = tv.getText().toString();
        int ofe = tvt.indexOf(textToResetColor, 0);
        Spannable wordToSpan = new SpannableString(tv.getText());
        for (int ofs = 0; ofs < tvt.length() && ofe != -1; ofs = ofe + 1) {
            ofe = tvt.indexOf(textToResetColor, ofs);
            if (ofe == -1)
                break;
            else {
                // set color here
                wordToSpan.setSpan(new BackgroundColorSpan(0), ofe, ofe + textToResetColor.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                tv.setText(wordToSpan, TextView.BufferType.SPANNABLE);
            }
        }
    }

    public static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    public static int getIconWarning() {
        return R.drawable.ic_warning_outline;
    }

    /**
     * U can use this method to set animation to any view
     * firstly, u need to define your view, then animator_mode, then [Float] move value (optional)
     *
     * For example: If you wrote smth like this:
     *      setAnimatorToAnyView(yourview, to_right, 250)
     *
     * your view will move to right (to 250px right) from its current position
     */
    public static void setTranslateAnimation(View view, String mode) {
        switch (mode) {
            case "to_right": {
                TranslateAnimation animate = new TranslateAnimation(
                        view.getWidth(), 0, 0, 0);
                animate.setDuration(600);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
            case "to_left": {
                float mode_value_reference = view.getWidth() - (view.getWidth() * 2);

                TranslateAnimation animate = new TranslateAnimation(
                        mode_value_reference, 0, 0, 0);
                animate.setDuration(600);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
            case "to_bottom": {
                TranslateAnimation animate = new TranslateAnimation(
                        0, 0, 0, view.getHeight());
                animate.setDuration(250);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
            case "to_top": {
                TranslateAnimation animate = new TranslateAnimation(
                        0, 0, view.getHeight(), 0);
                animate.setDuration(250);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
        }
    }

    public static void setTranslateAnimation(View view, String mode, Float move_value) {
        switch (mode) {
            case "to_right": {
                TranslateAnimation animate = new TranslateAnimation(
                        move_value, 0, 0, 0);
                animate.setDuration(600);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
            case "to_left": {
                float mode_value_reference = move_value - (move_value * 2);

                TranslateAnimation animate = new TranslateAnimation(
                        mode_value_reference, 0, 0, 0);
                animate.setDuration(600);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
            case "to_bottom": {
                TranslateAnimation animate = new TranslateAnimation(
                        0, 0, 0, move_value);
                animate.setDuration(250);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
            case "to_top": {
                TranslateAnimation animate = new TranslateAnimation(
                        0, 0, move_value, 0);
                animate.setDuration(250);
                animate.setFillAfter(false);
                view.startAnimation(animate);
                break;
            }
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
        This simple method have been created for fetching app's info (VerisionName or VersionCode).
        It returns String, so his return value can be used instead of any string which defined in strings.xml and etc.

        For Example:
            anyTextView.setText(Utils.getApplicationVersionInfo( [CONTEXT] , PACKAGEMANAGER_GET_APP_VERISON_NAME);
        Or:
            anyTextView.setText(Utils.getApplicationVersionInfo( [CONTEXT] , PACKAGEMANAGER_GET_APP_VERISON_CODE);
        Or:
     */

    public static String getApplicationVersionInfo(Context context, int info_mode) {
        //Define output that will be used in the return statement
        String output_info = null;

        //Setup PackageInfo fetcher
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(AppUtils.LOG_TAG, context.getString(R.string.app_error_occured));
            e.printStackTrace();
        }

        //Grab Info
        if (info_mode==PACKAGEMANAGER_GET_APP_VERISON_NAME) {
            output_info=pInfo.versionName.toString();
        } else if (info_mode==PACKAGEMANAGER_GET_APP_VERISON_CODE)  {
            output_info=String.valueOf(pInfo.versionCode);
        }
        
        //Define return statement
        return output_info;
    }

    public static void copyTXTFileFromAssets (Context context, String filename, String outPreDir, String outDir, String outFileName, String outFileDir, String log_msg){
        AssetManager assetManager = context.getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);

            File preDirectory = new File(outPreDir);
            if (! preDirectory.exists()){
                preDirectory.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }

            File directory = new File(outDir);
            if (! directory.exists()){
                directory.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }

            File outFile = new File(outDir,  outFileName + ".txt");
            if (outFile.exists()){
                new StyleableToast.Builder(context)
                        .text(context.getString(R.string.app_saved_already) + ":" + outFileDir + outFileName + ".txt") // set text
                        .textBold() //set text bold
                        .iconStart(AppUtils.getIconWarning()) //icon in start of toast
                        .show(); //show custom toast
            } else {
                out = new FileOutputStream(outFile);
                AppUtils.copyFile(in, out);
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;

                new StyleableToast.Builder(context)
                        .text(context.getString(R.string.app_saved) + ":" + outFileDir + outFileName + ".txt") // set text
                        .textBold() //set text bold
                        .iconStart(AppUtils.getIconWarning()) //icon in start of toast
                        .show(); //show custom toast
            }

        } catch(IOException e) {
            Log.e(LOG_TAG, log_msg, e);

            new StyleableToast.Builder(context)
                    .text(context.getString(R.string.app_error_while_saving_file)) // set text
                    .textBold() //set text bold
                    .iconStart(AppUtils.getIconWarning()) //icon in start of toast
                    .show(); //show custom toast
        }
    }
}
