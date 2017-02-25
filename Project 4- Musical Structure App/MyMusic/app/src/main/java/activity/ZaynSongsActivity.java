package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mymusic.R;

/**
 * Created by Muhammad on 2/22/2017.
 */

public class ZaynSongsActivity extends Activity {

    String[] zaynArray = {"1. MiNd Of MiNdd (Intro)", "2. PILLOWTALK", "3. iT’s YoU", "4. wRoNg (feat. Kehlani)",
            "5. SHE DON'T LOVE ME"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaynsongs);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, zaynArray);

        ListView listView = (ListView) findViewById(R.id.zayn_list);
        listView.setAdapter(adapter);

    }

}
