package com.example.vacash.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacash.R;
import com.example.vacash.models.GameWithItems;
import com.example.vacash.models.RecyclerViewInterface;

import java.util.ArrayList;

public class HomeGameAdapter extends RecyclerView.Adapter<HomeGameAdapter.MyViewHolder> {

    Context context;
    ArrayList<GameWithItems> games;

    private final RecyclerViewInterface recyclerViewInterface;

    public HomeGameAdapter(Context context, ArrayList<GameWithItems> games, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.games = games;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.home_game_card, parent, false);
        return new MyViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int size = 10;
        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), games.get(position).getGameIcon());
        Bitmap resized = Bitmap.createScaledBitmap(originalBitmap, originalBitmap.getWidth() / size, originalBitmap.getHeight() / size, true);
        originalBitmap.recycle();
        holder.gameImage.setImageBitmap(resized);

        holder.gameName.setText(games.get(position).getGameName());
        holder.gameDeveloper.setText(games.get(position).getGameDeveloper());
        holder.gameRating.setText(games.get(position).getRating().toString());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView gameImage;
        TextView gameName, gameDeveloper, gameRating;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            gameImage = itemView.findViewById(R.id.gameImage);
            gameName = itemView.findViewById(R.id.gameName);
            gameDeveloper = itemView.findViewById(R.id.gameDeveloper);
            gameRating = itemView.findViewById(R.id.gameRating);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
