/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.syntax;

import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.prism4j.AbsVisitor;
import com.verNANDo57.rulebook_educational.markwon.prism4j.Prism4j;

class Prism4jSyntaxVisitor extends AbsVisitor {

    private final String language;
    private final Prism4jTheme theme;
    private final SpannableStringBuilder builder;

    Prism4jSyntaxVisitor(
            @NonNull String language,
            @NonNull Prism4jTheme theme,
            @NonNull SpannableStringBuilder builder) {
        this.language = language;
        this.theme = theme;
        this.builder = builder;
    }

    @Override
    protected void visitText(@NonNull Prism4j.Text text) {
        builder.append(text.literal());
    }

    @Override
    protected void visitSyntax(@NonNull Prism4j.Syntax syntax) {

        final int start = builder.length();
        visit(syntax.children());
        final int end = builder.length();

        if (end != start) {
            theme.apply(language, syntax, builder, start, end);
        }
    }
}
