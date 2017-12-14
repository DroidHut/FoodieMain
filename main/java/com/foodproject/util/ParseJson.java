package com.foodproject.util;

import android.util.Log;


import com.foodproject.pojo.ProductModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Aashish on 9/24/2017.
 */

public class ParseJson {

    public static ArrayList<ProductModel> getProductList(String s) {
        ArrayList<ProductModel>productlist=new ArrayList<>();
        JSONObject dataObject = null;
        try {
            JSONObject jsonObject = new JSONObject(s);
            if (jsonObject.has("success")) {
                if (jsonObject.getBoolean("success")) {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        ProductModel productModel=new ProductModel();
                        dataObject = jsonArray.getJSONObject(i);
                        if (jsonArray.getJSONObject(i).has("restra_id")) {
                            String id = dataObject.getString("restra_id");
                            Log.d("id", id);
                            productModel.setId(id);
                        }
                        if (jsonArray.getJSONObject(i).has("restra_name")) {
                            String name = dataObject.getString("restra_name");
                            Log.d("Restrant name", name);
                            productModel.setName(name);
                        }
                        if (jsonArray.getJSONObject(i).has("restra_image")) {
                            String imgurl = dataObject.getString("restra_image");
                            Log.d("imageUrl", imgurl);
                            productModel.setImageurl(imgurl);
                        }

                        JSONObject rating = jsonArray.getJSONObject(i).getJSONObject("restra_rating");

                        if (rating.has("Star")) {
                            int star = rating.getInt("Star");
                            Log.d("Star", star + "");
                            productModel.setStar(star);
                        }
                        if (rating.has("Rating")) {
                            int rate = rating.getInt("Rating");
                            Log.d("rate", rate + "");
                            productModel.setRate(rate);
                        }
                productlist.add(productModel);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return productlist;
    }
}
