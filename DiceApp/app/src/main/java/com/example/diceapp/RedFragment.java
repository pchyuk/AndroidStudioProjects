package com.example.diceapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class RedFragment extends Fragment {
    public RedFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_red,container,false);

        ListView listView = (ListView) view.findViewById(R.id.list_view);
        ArrayList<String> numbers = new ArrayList<>();
        for (int i=1; i<=20; i++){
            numbers.add("Number " + i);
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(itemsAdapter);

        return view;
    }
}
