package com.foodproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import com.foodproject.R;
import com.foodproject.adapter.CustomAdapter;
import com.foodproject.pojo.ProductModel;
import com.foodproject.util.ParseJson;

import org.json.JSONObject;

import java.util.ArrayList;

import developer.shivam.perfecto.OnNetworkRequest;
import developer.shivam.perfecto.Perfecto;


public class ProductActivity extends AppCompatActivity {
        String type=null;
        ListView listView;
    ArrayList<ProductModel> productModelslist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        listView=(ListView)findViewById(R.id.list);
        String data[]=ChooseLocality.value.split(":");
        Log.d("Data",data[1]);
        String value[]=data[1].split(",");
        String lat=value[0].replace("("," ").trim();
        String lang=value[1].replace(")"," ");


        type=getIntent().getStringExtra("type");
            Senddatatoserver(lat, lang, type);

    }

    private void Senddatatoserver(String lat, String lang, String type) {
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("tag","get_restra");
            jsonObject.put("lat",lat);
            jsonObject.put("long",lang);
            jsonObject.put("Method",type);
          Perfecto.with(ProductActivity.this)
                  .fromUrl("http://bgsdigital.us/fd/api")
                  .ofTypePost(jsonObject)
                  .connect(new OnNetworkRequest() {
                      @Override
                      public void onStart() {

                      }

                      @Override
                      public void onSuccess(String s) {
                        productModelslist= ParseJson.getProductList(s);
                          listView.setAdapter(new CustomAdapter(ProductActivity.this,productModelslist));
                      }

                      @Override
                      public void onFailure(int i, String s, String s1) {

                      }
                  });






        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
