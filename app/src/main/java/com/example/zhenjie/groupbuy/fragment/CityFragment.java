package com.example.zhenjie.groupbuy.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhenjie.groupbuy.R;
import com.example.zhenjie.groupbuy.adapter.CityListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {
    protected RecyclerView cityListRecyclerView;
    protected List<String> cityList;
    public CityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cityListRecyclerView = getView().findViewById(R.id.recycler_view_city_list);
        String cityname[] = {"A","安庆","安宁","鞍山","安阳","B","白山","白银","保定","C","C1","C2"};
        cityList = new ArrayList();
        for(int i=0;i<cityname.length;i++){
            cityList.add(cityname[i]);
        }
        cityListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cityListRecyclerView.setAdapter(new CityListAdapter(getContext(),cityList));
    }
}
