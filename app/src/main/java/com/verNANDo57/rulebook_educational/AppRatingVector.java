/*
 * Author: sujithkanna
 * date: 2020/03/29
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2021/06/05
 */

package com.verNANDo57.rulebook_educational;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.verNANDo57.rulebook_educational.extradata.R;

public class AppRatingVector extends View {
    private int faceColor, eyesColor, mouthColor, tongueColor;
    private RectF faceBgOval, sadOval, neutralOval, slightHappyOval, happyOval, amazingOval, tongueOval, AwfulOval, AwfultongueOval;
    private Paint paint;
    float centerOffset, viewWidth, viewHeight, whatToDraw = 2, defaultRating, strokeWidth, eyeRadius;
    int currEyeLX, currEyeRX, currEyeY;

    ValueAnimator rightEyeAnimatorX, leftEyeAnimatorX, eyesAnimatorY;
    final long animationDuration = 300;

    public AppRatingVector(Context context) {
        super(context);
    }

    public AppRatingVector(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Initializing objects
        paint = new Paint();
        faceBgOval = new RectF();
        sadOval = new RectF();
        neutralOval = new RectF();
        slightHappyOval = new RectF();
        happyOval = new RectF();
        amazingOval = new RectF();
        AwfulOval = new RectF();
        AwfultongueOval = new RectF();
        tongueOval = new RectF();
        leftEyeAnimatorX = new ValueAnimator();
        rightEyeAnimatorX = new ValueAnimator();
        eyesAnimatorY = new ValueAnimator();

        //Getting attributes value
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AppRatingVector);
        try {
            faceColor = typedArray.getColor(R.styleable.AppRatingVector_face_color,
                    getResources().getColor(R.color.app_vector_rating_face_color));
            eyesColor = typedArray.getColor(R.styleable.AppRatingVector_eyes_color,
                    getResources().getColor(R.color.app_vector_rating_eyes_color));
            mouthColor = typedArray.getColor(R.styleable.AppRatingVector_mouth_color,
                    getResources().getColor(R.color.app_vector_rating_mouth_color));
            tongueColor = typedArray.getColor(R.styleable.AppRatingVector_tongue_color,
                    getResources().getColor(R.color.app_vector_rating_tongue_color));
            defaultRating = typedArray.getInteger(
                    R.styleable.AppRatingVector_default_rating, 2);
        } finally {
            typedArray.recycle();
        }
        whatToDraw = defaultRating;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewWidth = getMeasuredWidth();
        viewHeight = getMeasuredHeight();

        strokeWidth = viewHeight / 30 + viewWidth / 30;
        eyeRadius = viewHeight / 25 + viewWidth / 25;
        centerOffset = viewHeight / 3;

        switch ((int) whatToDraw) {
            case 1:
                currEyeLX = (int) ((viewWidth / 2) - (viewWidth / 100 * 25));
                currEyeRX = (int) ((viewWidth / 2) + (viewWidth / 100 * 25));
                currEyeY = (int) (viewHeight / 100 * 20);
                break;
            case 2:
                currEyeLX = (int) ((viewWidth / 2) - (viewWidth / 100 * 20));
                currEyeRX = (int) ((viewWidth / 2) + (viewWidth / 100 * 20));
                currEyeY = (int) (viewHeight / 100 * 20);
                break;
            case 3:
                currEyeLX = (int) ((viewWidth / 2) - (viewWidth / 100 * 17));
                currEyeRX = (int) ((viewWidth / 2) + (viewWidth / 100 * 17));
                currEyeY = (int) (viewHeight / 100 * 25);
                break;
            case 4:
                currEyeLX = (int) ((viewWidth / 2) - (viewWidth / 100 * 19));
                currEyeRX = (int) ((viewWidth / 2) + (viewWidth / 100 * 19));
                currEyeY = (int) (viewHeight / 100 * 22);
                break;
            case 5:
                currEyeLX = (int) ((viewWidth / 2) - (viewWidth / 100 * 23));
                currEyeRX = (int) ((viewWidth / 2) + (viewWidth / 100 * 23));
                currEyeY = (int) (viewHeight / 100 * 23);
                break;
        }

        faceBgOval.set(-centerOffset, -viewHeight, viewWidth + centerOffset, viewHeight);

        sadOval.set((viewWidth / 2) - (viewWidth / 100 * 25), viewHeight - (viewHeight / 100 * 45),
                (viewWidth / 2) + (viewWidth / 100 * 25), viewHeight - (viewHeight / 100 * 10));

        neutralOval.set((viewWidth / 2) - (viewWidth / 100) * 30,
         viewHeight - (viewHeight / 100) * 40,
        (viewWidth / 2) + (viewWidth / 100) * 30,
        viewHeight - (viewHeight / 100) * 40);

        slightHappyOval.set((viewWidth / 2) - (viewWidth / 100 * 30), viewHeight - (viewHeight / 100 * 60),
                (viewWidth / 2) + (viewWidth / 100 * 30), viewHeight - (viewHeight / 100 * 20));

        happyOval.set((viewWidth / 2) - (viewWidth / 100 * 35), viewHeight - (viewHeight / 100 * 90),
                (viewWidth / 2) + (viewWidth / 100 * 35), viewHeight - (viewHeight / 100 * 20));

        amazingOval.set((viewWidth / 2) - (viewWidth / 100 * 35), viewHeight - (viewHeight / 100 * 90),
                (viewWidth / 2) + (viewWidth / 100 * 35), viewHeight - (viewHeight / 100 * 15));

