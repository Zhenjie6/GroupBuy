package com.example.zhenjie.groupbuy.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zhenjie.groupbuy.R;
import com.example.zhenjie.groupbuy.Utils.DataUtils;
import com.example.zhenjie.groupbuy.activity.MainFunctionActivity;
import com.example.zhenjie.groupbuy.adapter.GoodListAdapter;

import com.example.zhenjie.groupbuy.entity.Good;


import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    protected ImageView backButton;
    protected int goodIcons[], goodNum[];
    protected String goodTitles[], goodInfo[], goodPrice[];
    protected List<Good> goodList;
    protected RecyclerView mainMenuRecyclerView, goodListRecyclerView;


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        backButton = getView().findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //此处实现fragment的切换
                MainFunctionActivity activity = (MainFunctionActivity) getActivity();
                activity.switchFragment(1);
            }
        });
        goodListRecyclerView = getView().findViewById(R.id.recycler_view_good_list);
        goodTitles = getActivity().getResources().getStringArray(R.array.good_name);
        goodInfo = getActivity().getResources().getStringArray(R.array.good_info);
        goodIcons = new int[]{R.drawable.pro1, R.drawable.pro2, R.drawable.product3, R.drawable.product4
                , R.drawable.pro1, R.drawable.pro2, R.drawable.product3
                , R.drawable.product4, R.drawable.pro1, R.drawable.pro2, R.drawable.product3, R.drawable.product4};
        goodPrice = new String[]{"39.9", "99.9", "12", "9.9", "39.9", "99.9", "12", "9.9", "39.9", "99.9", "12", "9.9"};
        goodNum = new int[]{44, 22, 99, 44, 44, 22, 99, 44, 44, 22, 99, 44};
        goodList = DataUtils.getGoodItems(goodIcons, goodTitles, goodInfo, goodPrice, goodNum);
        goodListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        goodListRecyclerView.setAdapter(new GoodListAdapter(getContext(), goodList));
    }
}
