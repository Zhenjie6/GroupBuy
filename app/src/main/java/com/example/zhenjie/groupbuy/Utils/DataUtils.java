package com.example.zhenjie.groupbuy.Utils;

import com.example.zhenjie.groupbuy.entity.Good;
import com.example.zhenjie.groupbuy.entity.MainMenuItem;

import java.util.ArrayList;
import java.util.List;

/***
 * 数据工具类
 */
public class DataUtils {

    /***
     * 获取菜单实体列表的方法
     * @param icon
     * @param title
     * @return
     */
    public static List<MainMenuItem> getMainMenuItems(int icon[],String title[]){
        List<MainMenuItem> list = new ArrayList();
        for(int i =0 ;i < icon.length;i++){
            MainMenuItem menu = new MainMenuItem(icon[i],title[i]);
            list.add(menu);
        }
        return list;
    }

    /***
     * 获取团购商品实体类的方法
     * @param icon
     * @param title
     * @param info
     * @param price
     * @param num
     * @return
     */
    public static List<Good> getGoodItems(int icon[],String title[],String info[],String price[],int num[]){
        List<Good> list = new ArrayList<>();
        for(int i = 0;i<icon.length;i++){
            Good good = new Good(icon[i],title[i],info[i],price[i],num[i]);
            list.add(good);
        }
        return list;
    }

}
