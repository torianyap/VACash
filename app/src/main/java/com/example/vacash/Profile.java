package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vacash.adapters.TransactionAdapter;
import com.example.vacash.models.GlobalVariable;
import com.example.vacash.models.TransactionModel;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    ArrayList<TransactionModel> transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        generateDummyTransaction();

        transactions = GlobalVariable.transactions;
        RecyclerView pastTransactions = findViewById(R.id.pastTransactionRV);
        TransactionAdapter adapter = new TransactionAdapter(this, transactions);

        pastTransactions.setAdapter(adapter);
        pastTransactions.setLayoutManager(new LinearLayoutManager(this));
    }


    public static void generateDummyTransaction () {
        for (int i = 0; i < 3; i++) {
            GlobalVariable.transactions.add(new TransactionModel("aaa", "bbb", 2000, 12));
        }
    }
}