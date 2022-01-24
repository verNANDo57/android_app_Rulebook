/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.rules;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;
import static com.verNANDo57.rulebook_educational.utils.AppUtils.TRANSLATE_DIRECTION_BOTTOM;
import static com.verNANDo57.rulebook_educational.utils.AppUtils.TRANSLATE_DIRECTION_TOP;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.verNANDo57.rulebook_educational.BottomNavAmongLessonsFragment;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.pdflib.pdfviewer.PDFView;
import com.verNANDo57.rulebook_educational.pdflib.pdfviewer.listener.OnPageScrollListener;
import com.verNANDo57.rulebook_educational.pdflib.pdfviewer.scroll.DefaultScrollHandle;
import com.verNANDo57.rulebook_educational.pdflib.pdfviewer.util.FitPolicy;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

public class AppLexiconActivity extends CustomThemeEngineAppCompatActivity {

    private Toolbar toolbar_pdfview;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_bottomappbar_pdfview);

        toolbar_pdfview = findViewById(R.id.toolbar_pdfview);
        setSupportActionBar(toolbar_pdfview);
        toolbar_pdfview.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomNavAmongLessonsFragment BottomNavBetweenLessons = new BottomNavAmongLessonsFragment();
                BottomNavBetweenLessons.show(getSupportFragmentManager(), LOG_TAG);
            }
        });

        // Init PdfView
        PDFView lexicon_pdfview = findViewById(R.id.pdfView);

        // Load PDF from assets
        lexicon_pdfview.fromAsset("lexicon/lexicon.pdf")
                .enableAnnotationRendering(true)
                .pageFitPolicy(FitPolicy.BOTH)
                .scrollHandle(new DefaultScrollHandle(this))
                .onPageScroll(new OnPageScrollListener() {
                    @Override
                    public void onPageScrolled(int page, float positionOffset) {
                        if (page >= lexicon_pdfview.getPageCount() - 2) {
                            if (toolbar_pdfview.getVisibility() == View.VISIBLE) {
                                AppUtils.setTranslateAnimation(toolbar_pdfview, TRANSLATE_DIRECTION_BOTTOM, (float) 250);
                                toolbar_pdfview.setVisibility(View.GONE);
                            }
                        } else if (page < lexicon_pdfview.getPageCount() - 2) {
                            if (toolbar_pdfview.getVisibility() == View.GONE) {
                                AppUtils.setTranslateAnimation(toolbar_pdfview, TRANSLATE_DIRECTION_TOP, (float) 250);
                                toolbar_pdfview.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                })
                .load();
        lexicon_pdfview.useBestQuality(true);
    }
}
