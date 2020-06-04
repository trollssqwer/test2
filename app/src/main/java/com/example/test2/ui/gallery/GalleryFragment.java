package com.example.test2.ui.gallery;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.Cart;
import com.example.test2.InformationProduct;
import com.example.test2.ProductAdapter;
import com.example.test2.R;
import com.example.test2.UserCategory;
import com.example.test2.model.mathang;
import com.example.test2.ui.home.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import com.example.test2.CartAdapter;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.test2.InformationProduct.listCart;


public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private HomeViewModel ChomeViewModel;
    private RecyclerView CrecyclerView;
    private CartAdapter Cadapter;
    private RecyclerView.LayoutManager ClayoutManager;
    private Button nextbtn;
    private TextView totalCount;
    private float tongTien1;
    private String tongtien;
    private String idkh;
    private String idcuahang;
    private String idhd;
    int dem=0;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        totalCount = root.findViewById(R.id.total_price);
////aa
        totalCount.setText(TongTien().toString());
        nextbtn = root.findViewById(R.id.next_btn);
        CrecyclerView =  root.findViewById(R.id.cart_list);
        CrecyclerView.setHasFixedSize(true);
        ClayoutManager = new LinearLayoutManager(getActivity());
        Cadapter = new CartAdapter(listCart);
        CrecyclerView.setLayoutManager(ClayoutManager);
        CrecyclerView.setAdapter(Cadapter);
        Intent intenta1= getActivity().getIntent();
        dem=listCart.size();
        idkh= String.valueOf(intenta1.getIntExtra("idkhachhang1",10));
        idcuahang=intenta1.getStringExtra("idcuahang");
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //THANH TOAN

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("THANH TOAN");
                alert.setMessage("BAN MUON THANH TOAN HOA DON ?");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Thanh toan thanh cong!",Toast.LENGTH_LONG).show();
                    new postToServer().execute("http://35.198.237.116/api/dathang");

                    }
                });
                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Huy thanh toan",Toast.LENGTH_LONG).show();
                    }
                });
                alert.create().show();
            }
        });

        return root;
    }
    public float TongTienHD()
    {
        float tongTien1 = 0;
        for (int i=0;i<listCart.size();i++){
            tongTien1 = tongTien1 + listCart.get(i).getGiaHang()*listCart.get(i).getSoluong();
        }
        return tongTien1;
    }
    public String TongTien(){
        long tongTien = 0;
        for (int i=0;i<listCart.size();i++){
            tongTien = tongTien + listCart.get(i).getGiaHang()*listCart.get(i).getSoluong();
        }
        tongtien=String.valueOf(tongTien);
        return  "Tong tien = " + String.valueOf(tongTien);
    }

    class postToServer extends AsyncTask<String,Void,String>
    {
        OkHttpClient client=new OkHttpClient.Builder().build();

        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            MediaType mediaType = MediaType.parse("application/json");
            Log.d("AAA","Tạo thanh công");
            //RequestBody body = RequestBody.create(mediaType, "{\r\n\t\t\t\"idkhachhang\": "+ idkh+",\r\n            \"tongtienbandau\": "+ tongtien+",\r\n            \"tongtienthanhtoan\": "+tongtien+",\r\n            \"idcuahang\": \""+idcuahang+"\"\r\n}");
            //RequestBody body = RequestBody.create(mediaType, "{\r\n\t\t\t\"idkhachhang\": "+"13"+",\r\n            \"tongtienbandau\": "+tongtien+",\r\n            \"tongtienthanhtoan\": "+tongtien+",\r\n            \"idcuahang\": "+idcuahang+"\r\n}");
            RequestBody body = RequestBody.create(mediaType, "{\r\n\t\t\t\"idkhachhang\": 13,\r\n            \"tongtienbandau\": "+tongtien+",\r\n            \"tongtienthanhtoan\": "+tongtien+",\r\n            \"idcuahang\": \"1\"\r\n}");
            Request request = new Request.Builder()
                    .url("http://172.20.10.5:8080/api/dathang")
                    .method("POST", body)
                    .build();

            try {
                Response response = client.newCall(request).execute();

                return  response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            if(!s.equals(""))
            {
                idhd=s;
                new postCTToServer().execute("http://35.198.237.116/api/dathangchitiet");
            }
            super.onPostExecute(s);
        }

}
    class postCTToServer extends AsyncTask<String,Void,String>
    {
        OkHttpClient client=new OkHttpClient.Builder().build();

        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            Log.d("AAA","Tạo thanh công");
            for(int i=0;i<listCart.size();i++)
            {
                String idhangcart;
                String soluongcart;
                String giagiahientaicart;
                String thanhtiencart;
                idhangcart=String.valueOf(listCart.get(i).getIdHang());
                soluongcart=String.valueOf(listCart.get(i).getSoluong());
                giagiahientaicart=String.valueOf(listCart.get(i).getGiaHang());
                thanhtiencart=String.valueOf(listCart.get(i).getSoluong()*listCart.get(i).getGiaHang());

                RequestBody body = RequestBody.create(mediaType, "{\r\n\t\t\t\"idhoadon\": "+idhd+",\r\n            \"idmathang\": "+idhangcart+",\r\n            \"soluong\":"+ soluongcart+",\r\n            \"giatienhientai\": "+giagiahientaicart+",\r\n            \"thanhtien\": "+thanhtiencart+"\r\n}");
                Request request = new Request.Builder()
                        .url("http://35.198.237.116/api/dathangchitiet")
                        .method("POST", body)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    return  response.body().string();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }



            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            listCart.clear();
            Intent intent = new Intent(getActivity(), UserCategory.class);
            startActivity(intent);
            super.onPostExecute(s);
        }
}}