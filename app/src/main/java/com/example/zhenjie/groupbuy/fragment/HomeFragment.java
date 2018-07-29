package com.example.zhenjie.groupbuy.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhenjie.groupbuy.R;
import com.example.zhenjie.groupbuy.Utils.DataUtils;
import com.example.zhenjie.groupbuy.activity.MainFunctionActivity;
import com.example.zhenjie.groupbuy.adapter.GoodListAdapter;
import com.example.zhenjie.groupbuy.adapter.MainMenuAdapter;
import com.example.zhenjie.groupbuy.entity.Good;
import com.example.zhenjie.groupbuy.entity.MainMenuItem;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    protected int mainMenuIcons[],goodIcons[],goodNum[];
    protected String mainMenuTitles[],goodTitles[],goodInfo[],goodPrice[];
    protected List<MainMenuItem> mainMenuItemList;
    protected List<Good> goodList;
    protected RecyclerView mainMenuRecyclerView,goodListRecyclerView;
    protected ImageView selectCityButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        selectCityButton = getView().findViewById(R.id.imageView_select_city);
        selectCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFunctionActivity activity = (MainFunctionActivity) getActivity();
                activity.switchFragment(2);
            }
        });
        mainMenuRecyclerView = getView().findViewById(R.id.recyclerView_homepage_main_menu);
        //初始化菜单图标
        mainMenuIcons = new int[]{R.drawable.fly1,R.drawable.car,R.drawable.autombile1,R.drawable.cake,R.drawable.food,
                R.drawable.watch,R.drawable.cp,R.drawable.phone};
        //初始化菜单文字数据
        mainMenuTitles = getActivity().getResources().getStringArray(R.array.main_menus);
        mainMenuItemList = DataUtils.getMainMenuItems(mainMenuIcons,mainMenuTitles);
        mainMenuRecyclerView.setAdapter(new MainMenuAdapter(mainMenuItemList,getContext()));
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),4);
        mainMenuRecyclerView.setLayoutManager(layoutManager);

        goodListRecyclerView = getView().findViewById(R.id.recycler_view_good_list);
        goodTitles = getActivity().getResources().getStringArray(R.array.good_name);
        goodInfo = getActivity().getResources().getStringArray(R.array.good_info);
        goodIcons = new int[]{R.drawable.pro1,R.drawable.pro2,R.drawable.product3,R.drawable.product4
                ,R.drawable.pro1,R.drawable.pro2,R.drawable.product3
                ,R.drawable.product4,R.drawable.pro1,R.drawable.pro2,R.drawable.product3,R.drawable.product4};
        goodPrice = new String[]{"39.9","99.9","12","9.9","39.9","99.9","12","9.9","39.9","99.9","12","9.9"};
        goodNum = new int[]{44,22,99,44,44,22,99,44,44,22,99,44};
        goodList = DataUtils.getGoodItems(goodIcons,goodTitles,goodInfo,goodPrice,goodNum);
        goodListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        goodListRecyclerView.setAdapter(new GoodListAdapter(getContext(),goodList));
    }
}
