package com.example.vacash.models;

import com.example.vacash.R;
import com.example.vacash.models.TransactionModel;

import java.util.ArrayList;

public class GlobalVariable {
    public static String username = "";
    public static String email = "";
    public static Integer accountBalance = 0;

    public static ArrayList<GameWithItems> games = new ArrayList<>();
    public static ArrayList<TransactionModel> transactions = new ArrayList<>();

    public static class GameWithItems {
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
    
    public static ArrayList filterGameByType (String type) {
        ArrayList<GameWithItems> filtered = new ArrayList<>();
        for (GameWithItems game: games) {
            if (game.gameType.equalsIgnoreCase(type)) {
                filtered.add(game);
            }
        }
        return  filtered;
    }

    public static void init () {
        // mobile legend
        GameWithItems mobileLegend = new GameWithItems("Mobile Legend", "Mobile", "Moontoon", 4.5, R.drawable.mobilelegendmobile);
        mobileLegend.items.add(new ItemModel("Twilight Pass", "Suka Maju", "Product sent by seller within 10 minutes", "51000", R.drawable.ml));
        mobileLegend.items.add(new ItemModel("Diamond", "Happy Gaming Store", "Available in 24 hours", "48000", R.drawable.ml));
        mobileLegend.items.add(new ItemModel("Starlight Membership", "Mole Store", "Product sent by seller within 10 minutes", "73000", R.drawable.ml));
        mobileLegend.items.add(new ItemModel("Diamond 10", "Toryabz Store", "Trusted since 202", "86000", R.drawable.ml));
        mobileLegend.items.add(new ItemModel("Starlight Membership Plus", "Christalia Store", "Trusted since 2010", "171000", R.drawable.ml));

        games.add(mobileLegend);

        // hayday
        GameWithItems hayDay = new GameWithItems("Hay Day", "Mobile", "Supercell", 4.4, R.drawable.haydaymobile);
        hayDay.items.add(new ItemModel("10 Coins", "ChickenHoras", "Trusted since 2018", "25000", R.drawable.hayday));
        hayDay.items.add(new ItemModel("50 coins", "LetsFarming", "Trusted since 2019", "48000", R.drawable.hayday));
        hayDay.items.add(new ItemModel("100 coins", "Success88", "Trusted since 2017", "95000", R.drawable.hayday));

        games.add(hayDay);

        // Hago
        GameWithItems hago = new GameWithItems("Hago", "Mobile", "Neotask Inc", 4.6, R.drawable.hagomobile);
        hago.items.add(new ItemModel("6 Diamonds", "GGwp Store", "Trusted since 2020", "1000", R.drawable.hago));
        hago.items.add(new ItemModel("45 Diamonds", "GGwp Store", "Trusted since 2020", "13000", R.drawable.hago));
        hago.items.add(new ItemModel("90 Diamonds", "GGwp Store", "Trusted since 2020", "25000", R.drawable.hago));

        games.add(hago);

        // genshin impact
        GameWithItems genshin = new GameWithItems("Genshin Impact", "Mobile", "MiHoYo", 4.6, R.drawable.genshinmobile);
        genshin.items.add(new ItemModel("60 Genesis Crystal", "Lollipop Store", "Trusted since 2018", "12000", R.drawable.genshin));
        genshin.items.add(new ItemModel("980+110 Genesis Crystal", "Lollipop Store", "Trusted since 2018", "180000", R.drawable.genshin));
        genshin.items.add(new ItemModel("Blessing of the Welkin Moon", "Daydream Store", "New", "75000", R.drawable.genshin));

        games.add(genshin);

        // PUBG
        GameWithItems pubg = new GameWithItems("PUBG Mobile", "Mobile", "Krafton", 4.8, R.drawable.pubgmobile);
        pubg.items.add(new ItemModel("30 Battle Coin", "Mengg33", "Trusted since 2020", "7000", R.drawable.pubg));
        pubg.items.add(new ItemModel("40 Battle Coin", "Mengg33", "Trusted since 2020", "9000", R.drawable.pubg));
        pubg.items.add(new ItemModel("60 Battle Coin", "Mengg33", "Trusted since 2020", "13400", R.drawable.pubg));

        games.add(pubg);

        // Growtopia
        GameWithItems growtopia = new GameWithItems("Growtopia", "Mobile", "Ubisoft", 4.7, R.drawable.growtopiamobile);
        growtopia.items.add(new ItemModel("World Lock", "GGwp Store", "Trusted since 2020", "1000", R.drawable.growtopia));
        growtopia.items.add(new ItemModel("Bunny Lock", "GGwp Store", "Trusted since 2020", "3000", R.drawable.growtopia));
        growtopia.items.add(new ItemModel("Green Gem Box", "GGwp Store", "Trusted since 2019", "366000", R.drawable.growtopia));

        games.add(growtopia);

        // Apex Legends
        GameWithItems apex = new GameWithItems("Apex Legends", "PC", "Electronic Arts", 4.5, R.drawable.apexpc);
        apex.items.add(new ItemModel("1000 Apex Coins", "AJP Store", "Trusted since 2016", "155000", R.drawable.apex));
        apex.items.add(new ItemModel("2000 Apex Coins", "Luxvry Store", "Trusted since 2016", "298000", R.drawable.apex));
        apex.items.add(new ItemModel("2500 Apex Coins", "AJP Store", "Trusted since 2016", "360000", R.drawable.apex));

        games.add(apex);

        // GTA V
        GameWithItems gta = new GameWithItems("GTA V", "PC", "Rockstar Games", 4.4, R.drawable.gta);
        gta.items.add(new ItemModel("Great White Shark Cash Card", "GGwp Store", "Trusted since 2020", "180000", R.drawable.gta));
    }
}
