package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText emailuser, passworduser;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

//        emailuser = findViewById(R.id.emailtxt);
//        passworduser = findViewById(R.id.passwordtxt);
//        loginbtn = findViewById(R.id.button_loginpage);
//
//        loginbtn.setOnClickListener((e)->{
//            String email = emailuser.getText().toString();
//            String password = passworduser.getText().toString();
//
//            if (email.isEmpty()){
//                Toast.makeText(LoginPage.this, "Email must be filled", Toast.LENGTH_SHORT).show();
//            } else if (password.isEmpty()) {
//                Toast.makeText(LoginPage.this, "Password must be filled", Toast.LENGTH_SHORT).show();
//            } else {
//                AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
//                builder.setTitle("Success");
//                builder.setMessage("You have successfully logged in");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });
//
//        loginbtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
////                if (TextUtils.isEmpty(emailuser.getText().toString())){
////                    emailuser.setError("Email must be filled");
////                }
//            }
//        });
    }


}