/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.verNANDo57.rulebook_educational.markwon.Markwon.Builder;
import com.verNANDo57.rulebook_educational.markwon.core.MarkwonTheme;
import com.verNANDo57.rulebook_educational.markwon.parser.Parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @since 3.0.0
 */
class MarkwonBuilderImpl implements Markwon.Builder {

    private final Context context;

    private final List<MarkwonPlugin> plugins = new ArrayList<>(3);

    private TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;

    private Markwon.TextSetter textSetter;

    // @since 4.4.0
    private boolean fallbackToRawInputWhenEmpty = true;

    MarkwonBuilderImpl(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Builder bufferType(@NonNull TextView.BufferType bufferType) {
        this.bufferType = bufferType;
        return this;
    }

    @NonNull
    @Override
    public Builder textSetter(@NonNull Markwon.TextSetter textSetter) {
        this.textSetter = textSetter;
        return this;
    }

    @NonNull
    @Override
    public Builder usePlugin(@NonNull MarkwonPlugin plugin) {
        plugins.add(plugin);
        return this;
    }

    @NonNull
    @Override
    public Builder usePlugins(@NonNull Iterable<? extends MarkwonPlugin> plugins) {

        final Iterator<? extends MarkwonPlugin> iterator = plugins.iterator();

        MarkwonPlugin plugin;

        while (iterator.hasNext()) {
            plugin = iterator.next();
            if (plugin == null) {
                throw new NullPointerException();
            }
            this.plugins.add(plugin);
        }

        return this;
    }

    @NonNull
    @Override
    public Builder fallbackToRawInputWhenEmpty(boolean fallbackToRawInputWhenEmpty) {
        this.fallbackToRawInputWhenEmpty = fallbackToRawInputWhenEmpty;
        return this;
    }

    @NonNull
    @Override
    public Markwon build() {

        if (plugins.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin " +
                    "method to add them");
        }

        // please note that this method must not modify supplied collection
        // if nothing should be done -> the same collection can be returned
        final List<MarkwonPlugin> plugins = preparePlugins(this.plugins);

        final Parser.Builder parserBuilder = new Parser.Builder();
        final MarkwonTheme.Builder themeBuilder = MarkwonTheme.builderWithDefaults(context);
        final MarkwonConfiguration.Builder configurationBuilder = new MarkwonConfiguration.Builder();
        final MarkwonVisitor.Builder visitorBuilder = new MarkwonVisitorImpl.BuilderImpl();
        final MarkwonSpansFactory.Builder spanFactoryBuilder = new MarkwonSpansFactoryImpl.BuilderImpl();

        for (MarkwonPlugin plugin : plugins) {
            plugin.configureParser(parserBuilder);
            plugin.configureTheme(themeBuilder);
            plugin.configureConfiguration(configurationBuilder);
            plugin.configureVisitor(visitorBuilder);
            plugin.configureSpansFactory(spanFactoryBuilder);
        }

        final MarkwonConfiguration configuration = configurationBuilder.build(
                themeBuilder.build(),
                spanFactoryBuilder.build());

        // @since 4.1.1
        // @since 4.1.2 - do not reuse render-props (each render call should have own render-props)
        final MarkwonVisitorFactory visitorFactory = MarkwonVisitorFactory.create(
                visitorBuilder,
                configuration);

        return new MarkwonImpl(
                bufferType,
                textSetter,
                parserBuilder.build(),
                visitorFactory,
                configuration,
                Collections.unmodifiableList(plugins),
                fallbackToRawInputWhenEmpty
        );
    }

    @NonNull
    private static List<MarkwonPlugin> preparePlugins(@NonNull List<MarkwonPlugin> plugins) {
        return new RegistryImpl(plugins).process();
    }
}
