package com.foodproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.foodproject.R;
import com.foodproject.pojo.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Aashish on 9/24/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ProductModel> productModelArrayList;
    public CustomAdapter(Context context, ArrayList<ProductModel> productModelslist) {
    this.context=context;
        this.productModelArrayList=productModelslist;
    }

    @Override
    public int getCount() {
        return productModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return productModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.menuitem_layout, null);


            holder = new ItemHolder();
            holder.name = (TextView) convertView.findViewById(R.id.item_name);
            holder.image = (ImageView) convertView.findViewById(R.id.productImage);


            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }
            holder.name.setText(productModelArrayList.get(position).getName());
        Picasso.with(context).load(productModelArrayList.get(position).getImageurl().toString()).placeholder(R.drawable.appimg).into(holder.image);




        return convertView;
    }

    private class ItemHolder {
    TextView name;
        ImageView image;

    }


}
