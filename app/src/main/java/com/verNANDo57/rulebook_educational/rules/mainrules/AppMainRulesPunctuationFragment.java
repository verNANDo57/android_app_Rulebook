package com.verNANDo57.rulebook_educational.rules.mainrules;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineFragment;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.AppExtraBooleans;

public class AppMainRulesPunctuationFragment extends CustomThemeEngineFragment {

    private View view;
    RulebookApplicationSharedPreferences preferences;
    private AppExtraBooleans booleansInMainRules;

    public AppMainRulesPunctuationFragment() {
        //required empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Animation fade_in = AnimationUtils.loadAnimation(requireContext(), R.anim.app_fade_in);
        Animation fade_out = AnimationUtils.loadAnimation(requireContext(), R.anim.app_fade_out);

        preferences = new RulebookApplicationSharedPreferences(requireContext());
        booleansInMainRules = new AppExtraBooleans(requireContext());

        view = inflater.inflate(R.layout.punctuation, container, false);

        LinearLayout punctuationButton1_container = view.findViewById(R.id.punctuationButton1_container);
        LinearLayout punctuationButton2_container = view.findViewById(R.id.punctuationButton2_container);
        LinearLayout punctuationButton3_container = view.findViewById(R.id.punctuationButton3_container);
        LinearLayout punctuationButton4_container = view.findViewById(R.id.punctuationButton4_container);
        LinearLayout punctuationButton5_container = view.findViewById(R.id.punctuationButton5_container);
        LinearLayout punctuationButton6_container = view.findViewById(R.id.punctuationButton6_container);
        LinearLayout punctuationButton7_container = view.findViewById(R.id.punctuationButton7_container);
        LinearLayout punctuationButton8_container = view.findViewById(R.id.punctuationButton8_container);
        LinearLayout punctuationButton9_container = view.findViewById(R.id.punctuationButton9_container);
        LinearLayout punctuationButton10_container = view.findViewById(R.id.punctuationButton10_container);
        LinearLayout punctuationButton11_container = view.findViewById(R.id.punctuationButton11_container);
        LinearLayout punctuationButton12_container = view.findViewById(R.id.punctuationButton12_container);
        LinearLayout punctuationButton14_container = view.findViewById(R.id.punctuationButton14_container);
        LinearLayout punctuationButton15_container = view.findViewById(R.id.punctuationButton15_container);
        LinearLayout punctuationButton17_container = view.findViewById(R.id.punctuationButton17_container);
        LinearLayout punctuationButton18_container = view.findViewById(R.id.punctuationButton18_container);
        LinearLayout punctuationButton19_container = view.findViewById(R.id.punctuationButton19_container);

        LinearLayout punctuationButton1_sub_container = view.findViewById(R.id.punctuationButton1_sub_container);
        LinearLayout punctuationButton2_sub_container = view.findViewById(R.id.punctuationButton2_sub_container);
        LinearLayout punctuationButton3_sub_container = view.findViewById(R.id.punctuationButton3_sub_container);
        LinearLayout punctuationButton4_sub_container = view.findViewById(R.id.punctuationButton4_sub_container);
        LinearLayout punctuationButton5_sub_container = view.findViewById(R.id.punctuationButton5_sub_container);
        LinearLayout punctuationButton6_sub_container = view.findViewById(R.id.punctuationButton6_sub_container);
        LinearLayout punctuationButton7_sub_container = view.findViewById(R.id.punctuationButton7_sub_container);
        LinearLayout punctuationButton8_sub_container = view.findViewById(R.id.punctuationButton8_sub_container);
        LinearLayout punctuationButton9_sub_container = view.findViewById(R.id.punctuationButton9_sub_container);
        LinearLayout punctuationButton10_sub_container = view.findViewById(R.id.punctuationButton10_sub_container);
        LinearLayout punctuationButton11_sub_container = view.findViewById(R.id.punctuationButton11_sub_container);
        LinearLayout punctuationButton12_sub_container = view.findViewById(R.id.punctuationButton12_sub_container);
        LinearLayout punctuationButton14_sub_container = view.findViewById(R.id.punctuationButton14_sub_container);
        LinearLayout punctuationButton15_sub_container = view.findViewById(R.id.punctuationButton15_sub_container);
        LinearLayout punctuationButton17_sub_container = view.findViewById(R.id.punctuationButton17_sub_container);
        LinearLayout punctuationButton18_sub_container = view.findViewById(R.id.punctuationButton18_sub_container);
        LinearLayout punctuationButton19_sub_container = view.findViewById(R.id.punctuationButton19_sub_container);

        Button punct1mainButton1 = view.findViewById(R.id.punct1mainButton1);
        Button punct1mainButton2 = view.findViewById(R.id.punct1mainButton2);
        Button punct1mainButton3 = view.findViewById(R.id.punct1mainButton3);
        Button punct1mainButton4 = view.findViewById(R.id.punct1mainButton4);

        Button punct2mainButton1 = view.findViewById(R.id.punct2mainButton1);
        Button punct2mainButton2 = view.findViewById(R.id.punct2mainButton2);
        Button punct2mainButton3 = view.findViewById(R.id.punct2mainButton3);
        Button punct2mainButton4 = view.findViewById(R.id.punct2mainButton4);

        Button punct3mainButton1 = view.findViewById(R.id.punct3mainButton1);
        Button punct3mainButton2 = view.findViewById(R.id.punct3mainButton2);
        Button punct3mainButton3 = view.findViewById(R.id.punct3mainButton3);
        Button punct3mainButton4 = view.findViewById(R.id.punct3mainButton4);
        Button punct3mainButton5 = view.findViewById(R.id.punct3mainButton5);
        Button punct3mainButton6 = view.findViewById(R.id.punct3mainButton6);
        Button punct3mainButton7 = view.findViewById(R.id.punct3mainButton7);

        Button punct4mainButton1 = view.findViewById(R.id.punct4mainButton1);
        Button punct4mainButton2 = view.findViewById(R.id.punct4mainButton2);

        Button punct5mainButton1 = view.findViewById(R.id.punct5mainButton1);
        Button punct5mainButton2 = view.findViewById(R.id.punct5mainButton2);
        Button punct5mainButton3 = view.findViewById(R.id.punct5mainButton3);
        Button punct5mainButton4 = view.findViewById(R.id.punct5mainButton4);

        Button punct6mainButton1 = view.findViewById(R.id.punct6mainButton1);
        Button punct6mainButton2 = view.findViewById(R.id.punct6mainButton2);
        Button punct6mainButton3 = view.findViewById(R.id.punct6mainButton3);

        Button punct7mainButton1 = view.findViewById(R.id.punct7mainButton1);
        Button punct7mainButton2 = view.findViewById(R.id.punct7mainButton2);
        Button punct7mainButton3 = view.findViewById(R.id.punct7mainButton3);

        Button punct8mainButton1 = view.findViewById(R.id.punct8mainButton1);
        Button punct8mainButton2 = view.findViewById(R.id.punct8mainButton2);

        Button punct9mainButton1 = view.findViewById(R.id.punct9mainButton1);
        Button punct9mainButton2 = view.findViewById(R.id.punct9mainButton2);
        Button punct9mainButton3 = view.findViewById(R.id.punct9mainButton3);

        Button punct10mainButton1 = view.findViewById(R.id.punct10mainButton1);
        Button punct10mainButton2 = view.findViewById(R.id.punct10mainButton2);
        Button punct10mainButton3 = view.findViewById(R.id.punct10mainButton3);
        Button punct10mainButton4 = view.findViewById(R.id.punct10mainButton4);
        Button punct10mainButton5 = view.findViewById(R.id.punct10mainButton5);
        Button punct10mainButton6 = view.findViewById(R.id.punct10mainButton6);
        Button punct10mainButton7 = view.findViewById(R.id.punct10mainButton7);
        Button punct10mainButton8 = view.findViewById(R.id.punct10mainButton8);

        Button punct11mainButton1 = view.findViewById(R.id.punct11mainButton1);
        Button punct11mainButton2 = view.findViewById(R.id.punct11mainButton2);

        Button punct12mainButton1 = view.findViewById(R.id.punct12mainButton1);
        Button punct12mainButton2 = view.findViewById(R.id.punct12mainButton2);
        Button punct12mainButton3 = view.findViewById(R.id.punct12mainButton3);
        Button punct12mainButton4 = view.findViewById(R.id.punct12mainButton4);

        Button punctuationButton13 = view.findViewById(R.id.punctuationButton13);

        Button punct14mainButton1 = view.findViewById(R.id.punct14mainButton1);
        Button punct14mainButton2 = view.findViewById(R.id.punct14mainButton2);
        Button punct14mainButton3 = view.findViewById(R.id.punct14mainButton3);
        Button punct14mainButton4 = view.findViewById(R.id.punct14mainButton4);
        Button punct14mainButton5 = view.findViewById(R.id.punct14mainButton5);
        Button punct14mainButton6 = view.findViewById(R.id.punct14mainButton6);
        Button punct14mainButton7 = view.findViewById(R.id.punct14mainButton7);
        Button punct14mainButton8 = view.findViewById(R.id.punct14mainButton8);

        Button punct15mainButton1 = view.findViewById(R.id.punct15mainButton1);
        Button punct15mainButton2 = view.findViewById(R.id.punct15mainButton2);
        Button punct15mainButton3 = view.findViewById(R.id.punct15mainButton3);
        Button punct15mainButton4 = view.findViewById(R.id.punct15mainButton4);

        Button punctuationButton16 = view.findViewById(R.id.punctuationButton16);

        Button punct17mainButton1 = view.findViewById(R.id.punct17mainButton1);
        Button punct17mainButton2 = view.findViewById(R.id.punct17mainButton2);
        Button punct17mainButton3 = view.findViewById(R.id.punct17mainButton3);
        Button punct17mainButton4 = view.findViewById(R.id.punct17mainButton4);
        Button punct17mainButton5 = view.findViewById(R.id.punct17mainButton5);

        Button punct18mainButton1 = view.findViewById(R.id.punct18mainButton1);
        Button punct18mainButton2 = view.findViewById(R.id.punct18mainButton2);
        Button punct18mainButton3 = view.findViewById(R.id.punct18mainButton3);
        Button punct18mainButton4 = view.findViewById(R.id.punct18mainButton4);
        Button punct18mainButton5 = view.findViewById(R.id.punct18mainButton5);
        Button punct18mainButton6 = view.findViewById(R.id.punct18mainButton6);

        Button punct19mainButton1 = view.findViewById(R.id.punct19mainButton1);
        Button punct19mainButton2 = view.findViewById(R.id.punct19mainButton2);
        Button punct19mainButton3 = view.findViewById(R.id.punct19mainButton3);

        Button punctuationButton20 = view.findViewById(R.id.punctuationButton20);

        Button punctuationButton21 = view.findViewById(R.id.punctuationButton21);

        Intent scrollableactivity_in_mainrules = new Intent(getContext(), AppMainRulesScrollableActivityInMainRules.class);

        //punct_1
        Button punct_1 = view.findViewById(R.id.punctuationButton1);
        punct_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton1_sub_container.getVisibility() == View.GONE) {
                    punctuationButton1_sub_container.startAnimation(fade_in);
                    punctuationButton1_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton1_sub_container.startAnimation(fade_out);
                    punctuationButton1_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct1mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_1_1");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct1mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_1_2");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct1mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_1_3");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct1mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_1_4");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_1

        //punct_2
        Button punct_2 = view.findViewById(R.id.punctuationButton2);
        punct_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton2_sub_container.getVisibility() == View.GONE) {
                    punctuationButton2_sub_container.startAnimation(fade_in);
                    punctuationButton2_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton2_sub_container.startAnimation(fade_out);
                    punctuationButton2_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct2mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_2_5");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct2mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_2_6");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct2mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_2_7");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct2mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_2_8");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_2

        //punct_3
        Button punct_3 = view.findViewById(R.id.punctuationButton3);
        punct_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton3_sub_container.getVisibility() == View.GONE) {
                    punctuationButton3_sub_container.startAnimation(fade_in);
                    punctuationButton3_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton3_sub_container.startAnimation(fade_out);
                    punctuationButton3_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct3mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_3_9");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct3mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_3_10");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct3mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_3_11");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct3mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_3_12");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct3mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_3_13");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct3mainButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_3_14");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct3mainButton7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_3_15");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_3

        //punct_4
        Button punct_4 = view.findViewById(R.id.punctuationButton4);
        punct_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton4_sub_container.getVisibility() == View.GONE) {
                    punctuationButton4_sub_container.startAnimation(fade_in);
                    punctuationButton4_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton4_sub_container.startAnimation(fade_out);
                    punctuationButton4_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct4mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_4_16");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct4mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_4_17");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_4

        //punct_5
        Button punct_5 = view.findViewById(R.id.punctuationButton5);
        punct_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton5_sub_container.getVisibility() == View.GONE) {
                    punctuationButton5_sub_container.startAnimation(fade_in);
                    punctuationButton5_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton5_sub_container.startAnimation(fade_out);
                    punctuationButton5_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct5mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_5_18");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct5mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_5_19");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct5mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_5_20");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct5mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_5_21");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_5

        //punct_6
        Button punct_6 = view.findViewById(R.id.punctuationButton6);
        punct_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton6_sub_container.getVisibility() == View.GONE) {
                    punctuationButton6_sub_container.startAnimation(fade_in);
                    punctuationButton6_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton6_sub_container.startAnimation(fade_out);
                    punctuationButton6_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct6mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_6_22");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct6mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_6_23");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct6mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_6_24");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_6

        //punct_7
        Button punct_7 = view.findViewById(R.id.punctuationButton7);
        punct_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton7_sub_container.getVisibility() == View.GONE) {
                    punctuationButton7_sub_container.startAnimation(fade_in);
                    punctuationButton7_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton7_sub_container.startAnimation(fade_out);
                    punctuationButton7_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct7mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_7_25");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct7mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_7_26");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct7mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_7_27");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_7

        //punct_8
        Button punct_8 = view.findViewById(R.id.punctuationButton8);
        punct_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton8_sub_container.getVisibility() == View.GONE) {
                    punctuationButton8_sub_container.startAnimation(fade_in);
                    punctuationButton8_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton8_sub_container.startAnimation(fade_out);
                    punctuationButton8_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct8mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_8_28");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct8mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_8_29");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_8

        //punct_9
        Button punct_9 = view.findViewById(R.id.punctuationButton9);
        punct_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton9_sub_container.getVisibility() == View.GONE) {
                    punctuationButton9_sub_container.startAnimation(fade_in);
                    punctuationButton9_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton9_sub_container.startAnimation(fade_out);
                    punctuationButton9_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct9mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_9_30");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct9mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_9_31");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct9mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_9_32");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_9

        //punct_10
        Button punct_10 = view.findViewById(R.id.punctuationButton10);
        punct_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton10_sub_container.getVisibility() == View.GONE) {
                    punctuationButton10_sub_container.startAnimation(fade_in);
                    punctuationButton10_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton10_sub_container.startAnimation(fade_out);
                    punctuationButton10_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct10mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_33");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct10mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_34");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct10mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_35");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct10mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_36");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct10mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_37");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct10mainButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_38");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct10mainButton7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_39");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct10mainButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_10_40");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_10

        //punct_11
        Button punct_11 = view.findViewById(R.id.punctuationButton11);
        punct_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton11_sub_container.getVisibility() == View.GONE) {
                    punctuationButton11_sub_container.startAnimation(fade_in);
                    punctuationButton11_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton11_sub_container.startAnimation(fade_out);
                    punctuationButton11_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct11mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_11_41");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct11mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_11_42");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_11

        //punct_12
        Button punct_12 = view.findViewById(R.id.punctuationButton12);
        punct_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton12_sub_container.getVisibility() == View.GONE) {
                    punctuationButton12_sub_container.startAnimation(fade_in);
                    punctuationButton12_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton12_sub_container.startAnimation(fade_out);
                    punctuationButton12_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct12mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_12_43");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct12mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_12_44");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct12mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_12_45");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct12mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_12_46");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_12

        //punct_13
        punctuationButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_13_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //punct_13

        //punct_14
        Button punct_14 = view.findViewById(R.id.punctuationButton14);
        punct_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton14_sub_container.getVisibility() == View.GONE) {
                    punctuationButton14_sub_container.startAnimation(fade_in);
                    punctuationButton14_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton14_sub_container.startAnimation(fade_out);
                    punctuationButton14_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct14mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_47");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct14mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_48");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct14mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_49");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct14mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_50");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct14mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_51");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct14mainButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_52");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct14mainButton7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_53");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct14mainButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_14_54");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_14

        //punct_15
        Button punct_15 = view.findViewById(R.id.punctuationButton15);
        punct_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton15_sub_container.getVisibility() == View.GONE) {
                    punctuationButton15_sub_container.startAnimation(fade_in);
                    punctuationButton15_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton15_sub_container.startAnimation(fade_out);
                    punctuationButton15_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct15mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_15_55");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct15mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_15_56");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct15mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_15_57");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct15mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_15_58");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_15

        //punct_16
        punctuationButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_16_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //punct_16

        //punct_17
        Button punct_17 = view.findViewById(R.id.punctuationButton17);
        punct_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton17_sub_container.getVisibility() == View.GONE) {
                    punctuationButton17_sub_container.startAnimation(fade_in);
                    punctuationButton17_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton17_sub_container.startAnimation(fade_out);
                    punctuationButton17_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct17mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_17_59");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct17mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_17_60");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct17mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_17_61");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct17mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_17_62");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct17mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_17_63");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_17

        //punct_18
        Button punct_18 = view.findViewById(R.id.punctuationButton18);
        punct_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton18_sub_container.getVisibility() == View.GONE) {
                    punctuationButton18_sub_container.startAnimation(fade_in);
                    punctuationButton18_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton18_sub_container.startAnimation(fade_out);
                    punctuationButton18_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct18mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_18_64");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct18mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_18_65");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct18mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_18_66");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct18mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_18_67");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct18mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_18_68");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct18mainButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_18_69");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_18

        //punct_19
        Button punct_19 = view.findViewById(R.id.punctuationButton19);
        punct_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (punctuationButton19_sub_container.getVisibility() == View.GONE) {
                    punctuationButton19_sub_container.startAnimation(fade_in);
                    punctuationButton19_sub_container.setVisibility(View.VISIBLE);
                } else {
                    punctuationButton19_sub_container.startAnimation(fade_out);
                    punctuationButton19_sub_container.setVisibility(View.GONE);
                }
            }
        });
            punct19mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_19_70");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct19mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_19_71");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            punct19mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_19_72");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //punct_19

        //punct_20
        punctuationButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_20_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //punct_20

        //punct_21
        punctuationButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenBoolean("punct_21_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //punct_21

        return view;
    }
}
