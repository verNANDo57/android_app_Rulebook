/*
 * Author: noties <https://noties.io/>
 * date: 2021/03/15
 *
 * Modified by: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables;

import com.verNANDo57.rulebook_educational.markwon.Extension;
import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.internal.TableBlockParser;
import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.internal.TableHtmlNodeRenderer;
import com.verNANDo57.rulebook_educational.markwon.ext.gfm.tables.internal.TableTextContentNodeRenderer;
import com.verNANDo57.rulebook_educational.markwon.parser.Parser;
import com.verNANDo57.rulebook_educational.markwon.renderer.NodeRenderer;
import com.verNANDo57.rulebook_educational.markwon.renderer.html.HtmlNodeRendererContext;
import com.verNANDo57.rulebook_educational.markwon.renderer.html.HtmlNodeRendererFactory;
import com.verNANDo57.rulebook_educational.markwon.renderer.html.HtmlRenderer;
import com.verNANDo57.rulebook_educational.markwon.renderer.text.TextContentNodeRendererContext;
import com.verNANDo57.rulebook_educational.markwon.renderer.text.TextContentNodeRendererFactory;
import com.verNANDo57.rulebook_educational.markwon.renderer.text.TextContentRenderer;

/**
 * Extension for GFM tables using "|" pipes (GitHub Flavored Markdown).
 * <p>
 * Create it with {@link #create()} and then configure it on the builders
 * ({@link Parser.Builder#extensions(Iterable)},
 * {@link HtmlRenderer.Builder#extensions(Iterable)}).
 * </p>
 * <p>
 * The parsed tables are turned into {@link TableBlock} blocks.
 * </p>
 *
 * @see <a href="https://github.github.com/gfm/#tables-extension-">Tables (extension) in GitHub Flavored Markdown Spec</a>
 */
public class TablesExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension,
        TextContentRenderer.TextContentRendererExtension {

    private TablesExtension() {
    }

    public static Extension create() {
        return new TablesExtension();
    }

    @Override
    public void extend(Parser.Builder parserBuilder) {
        parserBuilder.customBlockParserFactory(new TableBlockParser.Factory());
    }

    @Override
    public void extend(HtmlRenderer.Builder rendererBuilder) {
        rendererBuilder.nodeRendererFactory(new HtmlNodeRendererFactory() {
            @Override
            public NodeRenderer create(HtmlNodeRendererContext context) {
                return new TableHtmlNodeRenderer(context);
            }
        });
    }

    @Override
    public void extend(TextContentRenderer.Builder rendererBuilder) {
        rendererBuilder.nodeRendererFactory(new TextContentNodeRendererFactory() {
            @Override
            public NodeRenderer create(TextContentNodeRendererContext context) {
                return new TableTextContentNodeRenderer(context);
            }
        });
    }
}
