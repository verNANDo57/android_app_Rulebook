/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.node;

public abstract class ListBlock extends Block {

    private boolean tight;

    /**
     * @return whether this list is tight or loose
     * @see <a href="https://spec.commonmark.org/0.28/#tight">CommonMark Spec for tight lists</a>
     */
    public boolean isTight() {
        return tight;
    }

    public void setTight(boolean tight) {
        this.tight = tight;
    }

}
