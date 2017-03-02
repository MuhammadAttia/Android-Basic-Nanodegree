package com.example.muhammadattia.jordantourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public CategoryAdapter(FragmentManager fm,Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PopularCitiesFragment();
        } else if (position == 1) {
            return new HotelsFragment();
        }
        else if (position == 2) {
            return new ResturantFragment();
        }
        else {
            return new shoppingFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_popular_city);
        } else if (position == 1) {
            return mContext.getString(R.string.category_hotel);
        }
        else if (position == 2) {
            return mContext.getString(R.string.category_resturant);
        }
        else {
            return mContext.getString(R.string.category_Shopping);
        }
    }
}