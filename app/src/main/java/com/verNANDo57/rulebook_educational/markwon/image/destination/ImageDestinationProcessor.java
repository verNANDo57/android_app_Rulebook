/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.image.destination;

import androidx.annotation.NonNull;

/**
 * Process destination of image nodes
 *
 * @since 4.4.0
 */
public abstract class ImageDestinationProcessor {
    @NonNull
    public abstract String process(@NonNull String destination);

    @NonNull
    public static ImageDestinationProcessor noOp() {
        return new NoOp();
    }

    private static class NoOp extends ImageDestinationProcessor {

        @NonNull
        @Override
        public String process(@NonNull String destination) {
            return destination;
        }
    }
}
