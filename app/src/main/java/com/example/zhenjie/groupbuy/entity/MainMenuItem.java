package com.example.zhenjie.groupbuy.entity;

public class MainMenuItem {
    private int icon;
    private String title;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MainMenuItem(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }
}
