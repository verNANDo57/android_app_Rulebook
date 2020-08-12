package com.verNANDo57.rulebook_educational.libs.nineoldandroids.animation;

/**
 * Interface for use with the {@link ValueAnimator#setEvaluator(TypeEvaluator)} function. Evaluators
 * allow developers to create animations on arbitrary property types, by allowing them to supply
 * custom evaulators for types that are not automatically understood and used by the animation
 * system.
 *
 * @see ValueAnimator#setEvaluator(TypeEvaluator)
 */
public interface TypeEvaluator<T> {

    /**
     * This function returns the result of linearly interpolating the start and end values, with
     * <code>fraction</code> representing the proportion between the start and end values. The
     * calculation is a simple parametric calculation: <code>result = x0 + t * (v1 - v0)</code>,
     * where <code>x0</code> is <code>startValue</code>, <code>x1</code> is <code>endValue</code>,
     * and <code>t</code> is <code>fraction</code>.
     *
     * @param fraction   The fraction from the starting to the ending values
     * @param startValue The start value.
     * @param endValue   The end value.
     * @return A linear interpolation between the start and end values, given the
     *         <code>fraction</code> parameter.
     */
    public T evaluate(float fraction, T startValue, T endValue);

}