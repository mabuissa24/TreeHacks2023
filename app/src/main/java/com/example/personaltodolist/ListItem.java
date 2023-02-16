package com.example.personaltodolist;

public class ListItem {
    String text;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    String key;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    boolean isChecked;

    public ListItem(String text, boolean isChecked, String key) {
        this.text = text;
        this.isChecked = isChecked;
        this.key = key;
    }
}
