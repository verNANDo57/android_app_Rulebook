/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.image;

import com.verNANDo57.rulebook_educational.markwon.Prop;

/**
 * @since 3.0.0
 */
public abstract class ImageProps {

    public static final Prop<String> DESTINATION = Prop.of("image-destination");

    public static final Prop<Boolean> REPLACEMENT_TEXT_IS_LINK =
            Prop.of("image-replacement-text-is-link");

    public static final Prop<ImageSize> IMAGE_SIZE = Prop.of("image-size");


    private ImageProps() {
    }
}
