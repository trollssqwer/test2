package com.example.test2.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    ArrayList<mathang> ClistHang = new ArrayList<mathang>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        ClistHang.add(new mathang(1,"a",3,"a"));
        ClistHang.add(new mathang(2,"b",4,"b"));
        ClistHang.add(new mathang(3,"c",5,"c"));
        CrecyclerView =  root.findViewById(R.id.cart_list);
        CrecyclerView.setHasFixedSize(true);
        ClayoutManager = new LinearLayoutManager(getActivity());
        Cadapter = new CartAdapter(listCart);
        CrecyclerView.setLayoutManager(ClayoutManager);
        CrecyclerView.setAdapter(Cadapter);










        return root;
    }
}