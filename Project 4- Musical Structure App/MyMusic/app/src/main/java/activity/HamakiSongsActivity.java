package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mymusic.R;

/**
 * Created by Muhammad on 2/22/2017.
 */

public class HamakiSongsActivity extends Activity {

    String[] hamakiarray = {"1. ma balash", "2. min alby baghany", "3. kan we kan", "4. wadi haly maak",
            "5. wahda wahda"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hamkisongs);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, hamakiarray);

        ListView listView = (ListView) findViewById(R.id.hamki_list);
        listView.setAdapter(adapter);

    }

}
