package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Register extends AppCompatActivity {
    private Button CreateAccountButton;
    private EditText UserNameEditText,PasswordEditText,PhoneNumberEditText;
    private ProgressDialog loadingBar;
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
        new getURL().execute("http://35.198.237.116/coffeshop/api/mathangs");
        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });

    }
    //Check input account
    private void CreateAccount() {
        String name = UserNameEditText.getText().toString();
        String password = PasswordEditText.getText().toString();
        String phonenumber = PhoneNumberEditText.getText().toString();

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
            Toast.makeText(Register.this,"Ten dang nhap hoac so dien thoai da ton tai !",Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(Register.this,"Ten dang nhap hoac so dien thoai da ton tai !",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Register.this,MainActivity.class);
            startActivity(intent);
        }
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

            }

            super.onPostExecute(s);
        }
    }

}
