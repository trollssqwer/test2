package com.example.test2.ui.home;

import android.os.Bundle;
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

import com.example.test2.Cart;
import com.example.test2.InformationProduct;
import com.example.test2.ProductAdapter;
import com.example.test2.R;
import com.example.test2.Register;
import com.example.test2.UserCategory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.test2.model.mathang;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<mathang> listHang = new ArrayList<mathang>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listHang.add(new mathang(1,"a",3,"a"));
        listHang.add(new mathang(2,"b",4,"b"));
        listHang.add(new mathang(3,"c",5,"c"));
        recyclerView = root.findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new ProductAdapter(listHang);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnPruductClickLisner(new ProductAdapter.OnProductClickLisner() {
            @Override
            public void OnItemClick(int position) {
                 String tenhang = listHang.get(position).getTenhang();
                Intent intentADD = new Intent(getActivity(),InformationProduct.class);
                intentADD.putExtra("idHang",tenhang);
                startActivity(intentADD);
            }
        });

        return root;
    }
}