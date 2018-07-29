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
import com.example.zhenjie.groupbuy.entity.Good;

import java.util.List;

public class GoodListAdapter extends RecyclerView.Adapter<GoodListViewHolder> {
    Context context;
    List<Good> goods;

    public GoodListAdapter(Context context, List<Good> goods) {
        super();
        this.context = context;
        this.goods = goods;
    }

    @NonNull
    @Override
    public GoodListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_goods_list,parent,false);
        GoodListViewHolder viewHolder = new GoodListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoodListViewHolder holder, int position) {
        holder.icon.setImageResource(goods.get(position).getIcon());
        holder.title.setText(goods.get(position).getName());
        holder.info.setText(goods.get(position).getInfo());
        holder.price.setText(goods.get(position).getPrice());
        holder.num.setText(goods.get(position).getNum()+"");

    }

    @Override
    public int getItemCount() {
        return goods!=null?goods.size():0;
    }
}

class GoodListViewHolder extends RecyclerView.ViewHolder {
    ImageView icon;
    TextView title,info,price,num;
    public GoodListViewHolder(View itemView) {
        super(itemView);
        this.icon = itemView.findViewById(R.id.imageView_good_list_icon);
        this.title = itemView.findViewById(R.id.textView_good_list_title);
        this.info = itemView.findViewById(R.id.textView_good_list_info);
        this.price = itemView.findViewById(R.id.textView_good_list_price);
        this.num = itemView.findViewById(R.id.textView_good_list_num);
    }
}