package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailPage extends AppCompatActivity {
    LinearLayout minus, plus;
    View backButton;
    TextView quantityField;
    Integer qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        // back button to item page
        backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ItemPage.class);
            startActivity(intent);
            finish();
        });

        // stepper
        quantityField = findViewById(R.id.quantity);
        qty = Integer.parseInt(quantityField.getText().toString());

        minus = findViewById(R.id.stepper_minus);
        plus = findViewById(R.id.stepper_plus);

        minus.setOnClickListener(v -> {
            if (qty > 0) qty--;
            quantityField.setText(qty.toString());
        });
        plus.setOnClickListener(v -> {
            qty++;
            quantityField.setText(qty.toString());
        });
    }
}