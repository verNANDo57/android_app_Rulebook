/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.image;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class AsyncDrawableLoaderNoOp extends AsyncDrawableLoader {
    @Override
    public void load(@NonNull AsyncDrawable drawable) {

    }

    @Override
    public void cancel(@NonNull AsyncDrawable drawable) {

    }

    @Nullable
    @Override
    public Drawable placeholder(@NonNull AsyncDrawable drawable) {
        return null;
    }
}
