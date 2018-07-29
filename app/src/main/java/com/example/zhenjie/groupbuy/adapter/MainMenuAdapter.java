package com.example.zhenjie.groupbuy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhenjie.groupbuy.R;
import com.example.zhenjie.groupbuy.entity.MainMenuItem;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder>{
    List<MainMenuItem> menusList;
    Context context;

    public MainMenuAdapter(List<MainMenuItem> menusList, Context context) {
        super();
        this.menusList = menusList;
        this.context = context;
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_main_menu,parent,false);
        return new MainMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder holder, int position) {
        holder.imageView.setImageResource(menusList.get(position).getIcon());
        holder.textView.setText(menusList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return menusList!=null?menusList.size():0;
    }
}

class MainMenuViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView textView;
    public MainMenuViewHolder(View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView_main_menu_icon);
        this.textView = itemView.findViewById(R.id.textView_main_menu_title);
    }
}
