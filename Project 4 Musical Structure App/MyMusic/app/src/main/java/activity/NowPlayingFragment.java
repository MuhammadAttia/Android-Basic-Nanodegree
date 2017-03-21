package activity;

/**
 * Created by Muhammad on 2/21/2017.
 */

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mymusic.R;

import co.mobiwise.library.MusicPlayerView;

/* This project uses the aweseome library MusicPlayerView from iammert
   Thanks for sharing this project that you can compile and use for personal projects :
   https://github.com/iammert/MusicPlayerView
 */



public class NowPlayingFragment extends Fragment {


    MusicPlayerView mpv ;
    boolean started = false;


    public NowPlayingFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nowplaying, container, false);

        mpv = (MusicPlayerView) rootView.findViewById(R.id.mpv);
        mpv.setButtonColor(Color.RED);
        mpv.setCoverDrawable(R.drawable.zayn);
        mpv.setProgressEmptyColor(Color.GRAY);
        mpv.setProgressLoadedColor(Color.BLUE);
        mpv.setTimeColor(Color.RED);

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
}