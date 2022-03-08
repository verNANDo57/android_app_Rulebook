/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational.search;

public class SearchItemData {

    private final String item_title;
    private final String item_description;
    private final String item_key;
    private final int item_imgId;
    private int item_imageBtnId;

    public SearchItemData(String item_title, String item_description, String item_key, int item_imgId, int item_imageBtnId) {
        this.item_title = item_title;
        this.item_description = item_description;
        this.item_key = item_key;
        this.item_imgId = item_imgId;
        this.item_imageBtnId = item_imageBtnId;
    }

    public String getItemTitle () {
        return this.item_title;
    }

    public String getItemDescription() {
        return this.item_description;
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
