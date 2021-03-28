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
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.rules.RulebookBooleans;

public class AppMainRulesOrthographyFragment extends CustomThemeEngineFragment {

    private View view;
    RulebookApplicationSharedPreferences preferences;
    private RulebookBooleans booleansInMainRules;

    public AppMainRulesOrthographyFragment() {
        //required empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Animation fade_in = AnimationUtils.loadAnimation(requireContext(), R.anim.app_fade_in);
        Animation fade_out = AnimationUtils.loadAnimation(requireContext(), R.anim.app_fade_out);

        preferences = new RulebookApplicationSharedPreferences(requireContext());
        booleansInMainRules = new RulebookBooleans(requireContext());


        view = inflater.inflate(R.layout.orthography, container, false);

        LinearLayout orthographyButton1_container = view.findViewById(R.id.orthographyButton1_container);
        LinearLayout orthographyButton2_container = view.findViewById(R.id.orthographyButton2_container);
        LinearLayout orthographyButton3_container = view.findViewById(R.id.orthographyButton3_container);
        LinearLayout orthographyButton4_container = view.findViewById(R.id.orthographyButton4_container);
        LinearLayout orthographyButton5_container = view.findViewById(R.id.orthographyButton5_container);
        LinearLayout orthographyButton6_container = view.findViewById(R.id.orthographyButton6_container);
        LinearLayout orthographyButton7_container = view.findViewById(R.id.orthographyButton7_container);
        LinearLayout orthographyButton8_container = view.findViewById(R.id.orthographyButton8_container);
        LinearLayout orthographyButton9_container = view.findViewById(R.id.orthographyButton9_container);
        LinearLayout orthographyButton10_container = view.findViewById(R.id.orthographyButton10_container);
        LinearLayout orthographyButton11_container = view.findViewById(R.id.orthographyButton11_container);
        LinearLayout orthographyButton12_container = view.findViewById(R.id.orthographyButton12_container);
        LinearLayout orthographyButton13_container = view.findViewById(R.id.orthographyButton13_container);
        LinearLayout orthographyButton14_container = view.findViewById(R.id.orthographyButton14_container);
        LinearLayout orthographyButton17_container = view.findViewById(R.id.orthographyButton17_container);

        LinearLayout orthographyButton1_sub_container = view.findViewById(R.id.orthographyButton1_sub_container);
        LinearLayout orthographyButton2_sub_container = view.findViewById(R.id.orthographyButton2_sub_container);
        LinearLayout orthographyButton3_sub_container = view.findViewById(R.id.orthographyButton3_sub_container);
        LinearLayout orthographyButton5_sub_container = view.findViewById(R.id.orthographyButton5_sub_container);
        LinearLayout orthographyButton6_sub_container = view.findViewById(R.id.orthographyButton6_sub_container);
        LinearLayout orthographyButton7_sub_container = view.findViewById(R.id.orthographyButton7_sub_container);
        LinearLayout orthographyButton8_sub_container = view.findViewById(R.id.orthographyButton8_sub_container);
        LinearLayout orthographyButton9_sub_container = view.findViewById(R.id.orthographyButton9_sub_container);
        LinearLayout orthographyButton10_sub_container = view.findViewById(R.id.orthographyButton10_sub_container);
        LinearLayout orthographyButton11_sub_container = view.findViewById(R.id.orthographyButton11_sub_container);
        LinearLayout orthographyButton12_sub_container = view.findViewById(R.id.orthographyButton12_sub_container);
        LinearLayout orthographyButton13_sub_container = view.findViewById(R.id.orthographyButton13_sub_container);
        LinearLayout orthographyButton14_sub_container = view.findViewById(R.id.orthographyButton14_sub_container);
        LinearLayout orthographyButton17_sub_container = view.findViewById(R.id.orthographyButton17_sub_container);

        Button ortho1mainButton1 = view.findViewById(R.id.ortho1mainButton1);
        Button ortho1mainButton2 = view.findViewById(R.id.ortho1mainButton2);
        Button ortho1mainButton3 = view.findViewById(R.id.ortho1mainButton3);
        Button ortho1mainButton4 = view.findViewById(R.id.ortho1mainButton4);
        Button ortho1mainButton5 = view.findViewById(R.id.ortho1mainButton5);
        Button ortho1mainButton6 = view.findViewById(R.id.ortho1mainButton6);

        Button ortho2mainButton1 = view.findViewById(R.id.ortho2mainButton1);
        Button ortho2mainButton2 = view.findViewById(R.id.ortho2mainButton2);
        Button ortho2mainButton3 = view.findViewById(R.id.ortho2mainButton3);

        Button ortho3mainButton1 = view.findViewById(R.id.ortho3mainButton1);
        Button ortho3mainButton2 = view.findViewById(R.id.ortho3mainButton2);
        Button ortho3mainButton3 = view.findViewById(R.id.ortho3mainButton3);
        Button ortho3mainButton4 = view.findViewById(R.id.ortho3mainButton4);
        Button ortho3mainButton5 = view.findViewById(R.id.ortho3mainButton5);
        Button ortho3mainButton6 = view.findViewById(R.id.ortho3mainButton6);
        Button ortho3mainButton7 = view.findViewById(R.id.ortho3mainButton7);
        Button ortho3mainButton8 = view.findViewById(R.id.ortho3mainButton8);
        Button ortho3mainButton9 = view.findViewById(R.id.ortho3mainButton9);
        Button ortho3mainButton10 = view.findViewById(R.id.ortho3mainButton10);
        Button ortho3mainButton11 = view.findViewById(R.id.ortho3mainButton11);
        Button ortho3mainButton12 = view.findViewById(R.id.ortho3mainButton12);
        Button ortho3mainButton13 = view.findViewById(R.id.ortho3mainButton13);
        Button ortho3mainButton14 = view.findViewById(R.id.ortho3mainButton14);
        Button ortho3mainButton15 = view.findViewById(R.id.ortho3mainButton15);
        Button ortho3mainButton16 = view.findViewById(R.id.ortho3mainButton16);
        Button ortho3mainButton17 = view.findViewById(R.id.ortho3mainButton17);

        Button ortho5mainButton1 = view.findViewById(R.id.ortho5mainButton1);
        Button ortho5mainButton2 = view.findViewById(R.id.ortho5mainButton2);
        Button ortho5mainButton3 = view.findViewById(R.id.ortho5mainButton3);

        Button ortho6mainButton1 = view.findViewById(R.id.ortho6mainButton1);
        Button ortho6mainButton2 = view.findViewById(R.id.ortho6mainButton2);

        Button ortho7mainButton1 = view.findViewById(R.id.ortho7mainButton1);
        Button ortho7mainButton2 = view.findViewById(R.id.ortho7mainButton2);

        Button ortho8mainButton1 = view.findViewById(R.id.ortho8mainButton1);
        Button ortho8mainButton2 = view.findViewById(R.id.ortho8mainButton2);

        Button ortho9mainButton1 = view.findViewById(R.id.ortho9mainButton1);
        Button ortho9mainButton2 = view.findViewById(R.id.ortho9mainButton2);
        Button ortho9mainButton3 = view.findViewById(R.id.ortho9mainButton3);
        Button ortho9mainButton4 = view.findViewById(R.id.ortho9mainButton4);

        Button ortho10mainButton1 = view.findViewById(R.id.ortho10mainButton1);
        Button ortho10mainButton2 = view.findViewById(R.id.ortho10mainButton2);

        Button ortho11mainButton1 = view.findViewById(R.id.ortho11mainButton1);
        Button ortho11mainButton2 = view.findViewById(R.id.ortho11mainButton2);

        Button ortho12mainButton1 = view.findViewById(R.id.ortho12mainButton1);
        Button ortho12mainButton2 = view.findViewById(R.id.ortho12mainButton2);
        Button ortho12mainButton3 = view.findViewById(R.id.ortho12mainButton3);

        Button ortho13mainButton1 = view.findViewById(R.id.ortho13mainButton1);
        Button ortho13mainButton2 = view.findViewById(R.id.ortho13mainButton2);

        Button ortho14mainButton1 = view.findViewById(R.id.ortho14mainButton1);
        Button ortho14mainButton2 = view.findViewById(R.id.ortho14mainButton2);
        Button ortho14mainButton3 = view.findViewById(R.id.ortho14mainButton3);
        Button ortho14mainButton4 = view.findViewById(R.id.ortho14mainButton4);
        Button ortho14mainButton5 = view.findViewById(R.id.ortho14mainButton5);
        Button ortho14mainButton6 = view.findViewById(R.id.ortho14mainButton6);

        Button ortho17mainButton1 = view.findViewById(R.id.ortho17mainButton1);
        Button ortho17mainButton2 = view.findViewById(R.id.ortho17mainButton2);
        Button ortho17mainButton3 = view.findViewById(R.id.ortho17mainButton3);
        Button ortho17mainButton4 = view.findViewById(R.id.ortho17mainButton4);
        Button ortho17mainButton5 = view.findViewById(R.id.ortho17mainButton5);
        Button ortho17mainButton6 = view.findViewById(R.id.ortho17mainButton6);
        Button ortho17mainButton7 = view.findViewById(R.id.ortho17mainButton7);
        Button ortho17mainButton8 = view.findViewById(R.id.ortho17mainButton8);

        Intent scrollableactivity_in_mainrules = new Intent(getContext(), AppMainRulesScrollableActivityInMainRules.class);

        //ortho_1
        Button ortho_1 = view.findViewById(R.id.orthographyButton1);
        ortho_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton1_sub_container.getVisibility() == View.GONE) {
                    orthographyButton1_sub_container.startAnimation(fade_in);
                    orthographyButton1_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton1_sub_container.startAnimation(fade_out);
                    orthographyButton1_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho1mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_1");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho1mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_2");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho1mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_3");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho1mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_4");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho1mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_5");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho1mainButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_6");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_1

        //ortho_2
        Button ortho_2 = view.findViewById(R.id.orthographyButton2);
        ortho_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton2_sub_container.getVisibility() == View.GONE) {
                    orthographyButton2_sub_container.startAnimation(fade_in);
                    orthographyButton2_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton2_sub_container.startAnimation(fade_out);
                    orthographyButton2_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho2mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_2_7");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho2mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_2_8");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho2mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_2_9");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_2

        //ortho_3
        Button ortho_3 = view.findViewById(R.id.orthographyButton3);
        ortho_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton3_sub_container.getVisibility() == View.GONE) {
                    orthographyButton3_sub_container.startAnimation(fade_in);
                    orthographyButton3_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton3_sub_container.startAnimation(fade_out);
                    orthographyButton3_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho3mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_10");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_11");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_12");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_13");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_14");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_15");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_16");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_17");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_18");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_19");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_20");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_21");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_22");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_23");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_24");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_25");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho3mainButton17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_26");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_3

        //ortho_4
        Button ortho_4 = view.findViewById(R.id.orthographyButton4);
        ortho_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_4_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //ortho_4

        //ortho_5
        Button ortho_5 = view.findViewById(R.id.orthographyButton5);
        ortho_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton5_sub_container.getVisibility() == View.GONE) {
                    orthographyButton5_sub_container.startAnimation(fade_in);
                    orthographyButton5_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton5_sub_container.startAnimation(fade_out);
                    orthographyButton5_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho5mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_5_27");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho5mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_5_28");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho5mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_5_29");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_5

        //ortho_6
        Button ortho_6 = view.findViewById(R.id.orthographyButton6);
        ortho_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton6_sub_container.getVisibility() == View.GONE) {
                    orthographyButton6_sub_container.startAnimation(fade_in);
                    orthographyButton6_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton6_sub_container.startAnimation(fade_out);
                    orthographyButton6_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho6mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_6_30");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho6mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_6_31");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_6

        //ortho_7
        Button ortho_7 = view.findViewById(R.id.orthographyButton7);
        ortho_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton7_sub_container.getVisibility() == View.GONE) {
                    orthographyButton7_sub_container.startAnimation(fade_in);
                    orthographyButton7_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton7_sub_container.startAnimation(fade_out);
                    orthographyButton7_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho7mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_7_32");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho7mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_7_33");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_7

        //ortho_8
        Button ortho_8 = view.findViewById(R.id.orthographyButton8);
        ortho_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton8_sub_container.getVisibility() == View.GONE) {
                    orthographyButton8_sub_container.startAnimation(fade_in);
                    orthographyButton8_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton8_sub_container.startAnimation(fade_out);
                    orthographyButton8_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho8mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_8_34");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho8mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_8_35");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_8

        //ortho_9
        Button ortho_9 = view.findViewById(R.id.orthographyButton9);
        ortho_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton9_sub_container.getVisibility() == View.GONE) {
                    orthographyButton9_sub_container.startAnimation(fade_in);
                    orthographyButton9_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton9_sub_container.startAnimation(fade_out);
                    orthographyButton9_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho9mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_36");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho9mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_37");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho9mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_38");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho9mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_39");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_9

        //ortho_10
        Button ortho_10 = view.findViewById(R.id.orthographyButton10);
        ortho_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton10_sub_container.getVisibility() == View.GONE) {
                    orthographyButton10_sub_container.startAnimation(fade_in);
                    orthographyButton10_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton10_sub_container.startAnimation(fade_out);
                    orthographyButton10_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho10mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_10_40");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho10mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_10_41");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_10

        //ortho_11
        Button ortho_11 = view.findViewById(R.id.orthographyButton11);
        ortho_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton11_sub_container.getVisibility() == View.GONE) {
                    orthographyButton11_sub_container.startAnimation(fade_in);
                    orthographyButton11_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton11_sub_container.startAnimation(fade_out);
                    orthographyButton11_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho11mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_11_42");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho11mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_11_43");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_11

        //ortho_12
        Button ortho_12 = view.findViewById(R.id.orthographyButton12);
        ortho_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton12_sub_container.getVisibility() == View.GONE) {
                    orthographyButton12_sub_container.startAnimation(fade_in);
                    orthographyButton12_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton12_sub_container.startAnimation(fade_out);
                    orthographyButton12_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho12mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_12_44");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho12mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_12_45");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho12mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_12_46");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_12

        //ortho_13
        Button ortho_13 = view.findViewById(R.id.orthographyButton13);
        ortho_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton13_sub_container.getVisibility() == View.GONE) {
                    orthographyButton13_sub_container.startAnimation(fade_in);
                    orthographyButton13_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton13_sub_container.startAnimation(fade_out);
                    orthographyButton13_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho13mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_13_47");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho13mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_13_48");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_13

        //ortho_14
        Button ortho_14 = view.findViewById(R.id.orthographyButton14);
        ortho_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton14_sub_container.getVisibility() == View.GONE) {
                    orthographyButton14_sub_container.startAnimation(fade_in);
                    orthographyButton14_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton14_sub_container.startAnimation(fade_out);
                    orthographyButton14_sub_container.setVisibility(View.GONE);
                }
            }
        });
            ortho14mainButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_49");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho14mainButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_50");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho14mainButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_51");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho14mainButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_52");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho14mainButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_53");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
            ortho14mainButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_54");
                    startActivity(scrollableactivity_in_mainrules);
                }
            });
        //ortho_14

        //ortho_15
        Button ortho_15 = view.findViewById(R.id.orthographyButton15);
        ortho_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_15_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //ortho_15

        //ortho_16
        Button ortho_16 = view.findViewById(R.id.orthographyButton16);
        ortho_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_16_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //ortho_16

        //ortho_17
        Button ortho_17 = view.findViewById(R.id.orthographyButton17);
        ortho_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orthographyButton17_sub_container.getVisibility() == View.GONE) {
                    orthographyButton17_sub_container.startAnimation(fade_in);
                    orthographyButton17_sub_container.setVisibility(View.VISIBLE);
                } else {
                    orthographyButton17_sub_container.startAnimation(fade_out);
                    orthographyButton17_sub_container.setVisibility(View.GONE);
                }
            }
        });
        ortho17mainButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_55");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        ortho17mainButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_56");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        ortho17mainButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_57");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        ortho17mainButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_58");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        ortho17mainButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_59");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        ortho17mainButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_60");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        ortho17mainButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_61");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        ortho17mainButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_62");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //ortho_17

        //ortho_18
        Button ortho_18 = view.findViewById(R.id.orthographyButton18);
        ortho_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_18_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //ortho_18

        //ortho_19
        Button ortho_19 = view.findViewById(R.id.orthographyButton19);
        ortho_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_19_split");
                startActivity(scrollableactivity_in_mainrules);
            }
        });
        //ortho_19
        return view;
    }
}

