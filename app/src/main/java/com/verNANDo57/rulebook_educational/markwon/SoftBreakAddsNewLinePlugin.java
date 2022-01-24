/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.node.SoftLineBreak;

/**
 * @since 4.3.0
 */
public class SoftBreakAddsNewLinePlugin extends AbstractMarkwonPlugin {

    @NonNull
    public static SoftBreakAddsNewLinePlugin create() {
        return new SoftBreakAddsNewLinePlugin();
    }

    @Override
    public void configureVisitor(@NonNull MarkwonVisitor.Builder builder) {
        builder.on(SoftLineBreak.class, new MarkwonVisitor.NodeVisitor<SoftLineBreak>() {
            @Override
            public void visit(@NonNull MarkwonVisitor visitor, @NonNull SoftLineBreak softLineBreak) {
                visitor.ensureNewLine();
            }
        });
    }
}
