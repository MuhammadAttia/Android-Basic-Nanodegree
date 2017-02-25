package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mymusic.R;

/**
 * Created by Muhammad on 2/22/2017.
 */

public class MonierSongsActivity extends Activity {

    String[] monierArray = {"1. lama el naseem", "2. Fi Aeshq El Banat ", "3. Shea Meen Be3ed", "4. Yunis",
            "5. 7twath Masryh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moniersongs);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, monierArray);
        ListView listView = (ListView) findViewById(R.id.monier_list);
        listView.setAdapter(adapter);
    }

}
