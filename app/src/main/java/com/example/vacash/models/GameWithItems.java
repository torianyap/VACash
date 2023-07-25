package com.example.vacash.models;

import java.util.ArrayList;

public class GameWithItems {
    String gameName;
    String gameType;
    String gameDeveloper;
    Double rating;
    Integer gameIcon;
    ArrayList<ItemModel> items = new ArrayList<>();

    public String getGameName() {
        return gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getGameIcon() {
        return gameIcon;
    }

    public ArrayList<ItemModel> getItems() {
        return items;
    }

    public GameWithItems(String gameName, String gameType, String gameDeveloper, Double rating, Integer gameIcon) {
        this.gameName = gameName;
        this.gameType = gameType;
        this.gameDeveloper = gameDeveloper;
        this.rating = rating;
        this.gameIcon = gameIcon;
    }

    public void setItems(ArrayList<ItemModel> items) {
        this.items = items;
    }
}
