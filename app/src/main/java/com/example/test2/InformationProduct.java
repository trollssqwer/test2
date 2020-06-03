package com.example.test2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.lang.UCharacter;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test2.model.mathang;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import  com.example.test2.model.cart;

import static com.example.test2.ui.home.HomeFragment.listURL;

public class InformationProduct extends AppCompatActivity {
    public static  ArrayList<cart> listCart = new ArrayList<cart>();
    private TextView mTextView,productname,productprice,productid;
    private ImageView productImg;
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
        productImg = findViewById(R.id.product_image_details);
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

        new DownLoadImageTask(productImg).execute(anhHang);

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




    private class DownLoadImageTask extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }

}