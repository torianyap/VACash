package com.example.vacash.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacash.R;
import com.example.vacash.models.GlobalVariable;

import java.util.ArrayList;

public class HomeGameAdapter extends RecyclerView.Adapter<HomeGameAdapter.MyViewHolder> {

    Context context;
    ArrayList<GlobalVariable.GameWithItems> games;

    public HomeGameAdapter(Context context, ArrayList<GlobalVariable.GameWithItems> games) {
        this.context = context;
        this.games = games;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.mobilegame, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.gameImage.setImageResource(games.get(position).getGameIcon());
        holder.gameName.setText(games.get(position).getGameName());
        holder.gameDeveloper.setText(games.get(position).getGameDeveloper());
        holder.gameRating.setText(games.get(position).getRating().toString());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView gameImage;
        TextView gameName, gameDeveloper, gameRating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            gameImage = itemView.findViewById(R.id.gameImage);
            gameName = itemView.findViewById(R.id.gameName);
            gameDeveloper = itemView.findViewById(R.id.gameDeveloper);
            gameRating = itemView.findViewById(R.id.gameRating);
        }
    }
}
