package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


}
