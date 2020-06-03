package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class InformationProduct extends AppCompatActivity {

    private TextView mTextView,productname;
    private Button addToCart;
    private ElegantNumberButton btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_product);
        Intent intentADD = getIntent();
        String b = intentADD.getStringExtra("idHang");

        productname = findViewById(R.id.product_name_details);
        productname.setText(b);
        btnCount = (ElegantNumberButton) findViewById(R.id.number_btn);

        mTextView = (TextView) findViewById(R.id.text);
        addToCart = (Button) findViewById(R.id.pd_add_to_cart_button);
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
        Intent intentCart = new Intent(InformationProduct.this,UserCategory.class);
        intentCart.putExtra("tenHang",productname.getText().toString());
        intentCart.putExtra("count",btnCount.getNumber());
        startActivity(intentCart);
    }
}