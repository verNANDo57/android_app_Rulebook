package com.verNANDo57.rulebook_educational.usefulclasses;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;

import com.verNANDo57.rulebook_educational.BottomNavBetweenActivitiesFragment;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AppSomeUtils extends CustomThemeEngineAppCompatActivity {

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
    public static void setAnimatorToAnyView(View view, String mode) {
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

    public static void setAnimatorToAnyView(View view, String mode, Float move_value) {
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


    /**
     * There are 18 PorterDuff modes:
     *  SRC_IN, SRC, ADD, CLEAR, DARKEN, LIGHTEN, DST, DST_ATOP, DST_OUT, DST_IN, DST_OVER,
     *  MULTIPLY, OVERLAY, SCREEN, XOR, SRC_OUT, SRC_OVER, SRC_ATOP
     *
     * Usage:
     *  setColorFilterToDrawable (your_drawable, filter_mode, your_color);
     * or:
     *  setColorFilterToDrawable (your_imageview, filter_mode, your_color);
     * or:
     *  setColorFilterToDrawable(your_imagebutton, filter_mode, your_color);
     *
     * For example:
     *  setColorFilterToDrawable(mDrawable, SRC_IN, ContextCompat.getColor(this, R.color.coloraccent));
     * or:
     *  setColorFilterToDrawable(mDrawable, SRC_IN, #FFFFFF);
     */
    public static void setColorFilterToDrawable(Drawable drawable, String filter_mode, @ColorInt int custom_color){
        switch (filter_mode) {
            case "SRC_IN":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.SRC_IN);
                break;
            case "SRC":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.SRC);
                break;
            case "ADD":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.ADD);
                break;
            case "CLEAR":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.CLEAR);
                break;
            case "DARKEN":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.DARKEN);
                break;
            case "DST":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.DST);
                break;
            case "DST_ATOP":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.DST_ATOP);
                break;
            case "DST_IN":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.DST_IN);
                break;
            case "DST_OVER":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.DST_OVER);
                break;
            case "DST_OUT":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.DST_OUT);
                break;
            case "LIGHTEN":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.LIGHTEN);
                break;
            case "MULTIPLY":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.MULTIPLY);
                break;
            case "OVERLAY":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.OVERLAY);
                break;
            case "SCREEN":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.SCREEN);
                break;
            case "XOR":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.XOR);
                break;
            case "SRC_ATOP":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.SRC_ATOP);
                break;
            case "SRC_OVER":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.SRC_OVER);
                break;
            case "SRC_OUT":
                drawable.setColorFilter(custom_color, PorterDuff.Mode.SRC_OUT);
                break;
        }
    }

    public static void setColorFilterToDrawable(ImageButton imageButton, String filter_mode, @ColorInt int custom_color){
        switch (filter_mode) {
            case "SRC_IN":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.SRC_IN);
                break;
            case "SRC":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.SRC);
                break;
            case "ADD":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.ADD);
                break;
            case "CLEAR":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.CLEAR);
                break;
            case "DARKEN":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.DARKEN);
                break;
            case "DST":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.DST);
                break;
            case "DST_ATOP":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.DST_ATOP);
                break;
            case "DST_IN":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.DST_IN);
                break;
            case "DST_OVER":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.DST_OVER);
                break;
            case "DST_OUT":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.DST_OUT);
                break;
            case "LIGHTEN":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.LIGHTEN);
                break;
            case "MULTIPLY":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.MULTIPLY);
                break;
            case "OVERLAY":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.OVERLAY);
                break;
            case "SCREEN":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.SCREEN);
                break;
            case "XOR":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.XOR);
                break;
            case "SRC_ATOP":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.SRC_ATOP);
                break;
            case "SRC_OVER":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.SRC_OVER);
                break;
            case "SRC_OUT":
                imageButton.setColorFilter(custom_color, PorterDuff.Mode.SRC_OUT);
                break;
        }
    }

    public static void setColorFilterToDrawable(ImageView imageView, String filter_mode, @ColorInt int custom_color){
        switch (filter_mode) {
            case "SRC_IN":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.SRC_IN);
                break;
            case "SRC":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.SRC);
                break;
            case "ADD":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.ADD);
                break;
            case "CLEAR":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.CLEAR);
                break;
            case "DARKEN":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.DARKEN);
                break;
            case "DST":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.DST);
                break;
            case "DST_ATOP":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.DST_ATOP);
                break;
            case "DST_IN":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.DST_IN);
                break;
            case "DST_OVER":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.DST_OVER);
                break;
            case "DST_OUT":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.DST_OUT);
                break;
            case "LIGHTEN":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.LIGHTEN);
                break;
            case "MULTIPLY":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.MULTIPLY);
                break;
            case "OVERLAY":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.OVERLAY);
                break;
            case "SCREEN":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.SCREEN);
                break;
            case "XOR":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.XOR);
                break;
            case "SRC_ATOP":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.SRC_ATOP);
                break;
            case "SRC_OVER":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.SRC_OVER);
                break;
            case "SRC_OUT":
                imageView.setColorFilter(custom_color, PorterDuff.Mode.SRC_OUT);
                break;
        }
    }
}
