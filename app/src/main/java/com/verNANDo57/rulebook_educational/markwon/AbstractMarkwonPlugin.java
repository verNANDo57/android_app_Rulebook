/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon;

import android.text.Spanned;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.core.MarkwonTheme;
import com.verNANDo57.rulebook_educational.markwon.node.Node;
import com.verNANDo57.rulebook_educational.markwon.parser.Parser;

/**
 * Class that extends {@link MarkwonPlugin} with all methods implemented (empty body)
 * for easier plugin implementation. Only required methods can be overriden
 *
 * @see MarkwonPlugin
 * @since 3.0.0
 */
public abstract class AbstractMarkwonPlugin implements MarkwonPlugin {

    @Override
    public void configure(@NonNull Registry registry) {

    }

    @Override
    public void configureParser(@NonNull Parser.Builder builder) {

    }

    @Override
    public void configureTheme(@NonNull MarkwonTheme.Builder builder) {

    }

    @Override
    public void configureConfiguration(@NonNull MarkwonConfiguration.Builder builder) {

    }

    @Override
    public void configureVisitor(@NonNull MarkwonVisitor.Builder builder) {

    }

    @Override
    public void configureSpansFactory(@NonNull MarkwonSpansFactory.Builder builder) {

    }

    @NonNull
    @Override
    public String processMarkdown(@NonNull String markdown) {
        return markdown;
    }

    @Override
    public void beforeRender(@NonNull Node node) {

    }

    @Override
    public void afterRender(@NonNull Node node, @NonNull MarkwonVisitor visitor) {

    }

    @Override
    public void beforeSetText(@NonNull TextView textView, @NonNull Spanned markdown) {

    }

    @Override
    public void afterSetText(@NonNull TextView textView) {

    }
}
