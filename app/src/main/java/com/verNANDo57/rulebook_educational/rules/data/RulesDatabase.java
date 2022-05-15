/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.rules.data;

import android.content.Context;
import android.content.Intent;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.AppBaseScrollableActivity;
import com.verNANDo57.rulebook_educational.rules.Constants;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

import java.util.ArrayList;

public class RulesDatabase {

    public static ArrayList<RuleItemData> setupOrthographyRulesData (Context context) {
        ArrayList<RuleItemData> listdata = new ArrayList<>();

        //Orthography
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_1_1), context.getResources().getString(R.string.ortho_1), Constants.ORTHOGRAPHY_1_1, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_1_2), context.getResources().getString(R.string.ortho_1), Constants.ORTHOGRAPHY_1_2, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_1_3), context.getResources().getString(R.string.ortho_1), Constants.ORTHOGRAPHY_1_3, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_1_4), context.getResources().getString(R.string.ortho_1), Constants.ORTHOGRAPHY_1_4, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_1_5), context.getResources().getString(R.string.ortho_1), Constants.ORTHOGRAPHY_1_5, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_1_6), context.getResources().getString(R.string.ortho_1), Constants.ORTHOGRAPHY_1_6, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_2_7), context.getResources().getString(R.string.ortho_2), Constants.ORTHOGRAPHY_2_7, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_2_8), context.getResources().getString(R.string.ortho_2), Constants.ORTHOGRAPHY_2_8, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_2_9), context.getResources().getString(R.string.ortho_2), Constants.ORTHOGRAPHY_2_9, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_10), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_10, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_11), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_11, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_12), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_12, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_13), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_13, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_14), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_14, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_15), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_15, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_16), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_16, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_17), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_17, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_18), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_18, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_19), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_19, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_20), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_20, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_21), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_21, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_22), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_22, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_23), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_23, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_24), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_24, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_25), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_25, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_3_26), context.getResources().getString(R.string.ortho_3), Constants.ORTHOGRAPHY_3_26, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_4), context.getResources().getString(R.string.ortho), Constants.ORTHOGRAPHY_4_SPLIT, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_5_27), context.getResources().getString(R.string.ortho_5), Constants.ORTHOGRAPHY_5_27, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_5_28), context.getResources().getString(R.string.ortho_5), Constants.ORTHOGRAPHY_5_28, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_5_29), context.getResources().getString(R.string.ortho_5), Constants.ORTHOGRAPHY_5_29, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_6_30), context.getResources().getString(R.string.ortho_6), Constants.ORTHOGRAPHY_6_30, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_6_31), context.getResources().getString(R.string.ortho_6), Constants.ORTHOGRAPHY_6_31, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_7_32), context.getResources().getString(R.string.ortho_7), Constants.ORTHOGRAPHY_7_32, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_7_33), context.getResources().getString(R.string.ortho_7), Constants.ORTHOGRAPHY_7_33, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_8_34), context.getResources().getString(R.string.ortho_8), Constants.ORTHOGRAPHY_8_34, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_8_35), context.getResources().getString(R.string.ortho_8), Constants.ORTHOGRAPHY_8_35, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_9_36), context.getResources().getString(R.string.ortho_9), Constants.ORTHOGRAPHY_9_36, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_9_37), context.getResources().getString(R.string.ortho_9), Constants.ORTHOGRAPHY_9_37, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_9_38), context.getResources().getString(R.string.ortho_9), Constants.ORTHOGRAPHY_9_38, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_9_39), context.getResources().getString(R.string.ortho_9), Constants.ORTHOGRAPHY_9_39, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_10_40), context.getResources().getString(R.string.ortho_10), Constants.ORTHOGRAPHY_10_40, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_10_41), context.getResources().getString(R.string.ortho_10), Constants.ORTHOGRAPHY_10_41, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_11_42), context.getResources().getString(R.string.ortho_11), Constants.ORTHOGRAPHY_11_42, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_11_43), context.getResources().getString(R.string.ortho_11), Constants.ORTHOGRAPHY_11_43, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_12_44), context.getResources().getString(R.string.ortho_12), Constants.ORTHOGRAPHY_12_44, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_12_45), context.getResources().getString(R.string.ortho_12), Constants.ORTHOGRAPHY_12_45, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_12_46), context.getResources().getString(R.string.ortho_12), Constants.ORTHOGRAPHY_12_46, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_13_47), context.getResources().getString(R.string.ortho_13), Constants.ORTHOGRAPHY_13_47, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_13_48), context.getResources().getString(R.string.ortho_13), Constants.ORTHOGRAPHY_13_48, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_14_49), context.getResources().getString(R.string.ortho_14), Constants.ORTHOGRAPHY_14_49, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_14_50), context.getResources().getString(R.string.ortho_14), Constants.ORTHOGRAPHY_14_50, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_14_51), context.getResources().getString(R.string.ortho_14), Constants.ORTHOGRAPHY_14_51, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_14_52), context.getResources().getString(R.string.ortho_14), Constants.ORTHOGRAPHY_14_52, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_14_53), context.getResources().getString(R.string.ortho_14), Constants.ORTHOGRAPHY_14_53, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_14_54), context.getResources().getString(R.string.ortho_14), Constants.ORTHOGRAPHY_14_54, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_15), context.getResources().getString(R.string.ortho), Constants.ORTHOGRAPHY_15_SPLIT, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_16), context.getResources().getString(R.string.ortho), Constants.ORTHOGRAPHY_16_SPLIT, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_55), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_55, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_56), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_56, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_57), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_57, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_58), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_58, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_59), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_59, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_60), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_60, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_61), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_61, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_17_62), context.getResources().getString(R.string.ortho_17), Constants.ORTHOGRAPHY_17_62, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_18), context.getResources().getString(R.string.ortho), Constants.ORTHOGRAPHY_18_SPLIT, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.ortho_19), context.getResources().getString(R.string.ortho), Constants.ORTHOGRAPHY_19_SPLIT, R.drawable.app_pen_icon, R.drawable.app_bookmark_removed));

        return listdata;
    }

    public static ArrayList<RuleItemData> setupPunctuationRulesData (Context context) {
        ArrayList<RuleItemData> listdata = new ArrayList<>();
        //Punctuation
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_1_1), context.getResources().getString(R.string.punct_1), Constants.PUNCTUATION_1_1, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_1_2), context.getResources().getString(R.string.punct_1), Constants.PUNCTUATION_1_2, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_1_3), context.getResources().getString(R.string.punct_1), Constants.PUNCTUATION_1_3, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_1_4), context.getResources().getString(R.string.punct_1), Constants.PUNCTUATION_1_4, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_2_5), context.getResources().getString(R.string.punct_2), Constants.PUNCTUATION_2_5, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_2_6), context.getResources().getString(R.string.punct_2), Constants.PUNCTUATION_2_6, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_2_7), context.getResources().getString(R.string.punct_2), Constants.PUNCTUATION_2_7, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_2_8), context.getResources().getString(R.string.punct_2), Constants.PUNCTUATION_2_8, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_3_9), context.getResources().getString(R.string.punct_3), Constants.PUNCTUATION_3_9, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_3_10), context.getResources().getString(R.string.punct_3), Constants.PUNCTUATION_3_10, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_3_11), context.getResources().getString(R.string.punct_3), Constants.PUNCTUATION_3_11, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_3_12), context.getResources().getString(R.string.punct_3), Constants.PUNCTUATION_3_12, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_3_13), context.getResources().getString(R.string.punct_3), Constants.PUNCTUATION_3_13, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_3_14), context.getResources().getString(R.string.punct_3), Constants.PUNCTUATION_3_14, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_3_15), context.getResources().getString(R.string.punct_3), Constants.PUNCTUATION_3_15, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_4_16), context.getResources().getString(R.string.punct_4), Constants.PUNCTUATION_4_16, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_4_17), context.getResources().getString(R.string.punct_4), Constants.PUNCTUATION_4_17, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_5_18), context.getResources().getString(R.string.punct_5), Constants.PUNCTUATION_5_18, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_5_19), context.getResources().getString(R.string.punct_5), Constants.PUNCTUATION_5_19, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_5_20), context.getResources().getString(R.string.punct_5), Constants.PUNCTUATION_5_20, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_5_21), context.getResources().getString(R.string.punct_5), Constants.PUNCTUATION_5_21, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_6_22), context.getResources().getString(R.string.punct_6), Constants.PUNCTUATION_6_22, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_6_23), context.getResources().getString(R.string.punct_6), Constants.PUNCTUATION_6_23, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_6_24), context.getResources().getString(R.string.punct_6), Constants.PUNCTUATION_6_24, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_7_25), context.getResources().getString(R.string.punct_7), Constants.PUNCTUATION_7_25, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_7_26), context.getResources().getString(R.string.punct_7), Constants.PUNCTUATION_7_26, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_7_27), context.getResources().getString(R.string.punct_7), Constants.PUNCTUATION_7_27, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_8_28), context.getResources().getString(R.string.punct_8), Constants.PUNCTUATION_8_28, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_8_29), context.getResources().getString(R.string.punct_8), Constants.PUNCTUATION_8_29, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_9_30), context.getResources().getString(R.string.punct_9), Constants.PUNCTUATION_9_30, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_9_31), context.getResources().getString(R.string.punct_9), Constants.PUNCTUATION_9_31, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_9_32), context.getResources().getString(R.string.punct_9), Constants.PUNCTUATION_9_32, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_33), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_33, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_34), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_34, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_35), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_35, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_36), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_36, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_37), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_37, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_38), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_38, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_39), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_39, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_10_40), context.getResources().getString(R.string.punct_10), Constants.PUNCTUATION_10_40, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_11_41), context.getResources().getString(R.string.punct_11), Constants.PUNCTUATION_11_41, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_11_42), context.getResources().getString(R.string.punct_11), Constants.PUNCTUATION_11_42, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_12_43), context.getResources().getString(R.string.punct_12), Constants.PUNCTUATION_12_43, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_12_44), context.getResources().getString(R.string.punct_12), Constants.PUNCTUATION_12_44, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_12_45), context.getResources().getString(R.string.punct_12), Constants.PUNCTUATION_12_45, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_12_46), context.getResources().getString(R.string.punct_12), Constants.PUNCTUATION_12_46, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_13), context.getResources().getString(R.string.punct), Constants.PUNCTUATION_13_SPLIT, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_47), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_47, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_48), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_48, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_49), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_49, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_50), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_50, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_51), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_51, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_52), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_52, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_53), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_53, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_14_54), context.getResources().getString(R.string.punct_14), Constants.PUNCTUATION_14_54, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_15_55), context.getResources().getString(R.string.punct_15), Constants.PUNCTUATION_15_55, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_15_56), context.getResources().getString(R.string.punct_15), Constants.PUNCTUATION_15_56, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_15_57), context.getResources().getString(R.string.punct_15), Constants.PUNCTUATION_15_57, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_15_58), context.getResources().getString(R.string.punct_15), Constants.PUNCTUATION_15_58, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_16), context.getResources().getString(R.string.punct), Constants.PUNCTUATION_16_SPLIT, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_17_59), context.getResources().getString(R.string.punct_17), Constants.PUNCTUATION_17_59, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_17_60), context.getResources().getString(R.string.punct_17), Constants.PUNCTUATION_17_60, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_17_61), context.getResources().getString(R.string.punct_17), Constants.PUNCTUATION_17_61, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_17_62), context.getResources().getString(R.string.punct_17), Constants.PUNCTUATION_17_62, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_17_63), context.getResources().getString(R.string.punct_17), Constants.PUNCTUATION_17_63, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_18_64), context.getResources().getString(R.string.punct_18), Constants.PUNCTUATION_18_64, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_18_65), context.getResources().getString(R.string.punct_18), Constants.PUNCTUATION_18_65, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_18_66), context.getResources().getString(R.string.punct_18), Constants.PUNCTUATION_18_66, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_18_67), context.getResources().getString(R.string.punct_18), Constants.PUNCTUATION_18_67, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_18_68), context.getResources().getString(R.string.punct_18), Constants.PUNCTUATION_18_68, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_18_69), context.getResources().getString(R.string.punct_18), Constants.PUNCTUATION_18_69, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_19_70), context.getResources().getString(R.string.punct_19), Constants.PUNCTUATION_19_70, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_19_71), context.getResources().getString(R.string.punct_19), Constants.PUNCTUATION_19_71, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_19_72), context.getResources().getString(R.string.punct_19), Constants.PUNCTUATION_19_72, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_20), context.getResources().getString(R.string.punct), Constants.PUNCTUATION_20_SPLIT, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.punct_21), context.getResources().getString(R.string.punct), Constants.PUNCTUATION_21_SPLIT, R.drawable.app_pencil_icon, R.drawable.app_bookmark_removed));

        return listdata;
    }

    public static ArrayList<RuleItemData> setupAnalyzeMethodsRulesData (Context context){
        ArrayList<RuleItemData> listdata = new ArrayList<>();

        //Analyze Methods
        listdata.add(new RuleItemData(context.getResources().getString(R.string.lexical_analyze_method), context.getResources().getString(R.string.analyze_methods), Constants.LEXICAL_ANALYZE_METHOD, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphemic_analyze_method), context.getResources().getString(R.string.analyze_methods), Constants.MORPHEMIC_ANALYZE_METHOD, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_adjective), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADJECTIVE, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_adverb), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADVERB, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_conjunctions), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_CONJUNCTIONS,  R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_noun), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NOUN, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_numeral), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NUMERAL, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_participle), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_participle2), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE2, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_particle), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICLE, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_pretext), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PRETEXT, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.morphological_analyze_method_for_verb), context.getResources().getString(R.string.analyze_methods), Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_VERB, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.orthographic_analyze_method), context.getResources().getString(R.string.analyze_methods), Constants.ORTHOGRAPHIC_ANALYZE_METHOD, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.phonetic_analyze_method), context.getResources().getString(R.string.analyze_methods), Constants.PHONETIC_ANALYZE_METHOD, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.syntactic_analyze_method_for_difficult_sentence), context.getResources().getString(R.string.analyze_methods), Constants.SYNTACTIC_ANALYZE_METHOD_FOR_DIFFICULT_SENTENCE, R.drawable.app_search, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.syntactic_analyze_method_for_simple_sentence), context.getResources().getString(R.string.analyze_methods), Constants.SYNTACTIC_ANALYZE_METHOD_FOR_SIMPLE_SENTENCE, R.drawable.app_search, R.drawable.app_bookmark_removed));

        return listdata;
    }

    public static ArrayList<RuleItemData> setupDictionariesRulesData (Context context) {
        ArrayList<RuleItemData> listdata = new ArrayList<>();

        //Dictionaries
        listdata.add(new RuleItemData(context.getResources().getString(R.string.vocabulary_words), context.getResources().getString(R.string.dictionaries), Constants.DICT_VOCABULARY_WORDS, R.drawable.app_char_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.phrasebook), context.getResources().getString(R.string.dictionaries), Constants.DICT_PHRASEBOOK, R.drawable.app_char_icon, R.drawable.app_bookmark_removed));
        listdata.add(new RuleItemData(context.getResources().getString(R.string.orthoepical_dictionary), context.getResources().getString(R.string.dictionaries), Constants.DICT_ORTHOEPICAL, R.drawable.app_char_icon, R.drawable.app_bookmark_removed));

        return listdata;
    }

    public static void performOnClickAction(Context context, String item_key, String item_title, String item_summary) {
        Intent basescrollableactivity = new Intent(context, AppBaseScrollableActivity.class);
        basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_KEY, item_key);
        basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_TITLE, item_title);
        basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_SUMMARY, item_summary);
        context.startActivity(basescrollableactivity);
    }
}
