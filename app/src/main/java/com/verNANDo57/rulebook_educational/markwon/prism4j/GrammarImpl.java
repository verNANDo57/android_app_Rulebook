/*
 * Author: noties <https://noties.io/>
 * date: 2019/06/11
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.prism4j;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GrammarImpl implements Prism4j.Grammar {

    private final String name;
    private final List<Prism4j.Token> tokens;

    public GrammarImpl(@NotNull String name, @NotNull List<Prism4j.Token> tokens) {
        this.name = name;
        this.tokens = tokens;
    }

    @NotNull
    @Override
    public String name() {
        return name;
    }

    @NotNull
    @Override
    public List<Prism4j.Token> tokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