        tongueOval.set((viewWidth / 2) - (viewWidth / 100 * 20), viewHeight - (viewHeight / 100 * 60),
                (viewWidth / 2) + (viewWidth / 100 * 20), viewHeight - (viewHeight / 100 * 20));

        AwfulOval.set((viewWidth / 2) - (viewWidth / 100 * 35), viewHeight - (viewHeight / 175 * 90),
                (viewWidth / 2) + (viewWidth / 100 * 35), viewHeight - (viewHeight / 1000 * 15));

        AwfultongueOval.set((viewWidth / 2) - (viewWidth / 100 * 15), viewHeight - (viewHeight / 100 * 44),
                (viewWidth / 2) + (viewWidth / 100 * 15), viewHeight - (viewHeight / 100 * 24));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Draw face BG
        paint.setColor(faceColor);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(faceBgOval, 0, 180, true, paint);


        switch ((int) whatToDraw) {
            case 0:
            case 1:
                drawSadFace(canvas);
                break;
            case 2:
                drawNeutralFace(canvas);
                break;
            case 3:
                drawSlightSmileFace(canvas);
                break;
            case 4:
                drawHappyFace(canvas);
                break;
            case 5:
                drawAmazingFace(canvas);
                break;
        }
    }

    private void drawSadFace(Canvas canvas) {
        //Draw Eyes
        paint.setColor(eyesColor);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(currEyeLX, currEyeY, eyeRadius, paint);
        canvas.drawCircle(currEyeRX, currEyeY, eyeRadius, paint);

        //Draw mouth
        paint.setColor(mouthColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(sadOval, 0, -180, false, paint);

    }

    private void drawNeutralFace(Canvas canvas) {

        //Draw Eyes
        paint.setColor(eyesColor);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(currEyeLX, currEyeY, eyeRadius, paint);
        canvas.drawCircle(currEyeRX, currEyeY, eyeRadius, paint);


        //Draw mouth
        paint.setColor(mouthColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        //canvas.drawArc(neutralOval, 0, 180, false, paint);
        canvas.drawLine((viewWidth / 2) - (viewWidth / 100) * 30,
                viewHeight - (viewHeight / 100) * 30,
                (viewWidth / 2) + (viewWidth / 100) * 30,
                viewHeight - (viewHeight / 100) * 30,paint);

    }

    private void drawSlightSmileFace(Canvas canvas) {

        //Draw Eyes
        paint.setColor(eyesColor);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(currEyeLX, currEyeY, eyeRadius, paint);
        canvas.drawCircle(currEyeRX, currEyeY, eyeRadius, paint);

        //Draw mouth
        paint.setColor(mouthColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(slightHappyOval, 0, 180, false, paint);

    }

    private void drawHappyFace(Canvas canvas) {

        //Draw Eyes
        paint.setColor(eyesColor);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(currEyeLX, currEyeY, eyeRadius, paint);
        canvas.drawCircle(currEyeRX, currEyeY, eyeRadius, paint);

        //Draw mouth
        paint.setColor(mouthColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(happyOval, 0, 180, false, paint);

    }

    private void drawAmazingFace(Canvas canvas) {

        //Draw Eyes
        paint.setColor(eyesColor);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(currEyeLX, currEyeY, eyeRadius, paint);
        canvas.drawCircle(currEyeRX, currEyeY, eyeRadius, paint);


        //Draw mouth
        paint.setColor(mouthColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(amazingOval, 0, 180, true, paint);

        //Draw tongue
        paint.setColor(tongueColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(tongueOval, 0, 180, true, paint);

    }

    public void setSmiley(float rating) {
        switch ((int) rating) {
            case 0:
            case 1:
                whatToDraw = 1;
                startEyesAnimation((viewWidth / 2) - (viewWidth / 100 * 25),
                        (viewWidth / 2) + (viewWidth / 100 * 25),
                        (viewHeight / 100 * 20));
                break;
            case 2:
                whatToDraw = 2;
                startEyesAnimation((viewWidth / 2) - (viewWidth / 100 * 20),
                        (viewWidth / 2) + (viewWidth / 100 * 20),
                        (viewHeight / 100 * 20));
                break;
            case 3:
                whatToDraw = 3;
                startEyesAnimation((viewWidth / 2) - (viewWidth / 100 * 17),
                        (viewWidth / 2) + (viewWidth / 100 * 17),
                        (viewHeight / 100 * 25));
                break;
            case 4:
                whatToDraw = 4;
                startEyesAnimation((viewWidth / 2) - (viewWidth / 100 * 19),
                        (viewWidth / 2) + (viewWidth / 100 * 19),
                        (viewHeight / 100 * 22));
                break;
            case 5:
                whatToDraw = 5;
                startEyesAnimation((viewWidth / 2) - (viewWidth / 100 * 23),
                        (viewWidth / 2) + (viewWidth / 100 * 23),
                        (viewHeight / 100 * 23));
                break;
        }
    }

    private void startEyesAnimation(float... newPositions) {

        leftEyeAnimatorX.setIntValues(currEyeLX, (int) newPositions[0]);
        leftEyeAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currEyeLX = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        rightEyeAnimatorX.setIntValues(currEyeRX, (int) newPositions[1]);
        rightEyeAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currEyeRX = (int) animation.getAnimatedValue();
            }
        });
        eyesAnimatorY.setIntValues(currEyeY, (int) newPositions[2]);
        eyesAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currEyeY = (int) animation.getAnimatedValue();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(animationDuration);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(rightEyeAnimatorX, leftEyeAnimatorX, eyesAnimatorY);
        animatorSet.start();
    }

}
