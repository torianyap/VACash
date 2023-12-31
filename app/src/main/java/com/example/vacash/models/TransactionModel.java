package com.example.vacash.models;

public class TransactionModel {
    private String gameName;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private Integer itemIcon;

    public TransactionModel(String gameName, String itemName, int price, int quantity, int itemIcon) {
        this.gameName = gameName;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.itemIcon = itemIcon;
    }

    public Integer getItemIcon() {
        return itemIcon;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getItemNameQuantity() {
        return itemName + " - " + quantity + "pc(s)";
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price.toString();
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
