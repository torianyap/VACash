package com.example.vacash.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vacash.R;
import com.example.vacash.adapters.HomeGameAdapter;
import com.example.vacash.models.GlobalVariable;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PCFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PCFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PCFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pc.
     */
    // TODO: Rename and change types and number of parameters
    public static PCFragment newInstance(String param1, String param2) {
        PCFragment fragment = new PCFragment();
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
        ArrayList games = GlobalVariable.filterGameByType("PC");

        View view = inflater.inflate(R.layout.fragment_pc, container, false);
        RecyclerView homeRv = view.findViewById(R.id.home_rv);
        HomeGameAdapter adapter = new HomeGameAdapter(view.getContext(), games);

        homeRv.setAdapter(adapter);
        homeRv.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        return view;
    }
}