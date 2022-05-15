/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 */

package com.verNANDo57.rulebook_educational.rules.data;

public class RuleItemData {

    private final String item_title;
    private final String item_summary;
    private final String item_key;
    private final int item_imgId;
    private int item_imageBtnId;

    public RuleItemData(String item_title, String item_summary, String item_key, int item_imgId, int item_imageBtnId) {
        this.item_title = item_title;
        this.item_summary = item_summary;
        this.item_key = item_key;
        this.item_imgId = item_imgId;
        this.item_imageBtnId = item_imageBtnId;
    }

    public String getItemTitle () {
        return this.item_title;
    }

    public String getItemSummary() {
        return this.item_summary;
    }

    public String getItem_key() {
        return this.item_key;
    }

    public int getItemImgId() {
        return this.item_imgId;
    }

    public int getItem_imageBtnId(){
        return this.item_imageBtnId;
    }

    public void setItem_imageBtnId(int item_imageBtnId) {
        this.item_imageBtnId = item_imageBtnId;
    }
}
