package com.example.zhenjie.groupbuy.entity;

/***
 * 团购商品实体类
 */
public class Good {
    private int icon;
    private String name;
    private String info;
    private String price;
    private int num;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Good(int icon, String name, String info, String price, int num) {
        this.icon = icon;
        this.name = name;
        this.info = info;
        this.price = price;
        this.num = num;
    }
}
