package com.example.muhammadattia.jordantourguide;

import android.widget.ImageView;

/**
 * Created by Muhammad Attia on 01/03/2017.
 */

public class Jordan {

    private int mImageResourceId;
    private int title;
    private int discription;

    public Jordan(int mImageResourceId, int title, int discription) {
        this.mImageResourceId = mImageResourceId;
        this.title = title;
        this.discription = discription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getTitle() {
        return title;
    }

    public int getDiscription() {
        return discription;
    }


}
