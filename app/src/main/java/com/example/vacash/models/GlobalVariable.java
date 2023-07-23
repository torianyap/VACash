package com.example.vacash.models;

import com.example.vacash.models.TransactionModel;

import java.util.ArrayList;

public class GlobalVariable {
    public static String username = "";
    public static String email = "";
    public static Integer accountBalance = 0;

    public static ArrayList<TransactionModel> transactions = new ArrayList<>();
}
