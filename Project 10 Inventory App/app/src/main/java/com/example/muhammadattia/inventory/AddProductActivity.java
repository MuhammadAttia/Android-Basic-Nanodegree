package com.example.muhammadattia.inventory;

import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddProductActivity extends AppCompatActivity {
    public String price;
    public String quantity;
    public String name;
    public long nextID;

    public Product product = new Product();
    InventoryDbHelper InventoryDbHelper = new InventoryDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        nextID = (InventoryDbHelper.rowCount() + 1);
        Intent intent = getIntent();
        String message = intent.getStringExtra("Add New Product");
        setTitle(message);
    }

    public void onClickSubmit(View view) {
        EditText nameText = (EditText) findViewById(R.id.productName);
        EditText priceText = (EditText) findViewById(R.id.productPrice);
        EditText quantityText = (EditText) findViewById(R.id.productQuantity);
        ImageView img = (ImageView) findViewById(R.id.imageSelected);
        name = nameText.getText().toString();
        price = (priceText.getText().toString());
        quantity = (quantityText.getText().toString());

        if (nameText.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(),R.string.name_required, Toast.LENGTH_LONG).show();
            nameText.setError(getString(R.string.name_required));
        } else if (priceText.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(),R.string.price_required, Toast.LENGTH_LONG).show();
            priceText.setError(getString(R.string.price_required));
        } else if (quantityText.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(),R.string.quantity_required, Toast.LENGTH_LONG).show();
            quantityText.setError(getString(R.string.quantity_required));
        } else if (img.getDrawable() == null) {
            Toast.makeText(getApplicationContext(),R.string.upload_image, Toast.LENGTH_LONG).show();
        }
        else {
            InventoryDbHelper.addEntry(new Product(name, Integer.parseInt(quantity), Double.parseDouble(price)));
            Toast.makeText(this, R.string.product_added, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, InventoryActivity.class);
            startActivity(intent);
            Log.v("VALUES : ", name + " " + price + " " + quantity);
        }
    }


    public void btnImageOnClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 &&
                resultCode == RESULT_OK && null != data) {
            Toast.makeText(this, "Uploading", Toast.LENGTH_LONG).show();
            Uri selectedImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                ImageView imageView = (ImageView) findViewById(R.id.imageSelected);
                imageView.setImageBitmap(bitmap);
                String filename = Long.toString(nextID);
                saveToInternalStorage(bitmap, filename);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Could not load this image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveToInternalStorage(Bitmap bmp, String filename) {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File appDirectory = contextWrapper.getFilesDir();

        File currentPath = new File(appDirectory, filename);

        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(currentPath);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
