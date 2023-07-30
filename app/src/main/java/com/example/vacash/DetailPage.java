package com.example.vacash;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vacash.models.GameWithItems;
import com.example.vacash.models.GlobalVariable;
import com.example.vacash.models.ItemModel;
import com.example.vacash.models.TransactionModel;

public class DetailPage extends AppCompatActivity {
    LinearLayout minus, plus;
    View backButton;
    Button payBtn;

    String gameName;
    Integer qty;

    ItemModel selectedItem;
    ImageView itemImage;
    TextView quantityField, itemName, storeName, itemPrice, itemDescription, gameNameField, totalPriceField;

    public void init () {
        selectedItem = this.getIntent().getExtras().getParcelable("ItemDetail");
        gameName = this.getIntent().getExtras().getString("gameName");

        itemImage = findViewById(R.id.itemImage);
        itemImage.setImageResource(selectedItem.getItemImg());

        itemName = findViewById(R.id.itemName);
        itemName.setText(selectedItem.getItemName());

        storeName = findViewById(R.id.storeName);
        storeName.setText(selectedItem.getStoreName());

        itemPrice = findViewById(R.id.itemPrice);
        itemPrice.setText(GlobalVariable.formatCurrency(selectedItem.getItemPrice()));

        itemDescription = findViewById(R.id.itemDescription);
        itemDescription.setText(selectedItem.getStoreDetail());

        gameNameField = findViewById(R.id.gameName);
        gameNameField.setText(gameName);
    }

    public void showError (String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error").setMessage(msg);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void validateForm () {
        EditText usernameField = findViewById(R.id.usernameField);
        String username = usernameField.getText().toString();

        EditText emailField = findViewById(R.id.emailField);
        String email = emailField.getText().toString();
        Integer totalPrice = qty * Integer.parseInt(selectedItem.getItemPrice());

        if (email.isEmpty()) {
            showError("Email must be filled");
        } else if (!email.contains("@")) {
            showError("Email must contain '@'.");
        } else if (!email.endsWith(".com")) {
            showError("Email must end with '.com'.");
        } else if (username.isEmpty()) {
            showError("Username must be filled");
        } else if (qty <= 0) {
            showError("Quantity must be more than 0");
        } else if (GlobalVariable.accountBalance < totalPrice) {
            showError("Not enough balance");
        } else {
            GlobalVariable.accountBalance = GlobalVariable.accountBalance - totalPrice;
            GlobalVariable.transactions.add(new TransactionModel(gameName, selectedItem.getItemName(), totalPrice, qty, selectedItem.getItemImg()));

            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        qty = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        init();

        // back button to item page
        backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ItemPage.class);
            Bundle bundle = new Bundle();

            GameWithItems game = GlobalVariable.filterGameByName(gameName);

            bundle.putParcelableArrayList("Items", game.getItems());
            bundle.putString("gameName", game.getGameName());
            bundle.putInt("gameIcon", game.getGameIcon());

            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        });

        // stepper
        quantityField = findViewById(R.id.quantity);
        totalPriceField = findViewById(R.id.totalPrice);
        qty = Integer.parseInt(quantityField.getText().toString());

        minus = findViewById(R.id.stepper_minus);
        plus = findViewById(R.id.stepper_plus);

        minus.setOnClickListener(v -> {
            if (qty > 0) qty--;
            quantityField.setText(qty.toString());
            totalPriceField.setText(GlobalVariable.countTotalPrice(selectedItem.getItemPrice(), qty));
        });
        plus.setOnClickListener(v -> {
            qty++;
            quantityField.setText(qty.toString());
            totalPriceField.setText(GlobalVariable.countTotalPrice(selectedItem.getItemPrice(), qty));
        });

        // pay button
        payBtn = findViewById(R.id.payButton);
        payBtn.setOnClickListener(v -> validateForm());
    }
}