package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mymusic.R;

/**
 * Created by Muhammad on 2/22/2017.
 */

public class SadPlaylistSongsActivity extends Activity {

    String[] sadArray = {"1. Skinny Love", "2. Breathe Me", "3. Rustling Trees", "4. Let It Go",
            "5. Let Me Down Easy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sadsongs);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, sadArray);

        ListView listView = (ListView) findViewById(R.id.sad_list);
        listView.setAdapter(adapter);


    }

}
