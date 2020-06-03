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

        listmh=new ArrayList<>();
        new getURL().execute("http://35.198.237.116/coffeshop/api/mathangs");

//        listHang.add(new mathang(1,"a",3,"a"));
//        listHang.add(new mathang(2,"b",4,"b"));
//        listHang.add(new mathang(3,"c",5,"c"));

        txt2=(TextView) root.findViewById(R.id.textView2);



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
                for(int i=0;i<array.length();i++)
                {
                    mathang mh=new mathang();
                    JSONObject object=array.getJSONObject(i);
                    mh.setId(object.getInt("idmathang"));
                    mh.setDonvitinh(object.getString("donvitinh"));
                    mh.setTenhang(object.getString("tenhang"));
                    mh.setGia(object.getDouble("gia"));
                    listHang.add(mh);

                }


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
                        String imghang = listHang.get(position).getDonvitinh();
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