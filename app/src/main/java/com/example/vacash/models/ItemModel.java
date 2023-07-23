package com.example.vacash.models;

public class ItemModel {

    String ItemName;
    String StoreName;
    String StoreDetail;
    String ItemPrice;
    int itemImg;
    int storeIcon;

    public ItemModel(String itemName, String storeName, String storeDetail, String itemPrice, int itemImg, int storeIcon) {
        this.ItemName = itemName;
        this.StoreName = storeName;
        this.StoreDetail = storeDetail;
        this.ItemPrice = itemPrice;
        this.itemImg = itemImg;
        this.storeIcon = storeIcon;
    }

    public ItemModel(String itemName, String storeName, String storeDetail, String itemPrice, int itemImg) {
        this.ItemName = itemName;
        this.StoreName = storeName;
        this.StoreDetail = storeDetail;
        this.ItemPrice = itemPrice;
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getStoreName() {
        return StoreName;
    }

    public String getStoreDetail() {
        return StoreDetail;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public int getItemImg() {
        return itemImg;
    }

    public int getStoreIcon() {
        return storeIcon;
    }
}
