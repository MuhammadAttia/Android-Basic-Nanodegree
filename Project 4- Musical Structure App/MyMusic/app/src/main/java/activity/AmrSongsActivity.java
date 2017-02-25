package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mymusic.R;

/**
 * Created by Muhammad on 2/22/2017.
 */

public class AmrSongsActivity extends Activity {

    String[] amrArray = {"1. tamally ma'ak","2. ala hobak","3. wayah","4. aref habiby",
            "5. aks baad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amrsongs);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview,amrArray);

        ListView listView = (ListView) findViewById(R.id.amr_list);
        listView.setAdapter(adapter);




    }

}
