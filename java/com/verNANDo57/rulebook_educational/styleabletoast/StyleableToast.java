package com.verNANDo57.rulebook_educational.styleabletoast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.verNANDo57.rulebook_educational.for_pills.R;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;

import java.util.Objects;

/*
    int redColor = Color.parseColor("Your_color_or_import_from_res");
    Example:
    public void onClick (View v){
        new StyleableToast.Builder(this)
                    .text(toastMsg) // set text
                    .textBold() //set text bold
                    .textSize(18) //set text style
                    .cornerRadius(5) //set corner radius (as number)
                    .iconStart(getIcon()) //icon in start of toast
                    .iconEnd(getIcon()) //icon in end of toast
                    .stroke(2) //stroke
                    .show(); //show custom toast
    }

    public int getIcon() {
		return R.drawable.yourdrawable;
	}
 */

@SuppressLint("ViewConstructor")
public class StyleableToast extends LinearLayout {

    private int cornerRadius;
    private int backgroundColor;
    private int strokeWidth;
    private int iconStart;
    private int iconEnd;
    private int length;
    private int style;
    private float textSize;
    private boolean isTextSizeFromStyleXml = false;
    private boolean textBold;
    private String text;
    private TypedArray typedArray;
    private TextView textView;
    private int gravity;
    private Toast toast;
    private LinearLayout rootLayout;

    public static StyleableToast makeText(@NonNull Context context, String text, int length, @StyleRes int style) {
        return new StyleableToast(context, text, length, style);
    }

    public static StyleableToast makeText(@NonNull Context context, String text, @StyleRes int style) {
        return new StyleableToast(context, text, Toast.LENGTH_SHORT, style);
    }

    private StyleableToast(@NonNull Context context, String text, int length, @StyleRes int style) {
        super(context);
        this.text = text;
        this.length = length;
        this.style = style;
    }

    private StyleableToast(Builder builder) {
        super(builder.context);
        this.cornerRadius = builder.cornerRadius;
        this.iconEnd = builder.iconEnd;
        this.iconStart = builder.iconStart;
        this.strokeWidth = builder.strokeWidth;
        this.textSize = builder.textSize;
        this.textBold = builder.textBold;
        this.text = builder.text;
        this.gravity = builder.gravity;
        this.length = builder.length;
    }

    private void inflateToastLayout() {
        View v = inflate(getContext(), R.layout.styleable_layout, null);
        rootLayout = (LinearLayout) v.getRootView();
        textView = v.findViewById(R.id.textview);
        if (style > 0) {
            typedArray = getContext().obtainStyledAttributes(style, R.styleable.StyleableToast);
        }

        makeShape();
        makeTextView();
        makeIcon();

        // Very important to recycle AFTER the make() methods!
        if (typedArray != null) {
            typedArray.recycle();
        }
    }

    private void createAndShowToast() {
        inflateToastLayout();
        toast = new Toast(getContext());
        toast.setGravity(gravity, 0, gravity == Gravity.CENTER ? 0 : toast.getYOffset());
        toast.setDuration(length == Toast.LENGTH_LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.setView(rootLayout);
        toast.show();
    }

    public void show() {
        createAndShowToast();
    }


    public void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }


    private void makeShape() {
        loadShapeAttributes();
        GradientDrawable gradientDrawable = (GradientDrawable) rootLayout.getBackground().mutate();
        gradientDrawable.setAlpha(getResources().getInteger(R.integer.defaultBackgroundAlpha));

        if (cornerRadius > -1) {
            gradientDrawable.setCornerRadius(cornerRadius);
        }
        if (backgroundColor != 0) {
            gradientDrawable.setColor(backgroundColor);
        }

        rootLayout.setBackground(gradientDrawable);
    }

    private void makeTextView() {
        loadTextViewAttributes();
        textView.setText(text);
        if (textSize > 0) {
            textView.setTextSize(isTextSizeFromStyleXml ? 0 : TypedValue.COMPLEX_UNIT_SP, textSize);
        }
    }


