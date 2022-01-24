/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.node;

/**
 * A node that uses delimiters in the source form (e.g. <code>*bold*</code>).
 */
public interface Delimited {

    /**
     * @return the opening (beginning) delimiter, e.g. <code>*</code>
     */
    String getOpeningDelimiter();

    /**
     * @return the closing (ending) delimiter, e.g. <code>*</code>
     */
    String getClosingDelimiter();
}
