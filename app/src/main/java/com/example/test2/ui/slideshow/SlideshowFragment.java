package com.example.test2.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.test2.R;
import com.example.test2.model.hoadon;
import com.example.test2.model.hoadonAdapter;

import java.util.ArrayList;
import java.util.Date;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private ListView lvhoadon;
    ArrayList<hoadon> arrhoadon;
    hoadonAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("");
            }
        });
        lvhoadon =(ListView) root.findViewById(R.id.listviewhoadon);
        arrhoadon = new ArrayList<>();
        adapter = new hoadonAdapter(getActivity(),R.layout.dong_hoa_don,arrhoadon);
        lvhoadon.setAdapter(adapter);
        hoadon h1=new hoadon(1,1,1,100000,10000,new Date(2019,1,1),"Hoàng quốc việt");
        arrhoadon.add(h1);
        adapter.notifyDataSetChanged();

        return root;
    }
}