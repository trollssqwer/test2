package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test2.model.mathang;

import java.util.ArrayList;
import com.example.test2.model.cuahang;

import static com.example.test2.InformationProduct.listCart;

public class ShopList extends AppCompatActivity {
    private RecyclerView SrecyclerView;
    private ShopAdapter Sadapter;
    private RecyclerView.LayoutManager SlayoutManager;
    ArrayList<cuahang> SlistHang = new ArrayList<cuahang>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        SlistHang.add(new cuahang(1,"a","a","a"));
        SlistHang.add(new cuahang(1,"a","a","a"));
        SlistHang.add(new cuahang(1,"a","a","a"));
        SrecyclerView =   findViewById(R.id.rv_shoplist);
        SrecyclerView.setHasFixedSize(true);
        SlayoutManager = new LinearLayoutManager(this);
        Sadapter = new ShopAdapter(SlistHang);
        SrecyclerView.setLayoutManager(SlayoutManager);
        SrecyclerView.setAdapter(Sadapter);
        Sadapter.setOnPruductClickLisner(new ShopAdapter.OnShopClickLisner() {
            //sassadas
            @Override
            public void OnItemClick(int position) {
                int MaCuaHang = SlistHang.get(position).getMacuahang();
                Intent intentSHOP = new Intent(ShopList.this,UserCategory.class);
                intentSHOP.putExtra("idHang",MaCuaHang);
                startActivity(intentSHOP);
            }
        });
    }
}