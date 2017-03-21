package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mymusic.R;

/**
 * Created by Muhammad on 2/22/2017.
 */

public class AdeleSongsActivity extends Activity {

    String[] adeleArray = {"1. Hello","2. Send My Love (To Your New Lover)","3. I Miss You","4. When We Were Young",
            "5. Water Under the Bridge","6. Remedy","7. River Lea","8. Love in the Dark)",
            "9. Million Years Ago","10. Sweetest Devotion","11. All I Ask"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adelesongs);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview,adeleArray);

        ListView listView = (ListView) findViewById(R.id.adele_list);
        listView.setAdapter(adapter);

    }

}
