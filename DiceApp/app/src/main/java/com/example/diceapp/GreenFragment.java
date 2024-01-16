package com.example.diceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class GreenFragment extends Fragment {
    public GreenFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_green, container, false);

        ListView listView = (ListView) view.findViewById(R.id.image_list_view);
        ArrayList<Integer> imageIds = new ArrayList<>();

        for (int i=1; i<=6; i++){
            int resId = getResources().getIdentifier("dice"+i, "drawable", getActivity().getPackageName());
            imageIds.add(resId);
        }

        ImageListAdapter adapter = new ImageListAdapter(getActivity(), imageIds);
        listView.setAdapter(adapter);

        return view;
    }
}