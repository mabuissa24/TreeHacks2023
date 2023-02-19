package com.example.HAY;

public class Activity {
    String text;
    String link;
    String text2;
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text + link + text2;
    }


    public Activity(String text, String text2, String link, String key) {
        this.text = text;
        this.text2 = text2;
        this.link = link;
        this.key = key;
    }
}
