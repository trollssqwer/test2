package com.example.test2.ui.tools;

import android.annotation.SuppressLint;
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

import com.example.test2.R;
import com.example.test2.model.khachhang;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private  TextView txtHoten;
    private  TextView txtSodienthoai;
    private TextView txtEmail;
    private TextView txt_name;
    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

            }
        });
        Intent intenta1= getActivity().getIntent();
        int kt=intenta1.getIntExtra("idkhachhang1",0);
        //khachhang kh=new khachhang(1,"123456","fackbook@gmail.com","https://www.facebook.com/a.98","Toan");
        khachhang kh=new khachhang();
        txtHoten = root.findViewById(R.id.txtHoten);
        txtEmail=root.findViewById(R.id.txt_Email);
        txtSodienthoai=root.findViewById(R.id.txt_Sodienthoai);
        txt_name=root.findViewById(R.id.textviewHoTen);

        txtHoten.setText(intenta1.getStringExtra("tenkhachhang1"));
        txtEmail.setText(intenta1.getStringExtra("email1"));
        txtSodienthoai.setText(intenta1.getStringExtra("sodienthoai1"));
        txt_name.setText(intenta1.getStringExtra("tenkhachhang1"));

        return root;
    }
}