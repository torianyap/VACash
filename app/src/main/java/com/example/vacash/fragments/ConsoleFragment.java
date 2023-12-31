package com.example.vacash.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vacash.ItemPage;
import com.example.vacash.R;
import com.example.vacash.adapters.HomeGameAdapter;
import com.example.vacash.models.GameWithItems;
import com.example.vacash.models.GlobalVariable;
import com.example.vacash.models.RecyclerViewInterface;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsoleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsoleFragment extends Fragment implements RecyclerViewInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsoleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment console.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsoleFragment newInstance(String param1, String param2) {
        ConsoleFragment fragment = new ConsoleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ArrayList<GameWithItems> games = GlobalVariable.filterGameByType("Console");

        View view = inflater.inflate(R.layout.fragment_console, container, false);
        RecyclerView homeRv = view.findViewById(R.id.home_rv);
        HomeGameAdapter adapter = new HomeGameAdapter(view.getContext(), games, this);

        homeRv.setAdapter(adapter);
        homeRv.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        return view;
    }

    @Override
    public void onItemClick(int position) {
        ArrayList<GameWithItems> games = GlobalVariable.filterGameByType("Console");

        Intent i = new Intent(getActivity(), ItemPage.class);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Items", games.get(position).getItems());
        bundle.putString("gameName", games.get(position).getGameName());
        bundle.putInt("gameIcon", games.get(position).getGameIcon());

        i.putExtras(bundle);
        startActivity(i);
    }
}