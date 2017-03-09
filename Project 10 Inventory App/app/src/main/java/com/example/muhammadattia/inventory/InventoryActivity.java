package com.example.muhammadattia.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_inventory);
        InventoryDbHelper InventoryDbHelper = new InventoryDbHelper(this);

        ListView listView = (ListView) findViewById(R.id.inventory_listView);
        // insert
        TextView empty = (TextView) findViewById(R.id.empty);

        ArrayList<Product> listArray = InventoryDbHelper.readInventory();
        if (listArray.size() == 0) {
            empty.setText(R.string.empty);
        } else {
            empty.setText("");
        }
        ListViewAdapter customAdapter = new ListViewAdapter(listArray);
        customAdapter.notifyDataSetChanged();
        listView.setAdapter(customAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        InventoryDbHelper InventoryDbHelper = new InventoryDbHelper(this);

        ListView listView = (ListView) findViewById(R.id.inventory_listView);
        TextView empty = (TextView) findViewById(R.id.empty);

        ArrayList<Product> listArray = InventoryDbHelper.readInventory();
        if (listArray.size() == 0) {
            empty.setText(R.string.empty);
        } else {
            empty.setText("");
        }
        ListViewAdapter customAdapter = new ListViewAdapter(listArray);
        customAdapter.notifyDataSetChanged();
        listView.setAdapter(customAdapter);
    }

    public void addNewItem(View view) {
        Intent intent = new Intent(this, AddProductActivity.class);
        intent.putExtra("HEADER", "Add a New Product");
        startActivity(intent);
    }
}
