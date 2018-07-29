package com.example.zhenjie.groupbuy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhenjie.groupbuy.R;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListViewHolder> {
    Context context;
    List<String> cityList;

    public CityListAdapter (Context context,List<String> cityList){
        super();
        this.context = context;
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public CityListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_city_list,parent,false);
        CityListViewHolder viewHolder = new CityListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityListViewHolder holder, int position) {
        holder.cityName.setText(cityList.get(position));
    }

    @Override
    public int getItemCount() {
        return cityList!=null?cityList.size():0;
    }
}

class CityListViewHolder extends RecyclerView.ViewHolder {
    TextView cityName;
    public CityListViewHolder(View itemView) {
        super(itemView);
        this.cityName = itemView.findViewById(R.id.city_name);
    }
}