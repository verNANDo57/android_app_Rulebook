package com.verNANDo57.rulebook_educational.search;

import android.content.Context;
import android.content.Intent;

import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.rules.RulebookBooleans;
import com.verNANDo57.rulebook_educational.rules.analyze_methods.AppAnalyzeMethodsScrollableActivity;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesScrollableActivityInMainRules;

import java.util.ArrayList;

public class SearchReferences {

    public static ArrayList<SearchItemData> setupSearchData (Context context) {
        ArrayList<SearchItemData> listdata = new ArrayList<>();
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_1_1), context.getResources().getString(R.string.ortho_1), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_1_2), context.getResources().getString(R.string.ortho_1), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_1_3), context.getResources().getString(R.string.ortho_1), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_1_4), context.getResources().getString(R.string.ortho_1), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_1_5), context.getResources().getString(R.string.ortho_1), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_1_6), context.getResources().getString(R.string.ortho_1), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_2_7), context.getResources().getString(R.string.ortho_2), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_2_8), context.getResources().getString(R.string.ortho_2), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_2_9), context.getResources().getString(R.string.ortho_2), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_10), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_11), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_12), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_13), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_14), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_15), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_16), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_17), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_18), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_19), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_20), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_21), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_22), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_23), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_24), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_25), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_3_26), context.getResources().getString(R.string.ortho_3), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_4), context.getResources().getString(R.string.ortho), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_5_27), context.getResources().getString(R.string.ortho_5), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_5_28), context.getResources().getString(R.string.ortho_5), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_5_29), context.getResources().getString(R.string.ortho_5), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_6_30), context.getResources().getString(R.string.ortho_6), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_6_31), context.getResources().getString(R.string.ortho_6), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_7_32), context.getResources().getString(R.string.ortho_7), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_7_33), context.getResources().getString(R.string.ortho_7), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_8_34), context.getResources().getString(R.string.ortho_8), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_8_35), context.getResources().getString(R.string.ortho_8), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_9_36), context.getResources().getString(R.string.ortho_9), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_9_37), context.getResources().getString(R.string.ortho_9), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_9_38), context.getResources().getString(R.string.ortho_9), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_9_39), context.getResources().getString(R.string.ortho_9), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_10_40), context.getResources().getString(R.string.ortho_10), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_10_41), context.getResources().getString(R.string.ortho_10), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_11_42), context.getResources().getString(R.string.ortho_11), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_11_43), context.getResources().getString(R.string.ortho_11), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_12_44), context.getResources().getString(R.string.ortho_12), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_12_45), context.getResources().getString(R.string.ortho_12), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_12_46), context.getResources().getString(R.string.ortho_12), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_13_47), context.getResources().getString(R.string.ortho_13), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_13_48), context.getResources().getString(R.string.ortho_13), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_14_49), context.getResources().getString(R.string.ortho_14), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_14_50), context.getResources().getString(R.string.ortho_14), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_14_51), context.getResources().getString(R.string.ortho_14), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_14_52), context.getResources().getString(R.string.ortho_14), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_14_53), context.getResources().getString(R.string.ortho_14), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_14_54), context.getResources().getString(R.string.ortho_14), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_15), context.getResources().getString(R.string.ortho), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_16), context.getResources().getString(R.string.ortho), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_55), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_56), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_57), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_58), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_59), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_60), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_61), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_17_62), context.getResources().getString(R.string.ortho_17), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_18), context.getResources().getString(R.string.ortho), R.drawable.app_pen_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.ortho_19), context.getResources().getString(R.string.ortho), R.drawable.app_pen_icon));

        //Punctuation
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_1_1), context.getResources().getString(R.string.punct_1), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_1_2), context.getResources().getString(R.string.punct_1), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_1_3), context.getResources().getString(R.string.punct_1), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_1_4), context.getResources().getString(R.string.punct_1), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_2_5), context.getResources().getString(R.string.punct_2), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_2_6), context.getResources().getString(R.string.punct_2), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_2_7), context.getResources().getString(R.string.punct_2), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_2_8), context.getResources().getString(R.string.punct_2), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_3_9), context.getResources().getString(R.string.punct_3), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_3_10), context.getResources().getString(R.string.punct_3), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_3_11), context.getResources().getString(R.string.punct_3), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_3_12), context.getResources().getString(R.string.punct_3), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_3_13), context.getResources().getString(R.string.punct_3), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_3_14), context.getResources().getString(R.string.punct_3), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_3_15), context.getResources().getString(R.string.punct_3), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_4_16), context.getResources().getString(R.string.punct_4), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_4_17), context.getResources().getString(R.string.punct_4), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_5_18), context.getResources().getString(R.string.punct_5), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_5_19), context.getResources().getString(R.string.punct_5), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_5_20), context.getResources().getString(R.string.punct_5), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_5_21), context.getResources().getString(R.string.punct_5), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_6_22), context.getResources().getString(R.string.punct_6), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_6_23), context.getResources().getString(R.string.punct_6), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_6_24), context.getResources().getString(R.string.punct_6), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_7_25), context.getResources().getString(R.string.punct_7), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_7_26), context.getResources().getString(R.string.punct_7), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_7_27), context.getResources().getString(R.string.punct_7), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_8_28), context.getResources().getString(R.string.punct_8), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_8_29), context.getResources().getString(R.string.punct_8), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_9_30), context.getResources().getString(R.string.punct_9), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_9_31), context.getResources().getString(R.string.punct_9), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_9_32), context.getResources().getString(R.string.punct_9), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_10_33), context.getResources().getString(R.string.punct_10), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_10_34), context.getResources().getString(R.string.punct_10), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_10_35), context.getResources().getString(R.string.punct_10), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_10_36), context.getResources().getString(R.string.punct_10), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_10_37), context.getResources().getString(R.string.punct_10), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_10_38), context.getResources().getString(R.string.punct_10), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_10_39), context.getResources().getString(R.string.punct_10), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_11_41), context.getResources().getString(R.string.punct_11), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_11_42), context.getResources().getString(R.string.punct_11), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_12_43), context.getResources().getString(R.string.punct_12), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_12_44), context.getResources().getString(R.string.punct_12), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_12_45), context.getResources().getString(R.string.punct_12), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_12_46), context.getResources().getString(R.string.punct_12), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_13), context.getResources().getString(R.string.punct), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_47), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_48), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_49), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_50), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_51), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_52), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_53), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_14_54), context.getResources().getString(R.string.punct_14), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_15_55), context.getResources().getString(R.string.punct_15), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_15_56), context.getResources().getString(R.string.punct_15), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_15_57), context.getResources().getString(R.string.punct_15), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_15_58), context.getResources().getString(R.string.punct_15), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_16), context.getResources().getString(R.string.punct), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_17_59), context.getResources().getString(R.string.punct_17), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_17_60), context.getResources().getString(R.string.punct_17), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_17_61), context.getResources().getString(R.string.punct_17), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_17_62), context.getResources().getString(R.string.punct_17), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_17_63), context.getResources().getString(R.string.punct_17), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_18_64), context.getResources().getString(R.string.punct_18), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_18_65), context.getResources().getString(R.string.punct_18), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_18_66), context.getResources().getString(R.string.punct_18), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_18_67), context.getResources().getString(R.string.punct_18), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_18_68), context.getResources().getString(R.string.punct_18), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_18_69), context.getResources().getString(R.string.punct_18), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_19_70), context.getResources().getString(R.string.punct_19), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_19_71), context.getResources().getString(R.string.punct_19), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_19_72), context.getResources().getString(R.string.punct_19), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_20), context.getResources().getString(R.string.punct), R.drawable.app_pencil_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.punct_21), context.getResources().getString(R.string.punct), R.drawable.app_pencil_icon));

        //Analyze Methods
        listdata.add(new SearchItemData(context.getResources().getString(R.string.phonetic_analyze_method), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphemic_analyze_method), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_noun), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_verb), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_adjective), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_numeral), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_adverb), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_participle), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_participle2), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_union), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_particle), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.syntactic_analyze_method_for_simple_sentence), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.syntactic_analyze_method_for_difficult_sentence), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.lexical_analyze_method_for_everyword), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.orthographic_analyze_method_for_everyword), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_black));

        return listdata;
    }

    public static void SearchDataOnClickReferences (Context context, SearchAdapter.SearchHolder searchHolder) {
        RulebookBooleans booleansInMainRules = new RulebookBooleans(context);
        Intent scrollableactivity_in_mainrules = new Intent(context, AppMainRulesScrollableActivityInMainRules.class);
        Intent scrollableactivity_in_analyzemethods = new Intent(context, AppAnalyzeMethodsScrollableActivity.class);

        //Orthography
        if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_1_1))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_1");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_1_2))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_2");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_1_3))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_3");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_1_4))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_4");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_1_5))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_5");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_1_6))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_1_6");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_2_7))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_2_7");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_2_8))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_2_8");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_2_9))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_2_9");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_10))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_10");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_11))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_11");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_12))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_12");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_13))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_13");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_14))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_14");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_15))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_15");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_16))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_16");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_17))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_17");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_18))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_18");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_19))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_19");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_20))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_20");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_21))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_21");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_22))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_22");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_23))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_23");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_24))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_24");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_25))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_25");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_3_26))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_3_26");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_4))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_4_split");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_5_27))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_5_27");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_5_28))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_5_28");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_5_29))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_5_29");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_6_30))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_6_30");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_6_31))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_6_31");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_7_32))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_7_32");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_7_33))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_7_33");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_8_34))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_8_34");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_8_35))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_8_35");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_9_36))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_36");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_9_37))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_37");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_9_38))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_38");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_9_39))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_9_39");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_10_40))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_10_40");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_10_41))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_10_41");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_11_42))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_11_42");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_11_43))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_11_43");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_12_44))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_12_44");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_12_45))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_12_45");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_12_46))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_12_46");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_13_47))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_13_47");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_13_48))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_13_48");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_14_49))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_49");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_14_50))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_50");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_14_51))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_51");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_14_52))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_52");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_14_53))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_53");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_14_54))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_14_54");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_15))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_15_split");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_16))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_16_split");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_55))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_55");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_56))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_56");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_57))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_57");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_58))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_58");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_59))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_59");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_60))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_60");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_61))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_61");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_17_62))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_17_62");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_18))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_18_split");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.ortho_19))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("ortho_19_split");
            context.startActivity(scrollableactivity_in_mainrules);
        }

        //Punctuation
        else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_1_1))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_1_1");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_1_2))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_1_2");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_1_3))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_1_3");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_1_4))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_1_4");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_2_5))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_2_5");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_2_6))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_2_6");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_2_7))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_2_7");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_2_8))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_2_8");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_3_9))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_3_9");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_3_10))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_3_10");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_3_11))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_3_11");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_3_12))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_3_12");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_3_13))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_3_13");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_3_14))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_3_14");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_3_15))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_3_15");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_4_16))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_4_16");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_4_17))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_4_17");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_5_18))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_5_18");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_5_19))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_5_19");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_5_20))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_5_20");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_5_21))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_5_21");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_6_22))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_6_22");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_6_23))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_6_23");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_6_24))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_6_24");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_7_25))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_7_25");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_7_26))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_7_26");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_7_27))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_7_27");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_8_28))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_8_28");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_8_29))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_8_29");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_9_30))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_9_30");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_9_31))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_9_31");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_9_32))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_9_32");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_33))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_33");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_34))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_34");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_35))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_35");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_36))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_36");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_37))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_37");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_38))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_38");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_39))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_39");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_10_40))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_10_40");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_11_41))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_11_41");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_11_42))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_11_42");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_12_43))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_12_43");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_12_44))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_12_44");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_12_45))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_12_45");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_12_46))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_12_46");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_13))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_13_split");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_47))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_47");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_48))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_48");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_49))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_49");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_50))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_50");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_51))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_51");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_52))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_52");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_53))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_53");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_14_54))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_14_54");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_15_55))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_15_55");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_15_56))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_15_56");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_15_57))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_15_57");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_15_58))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_15_58");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_16))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_16_split");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_17_59))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_17_59");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_17_60))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_17_60");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_17_61))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_17_61");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_17_62))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_17_62");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_17_63))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_17_63");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_18_64))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_18_64");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_18_65))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_18_65");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_18_66))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_18_66");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_18_67))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_18_67");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_18_68))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_18_68");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_18_69))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_18_69");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_19_70))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_19_70");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_19_71))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_19_71");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_19_72))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_19_72");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_20))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_20_split");
            context.startActivity(scrollableactivity_in_mainrules);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.punct_21))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("punct_21_split");
            context.startActivity(scrollableactivity_in_mainrules);
        }

        //Analyze Methods
        else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.phonetic_analyze_method))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("phonetic_analyze_method");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphemic_analyze_method))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphemic_analyze_method");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_noun))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_noun");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_verb))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_verb");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_adjective))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_adjective");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_numeral))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_numeral");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_adverb))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_adverb");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_participle))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_participle");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_participle2))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_participle2");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_pretext))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_pretext");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_union))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_union");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.morphological_analyze_method_for_particle))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("morphological_analyze_method_for_particle");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.syntactic_analyze_method_for_simple_sentence))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("syntactic_analyze_method_for_simple_sentence");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.syntactic_analyze_method_for_difficult_sentence))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("syntactic_analyze_method_for_difficult_sentence");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.lexical_analyze_method_for_everyword))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("lexical_analyze_method_for_everyword");
            context.startActivity(scrollableactivity_in_analyzemethods);
        } else if (searchHolder.search_item_title.getText().equals(context.getResources().getString(R.string.orthographic_analyze_method_for_everyword))) {
            booleansInMainRules.setRulebookMainRulesFragmentOpenedBoolean("orthographic_analyze_method_for_everyword");
            context.startActivity(scrollableactivity_in_analyzemethods);
        }
    }


}
