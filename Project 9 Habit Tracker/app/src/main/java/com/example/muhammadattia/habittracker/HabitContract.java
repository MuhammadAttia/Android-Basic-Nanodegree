package com.example.muhammadattia.habittracker;

import android.provider.BaseColumns;

/**
 * Created by Muhammad Attia on 06/03/2017.
 */

public class HabitContract {

    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String ID = BaseColumns._ID;
        public final static String COLUMN_NAME ="name";
        public final static String COLUMN_CATEGORY ="category";
        public final static String COLUMN_COUNTER="counterPerWeek";
    }

}
