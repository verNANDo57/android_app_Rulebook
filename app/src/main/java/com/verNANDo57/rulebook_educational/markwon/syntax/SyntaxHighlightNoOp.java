/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.syntax;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SyntaxHighlightNoOp implements SyntaxHighlight {
    @NonNull
    @Override
    public CharSequence highlight(@Nullable String info, @NonNull String code) {
        return code;
    }
}