    private void makeIcon() {
        loadIconAttributes();
        int paddingVertical = (int) getResources().getDimension(R.dimen.toast_vertical_padding);
        int paddingHorizontal1 = (int) getResources().getDimension(R.dimen.toast_horizontal_padding_icon_side);
        int paddingNoIcon = (int) getResources().getDimension(R.dimen.toast_horizontal_padding_empty_side);
        int iconSize = (int) getResources().getDimension(R.dimen.icon_size);

        if (iconStart != 0) {
            Drawable drawable = DrawableCompat.wrap(Objects.requireNonNull(ContextCompat.getDrawable(getContext(), iconStart)));
            DrawableCompat.setTint(drawable, getResources().getColor(R.color.styleable_toast_default_accent_color));
            if (drawable != null) {
                drawable.setBounds(0, 0, iconSize, iconSize);
                TextViewCompat.setCompoundDrawablesRelative(textView, drawable, null, null, null);
                if (Utils.isRTL()) {
                    rootLayout.setPadding(paddingNoIcon, paddingVertical, paddingHorizontal1, paddingVertical);
                } else {
                    rootLayout.setPadding(paddingHorizontal1, paddingVertical, paddingNoIcon, paddingVertical);
                }
            }
        }

        if (iconEnd != 0) {
            Drawable drawable = DrawableCompat.wrap(Objects.requireNonNull(ContextCompat.getDrawable(getContext(), iconEnd)));
            DrawableCompat.setTint(drawable, getResources().getColor(R.color.styleable_toast_default_accent_color));
            if (drawable != null) {
                drawable.setBounds(0, 0, iconSize, iconSize);
                TextViewCompat.setCompoundDrawablesRelative(textView, null, null, drawable, null);
                if (Utils.isRTL()) {
                    rootLayout.setPadding(paddingHorizontal1, paddingVertical, paddingNoIcon, paddingVertical);
                } else {
                    rootLayout.setPadding(paddingNoIcon, paddingVertical, paddingHorizontal1, paddingVertical);
                }
            }
        }

        if (iconStart != 0 && iconEnd != 0) {
            Drawable drawableLeft = ContextCompat.getDrawable(getContext(), iconStart);
            Drawable drawableRight = ContextCompat.getDrawable(getContext(), iconEnd);
            if (drawableLeft != null && drawableRight != null) {
                drawableLeft.setBounds(0, 0, iconSize, iconSize);
                drawableRight.setBounds(0, 0, iconSize, iconSize);
                textView.setCompoundDrawables(drawableLeft, null, drawableRight, null);
                rootLayout.setPadding(paddingHorizontal1, paddingVertical, paddingHorizontal1, paddingVertical);
            }
        }
    }

    /**
     * loads style attributes from styles.xml if a style resource is used.
     */
    private void loadShapeAttributes() {
        if (style == 0) {
            return;
        }

        backgroundColor = typedArray.getColor(R.styleable.StyleableToast_stColorBackground, ContextCompat.getColor(getContext(), R.color.styleable_toast_default_background_color));
        int defaultCornerRadius = (int) getResources().getDimension(R.dimen.default_corner_radius);
        cornerRadius = (int) typedArray.getDimension(R.styleable.StyleableToast_stRadius, defaultCornerRadius);
        length = typedArray.getInt(R.styleable.StyleableToast_stLength, 0);
        gravity = typedArray.getInt(R.styleable.StyleableToast_stGravity, Gravity.BOTTOM);

        if (gravity == 1) {
            gravity = Gravity.CENTER;
        } else if (gravity == 2) {
            gravity = Gravity.TOP;
        }

        if (typedArray.hasValue(R.styleable.StyleableToast_stStrokeWidth)) {
            strokeWidth = (int) typedArray.getDimension(R.styleable.StyleableToast_stStrokeWidth, 0);
        }
    }

    private void loadTextViewAttributes() {
        if (style == 0) {
            return;
        }

        textBold = typedArray.getBoolean(R.styleable.StyleableToast_stTextBold, false);
        textSize = typedArray.getDimension(R.styleable.StyleableToast_stTextSize, 0);
        isTextSizeFromStyleXml = textSize > 0;
    }


    private void loadIconAttributes() {
        if (style == 0) {
            return;
        }
        iconStart = typedArray.getResourceId(R.styleable.StyleableToast_stIconStart, 0);
        iconEnd = typedArray.getResourceId(R.styleable.StyleableToast_stIconEnd, 0);
    }

    public static class Builder {
        private int cornerRadius = -1;
        private int strokeWidth;
        private int iconStart;
        private int iconEnd;
        private int length;
        private float textSize;
        private boolean textBold;
        private String text;
        private int gravity = Gravity.BOTTOM;
        private final Context context;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder textBold() {
            this.textBold = true;
            return this;
        }

        public Builder textSize(float textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder stroke(int strokeWidth, @ColorInt int strokeColor) {
            this.strokeWidth = Utils.toDp(context, strokeWidth);
            return this;
        }

        /**
         * @param cornerRadius Sets the corner radius of the StyleableToast's shape.
         */
        public Builder cornerRadius(int cornerRadius) {
            this.cornerRadius = Utils.toDp(context, cornerRadius);
            return this;
        }

        public Builder iconStart(@DrawableRes int iconStart) {
            this.iconStart = iconStart;
            return this;
        }

        public Builder iconEnd(@DrawableRes int iconEnd) {
            this.iconEnd = iconEnd;
            return this;
        }

        /**
         * Sets where the StyleableToast will appear on the screen
         */
        public Builder gravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        /**
         * @param length {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}
         */
        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public void show() {
            StyleableToast toast = new StyleableToast(this);
            toast.show();
        }
    }
}
