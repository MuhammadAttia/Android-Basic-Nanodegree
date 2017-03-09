package com.example.muhammadattia.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button stock;
    Button additem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        additem = (Button) findViewById(R.id.addItem);
        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddProductActivity.class);
                startActivity(intent);
            }
        });

        stock =(Button)findViewById(R.id.stock);
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, InventoryActivity.class);
                startActivity(intent);
            }
        });

    }

}
