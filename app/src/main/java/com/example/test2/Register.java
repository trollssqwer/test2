package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test2.ui.gallery.GalleryFragment;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Register extends AppCompatActivity {
    private Button CreateAccountButton;
    private EditText UserNameEditText,PasswordEditText,PhoneNumberEditText;
    private ProgressDialog loadingBar;
    String name;
    String password;
    String phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        CreateAccountButton = (Button) findViewById(R.id.register_button);
        UserNameEditText = (EditText) findViewById(R.id.register_username);
        PasswordEditText = (EditText) findViewById(R.id.register_password);
        PhoneNumberEditText = (EditText) findViewById(R.id.register_numberphone);
        loadingBar = new ProgressDialog(this);
        //Create Account

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });

    }
    //Check input account
    private void CreateAccount() {
        name = UserNameEditText.getText().toString();
        password = PasswordEditText.getText().toString();
        phonenumber = PhoneNumberEditText.getText().toString();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Hay dien ten dang nhap",Toast.LENGTH_LONG).show();
        }
        else  if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Hay dien mat khau",Toast.LENGTH_LONG).show();
        }
        else  if(TextUtils.isEmpty(phonenumber)){
            Toast.makeText(this,"Hay dien so dien thoai",Toast.LENGTH_LONG).show();
        }
        else{
        loadingBar.setTitle("Account Creating");
        loadingBar.setMessage("Hay doi trong giay lat");
        loadingBar.setCanceledOnTouchOutside(true);
        loadingBar.show();

        // check database
            ValidateInput(name,password,phonenumber);
        }
    }
    //Ham check database
    private void ValidateInput(String username,String password,String phonenumber){
        //Kien tra dieu kien user

        if(username == "a"){
            Toast.makeText(Register.this,"Đã tồn tại!",Toast.LENGTH_LONG).show();
        }
        else {

           new postToServer().execute("http://35.198.237.116/coffeshop/api/Khachhangs");

        }
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
            //RequestBody body = RequestBody.create(mediaType, "{\r\n\t\t\t\"idkhachhang\": "++",\r\n            \"tongtienbandau\": "+tongtien+",\r\n            \"tongtienthanhtoan\": "+tongtien+",\r\n            \"idcuahang\": "+idcuahang+"\r\n}");
            RequestBody body = RequestBody.create(mediaType, "{\r\n        \r\n        \"email\": \"b@gmail.com\",\r\n        \"facebook\": \"https://www.facebook.com/b.98\",\r\n        \"idloaikhachhang\": 1,\r\n        \"sodienthoai\": \""+phonenumber+"\",\r\n        \"tenkhachhang\": \"b\"\r\n    },");
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
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
            super.onPostExecute(s);
        }

    }

}
