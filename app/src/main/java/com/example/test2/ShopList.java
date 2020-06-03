package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.test2.model.mathang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.example.test2.model.cuahang;
import com.example.test2.ui.home.HomeFragment;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.test2.InformationProduct.listCart;

public class ShopList extends AppCompatActivity {
    private RecyclerView SrecyclerView;
    private ShopAdapter Sadapter;
    private RecyclerView.LayoutManager SlayoutManager;
    private int idkhachhang,idloaikhachhang;
    private String email,facebook,sodienthoai,tenkhachhang;
    ArrayList<cuahang> SlistHang = new ArrayList<cuahang>();
    Intent intentSHOP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
//        SlistHang.add(new cuahang(1,"a","a","a"));
//        SlistHang.add(new cuahang(1,"a","a","a"));
//        SlistHang.add(new cuahang(1,"a","a","a"));
        SrecyclerView =   findViewById(R.id.rv_shoplist);
        SlayoutManager = new LinearLayoutManager(this);


        Intent intenuser=getIntent();
        intentSHOP = new Intent(ShopList.this,UserCategory.class);
        //getdata from login
        idkhachhang=intenuser.getIntExtra("idkhachhang1",0);
        idloaikhachhang=intenuser.getIntExtra("idloaikhachhang1",0);
        email=intenuser.getStringExtra("email1");
        sodienthoai=intenuser.getStringExtra("sodienthoai1");
        facebook=intenuser.getStringExtra("facebook1");
        tenkhachhang=intenuser.getStringExtra("tenkhachhang1");

        //post data to usercata
        intentSHOP.putExtra("idkhachhang1",idkhachhang);
        intentSHOP.putExtra("tenkhachhang1",tenkhachhang);
        intentSHOP.putExtra("email1",email);
        intentSHOP.putExtra("facebook1",facebook);
        intentSHOP.putExtra("idloaikhachhang1",idloaikhachhang);
        intentSHOP.putExtra("sodienthoai1",sodienthoai);
        new getURL().execute("http://35.198.237.116/coffeshop/api/cuahangs");


    }

    class getURL extends AsyncTask<String,Void,String>
    {
        OkHttpClient client=new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        @Override
        protected String doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);
            Request request=builder.build();
            try {
                Response response= client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();

                return null;
            }}
        @Override
        protected void onPostExecute(String s) {
            if(!s.equals(""))
            {
                ObjectMapper mapper=new ObjectMapper();
                String json=  s;
                try {
                    JSONArray array=new JSONArray(s);
                    for(int i=0;i<array.length();i++)
                    {
                        cuahang ch=new cuahang();
                        JSONObject object=array.getJSONObject(i);
                        ch.setMacuahang(object.getInt("idcuahang"));
                        ch.setTencuahang(object.getString("tencuahang"));
                        ch.setDiachicuahang(object.getString("diachi"));
                        ch.setAnhcuahang("a");
                        SlistHang.add(ch);

                    }
                    SrecyclerView.setHasFixedSize(true);

                    Sadapter = new ShopAdapter(SlistHang);
                    SrecyclerView.setLayoutManager(SlayoutManager);
                    SrecyclerView.setAdapter(Sadapter);
                    Sadapter.setOnPruductClickLisner(new ShopAdapter.OnShopClickLisner() {
                        @Override
                        public void OnItemClick(int position) {
                            int MaCuaHang = SlistHang.get(position).getMacuahang();

                            intentSHOP.putExtra("idHang",MaCuaHang);
                            startActivity(intentSHOP);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            super.onPostExecute(s);
        }}}


