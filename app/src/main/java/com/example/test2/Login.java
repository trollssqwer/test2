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
import android.widget.TextView;
import android.widget.Toast;

import com.example.test2.model.khachhang;
import com.example.test2.model.mathang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Login extends AppCompatActivity {
    private Button LoginButton;
    private EditText UsernameEditText, PasswordEditText;
    private TextView CheckAdminTextView , NoCheckAdminTextView;
    String username,password;
    ProgressDialog loadingBar;
    ArrayList<khachhang> listkh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton = (Button) findViewById(R.id.login_login_button);
        UsernameEditText = (EditText) findViewById(R.id.login_username_input);
        PasswordEditText = (EditText) findViewById(R.id.login_password_input);
        CheckAdminTextView = (TextView) findViewById(R.id.login_admin_check);
        NoCheckAdminTextView = (TextView) findViewById(R.id.login_admin_nocheck);
        loadingBar = new ProgressDialog(this);


        CheckAdminTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoCheckAdminTextView.setVisibility(View.VISIBLE);
                CheckAdminTextView.setVisibility(View.INVISIBLE);
                LoginButton.setText("Admin Login");
            }
        });

        NoCheckAdminTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoCheckAdminTextView.setVisibility(View.INVISIBLE);
                CheckAdminTextView.setVisibility(View.VISIBLE);
                LoginButton.setText("Login");
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });
    }

    private void LoginUser(){
        username = UsernameEditText.getText().toString();
        password = PasswordEditText.getText().toString();

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Hay dien mat khau",Toast.LENGTH_LONG).show();
        }
        else  if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"Hay dien so dien thoai",Toast.LENGTH_LONG).show();
        }
        else{
            loadingBar.setTitle("Logging Account");
            loadingBar.setMessage("Hay doi trong giay lat");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            // check database
            ValidateLogin();
        }
    }

    //Check database Login
    private void ValidateLogin(){
        //check user, passwrod

        new getURL().execute("http://35.198.237.116/coffeshop/api/Khachhangs");
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
                try {
                    JSONArray array=new JSONArray(s);
                    for(int i=0;i<array.length();i++)
                    {
                        khachhang kh=new khachhang();
                        JSONObject object=array.getJSONObject(i);
                        kh.setIdkhachhang(object.getInt("idkhachhang"));
                        kh.setEmail(object.getString("email"));
                        kh.setFacebook(object.getString("facebook"));
                        kh.setSodienthoai(object.getString("sodienthoai"));
                        kh.setTenkhachhang(object.getString("tenkhachhang"));
                        listkh.add(kh);

                    }
                    boolean kt=false;
                    for(int i=0;i<listkh.size();i++)
                    {
                        if(listkh.get(i).getSodienthoai()==username)
                        {
                            kt=true;
                            break;
                        }
                        kt=false;
                    }
                    if(kt=true)
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intenta = new Intent(Login.this,ShopList.class);
                                startActivity(intenta);
                            }
                        });

                    }
                    else
                    {
                        Toast.makeText(Login.this,"Tài khoản không đúng",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            super.onPostExecute(s);
        }
    }

}
