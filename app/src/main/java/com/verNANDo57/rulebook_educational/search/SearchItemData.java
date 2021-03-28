package com.verNANDo57.rulebook_educational.search;

public class SearchItemData {
    private String item_title;
    private String item_description;
    private int item_imgId;
    public SearchItemData(String item_title, String item_description, int item_imgId) {
        this.item_title = item_title;
        this.item_description = item_description;
        this.item_imgId = item_imgId;
    }
    public String getItemTitle () {
        return item_title;
    }
    public void setItemTitle(String item_title){
        this.item_title = item_title;
    }
    public String getItemDescription() {
        return item_description;
    }
    public void setItemDescription(String item_description) {
        this.item_description = item_description;
    }
    public int getItemImgId() {
        return item_imgId;
    }
    public void setItemImgId(int item_imgId) {
        this.item_imgId = item_imgId;
    }
}
