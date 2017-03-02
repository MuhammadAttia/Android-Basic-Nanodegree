package com.example.muhammadattia.jordantourguide;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Attia on 01/03/2017.
 */


public class JordanAdapter extends ArrayAdapter<Jordan> {

    public JordanAdapter(Activity context, ArrayList<Jordan> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {object located at this position in the list
        Jordan currentItem = getItem(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.title);
        nameTextView.setText(currentItem.getTitle());

        TextView numberTextView = (TextView) convertView.findViewById(R.id.disc);
        numberTextView.setText(currentItem.getDiscription());

        ImageView iconView = (ImageView) convertView.findViewById(R.id.image);
        iconView.setImageResource(currentItem.getmImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        return convertView;
    }

}

