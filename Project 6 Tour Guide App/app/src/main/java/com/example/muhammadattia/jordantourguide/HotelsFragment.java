package com.example.muhammadattia.jordantourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {


    public HotelsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.item, container, false);

        // Create a list of hotels
        final ArrayList<Jordan> hotel = new ArrayList<Jordan>();
        hotel.add(new Jordan(R.drawable.rotana, R.string.ammanrotana_title, R.string.rotana_hotel));
        hotel.add(new Jordan(R.drawable.intercontinental,R.string.intercontinentail_title, R.string.interContinental));
        hotel.add(new Jordan(R.drawable.fourseasons, R.string.fourseasons_title, R.string.four_seasons));
        hotel.add(new Jordan(R.drawable.crowneplaza, R.string.crownaplaza_title, R.string.crowneplaza));
        hotel.add(new Jordan(R.drawable.kempinski,R.string.kempinski_title, R.string.kempinski));

        JordanAdapter adapter = new JordanAdapter(getActivity(), hotel);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;


    }
}