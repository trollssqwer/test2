package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductItem extends AppCompatActivity {
    private TextView ProductNamex , ProductPrice ,ProductDescrption;
    private ImageView ProductImage;

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
    }
}