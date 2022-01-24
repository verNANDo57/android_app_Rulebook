/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.image;

import android.graphics.Rect;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.MarkwonConfiguration;

/**
 * @see ImageSizeResolverDef
 * @see MarkwonConfiguration.Builder#imageSizeResolver(ImageSizeResolver)
 * @since 1.0.1
 */
public abstract class ImageSizeResolver {

    /**
     * @since 4.0.0
     */
    @NonNull
    public abstract Rect resolveImageSize(@NonNull AsyncDrawable drawable);
}
