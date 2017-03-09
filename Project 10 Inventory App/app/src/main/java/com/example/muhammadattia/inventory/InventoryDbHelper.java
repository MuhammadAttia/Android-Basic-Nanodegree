package com.example.muhammadattia.inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class InventoryDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Inventory";

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("QUERY:", InventoryContract.Table.CREATE_TABLE);
        db.execSQL(InventoryContract.Table.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(InventoryContract.Table.DELETE_TABLE);
        onCreate(db);
    }

    public ArrayList<Product> readInventory() {
        ArrayList<Product> productList = new ArrayList<Product>();
        String query = "SELECT * FROM " + InventoryContract.Table.TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setmID(Integer.parseInt(cursor.getString(0)));
                product.setmProduct(cursor.getString(1));
                product.setmQuantity(cursor.getInt(2));
                product.setmPrice(cursor.getDouble(3));
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return productList;
    }

    void addEntry(Product newEntry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryContract.Table.Column_NAME, newEntry.getmProduct());
        values.put(InventoryContract.Table.Column_QUANTITY, newEntry.getmQuantity());
        values.put(InventoryContract.Table.Column_PRICE, newEntry.getmPrice());
        db.insert(InventoryContract.Table.TABLE_NAME, null, values);
        db.close();
    }

    public void updateProduct(double id, Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryContract.Table.Column_NAME, product.getmProduct());
        values.put(InventoryContract.Table.Column_PRICE, product.getmPrice());
        values.put(InventoryContract.Table.Column_QUANTITY, product.getmQuantity());
        db.update(InventoryContract.Table.TABLE_NAME, values, InventoryContract.Table.Column_ID + "=" + id, null);
        db.close();
    }

    public void deleteProduct(double id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(InventoryContract.Table.TABLE_NAME, InventoryContract.Table.Column_ID + "=" + id, null);
        sqLiteDatabase.close();
    }

    public boolean updateQuantity(double id, int quantity) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(InventoryContract.Table.Column_QUANTITY, quantity);
        int rowsUpdated = sqLiteDatabase.update(InventoryContract.Table.TABLE_NAME, cv, InventoryContract.Table.Column_ID + "=" + id, null);
        boolean success = false;
        if (rowsUpdated == 1) success = true;
        sqLiteDatabase.close();
        return success;
    }

    public long rowCount() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long count = DatabaseUtils.queryNumEntries(sqLiteDatabase, InventoryContract.Table.TABLE_NAME);
        sqLiteDatabase.close();
        return count;
    }
}