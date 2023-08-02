package com.example.vacash.models;

import com.example.vacash.R;
import com.example.vacash.models.TransactionModel;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GlobalVariable {
    public static String username = "";
    public static String email = "";
    public static Integer accountBalance = 1000000;

    public static ArrayList<GameWithItems> games = new ArrayList<>();
    public static ArrayList<TransactionModel> transactions = new ArrayList<>();

    public static ArrayList<GameWithItems> filterGameByType (String type) {
        ArrayList<GameWithItems> filtered = new ArrayList<>();
        for (GameWithItems game: games) {
            if (game.gameType.equalsIgnoreCase(type)) {
                filtered.add(game);
            }
        }
        return filtered;
    }

    public static GameWithItems filterGameByName (String name) {
        for (GameWithItems game: games) {
            if (game.gameName.equalsIgnoreCase(name)) {
                return game;
            }
        }
        return games.get(0);
    }

    public static String formatCurrency (String num) {
//        Integer toBeFormatted = Integer.parseInt(num);
//
//        Locale locale = new Locale.Builder().setLanguage("id").setRegion("ID").build();
//        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
//        return formatter.format(toBeFormatted);

//        StringBuilder sb = new StringBuilder(num);
//        sb.reverse();
//        Iterable<String> tokens = Splitter.fixedLength(3).split(sb.toString());
//
//        return Joiner.on('.').join(ImmutableList.copyOf(tokens).reverse()) + " IDR";

        DecimalFormat formatter = new DecimalFormat("###,###,###,### IDR");
        Double number = Double.valueOf(num);

        return formatter.format(number);
    }

    public static String countTotalPrice (String price, Integer qty) {
        Integer p = Integer.parseInt(price);
        Integer total = p * qty;
        return formatCurrency(total.toString());
    }

    public static void init () {
        if (!games.isEmpty()) return;
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
        GameWithItems pubg = new GameWithItems("PUBG", "Mobile", "Krafton", 4.8, R.drawable.pubgmobile);
        pubg.items.add(new ItemModel("30 Battle Coin", "Mengg33", "Trusted since 2020", "7000", R.drawable.pubg));
        pubg.items.add(new ItemModel("40 Battle Coin", "Mengg33", "Trusted since 2020", "9000", R.drawable.pubg));
        pubg.items.add(new ItemModel("60 Battle Coin", "Mengg33", "Trusted since 2020", "13400", R.drawable.pubg));

        games.add(pubg);

        // Growtopia
        GameWithItems growtopia = new GameWithItems("Growtopia", "Mobile", "Ubisoft", 4.7, R.drawable.growtopiamobile);
        growtopia.items.add(new ItemModel("World Lock", "GGwp Store", "Trusted since 2020", "1000", R.drawable.growtopia));
        growtopia.items.add(new ItemModel("Bunny Lock", "GGwp Store", "Trusted since 2020", "3000", R.drawable.growtopia));
        growtopia.items.add(new ItemModel("Green Gem Box", "HatBox Store", "Trusted since 2019", "366000", R.drawable.growtopia));

        games.add(growtopia);

        // Apex Legends
        GameWithItems apex = new GameWithItems("Apex Legends", "PC", "Electronic Arts", 4.5, R.drawable.apexpc);
        apex.items.add(new ItemModel("1000 Apex Coins", "AJP Store", "Trusted since 2016", "155000", R.drawable.apex));
        apex.items.add(new ItemModel("2000 Apex Coins", "Luxvry Store", "Trusted since 2016", "298000", R.drawable.apex));
        apex.items.add(new ItemModel("2500 Apex Coins", "AJP Store", "Trusted since 2016", "360000", R.drawable.apex));

        games.add(apex);

        // GTA V
        GameWithItems gta = new GameWithItems("Grand Theft Auto V", "PC", "Rockstar Games", 4.4, R.drawable.gtapc);
        gta.items.add(new ItemModel("Great White Shark Cash Card", "GGwp Store", "Trusted since 2020", "180000", R.drawable.gta));
        gta.items.add(new ItemModel("Tiger Shark Cash Card", "GGwp Store", "Trusted since 2020", "155000", R.drawable.gta));
        gta.items.add(new ItemModel("Whale Shark Cash Card", "HatBox Store", "Trusted since 2019", "66000", R.drawable.gta));
        gta.items.add(new ItemModel("Red Shark Cash Card", "Asixx Store", "Trusted since 2020", "55000", R.drawable.gta));
        games.add(gta);

        // COD
        GameWithItems cod = new GameWithItems("Call of Duty", "PC", "Activision", 4.3, R.drawable.codpc);
        cod.items.add(new ItemModel("500 CP", "Abcd Store", "Trusted since 2020", "100000", R.drawable.cod));
        cod.items.add(new ItemModel("1100 CP", "Kukira Store", "Trusted since 2020", "195000", R.drawable.cod));
        cod.items.add(new ItemModel("2400 CP", "HatBox Store", "Trusted since 2019", "390000", R.drawable.cod));
        cod.items.add(new ItemModel("5000 CP", "Asixx Store", "Trusted since 2020", "655000", R.drawable.cod));
        games.add(cod);

        // Valorant
        GameWithItems valorant = new GameWithItems("Valorant", "PC", "Riot  Games", 4.6, R.drawable.valorantpc);
        valorant.items.add(new ItemModel("1000 Valo Points", "AJP Store", "Trusted since 2018", "155000", R.drawable.valorant));
        valorant.items.add(new ItemModel("2000 Valo Points", "Luxvry Store", "Trusted since 2018", "298000", R.drawable.valorant));
        valorant.items.add(new ItemModel("2500 Valo Points", "AJP Store", "Trusted since 2018", "260000", R.drawable.valorant));
        games.add(valorant);

        // FIFA
        GameWithItems fifa = new GameWithItems("FIFA 20", "PC", "EA Sports", 4.7, R.drawable.fifapc);
        fifa.items.add(new ItemModel("Voucher Point 1050", "GGwp Store", "Trusted since 2020", "50000", R.drawable.fifa));
        fifa.items.add(new ItemModel("Voucher Point 1600", "GGwp Store", "Trusted since 2020", "80000", R.drawable.fifa));
        fifa.items.add(new ItemModel("Voucher Point 2200", "HatBox Store", "Trusted since 2019", "110000", R.drawable.fifa));
        games.add(fifa);

        // Minecraft
        GameWithItems minecraft = new GameWithItems("Minecraft", "PC", "Mojang Studios", 4.3, R.drawable.minecraftpc);
        minecraft.items.add(new ItemModel("VIP to VIP+", "NTM Store", "Trusted since 2018", "25000", R.drawable.minecraft));
        minecraft.items.add(new ItemModel("Mystery Box", "NTM Store", "Trusted since 2019", "48000", R.drawable.minecraft));
        minecraft.items.add(new ItemModel("Gift", "Heyyo Store", "Trusted since 2017", "95000", R.drawable.minecraft));
        minecraft.items.add(new ItemModel("Booster", "Aloha Store", "Available in 24 hours", "88000", R.drawable.minecraft));
        games.add(minecraft);

        // Elden Ring
        GameWithItems eldenring = new GameWithItems("Elden Ring", "Console", "Bandai Namco", 4.5, R.drawable.eldenringconsole);
        eldenring.items.add(new ItemModel("Flame of the Redmanes Sword", "GGwp Store", "Trusted since 2020", "180000", R.drawable.eldenring));
        eldenring.items.add(new ItemModel("Radagon Soreseal", "GGwp Store", "Trusted since 2020", "155000", R.drawable.eldenring));
        eldenring.items.add(new ItemModel("Spirit Calling Bell", "HatBox Store", "Trusted since 2019", "66000", R.drawable.eldenring));
        games.add(eldenring);

        // Animal Crossing
        GameWithItems animal = new GameWithItems("Animal Crossing", "Console", "Nintendo", 4.4, R.drawable.animalcrossingconsole);
        animal.items.add(new ItemModel("6 Bell Bags", "GGwp Store", "Trusted since 2020", "1000", R.drawable.animal));
        animal.items.add(new ItemModel("45 Bell Bags", "GGwp Store", "Trusted since 2020", "13000", R.drawable.animal));
        animal.items.add(new ItemModel("90 Bell Bags", "HatBox Store", "Trusted since 2019", "25000", R.drawable.animal));
        games.add(animal);

        // Pokemon
        GameWithItems pokemon = new GameWithItems("Pokemon Arceus", "Console", "Nintendon & Pokemon", 4.3, R.drawable.pokemonconsole);
        pokemon.items.add(new ItemModel("Pokeball Legendary", "PokiPoki", "Trusted since 2018", "25000", R.drawable.pokemon));
        pokemon.items.add(new ItemModel("Pokeball Normal", "LetsBattle", "Trusted since 2019", "48000", R.drawable.pokemon));
        games.add(pokemon);

        // Hogwarts
        GameWithItems hogwarts = new GameWithItems("Hogwarts Legacy", "Console", "Warner Bros", 4.6, R.drawable.hogwartsconsole);
        hogwarts.items.add(new ItemModel("Hogwarts Legacy Deluxe", "Lollipop Store", "Trusted since 2018", "220000", R.drawable.hogwarts));
        hogwarts.items.add(new ItemModel("Hogwarts Legacy", "Lollipop Store", "Trusted since 2018", "100000", R.drawable.hogwarts));
        hogwarts.items.add(new ItemModel("Hogwarts Legacy Special", "Day Dream Store", "New", "150000", R.drawable.hogwarts));
        games.add(hogwarts);

        // Sims
        GameWithItems sims = new GameWithItems("The Sims 4", "Console", "Electronic Arts", 4.3, R.drawable.sims4console);
        sims.items.add(new ItemModel("Basement Treasure Package", "GGwp Store", "Trusted since 2020", "69000", R.drawable.sims));
        sims.items.add(new ItemModel("Greenhouse Haven Package", "GGwp Store", "Trusted since 2020", "69000", R.drawable.sims));
        sims.items.add(new ItemModel("Snowy Escape Package", "HatFam Store", "Trusted since 2019", "479000", R.drawable.sims));
        games.add(sims);
    }
}