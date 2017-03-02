package com.example.muhammadattia.jordantourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class shoppingFragment extends Fragment {


    public shoppingFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.item, container, false);

        // Create a list of hotels
        final ArrayList<Jordan> shop = new ArrayList<Jordan>();
        shop.add(new Jordan(R.drawable.rinbow,R.string.rainbow_title, R.string.rinbow));
        shop.add(new Jordan(R.drawable.citymall, R.string.citymall_title, R.string.citymall));
        shop.add(new Jordan(R.drawable.albalad, R.string.albaled_title, R.string.alBalad));
        shop.add(new Jordan(R.drawable.meccamall,R.string.mecca_title, R.string.meccamall));

        JordanAdapter adapter = new JordanAdapter(getActivity(), shop);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;


    }


}
