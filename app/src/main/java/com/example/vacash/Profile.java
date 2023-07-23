package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vacash.adapters.TransactionAdapter;
import com.example.vacash.models.GlobalVariable;
import com.example.vacash.models.TransactionModel;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    ArrayList<TransactionModel> transactions;
    TextView username, email, accBalance, topupError;
    EditText topUpField;
    Button topupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // set username & email
        username = findViewById(R.id.username);
        username.setText(GlobalVariable.username);

        email = findViewById(R.id.email);
        email.setText(GlobalVariable.email);

        accBalance = findViewById(R.id.accBalance);
        accBalance.setText(GlobalVariable.accountBalance.toString());

        // handle account balance topup
        topupError = findViewById(R.id.topupError);
        topupBtn = findViewById(R.id.topupBtn);
        topUpField = findViewById(R.id.topupField);

        topupBtn.setOnClickListener(v -> {
            Integer value = parse(topUpField.getText().toString());
            if (value == null) {
                showError("Input must be a number");
            } else if (value <= 0) {
                showError("Input must be more than 0");
            } else {
                GlobalVariable.accountBalance = GlobalVariable.accountBalance + value;
                accBalance.setText(GlobalVariable.accountBalance.toString());
            }
        });

        generateDummyTransaction();

        transactions = GlobalVariable.transactions;
        RecyclerView pastTransactions = findViewById(R.id.pastTransactionRV);
        TransactionAdapter adapter = new TransactionAdapter(this, transactions);

        pastTransactions.setAdapter(adapter);
        pastTransactions.setLayoutManager(new LinearLayoutManager(this));
    }

    public void showError (String msg) {
        topupError.setText(msg);
        topupError.setVisibility(View.VISIBLE);
    }

    public static void generateDummyTransaction () {
        for (int i = 0; i < 3; i++) {
            GlobalVariable.transactions.add(new TransactionModel("aaa", "bbb", 2000, 12));
        }
    }

    public static Integer parse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}