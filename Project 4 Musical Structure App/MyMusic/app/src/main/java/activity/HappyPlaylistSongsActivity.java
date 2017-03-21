package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mymusic.R;

/**
 * Created by Muhammad on 2/22/2017.
 */

public class HappyPlaylistSongsActivity extends Activity {
    String[] happyArray = {"1. Good Vibrations", "2. The Twist", "3. Dancing Queen", "4. I Believe In A Thing Called Love",
            "5. What I Got"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.happysongs);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, happyArray);

        ListView listView = (ListView) findViewById(R.id.happy_list);
        listView.setAdapter(adapter);

    }

}
