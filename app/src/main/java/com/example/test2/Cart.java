package com.example.test2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.model.mathang;
import com.example.test2.ui.home.HomeViewModel;

import java.util.ArrayList;



public class Cart extends  AppCompatActivity{
    private HomeViewModel ChomeViewModel;
    private RecyclerView CrecyclerView;
    private ProductAdapter Cadapter;
    private RecyclerView.LayoutManager ClayoutManager;
    ArrayList<mathang> ClistHang = new ArrayList<mathang>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ClistHang.add(new mathang(1,"a",3,"a"));
        ClistHang.add(new mathang(2,"b",4,"b"));
        ClistHang.add(new mathang(3,"c",5,"c"));
        CrecyclerView =  findViewById(R.id.rv_main);
        CrecyclerView.setHasFixedSize(true);
        ClayoutManager = new LinearLayoutManager(this);
        Cadapter = new ProductAdapter(ClistHang);
        CrecyclerView.setLayoutManager(ClayoutManager);
        CrecyclerView.setAdapter(Cadapter);
        Cadapter.setOnPruductClickLisner(new ProductAdapter.OnProductClickLisner() {
            @Override
            public void OnItemClick(int position) {
                String tenhang = ClistHang.get(position).getTenhang();
                Intent intentADD = new Intent(Cart.this,InformationProduct.class);
                intentADD.putExtra("idHang",tenhang);
                startActivity(intentADD);
            }
        });

    }
}
