package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test2.model.mathang;

import static com.example.test2.ui.home.HomeFragment.listHang;
import static com.example.test2.ui.home.HomeFragment.listURL;

public class MainActivity extends AppCompatActivity {
    private Button joinButton,loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        joinButton = (Button) findViewById(R.id.main_button_join);
        loginButton = (Button)  findViewById(R.id.main_button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,Login.class);
               startActivity(intent);
            }
        });

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        listHang.add(new mathang(1,"Sach kinh te",300000,"Trading System"));
        listHang.add(new mathang(1,"Sach kinh te",450000,"Price Action"));
        listHang.add(new mathang(1,"Sach kinh te",500000,"Ichimoku Clouds"));
        listHang.add(new mathang(1,"Sach tam ly",200000,"Test System"));
        listHang.add(new mathang(1,"Sach tam ly",400000,"Pyschology Analysis"));
        listHang.add(new mathang(1,"Sach tam ly",230000,"Perspective Trading"));
        listHang.add(new mathang(1,"Sach tam ly",500000,"Kikol Phenomenal"));
        listHang.add(new mathang(1,"Sach hoc thuat",12000,"Test System"));
        listHang.add(new mathang(1,"Sach kinh te",300000,"Trading System"));
        listHang.add(new mathang(1,"Sach kinh te",450000,"Price Action"));
        listHang.add(new mathang(1,"Sach kinh te",500000,"Ichimoku Clouds"));
        listHang.add(new mathang(1,"Sach tam ly",200000,"Test System"));
        listHang.add(new mathang(1,"Sach tam ly",400000,"Pyschology Analysis"));
        listHang.add(new mathang(1,"Sach tam ly",230000,"Perspective Trading"));
        listHang.add(new mathang(1,"Sach tam ly",500000,"Kikol Phenomenal"));
        listHang.add(new mathang(1,"Sach hoc thuat",12000,"Test System"));

        listURL.add("https://cdn.shopify.com/s/files/1/2177/5447/products/Fitz-Porsche-Ultimate-Series_1024x1024.jpg?v=1570630108");
        listURL.add("https://images.squarespace-cdn.com/content/v1/5aa83bad9772ae97813540d0/1546342351907-4R2L1N4GITARI03VU9N0/ke17ZwdGBToddI8pDm48kJPo64LO3YZG-4f-ST8EfI9Zw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVGunbRojLjYM_qWg5xABZ5ZcuB4bj617U7w2cj588VrBRur-lC0WofN0YB1wFg-ZW0/cover_UC95Q8VU77.png");
        listURL.add("https://media.istockphoto.com/vectors/modern-vector-abstract-love-book-cover-template-vector-id901801702");
        listURL.add("https://cdn.shopify.com/s/files/1/1154/8424/products/moms-one-line.jpg?v=1554231550");
        listURL.add("https://traderviet.com/attachments/art-and-science-of-technical-analysis-traderviet-jpg.6139/");
        listURL.add("https://images-na.ssl-images-amazon.com/images/I/41NG6HZA8DL.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTHr_rK6L67utG7NCr__J2HMjTwu80uCYw3gCL7Ced9RVKurnjh&usqp=CAU");
        listURL.add("https://m.media-amazon.com/images/I/51ohXNfqFxL.jpg");
        listURL.add("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442714697l/18106442._SY475_.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRdf1qIEYOIZ4fa7sUDRTkechyjpCK33g-fDtwFHhDt-lN-oMpD&usqp=CAU");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTlC5L6a0rYkQYcbrQsdz7e9aLucpRfeSaTy0oBKgVCtUXTL7kH&usqp=CAU");
        listURL.add("https://cdn.shopify.com/s/files/1/2177/5447/products/Fitz-Porsche-Ultimate-Series_1024x1024.jpg?v=1570630108");
        listURL.add("https://images.squarespace-cdn.com/content/v1/5aa83bad9772ae97813540d0/1546342351907-4R2L1N4GITARI03VU9N0/ke17ZwdGBToddI8pDm48kJPo64LO3YZG-4f-ST8EfI9Zw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVGunbRojLjYM_qWg5xABZ5ZcuB4bj617U7w2cj588VrBRur-lC0WofN0YB1wFg-ZW0/cover_UC95Q8VU77.png");
        listURL.add("https://media.istockphoto.com/vectors/modern-vector-abstract-love-book-cover-template-vector-id901801702");
        listURL.add("https://cdn.shopify.com/s/files/1/1154/8424/products/moms-one-line.jpg?v=1554231550");
        listURL.add("https://traderviet.com/attachments/art-and-science-of-technical-analysis-traderviet-jpg.6139/");
        listURL.add("https://images-na.ssl-images-amazon.com/images/I/41NG6HZA8DL.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTHr_rK6L67utG7NCr__J2HMjTwu80uCYw3gCL7Ced9RVKurnjh&usqp=CAU");
        listURL.add("https://m.media-amazon.com/images/I/51ohXNfqFxL.jpg");
        listURL.add("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442714697l/18106442._SY475_.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRdf1qIEYOIZ4fa7sUDRTkechyjpCK33g-fDtwFHhDt-lN-oMpD&usqp=CAU");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTlC5L6a0rYkQYcbrQsdz7e9aLucpRfeSaTy0oBKgVCtUXTL7kH&usqp=CAU");
        listURL.add("https://cdn.shopify.com/s/files/1/2177/5447/products/Fitz-Porsche-Ultimate-Series_1024x1024.jpg?v=1570630108");
        listURL.add("https://images.squarespace-cdn.com/content/v1/5aa83bad9772ae97813540d0/1546342351907-4R2L1N4GITARI03VU9N0/ke17ZwdGBToddI8pDm48kJPo64LO3YZG-4f-ST8EfI9Zw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVGunbRojLjYM_qWg5xABZ5ZcuB4bj617U7w2cj588VrBRur-lC0WofN0YB1wFg-ZW0/cover_UC95Q8VU77.png");
        listURL.add("https://media.istockphoto.com/vectors/modern-vector-abstract-love-book-cover-template-vector-id901801702");
        listURL.add("https://cdn.shopify.com/s/files/1/1154/8424/products/moms-one-line.jpg?v=1554231550");
        listURL.add("https://traderviet.com/attachments/art-and-science-of-technical-analysis-traderviet-jpg.6139/");
        listURL.add("https://images-na.ssl-images-amazon.com/images/I/41NG6HZA8DL.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTHr_rK6L67utG7NCr__J2HMjTwu80uCYw3gCL7Ced9RVKurnjh&usqp=CAU");
        listURL.add("https://m.media-amazon.com/images/I/51ohXNfqFxL.jpg");
        listURL.add("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442714697l/18106442._SY475_.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRdf1qIEYOIZ4fa7sUDRTkechyjpCK33g-fDtwFHhDt-lN-oMpD&usqp=CAU");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTlC5L6a0rYkQYcbrQsdz7e9aLucpRfeSaTy0oBKgVCtUXTL7kH&usqp=CAU");
        listURL.add("https://cdn.shopify.com/s/files/1/2177/5447/products/Fitz-Porsche-Ultimate-Series_1024x1024.jpg?v=1570630108");
        listURL.add("https://images.squarespace-cdn.com/content/v1/5aa83bad9772ae97813540d0/1546342351907-4R2L1N4GITARI03VU9N0/ke17ZwdGBToddI8pDm48kJPo64LO3YZG-4f-ST8EfI9Zw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVGunbRojLjYM_qWg5xABZ5ZcuB4bj617U7w2cj588VrBRur-lC0WofN0YB1wFg-ZW0/cover_UC95Q8VU77.png");
        listURL.add("https://media.istockphoto.com/vectors/modern-vector-abstract-love-book-cover-template-vector-id901801702");
        listURL.add("https://cdn.shopify.com/s/files/1/1154/8424/products/moms-one-line.jpg?v=1554231550");
        listURL.add("https://traderviet.com/attachments/art-and-science-of-technical-analysis-traderviet-jpg.6139/");
        listURL.add("https://images-na.ssl-images-amazon.com/images/I/41NG6HZA8DL.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTHr_rK6L67utG7NCr__J2HMjTwu80uCYw3gCL7Ced9RVKurnjh&usqp=CAU");
        listURL.add("https://m.media-amazon.com/images/I/51ohXNfqFxL.jpg");
        listURL.add("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442714697l/18106442._SY475_.jpg");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRdf1qIEYOIZ4fa7sUDRTkechyjpCK33g-fDtwFHhDt-lN-oMpD&usqp=CAU");
        listURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTlC5L6a0rYkQYcbrQsdz7e9aLucpRfeSaTy0oBKgVCtUXTL7kH&usqp=CAU");
    }

}
