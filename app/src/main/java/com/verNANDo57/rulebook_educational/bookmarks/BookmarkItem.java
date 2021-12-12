package com.verNANDo57.rulebook_educational.bookmarks;

public class BookmarkItem {
    private final String object_key;
    private final String object_title;
    private final String object_summary;

    public BookmarkItem(String object_key, String object_title, String object_summary) {
        this.object_key = object_key;
        this.object_title = object_title;
        this.object_summary = object_summary;
    }

    public String getObject_key() {
        return object_key;
    }

    public String getObject_title() {
        return object_title;
    }

    public String getObject_summary() {
        return object_summary;
    }
}
