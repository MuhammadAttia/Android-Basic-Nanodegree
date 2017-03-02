package com.example.muhammadattia.jordantourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PopularCitiesFragment extends Fragment {


    public PopularCitiesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.item, container, false);

        // Create a list of cities
        final ArrayList<Jordan> city = new ArrayList<Jordan>();
        city.add(new Jordan(R.drawable.amman,R.string.amman_title,R.string.Amman));
        city.add(new Jordan(R.drawable.aqaba,R.string.aqaba_title, R.string.Aqaba));
        city.add(new Jordan(R.drawable.petra,R.string.petra_title, R.string.Petra));
        city.add(new Jordan(R.drawable.jerash, R.string.jerash_title, R.string.Jerash));
        city.add(new Jordan(R.drawable.deadsea, R.string.deadsea_title, R.string.deadSea));

        JordanAdapter adapter = new JordanAdapter(getActivity(), city);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;

    }

}
