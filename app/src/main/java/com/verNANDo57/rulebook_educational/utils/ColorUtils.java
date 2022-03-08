/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.utils;

import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

import java.text.DecimalFormat;

public final class ColorUtils {

    public ColorUtils() {
        throw new AssertionError("no instances");
    }

    @ColorInt
    public static int darker (@ColorInt int color) {
        @FloatRange(from = 0.0D,to = 1.0D) float factor = 0.85f;
        return Color.argb(Color.alpha(color), ((int) (Color.red(color) * factor)),
                ((int) (Color.green(color) * factor)),
                ((int) (Color.blue(color) * factor))
        );
    }

    @ColorInt
    public static int lighter(@ColorInt int color) {
        @FloatRange(from = 0.0, to = 1.0) float factor = 0.15f;
        int alpha = Color.alpha(color);
        int red = (int)(((float)Color.red(color) * ((float)1 - factor) / (float)255 + factor) * (float)255);
        int green = (int)(((float)Color.green(color) * ((float)1 - factor) / (float)255 + factor) * (float)255);
        int blue = (int)(((float)Color.blue(color) * ((float)1 - factor) / (float)255 + factor) * (float)255);
        return Color.argb(alpha, red, green, blue);
    }

    /**
     * Returns `true` if the luminance of the color is less than or equal to 0.5
     *
     * @param color The color to calculate the luminance.
     * @return `true` if the color is dark
     */
    public static boolean isDarkColor(@ColorInt int color) {
        return isDarkColor(color, 0.5);
    }

    /**
     * Returns `true` if the luminance of the color is less than or equal to the luminance factor
     *
     * @param color The color to calculate the luminance.
     * @param luminance Value from 0-1. 1 = white. 0 = black.
     * @return `true` if the color is dark
     */
    public static boolean isDarkColor(@ColorInt int color, @FloatRange(from = 0.0, to = 1.0) double luminance) {
        return androidx.core.graphics.ColorUtils.calculateLuminance(color) <= luminance;
    }

    /**
     * Returns `true` if the luminance of the color is less than or equal to the luminance factor
     *
     * @param color The color to calculate the luminance.
     * luminance Value from 0-1. 1 = white. 0 = black.
     * @return `true` if the color is light
     */
    public static boolean isLightColor(@ColorInt int color) {
        @FloatRange(from = 0.0, to = 1.0) double luminance = 0.5;
        return androidx.core.graphics.ColorUtils.calculateLuminance(color) >= luminance;
    }

    /**
     * Manipulate the alpha bytes of a color
     *
     * @param color The color to adjust the alpha on
     * @param factor 0.0f - 1.0f
     * @return The new color value
     */
    @ColorInt
    public static int adjustAlpha(@ColorInt int color, @FloatRange(from = 0.0, to = 1.0) float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }

    /**
     * Remove alpha from a color
     *
     * @param color The color to modify
     * @return The color without any transparency
     */
    @ColorInt
    public static int stripAlpha(@ColorInt int color) {
        return Color.rgb(Color.red(color), Color.green(color), Color.blue(color));
    }

    public final String toHex(@ColorInt int color, boolean alpha) {
        StringBuilder hexBuilder = new StringBuilder(new String("#"));
        if (alpha) {
            hexBuilder.append(String.format("%08X", (color)));
        } else {
            hexBuilder.append(String.format("%06X", 0xFFFFFF & color));
        }
        return hexBuilder.toString();
    }


