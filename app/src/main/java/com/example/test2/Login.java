package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button LoginButton;
    private EditText UsernameEditText, PasswordEditText;
    private TextView CheckAdminTextView , NoCheckAdminTextView;
    ProgressDialog loadingBar;
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
        String username = UsernameEditText.getText().toString();
        String password = PasswordEditText.getText().toString();

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
            ValidateLogin(username,password);
        }
    }

    //Check database Login
    private void ValidateLogin(String username,String password){
        Intent intenta = new Intent(Login.this,UserCategory.class);
        startActivity(intenta);

        //Check usename, password
//        if(username != "a"){
//            Toast.makeText(Login.this,"Ten dang nhap hoac mat khau sai !",Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(Login.this,AdminCategory.class);
//            startActivity(intent);
//        }
//        else{
//            Toast.makeText(Login.this,"Dang nhap thanh cong",Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(Login.this,Home.class);
//            startActivity(intent);
//        }
    }


}
