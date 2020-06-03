package com.example.test2.ui.gallery;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import com.example.test2.CartAdapter;

import static com.example.test2.InformationProduct.listCart;


public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private HomeViewModel ChomeViewModel;
    private RecyclerView CrecyclerView;
    private CartAdapter Cadapter;
    private RecyclerView.LayoutManager ClayoutManager;
    private Button nextbtn;
    private TextView totalCount;
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
                        listCart.clear();
                        Intent intent = new Intent(getActivity(), UserCategory.class);
                        startActivity(intent);
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

    public String TongTien(){
        long tongTien = 0;
        for (int i=0;i<listCart.size();i++){
            tongTien = tongTien + listCart.get(i).getGiaHang()*listCart.get(i).getSoluong();
        }
        return  "Tong tien = " + String.valueOf(tongTien);
    }
}