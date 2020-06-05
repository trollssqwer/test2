package com.example.test2.ui.home;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.Toast;

import com.example.test2.Cart;
import com.example.test2.InformationProduct;
import com.example.test2.ProductAdapter;
import com.example.test2.R;
import com.example.test2.Register;
import com.example.test2.UserCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.test2.model.mathang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.widget.Toast.LENGTH_LONG;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<mathang> listmh;
    private mathang mathang[];
    private TextView txt2;
    ArrayList<com.example.test2.model.mathang> listHang = new ArrayList<mathang>();
    public static ArrayList<String> listURL = new ArrayList<String>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        listHang =new ArrayList<mathang>();
        recyclerView = root.findViewById(R.id.rv_main);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new ProductAdapter(listHang);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnPruductClickLisner(new ProductAdapter.OnProductClickLisner() {
            @Override
            public void OnItemClick(int position) {
                int a;
                 String tenhang = listHang.get(position).getTenhang();
                Intent intentADD = new Intent(getActivity(),InformationProduct.class);
                intentADD.putExtra("idHang",tenhang);
                startActivity(intentADD);
            }
        });


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
        listmh=new ArrayList<>();


        new getURL().execute("http://localhost:28976/api/users");



        return root;
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
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if(!s.equals(""))
        {
            ObjectMapper mapper=new ObjectMapper();
            String json=  s;
            try {
                JSONArray array=new JSONArray(s);
//                for(int i=0;i<array.length();i++)
//                {
//                    mathang mh=new mathang();
//                    JSONObject object=array.getJSONObject(i);
//                    mh.setId(object.getInt("idmathang"));
//                    mh.setDonvitinh(object.getString("donvitinh"));
//                    mh.setTenhang(object.getString("tenhang"));
//                    mh.setGia(object.getDouble("gia"));
//                    listHang.add(mh);
//
//                }


                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(getActivity());
                adapter = new ProductAdapter(listHang);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

                adapter.setOnPruductClickLisner(new ProductAdapter.OnProductClickLisner() {
                    @Override
                    public void OnItemClick(int position) {
                        String tenhang = listHang.get(position).getTenhang();
                        int mahang = listHang.get(position).getId();
                        double giahang = listHang.get(position).getGia();
                        String imghang = listURL.get(position).toString();
                        Intent intentADD = new Intent(getActivity(),InformationProduct.class);
                        intentADD.putExtra("tenHang",tenhang);
                        intentADD.putExtra("maHang",mahang);
                        intentADD.putExtra("giaHang",giahang);
                        intentADD.putExtra("imgHang",imghang);
                        startActivity(intentADD);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        super.onPostExecute(s);
    }
}
}