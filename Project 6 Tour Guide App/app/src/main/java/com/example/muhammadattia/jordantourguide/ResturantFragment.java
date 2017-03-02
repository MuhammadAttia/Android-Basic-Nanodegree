package com.example.muhammadattia.jordantourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ResturantFragment extends Fragment {


    public ResturantFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.item, container, false);

        // Create a list of restaurant
        final ArrayList<Jordan> restaurant = new ArrayList<Jordan>();
        restaurant.add(new Jordan(R.drawable.biskret, R.string.brisket_title, R.string.brisket));
        restaurant.add(new Jordan(R.drawable.hashme,R.string.hashem_title, R.string.hashem));
        restaurant.add(new Jordan(R.drawable.habiba,R.string.habiba_title, R.string.habiba));
        restaurant.add(new Jordan(R.drawable.sufra, R.string.sufra_title, R.string.sufra));


        JordanAdapter adapter = new JordanAdapter(getActivity(), restaurant);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;

    }

}
