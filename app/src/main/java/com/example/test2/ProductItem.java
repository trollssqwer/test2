package com.example.test2;
import  com.example.test2.model.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductItem extends AppCompatActivity {
    private TextView ProductNamex , ProductPrice ,ProductDescrption;
    private ImageView ProductImage;
    public List<mathang> listA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //test brach
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        ProductImage = (ImageView) findViewById(R.id.product_image);
        ProductNamex = (TextView) findViewById(R.id.product_name);
        ProductPrice = (TextView) findViewById(R.id.product_price);
        ProductDescrption = (TextView) findViewById(R.id.product_description);


        ProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductItem.this,Cart.class);
                startActivity(intent);
            }
        });
        ProductNamex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductItem.this,Cart.class);
                startActivity(intent);
            }
        });
        mathang a=new mathang(1,"Cốc",10000,"Capuchino");
        mathang b=new mathang(2, "Chai", 1000, "Trà sữa");

        listA.add(a);
        listA.add(b);
    }
}