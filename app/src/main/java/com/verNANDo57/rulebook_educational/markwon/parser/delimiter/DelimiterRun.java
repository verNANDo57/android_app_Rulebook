/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.parser.delimiter;

/**
 * A delimiter run is one or more of the same delimiter character.
 */
public interface DelimiterRun {

    /**
     * @return whether this can open a delimiter
     */
    boolean canOpen();

    /**
     * @return whether this can close a delimiter
     */
    boolean canClose();

    /**
     * @return the number of characters in this delimiter run (that are left for processing)
     */
    int length();

    /**
     * @return the number of characters originally in this delimiter run; at the start of processing, this is the same
     * as {{@link #length()}}
     */
    int originalLength();
}
