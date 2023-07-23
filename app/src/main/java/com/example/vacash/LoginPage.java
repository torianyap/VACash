package com.example.vacash;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LoginPage extends AppCompatActivity {

    EditText emailvaltxt;
    EditText passwordtxt;
    TextView errorTextView;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        emailvaltxt = findViewById(R.id.emailtxt);
        passwordtxt = findViewById(R.id.passwordtxt);
        errorTextView = findViewById(R.id.errorTextView);
        loginButton = findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateCredentials(emailvaltxt.getText().toString(), passwordtxt.getText().toString());
            }
        });
    }

    private void validateCredentials(String email, String password) {
        if (email.isEmpty()) {
            showError("Email must be filled.");
        } else if (!email.contains("@")) {
            showError("Email must contain '@'.");
        } else if (!email.endsWith(".com")) {
            showError("Email must end with '.com'.");
        } else if (TextUtils.isEmpty(password)) {
            showError("Password must be filled.");
        } else if (password.length() < 8) {
            showError("Password's length must be more than 8 characters.");
        } else {
            hideError();
            navigateToHome();
        }
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
        finish();
    }

    private void hideError() {
        errorTextView.setVisibility(android.view.View.GONE);
    }

    private void showError(String errorMessage) {
        errorTextView.setText(errorMessage);
        errorTextView.setVisibility(android.view.View.VISIBLE);
    }
}