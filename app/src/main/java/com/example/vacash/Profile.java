package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.vacash.adapters.TransactionAdapter;
import com.example.vacash.models.GameWithItems;
import com.example.vacash.models.GlobalVariable;
import com.example.vacash.models.RecyclerViewInterface;
import com.example.vacash.models.TransactionModel;

import java.util.ArrayList;

public class Profile extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<TransactionModel> transactions;
    TextView username, email, accBalance, topupError;
    EditText topUpField;
    Button topupBtn;

    ImageButton homeIcon;
    ImageButton hamburgerIcon;
    AnimatorSet slideDownAnimatorSet;

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
        accBalance.setText(GlobalVariable.formatCurrency(GlobalVariable.accountBalance.toString()));

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
                accBalance.setText(GlobalVariable.formatCurrency(GlobalVariable.accountBalance.toString()));
            }
        });

        transactions = GlobalVariable.transactions;
        RecyclerView pastTransactions = findViewById(R.id.pastTransactionRV);
        TransactionAdapter adapter = new TransactionAdapter(this, transactions, this);

        pastTransactions.setAdapter(adapter);
        pastTransactions.setLayoutManager(new LinearLayoutManager(this));

        homeIcon = findViewById(R.id.home_icon);
        hamburgerIcon = findViewById(R.id.hamburgerIcon);

        slideDownAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.slide_down);
        slideDownAnimatorSet.setTarget(R.menu.dropdown_menu);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHome();
            }
        });

        hamburgerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }

    private void showPopupMenu(View view) {
        Context wrapper = new ContextThemeWrapper(this, R.style.MenuStyle);
        PopupMenu popupMenu = new PopupMenu(wrapper, view, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.dropdown_menu_profile, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_profile:
                        navigateToProfile();
                        return true;
                    case R.id.menu_logout:
                        navigateToLogout();
                        return true;
                    default:
                        return false;
                }
            }
        });
        slideDownAnimatorSet.start();
        popupMenu.show();

        // Change background color when the dropdown is shown
//        mainLayout.setBackgroundColor(Color.parseColor("#800080")); // Purple color with 50% opacity
    }

    private void navigateToProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    private void navigateToLogout() {
        Intent intent = new Intent(this, SplashPage.class);
        startActivity(intent);
    }
    private void navigateToHome() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    public void showError (String msg) {
        topupError.setText(msg);
        topupError.setVisibility(View.VISIBLE);
    }

    public static Integer parse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public void onItemClick(int position) {
        TransactionModel selectedTransaction = GlobalVariable.transactions.get(position);

        Intent intent = new Intent(this, ItemPage.class);
        Bundle bundle = new Bundle();

        GameWithItems game = GlobalVariable.filterGameByName(selectedTransaction.getGameName());

        bundle.putParcelableArrayList("Items", game.getItems());
        bundle.putString("gameName", game.getGameName());
        bundle.putInt("gameIcon", game.getGameIcon());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}