    /**
     * Parse the color string, and return the corresponding color-int.
     * If the string cannot be parsed, throws an IllegalArgumentException
     * exception.
     */
    @ColorInt
    public static int parseColor(String colorString) {
        try {
            if (colorString.startsWith("#")) {
                return parseColor(colorString.substring(1));
            }

            int length = colorString.length();
            int a;
            int r;
            int g;
            int b = 0;

            if (length == 0) {
                r = 0;
                a = 255;
                g = 0;
            } else if (length <= 2) {
                a = 255;
                r = 0;
                b = Integer.parseInt(colorString, 16);
                g = 0;
            } else if (length == 3) {
                a = 255;
                r = Integer.parseInt(colorString.substring(0, 1), 16);
                g = Integer.parseInt(colorString.substring(1, 2), 16);
                b = Integer.parseInt(colorString.substring(2, 3), 16);
            } else if (length == 4) {
                a = 255;
                r = Integer.parseInt(colorString.substring(0, 2), 16);
                g = r;
                r = 0;
                b = Integer.parseInt(colorString.substring(2, 4), 16);
            } else if (length == 5) {
                a = 255;
                r = Integer.parseInt(colorString.substring(0, 1), 16);
                g = Integer.parseInt(colorString.substring(1, 3), 16);
                b = Integer.parseInt(colorString.substring(3, 5), 16);
            } else if (length == 6) {
                a = 255;
                r = Integer.parseInt(colorString.substring(0, 2), 16);
                g = Integer.parseInt(colorString.substring(2, 4), 16);
                b = Integer.parseInt(colorString.substring(4, 6), 16);
            } else if (length == 7) {
                a = Integer.parseInt(colorString.substring(0, 1), 16);
                r = Integer.parseInt(colorString.substring(1, 3), 16);
                g = Integer.parseInt(colorString.substring(3, 5), 16);
                b = Integer.parseInt(colorString.substring(5, 7), 16);
            } else if (length == 8) {
                a = Integer.parseInt(colorString.substring(0, 2), 16);
                r = Integer.parseInt(colorString.substring(2, 4), 16);
                g = Integer.parseInt(colorString.substring(4, 6), 16);
                b = Integer.parseInt(colorString.substring(6, 8), 16);
            } else {
                b = -1;
                g = -1;
                r = -1;
                a = -1;
            }
            return Color.argb(a, r, g, b);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return Color.parseColor(colorString);
        }
    }


    /**
     * Using these methods we can create color matrix.
     *
     * Here we transform six-centric number into a decimal using {@link Integer#parseInt(String, int)}
     * and then round it to hundredths using {@link DecimalFormat#format(double)}
     */
    public static float[] createColorMatrixFromHex(int colorFromResource) {
        String hex = Integer.toHexString(colorFromResource);

        float a = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(0, 2), 16) / 255.0f)); // Alpha (Transparency in percents) [First Two
        float r = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(2, 4), 16) / 255.0f)); // Red
        float g = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(4, 6), 16) / 255.0f)); // Green
        float b = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(6, 8), 16) / 255.0f)); // Blue

        // Now build a matrix using values from above
        return new float[]
                { r, 0, 0, 0, 0,
                  0, g, 0, 0, 0,
                  0, 0, b, 0, 0,
                  0, 0, 0, a, 0 };
    }

    public static float[] createColorMatrixFromHex(@NonNull String hex) {

        // Check if hashtag exist in input string
        if (hex.length() == 7) {
            // remove hashtag
            hex = hex.substring(1);
            // add missing pair of numbers responsible for transparency
            hex = "ff" + hex;
        } else if (hex.length() == 9) {
            // remove hashtag
            hex = hex.substring(1);
        }

        float a = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(0, 2), 16) / 255.0f)); // Alpha (Transparency in percents) [First Two
        float r = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(2, 4), 16) / 255.0f)); // Red
        float g = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(4, 6), 16) / 255.0f)); // Green
        float b = Float.parseFloat(new DecimalFormat("#.##").format(Integer.parseInt(hex.substring(6, 8), 16) / 255.0f)); // Blue

        // Now build a matrix using values from above
        return new float[]
                { r, 0, 0, 0, 0,
                  0, g, 0, 0, 0,
                  0, 0, b, 0, 0,
                  0, 0, 0, a, 0 };
    }
}
