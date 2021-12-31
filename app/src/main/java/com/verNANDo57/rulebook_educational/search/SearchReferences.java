package com.verNANDo57.rulebook_educational.search;

import android.content.Context;
import android.content.Intent;

import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.rules.AppBaseScrollableActivity;
import com.verNANDo57.rulebook_educational.utils.AppUtils;
import com.verNANDo57.rulebook_educational.rules.Constants;

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
        listdata.add(new SearchItemData(context.getResources().getString(R.string.phonetic_analyze_method), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphemic_analyze_method), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_noun), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_verb), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_adjective), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_numeral), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_adverb), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_participle), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_participle2), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_conjunctions), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.morphological_analyze_method_for_particle), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.syntactic_analyze_method_for_simple_sentence), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.syntactic_analyze_method_for_difficult_sentence), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.lexical_analyze_method), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.orthographic_analyze_method), context.getResources().getString(R.string.analyze_methods), R.drawable.ic_search_menu));

        //Dictionaries
        listdata.add(new SearchItemData(context.getResources().getString(R.string.vocabulary_words), context.getResources().getString(R.string.dictionaries), R.drawable.app_char_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.phrasebook), context.getResources().getString(R.string.dictionaries), R.drawable.app_char_icon));
        listdata.add(new SearchItemData(context.getResources().getString(R.string.orthoepical_dictionary), context.getResources().getString(R.string.dictionaries), R.drawable.app_char_icon));

        return listdata;
    }

    public static void performSearchItemOnClickAction(Context context, String title) {
        Intent basescrollableactivity = new Intent(context, AppBaseScrollableActivity.class);

        //Orthography
        if (title.equals(context.getResources().getString(R.string.ortho_1_1))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_1_1);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_1_2))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_1_2);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_1_3))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_1_3);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_1_4))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_1_4);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_1_5))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_1_5);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_1_6))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_1_6);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_2_7))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_2_7);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_2_8))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_2_8);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_2_9))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_2_9);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_10))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_10);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_11))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_11);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_12))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_12);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_13))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_13);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_14))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_14);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_15))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_15);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_16))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_16);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_17))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_17);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_18))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_18);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_19))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_19);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_20))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_20);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_21))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_21);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_22))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_22);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_23))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_23);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_24))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_24);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_25))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_25);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_3_26))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_3_26);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_4))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_4_SPLIT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_5_27))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_5_27);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_5_28))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_5_28);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_5_29))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_5_29);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_6_30))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_6_30);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_6_31))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_6_31);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_7_32))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_7_32);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_7_33))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_7_33);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_8_34))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_8_34);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_8_35))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_8_35);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_9_36))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_9_36);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_9_37))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_9_37);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_9_38))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_9_38);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_9_39))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_9_39);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_10_40))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_10_40);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_10_41))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_10_41);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_11_42))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_11_42);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_11_43))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_11_43);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_12_44))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_12_44);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_12_45))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_12_45);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_12_46))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_12_46);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_13_47))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_13_47);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_13_48))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_13_48);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_14_49))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_14_49);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_14_50))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_14_50);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_14_51))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_14_51);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_14_52))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_14_52);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_14_53))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_14_53);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_14_54))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_14_54);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_15))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_15_SPLIT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_16))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_16_SPLIT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_55))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_55);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_56))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_56);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_57))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_57);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_58))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_58);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_59))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_59);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_60))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_60);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_61))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_61);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_17_62))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_17_62);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_18))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_18_SPLIT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.ortho_19))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHY_19_SPLIT);
            context.startActivity(basescrollableactivity);
        }

        //Punctuation
        else if (title.equals(context.getResources().getString(R.string.punct_1_1))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_1_1);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_1_2))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_1_2);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_1_3))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_1_3);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_1_4))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_1_4);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_2_5))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_2_5);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_2_6))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_2_6);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_2_7))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_2_7);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_2_8))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_2_8);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_3_9))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_3_9);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_3_10))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_3_10);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_3_11))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_3_11);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_3_12))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_3_12);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_3_13))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_3_13);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_3_14))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_3_14);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_3_15))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_3_15);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_4_16))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_4_16);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_4_17))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_4_17);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_5_18))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_5_18);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_5_19))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_5_19);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_5_20))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_5_20);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_5_21))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_5_21);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_6_22))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_6_22);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_6_23))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_6_23);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_6_24))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_6_24);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_7_25))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_7_25);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_7_26))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_7_26);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_7_27))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_7_27);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_8_28))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_8_28);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_8_29))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_8_29);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_9_30))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_9_30);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_9_31))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_9_31);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_9_32))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_9_32);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_33))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_33);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_34))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_34);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_35))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_35);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_36))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_36);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_37))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_37);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_38))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_38);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_39))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_39);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_10_40))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_10_40);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_11_41))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_11_41);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_11_42))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_11_42);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_12_43))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_12_43);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_12_44))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_12_44);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_12_45))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_12_45);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_12_46))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_12_46);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_13))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_13_SPLIT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_47))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_47);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_48))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_48);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_49))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_49);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_50))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_50);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_51))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_51);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_52))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_52);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_53))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_53);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_14_54))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_14_54);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_15_55))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_15_55);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_15_56))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_15_56);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_15_57))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_15_57);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_15_58))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_15_58);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_16))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_16_SPLIT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_17_59))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_17_59);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_17_60))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_17_60);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_17_61))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_17_61);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_17_62))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_17_62);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_17_63))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_17_63);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_18_64))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_18_64);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_18_65))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_18_65);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_18_66))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_18_66);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_18_67))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_18_67);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_18_68))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_18_68);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_18_69))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_18_69);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_19_70))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_19_70);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_19_71))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_19_71);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_19_72))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_19_72);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_20))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_20_SPLIT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.punct_21))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PUNCTUATION_21_SPLIT);
            context.startActivity(basescrollableactivity);
        }

        //Analyze Methods
        else if (title.equals(context.getResources().getString(R.string.phonetic_analyze_method))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.PHONETIC_ANALYZE_METHOD);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphemic_analyze_method))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHEMIC_ANALYZE_METHOD);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_noun))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NOUN);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_verb))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_VERB);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_adjective))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADJECTIVE);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_numeral))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NUMERAL);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_adverb))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADVERB);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_participle))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_participle2))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE2);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_pretext))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PRETEXT);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_conjunctions))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_CONJUNCTIONS);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.morphological_analyze_method_for_particle))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICLE);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.syntactic_analyze_method_for_simple_sentence))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.SYNTACTIC_ANALYZE_METHOD_FOR_SIMPLE_SENTENCE);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.syntactic_analyze_method_for_difficult_sentence))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.SYNTACTIC_ANALYZE_METHOD_FOR_DIFFICULT_SENTENCE);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.lexical_analyze_method))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.LEXICAL_ANALYZE_METHOD);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.orthographic_analyze_method))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.ORTHOGRAPHIC_ANALYZE_METHOD);
            context.startActivity(basescrollableactivity);
        }

        // Dictionaries
        else if (title.equals(context.getResources().getString(R.string.vocabulary_words))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.DICT_VOCABULARY_WORDS);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.phrasebook))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.DICT_PHRASEBOOK);
            context.startActivity(basescrollableactivity);
        } else if (title.equals(context.getResources().getString(R.string.orthoepical_dictionary))) {
            basescrollableactivity.putExtra(AppUtils.EXTRA_DATA_NAME, Constants.DICT_ORTHOEPICAL);
            context.startActivity(basescrollableactivity);
        }
    }

    public static String getTitleOrthography(Context context, String input) {
        String output = null;

        switch (input) {
            case Constants.ORTHOGRAPHY_1_1:
                output = context.getResources().getString(R.string.ortho_1_1);
                break;
            case Constants.ORTHOGRAPHY_1_2:
                output = context.getResources().getString(R.string.ortho_1_2);
                break;
            case Constants.ORTHOGRAPHY_1_3:
                output = context.getResources().getString(R.string.ortho_1_3);
                break;
            case Constants.ORTHOGRAPHY_1_4:
                output = context.getResources().getString(R.string.ortho_1_4);
                break;
            case Constants.ORTHOGRAPHY_1_5:
                output = context.getResources().getString(R.string.ortho_1_5);
                break;
            case Constants.ORTHOGRAPHY_1_6:
                output = context.getResources().getString(R.string.ortho_1_6);
                break;
            case Constants.ORTHOGRAPHY_2_7:
                output = context.getResources().getString(R.string.ortho_2_7);
                break;
            case Constants.ORTHOGRAPHY_2_8:
                output = context.getResources().getString(R.string.ortho_2_8);
                break;
            case Constants.ORTHOGRAPHY_2_9:
                output = context.getResources().getString(R.string.ortho_2_9);
                break;
            case Constants.ORTHOGRAPHY_3_10:
                output = context.getResources().getString(R.string.ortho_3_10);
                break;
            case Constants.ORTHOGRAPHY_3_11:
                output = context.getResources().getString(R.string.ortho_3_11);
                break;
            case Constants.ORTHOGRAPHY_3_12:
                output = context.getResources().getString(R.string.ortho_3_12);
                break;
            case Constants.ORTHOGRAPHY_3_13:
                output = context.getResources().getString(R.string.ortho_3_13);
                break;
            case Constants.ORTHOGRAPHY_3_14:
                output = context.getResources().getString(R.string.ortho_3_14);
                break;
            case Constants.ORTHOGRAPHY_3_15:
                output = context.getResources().getString(R.string.ortho_3_15);
                break;
            case Constants.ORTHOGRAPHY_3_16:
                output = context.getResources().getString(R.string.ortho_3_16);
                break;
            case Constants.ORTHOGRAPHY_3_17:
                output = context.getResources().getString(R.string.ortho_3_17);
                break;
            case Constants.ORTHOGRAPHY_3_18:
                output = context.getResources().getString(R.string.ortho_3_18);
                break;
            case Constants.ORTHOGRAPHY_3_19:
                output = context.getResources().getString(R.string.ortho_3_19);
                break;
            case Constants.ORTHOGRAPHY_3_20:
                output = context.getResources().getString(R.string.ortho_3_20);
                break;
            case Constants.ORTHOGRAPHY_3_21:
                output = context.getResources().getString(R.string.ortho_3_21);
                break;
            case Constants.ORTHOGRAPHY_3_22:
                output = context.getResources().getString(R.string.ortho_3_22);
                break;
            case Constants.ORTHOGRAPHY_3_23:
                output = context.getResources().getString(R.string.ortho_3_23);
                break;
            case Constants.ORTHOGRAPHY_3_24:
                output = context.getResources().getString(R.string.ortho_3_24);
                break;
            case Constants.ORTHOGRAPHY_3_25:
                output = context.getResources().getString(R.string.ortho_3_25);
                break;
            case Constants.ORTHOGRAPHY_3_26:
                output = context.getResources().getString(R.string.ortho_3_26);
                break;
            case Constants.ORTHOGRAPHY_4_SPLIT:
                output = context.getResources().getString(R.string.ortho_4);
                break;
            case Constants.ORTHOGRAPHY_5_27:
                output = context.getResources().getString(R.string.ortho_5_27);
                break;
            case Constants.ORTHOGRAPHY_5_28:
                output = context.getResources().getString(R.string.ortho_5_28);
                break;
            case Constants.ORTHOGRAPHY_5_29:
                output = context.getResources().getString(R.string.ortho_5_29);
                break;
            case Constants.ORTHOGRAPHY_6_30:
                output = context.getResources().getString(R.string.ortho_6_30);
                break;
            case Constants.ORTHOGRAPHY_6_31:
                output = context.getResources().getString(R.string.ortho_6_31);
                break;
            case Constants.ORTHOGRAPHY_7_32:
                output = context.getResources().getString(R.string.ortho_7_32);
                break;
            case Constants.ORTHOGRAPHY_7_33:
                output = context.getResources().getString(R.string.ortho_7_33);
                break;
            case Constants.ORTHOGRAPHY_8_34:
                output = context.getResources().getString(R.string.ortho_8_34);
                break;
            case Constants.ORTHOGRAPHY_8_35:
                output = context.getResources().getString(R.string.ortho_8_35);
                break;
            case Constants.ORTHOGRAPHY_9_36:
                output = context.getResources().getString(R.string.ortho_9_36);
                break;
            case Constants.ORTHOGRAPHY_9_37:
                output = context.getResources().getString(R.string.ortho_9_37);
                break;
            case Constants.ORTHOGRAPHY_9_38:
                output = context.getResources().getString(R.string.ortho_9_38);
                break;
            case Constants.ORTHOGRAPHY_9_39:
                output = context.getResources().getString(R.string.ortho_9_39);
                break;
            case Constants.ORTHOGRAPHY_10_40:
                output = context.getResources().getString(R.string.ortho_10_40);
                break;
            case Constants.ORTHOGRAPHY_10_41:
                output = context.getResources().getString(R.string.ortho_10_41);
                break;
            case Constants.ORTHOGRAPHY_11_42:
                output = context.getResources().getString(R.string.ortho_11_42);
                break;
            case Constants.ORTHOGRAPHY_11_43:
                output = context.getResources().getString(R.string.ortho_11_43);
                break;
            case Constants.ORTHOGRAPHY_12_44:
                output = context.getResources().getString(R.string.ortho_12_44);
                break;
            case Constants.ORTHOGRAPHY_12_45:
                output = context.getResources().getString(R.string.ortho_12_45);
                break;
            case Constants.ORTHOGRAPHY_12_46:
                output = context.getResources().getString(R.string.ortho_12_46);
                break;
            case Constants.ORTHOGRAPHY_13_47:
                output = context.getResources().getString(R.string.ortho_13_47);
                break;
            case Constants.ORTHOGRAPHY_13_48:
                output = context.getResources().getString(R.string.ortho_13_48);
                break;
            case Constants.ORTHOGRAPHY_14_49:
                output = context.getResources().getString(R.string.ortho_14_49);
                break;
            case Constants.ORTHOGRAPHY_14_50:
                output = context.getResources().getString(R.string.ortho_14_50);
                break;
            case Constants.ORTHOGRAPHY_14_51:
                output = context.getResources().getString(R.string.ortho_14_51);
                break;
            case Constants.ORTHOGRAPHY_14_52:
                output = context.getResources().getString(R.string.ortho_14_52);
                break;
            case Constants.ORTHOGRAPHY_14_53:
                output = context.getResources().getString(R.string.ortho_14_53);
                break;
            case Constants.ORTHOGRAPHY_14_54:
                output = context.getResources().getString(R.string.ortho_14_54);
                break;
            case Constants.ORTHOGRAPHY_15_SPLIT:
                output = context.getResources().getString(R.string.ortho_15);
                break;
            case Constants.ORTHOGRAPHY_16_SPLIT:
                output = context.getResources().getString(R.string.ortho_16);
                break;
            case Constants.ORTHOGRAPHY_17_55:
                output = context.getResources().getString(R.string.ortho_17_55);
                break;
            case Constants.ORTHOGRAPHY_17_56:
                output = context.getResources().getString(R.string.ortho_17_56);
                break;
            case Constants.ORTHOGRAPHY_17_57:
                output = context.getResources().getString(R.string.ortho_17_57);
                break;
            case Constants.ORTHOGRAPHY_17_58:
                output = context.getResources().getString(R.string.ortho_17_58);
                break;
            case Constants.ORTHOGRAPHY_17_59:
                output = context.getResources().getString(R.string.ortho_17_59);
                break;
            case Constants.ORTHOGRAPHY_17_60:
                output = context.getResources().getString(R.string.ortho_17_60);
                break;
            case Constants.ORTHOGRAPHY_17_61:
                output = context.getResources().getString(R.string.ortho_17_61);
                break;
            case Constants.ORTHOGRAPHY_17_62:
                output = context.getResources().getString(R.string.ortho_17_62);
                break;
            case Constants.ORTHOGRAPHY_18_SPLIT:
                output = context.getResources().getString(R.string.ortho_18);
                break;
            case Constants.ORTHOGRAPHY_19_SPLIT:
                output = context.getResources().getString(R.string.ortho_19);
                break;
        }
        return output;
    }

    public static String getSummaryOrthography(Context context, String input) {
        String output = context.getResources().getString(R.string.ortho);

        if (input.contains(Constants.ORTHOGRAPHY_1)) {
            output = context.getResources().getString(R.string.ortho_1);
        } else if (input.contains(Constants.ORTHOGRAPHY_2)) {
            output = context.getResources().getString(R.string.ortho_2);
        } else if (input.contains(Constants.ORTHOGRAPHY_3)) {
            output = context.getResources().getString(R.string.ortho_3);
        } else if (input.contains(Constants.ORTHOGRAPHY_5)) {
            output = context.getResources().getString(R.string.ortho_5);
        } else if (input.contains(Constants.ORTHOGRAPHY_6)) {
            output = context.getResources().getString(R.string.ortho_6);
        } else if (input.contains(Constants.ORTHOGRAPHY_7)) {
            output = context.getResources().getString(R.string.ortho_7);
        } else if (input.contains(Constants.ORTHOGRAPHY_8)) {
            output = context.getResources().getString(R.string.ortho_8);
        } else if (input.contains(Constants.ORTHOGRAPHY_9)) {
            output = context.getResources().getString(R.string.ortho_9);
        } else if (input.contains(Constants.ORTHOGRAPHY_10)) {
            output = context.getResources().getString(R.string.ortho_10);
        } else if (input.contains(Constants.ORTHOGRAPHY_11)) {
            output = context.getResources().getString(R.string.ortho_11);
        } else if (input.contains(Constants.ORTHOGRAPHY_12)) {
            output = context.getResources().getString(R.string.ortho_12);
        } else if (input.contains(Constants.ORTHOGRAPHY_13)) {
            output = context.getResources().getString(R.string.ortho_13);
        } else if (input.contains(Constants.ORTHOGRAPHY_14)) {
            output = context.getResources().getString(R.string.ortho_14);
        } else if (input.contains(Constants.ORTHOGRAPHY_17)) {
            output = context.getResources().getString(R.string.ortho_17);
        }

        return output;
    }

    public static String getTitlePunctuation(Context context, String input) {
        String output = null;

        switch (input){
            case Constants.PUNCTUATION_1_1:
                output = context.getResources().getString(R.string.punct_1_1);
                break;
            case Constants.PUNCTUATION_1_2:
                output = context.getResources().getString(R.string.punct_1_2);
                break;
            case Constants.PUNCTUATION_1_3:
                output = context.getResources().getString(R.string.punct_1_3);
                break;
            case Constants.PUNCTUATION_1_4:
                output = context.getResources().getString(R.string.punct_1_4);
                break;
            case Constants.PUNCTUATION_2_5:
                output = context.getResources().getString(R.string.punct_2_5);
                break;
            case Constants.PUNCTUATION_2_6:
                output = context.getResources().getString(R.string.punct_2_6);
                break;
            case Constants.PUNCTUATION_2_7:
                output = context.getResources().getString(R.string.punct_2_7);
                break;
            case Constants.PUNCTUATION_2_8:
                output = context.getResources().getString(R.string.punct_2_8);
                break;
            case Constants.PUNCTUATION_3_9:
                output = context.getResources().getString(R.string.punct_3_9);
                break;
            case Constants.PUNCTUATION_3_10:
                output = context.getResources().getString(R.string.punct_3_10);
                break;
            case Constants.PUNCTUATION_3_11:
                output = context.getResources().getString(R.string.punct_3_11);
                break;
            case Constants.PUNCTUATION_3_12:
                output = context.getResources().getString(R.string.punct_3_12);
                break;
            case Constants.PUNCTUATION_3_13:
                output = context.getResources().getString(R.string.punct_3_13);
                break;
            case Constants.PUNCTUATION_3_14:
                output = context.getResources().getString(R.string.punct_3_14);
                break;
            case Constants.PUNCTUATION_3_15:
                output = context.getResources().getString(R.string.punct_3_15);
                break;
            case Constants.PUNCTUATION_4_16:
                output = context.getResources().getString(R.string.punct_4_16);
                break;
            case Constants.PUNCTUATION_4_17:
                output = context.getResources().getString(R.string.punct_4_17);
                break;
            case Constants.PUNCTUATION_5_18:
                output = context.getResources().getString(R.string.punct_5_18);
                break;
            case Constants.PUNCTUATION_5_19:
                output = context.getResources().getString(R.string.punct_5_19);
                break;
            case Constants.PUNCTUATION_5_20:
                output = context.getResources().getString(R.string.punct_5_20);
                break;
            case Constants.PUNCTUATION_5_21:
                output = context.getResources().getString(R.string.punct_5_21);
                break;
            case Constants.PUNCTUATION_6_22:
                output = context.getResources().getString(R.string.punct_6_22);
                break;
            case Constants.PUNCTUATION_6_23:
                output = context.getResources().getString(R.string.punct_6_23);
                break;
            case Constants.PUNCTUATION_6_24:
                output = context.getResources().getString(R.string.punct_6_24);
                break;
            case Constants.PUNCTUATION_7_25:
                output = context.getResources().getString(R.string.punct_7_25);
                break;
            case Constants.PUNCTUATION_7_26:
                output = context.getResources().getString(R.string.punct_7_26);
                break;
            case Constants.PUNCTUATION_7_27:
                output = context.getResources().getString(R.string.punct_7_27);
                break;
            case Constants.PUNCTUATION_8_28:
                output = context.getResources().getString(R.string.punct_8_28);
                break;
            case Constants.PUNCTUATION_8_29:
                output = context.getResources().getString(R.string.punct_8_29);
                break;
            case Constants.PUNCTUATION_9_30:
                output = context.getResources().getString(R.string.punct_9_30);
                break;
            case Constants.PUNCTUATION_9_31:
                output = context.getResources().getString(R.string.punct_9_31);
                break;
            case Constants.PUNCTUATION_9_32:
                output = context.getResources().getString(R.string.punct_9_32);
                break;
            case Constants.PUNCTUATION_10_33:
                output = context.getResources().getString(R.string.punct_10_33);
                break;
            case Constants.PUNCTUATION_10_34:
                output = context.getResources().getString(R.string.punct_10_34);
                break;
            case Constants.PUNCTUATION_10_35:
                output = context.getResources().getString(R.string.punct_10_35);
                break;
            case Constants.PUNCTUATION_10_36:
                output = context.getResources().getString(R.string.punct_10_36);
                break;
            case Constants.PUNCTUATION_10_37:
                output = context.getResources().getString(R.string.punct_10_37);
                break;
            case Constants.PUNCTUATION_10_38:
                output = context.getResources().getString(R.string.punct_10_38);
                break;
            case Constants.PUNCTUATION_10_39:
                output = context.getResources().getString(R.string.punct_10_39);
                break;
            case Constants.PUNCTUATION_10_40:
                output = context.getResources().getString(R.string.punct_10_40);
                break;
            case Constants.PUNCTUATION_11_41:
                output = context.getResources().getString(R.string.punct_11_41);
                break;
            case Constants.PUNCTUATION_11_42:
                output = context.getResources().getString(R.string.punct_11_42);
                break;
            case Constants.PUNCTUATION_12_43:
                output = context.getResources().getString(R.string.punct_12_43);
                break;
            case Constants.PUNCTUATION_12_44:
                output = context.getResources().getString(R.string.punct_12_44);
                break;
            case Constants.PUNCTUATION_12_45:
                output = context.getResources().getString(R.string.punct_12_45);
                break;
            case Constants.PUNCTUATION_12_46:
                output = context.getResources().getString(R.string.punct_12_46);
                break;
            case Constants.PUNCTUATION_13_SPLIT:
                output = context.getResources().getString(R.string.punct_13);
                break;
            case Constants.PUNCTUATION_14_47:
                output = context.getResources().getString(R.string.punct_14_47);
                break;
            case Constants.PUNCTUATION_14_48:
                output = context.getResources().getString(R.string.punct_14_48);
                break;
            case Constants.PUNCTUATION_14_49:
                output = context.getResources().getString(R.string.punct_14_49);
                break;
            case Constants.PUNCTUATION_14_50:
                output = context.getResources().getString(R.string.punct_14_50);
                break;
            case Constants.PUNCTUATION_14_51:
                output = context.getResources().getString(R.string.punct_14_51);
                break;
            case Constants.PUNCTUATION_14_52:
                output = context.getResources().getString(R.string.punct_14_52);
                break;
            case Constants.PUNCTUATION_14_53:
                output = context.getResources().getString(R.string.punct_14_53);
                break;
            case Constants.PUNCTUATION_14_54:
                output = context.getResources().getString(R.string.punct_14_54);
                break;
            case Constants.PUNCTUATION_15_55:
                output = context.getResources().getString(R.string.punct_15_55);
                break;
            case Constants.PUNCTUATION_15_56:
                output = context.getResources().getString(R.string.punct_15_56);
                break;
            case Constants.PUNCTUATION_15_57:
                output = context.getResources().getString(R.string.punct_15_57);
                break;
            case Constants.PUNCTUATION_15_58:
                output = context.getResources().getString(R.string.punct_15_58);
                break;
            case Constants.PUNCTUATION_16_SPLIT:
                output = context.getResources().getString(R.string.punct_16);
                break;
            case Constants.PUNCTUATION_17_59:
                output = context.getResources().getString(R.string.punct_17_59);
                break;
            case Constants.PUNCTUATION_17_60:
                output = context.getResources().getString(R.string.punct_17_60);
                break;
            case Constants.PUNCTUATION_17_61:
                output = context.getResources().getString(R.string.punct_17_61);
                break;
            case Constants.PUNCTUATION_17_62:
                output = context.getResources().getString(R.string.punct_17_62);
                break;
            case Constants.PUNCTUATION_17_63:
                output = context.getResources().getString(R.string.punct_17_63);
                break;
            case Constants.PUNCTUATION_18_64:
                output = context.getResources().getString(R.string.punct_18_64);
                break;
            case Constants.PUNCTUATION_18_65:
                output = context.getResources().getString(R.string.punct_18_65);
                break;
            case Constants.PUNCTUATION_18_66:
                output = context.getResources().getString(R.string.punct_18_66);
                break;
            case Constants.PUNCTUATION_18_67:
                output = context.getResources().getString(R.string.punct_18_67);
                break;
            case Constants.PUNCTUATION_18_68:
                output = context.getResources().getString(R.string.punct_18_68);
                break;
            case Constants.PUNCTUATION_18_69:
                output = context.getResources().getString(R.string.punct_18_69);
                break;
            case Constants.PUNCTUATION_19_70:
                output = context.getResources().getString(R.string.punct_19_70);
                break;
            case Constants.PUNCTUATION_19_71:
                output = context.getResources().getString(R.string.punct_19_71);
                break;
            case Constants.PUNCTUATION_19_72:
                output = context.getResources().getString(R.string.punct_19_72);
                break;
            case Constants.PUNCTUATION_20_SPLIT:
                output = context.getResources().getString(R.string.punct_20);
                break;
            case Constants.PUNCTUATION_21_SPLIT:
                output = context.getResources().getString(R.string.punct_21);
                break;
        }

        return output;
    }

    public static String getSummaryPunctuation(Context context, String input) {
        String output = context.getResources().getString(R.string.punct);

        if (input.contains(Constants.PUNCTUATION_1)) {
            output = context.getResources().getString(R.string.punct_1);
        } else if (input.contains(Constants.PUNCTUATION_2)) {
            output = context.getResources().getString(R.string.punct_2);
        } else if (input.contains(Constants.PUNCTUATION_3)) {
            output = context.getResources().getString(R.string.punct_3);
        } else if (input.contains(Constants.PUNCTUATION_4)) {
            output = context.getResources().getString(R.string.punct_4);
        } else if (input.contains(Constants.PUNCTUATION_5)) {
            output = context.getResources().getString(R.string.punct_5);
        } else if (input.contains(Constants.PUNCTUATION_6)) {
            output = context.getResources().getString(R.string.punct_6);
        } else if (input.contains(Constants.PUNCTUATION_7)) {
            output = context.getResources().getString(R.string.punct_7);
        } else if (input.contains(Constants.PUNCTUATION_8)) {
            output = context.getResources().getString(R.string.punct_8);
        } else if (input.contains(Constants.PUNCTUATION_9)) {
            output = context.getResources().getString(R.string.punct_9);
        } else if (input.contains(Constants.PUNCTUATION_10)) {
            output = context.getResources().getString(R.string.punct_10);
        } else if (input.contains(Constants.PUNCTUATION_11)) {
            output = context.getResources().getString(R.string.punct_11);
        } else if (input.contains(Constants.PUNCTUATION_12)) {
            output = context.getResources().getString(R.string.punct_12);
        } else if (input.contains(Constants.PUNCTUATION_14)) {
            output = context.getResources().getString(R.string.punct_14);
        } else if (input.contains(Constants.PUNCTUATION_15)) {
            output = context.getResources().getString(R.string.punct_15);
        } else if (input.contains(Constants.PUNCTUATION_17)) {
            output = context.getResources().getString(R.string.punct_17);
        } else if (input.contains(Constants.PUNCTUATION_18)) {
            output = context.getResources().getString(R.string.punct_18);
        } else if (input.contains(Constants.PUNCTUATION_19)) {
            output = context.getResources().getString(R.string.punct_19);
        }

        return output;
    }

    public static String getTitleAnalyzeMethods(Context context, String input) {
        String output = null;

        if(input.contains(Constants.MORPHEMIC_ANALYZE_METHOD)) {
            output = context.getResources().getString(R.string.morphemic_analyze_method);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NOUN)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_noun);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_VERB)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_verb);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADJECTIVE)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_adjective);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_NUMERAL)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_numeral);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_ADVERB)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_adverb);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_participle);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICIPLE2)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_participle2);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PRETEXT)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_pretext);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_CONJUNCTIONS)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_conjunctions);
        } else if(input.contains(Constants.MORPHOLOGICAL_ANALYZE_METHOD_FOR_PARTICLE)) {
            output = context.getResources().getString(R.string.morphological_analyze_method_for_particle);
        } else if(input.contains(Constants.SYNTACTIC_ANALYZE_METHOD_FOR_SIMPLE_SENTENCE)) {
            output = context.getResources().getString(R.string.syntactic_analyze_method_for_simple_sentence);
        } else if(input.contains(Constants.SYNTACTIC_ANALYZE_METHOD_FOR_DIFFICULT_SENTENCE)) {
            output = context.getResources().getString(R.string.syntactic_analyze_method_for_difficult_sentence);
        } else if(input.contains(Constants.LEXICAL_ANALYZE_METHOD)) {
            output = context.getResources().getString(R.string.lexical_analyze_method);
        } else if(input.contains(Constants.ORTHOGRAPHIC_ANALYZE_METHOD)) {
            output = context.getResources().getString(R.string.orthographic_analyze_method);
        } else if(input.contains(Constants.PHONETIC_ANALYZE_METHOD)) {
            output = context.getResources().getString(R.string.phonetic_analyze_method);
        }

        return output;
    }

    public static String getTitleDictionaries(Context context, String input) {
        String output = null;

        if (input.contains(Constants.DICT_VOCABULARY_WORDS)) {
            output = context.getResources().getString(R.string.vocabulary_words);
        } else if (input.contains(Constants.DICT_PHRASEBOOK)) {
            output = context.getResources().getString(R.string.phrasebook);
        } else if (input.contains(Constants.DICT_ORTHOEPICAL)) {
            output = context.getResources().getString(R.string.orthoepical_dictionary);
        }

        return output;
    }
}
