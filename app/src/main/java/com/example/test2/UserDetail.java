package com.example.test2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserDetail extends  AppCompatActivity{
    EditText txtHoten;
    EditText txtSodienthoai;
    EditText txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tools);
        txtHoten = (EditText) findViewById(R.id.txtHoten);
        txtSodienthoai=(EditText) findViewById(R.id.txt_Sodienthoai);
        txtEmail=(EditText) findViewById(R.id.txt_Email);
        txtHoten.setText("Vũ Khánh Toàn");
        txtSodienthoai.setText("012300");
        txtEmail.setText("toan@gmail.com");
    }


}
