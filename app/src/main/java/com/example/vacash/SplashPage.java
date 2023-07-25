package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vacash.models.GlobalVariable;

import java.util.ArrayList;

public class SplashPage extends AppCompatActivity {

    Button buttonloginpage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);

        // init variables
        GlobalVariable.init();

        buttonloginpage1 = findViewById(R.id.button_loginpage1);
        buttonloginpage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}