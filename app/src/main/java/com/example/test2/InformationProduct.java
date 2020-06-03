package com.example.test2;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test2.model.mathang;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;
import  com.example.test2.model.cart;
public class InformationProduct extends AppCompatActivity {
    public static  ArrayList<cart> listCart = new ArrayList<cart>();
    private TextView mTextView,productname,productprice,productid;
    private Button addToCart;
    private ElegantNumberButton btnCount;
    public cart HANG;
    Integer idHang;
    String tenHang;
    Double giaHang;
    String anhHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_product);
        Intent intentADD = getIntent();
        idHang = intentADD.getIntExtra("maHang",0);
        tenHang = intentADD.getStringExtra("tenHang");
        giaHang = intentADD.getDoubleExtra("giaHang",0);
        anhHang = intentADD.getStringExtra("imgHang");
        productname = findViewById(R.id.product_name_details);
        productid = findViewById(R.id.product_description_details);
        productprice = findViewById(R.id.product_price_details);
        productname.setText(tenHang);
        //productid.setText(String.valueOf(idHang));
        productprice.setText(String.valueOf(giaHang));
        btnCount = (ElegantNumberButton) findViewById(R.id.number_btn);

        mTextView = (TextView) findViewById(R.id.text);
        addToCart = (Button) findViewById(R.id.pd_add_to_cart_button);

//



        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddtoCart();

            }
        });
    }

    public  void AddtoCart(){
        if(1 == 1){
            Toast.makeText(this,"DA THEM VAO GIO HANG",Toast.LENGTH_SHORT).show();
        }
        int soHang = Integer.parseInt(btnCount.getNumber());
        HANG = new cart(idHang,tenHang,(new Double(giaHang).longValue()),soHang,anhHang);
        listCart.add(HANG);
        Intent intentCart = new Intent(InformationProduct.this,UserCategory.class);
        startActivity(intentCart);
    }
}