package com.example.vacash.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ItemModel implements Parcelable {

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

    protected ItemModel(Parcel in) {
        ItemName = in.readString();
        StoreName = in.readString();
        StoreDetail = in.readString();
        ItemPrice = in.readString();
        itemImg = in.readInt();
        storeIcon = in.readInt();
    }

    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(ItemName);
        parcel.writeString(StoreName);
        parcel.writeString(StoreDetail);
        parcel.writeString(ItemPrice);
        parcel.writeInt(itemImg);
        parcel.writeInt(storeIcon);
    }
}
