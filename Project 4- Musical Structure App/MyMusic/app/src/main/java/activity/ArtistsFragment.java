package activity;

/**
 * Created by Muhammad on 2/21/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.android.mymusic.R;


public class ArtistsFragment extends Fragment {

    public ArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_artists, container, false);

        LinearLayout mon = (LinearLayout) rootView.findViewById(R.id.monier);
        mon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent monierintent = new Intent(getActivity(), MonierSongsActivity.class);
                startActivity(monierintent);
            }
        });
        LinearLayout amr = (LinearLayout) rootView.findViewById(R.id.amr);
        amr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent amrintent = new Intent(getActivity(), AmrSongsActivity.class);
                startActivity(amrintent);
            }
        });
        LinearLayout hamo = (LinearLayout) rootView.findViewById(R.id.hamaki);
        hamo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent hamakiintent = new Intent(getActivity(), HamakiSongsActivity.class);
                startActivity(hamakiintent);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    // write your code her
}