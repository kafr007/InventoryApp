package com.chimpee.com.inventory.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class InventoryDBHelper extends SQLiteOpenHelper {
    /** Name of the database file */
    public final static String DB_NAME = "tvInventory.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    public final static int DB_VERSION = 1;

    public final static String LOG_TAG = InventoryDBHelper.class.getCanonicalName();

    /**
     * Constructs a new instance of {@link InventoryDBHelper}.
     *
     * @param context of the app
     */
    public InventoryDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InventoryContract.InventoryEntry.CREATE_TABLE_STOCK);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * This is called when we insert product to the database.
     */
    public void insertProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_NAME, product.getProductName());
        values.put(InventoryContract.InventoryEntry.COLUMN_PRICE, product.getPrice());
        values.put(InventoryContract.InventoryEntry.COLUMN_QUANTITY, product.getQuantity());
        values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME, product.getSupplierName());
        values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE, product.getSupplierPhone());
        values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_EMAIL, product.getSupplierEmail());
        values.put(InventoryContract.InventoryEntry.COLUMN_IMAGE, product.getImage());
        long id = db.insert(InventoryContract.InventoryEntry.TABLE_NAME, null, values);
    }

    /**
     * This is called when we read datas from the database (select * from samsungTvs).
     */
    public Cursor readProducts() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.COLUMN_NAME,
                InventoryContract.InventoryEntry.COLUMN_PRICE,
                InventoryContract.InventoryEntry.COLUMN_QUANTITY,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_EMAIL,
                InventoryContract.InventoryEntry.COLUMN_IMAGE
        };
        Cursor cursor = db.query(
                InventoryContract.InventoryEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    /**
     * This is called when we read datas from the database (select * from samsungTvs where _ID = productID ).
     */
    public Cursor readProduct(long productID) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.COLUMN_NAME,
                InventoryContract.InventoryEntry.COLUMN_PRICE,
                InventoryContract.InventoryEntry.COLUMN_QUANTITY,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_EMAIL,
                InventoryContract.InventoryEntry.COLUMN_IMAGE
        };
        String selection = InventoryContract.InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(productID) };

        Cursor cursor = db.query(
                InventoryContract.InventoryEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

 /**
     * This is called when we update datas in the database.
     */
    public void updateProduct(long currentProductID, String name, int quantity, double price, String supplierName, String supplierPhone, String supplierEmail) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_NAME, name);
        values.put(InventoryContract.InventoryEntry.COLUMN_QUANTITY, quantity);
        values.put(InventoryContract.InventoryEntry.COLUMN_PRICE, price);
        values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME, supplierName);
        values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE, supplierPhone);
        values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_EMAIL, supplierEmail);
        String selection = InventoryContract.InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(currentProductID) };
        db.update(InventoryContract.InventoryEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

       /**
     * This is called when we sell a product and we change the data in the database.
     */
    public void sellOneProduct(long itemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        int newQuantity = 0;
        if (quantity > 0) {
            newQuantity = quantity -1;
        }
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_QUANTITY, newQuantity);
        String selection = InventoryContract.InventoryEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };
        db.update(InventoryContract.InventoryEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

    /**
     * Add data for demo purposes
     */
    public void addTestData() {
        Product samsungTV1 = new Product(
                "Samsung1",
                150.25,
                45,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV1);

        Product samsungTV2 = new Product(
                "Samsung2",
                200.50,
                10,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV2);

        Product samsungTV3 = new Product(
                "Samsung3",
                400.50,
                5,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV3);

        Product samsungTV4 = new Product(
                "Samsung4",
                175.86,
                25,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV4);

        Product samsungTV5 = new Product(
                "Samsung5",
                150.25,
                2,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV5);

        Product samsungTV6 = new Product(
                "Samsung6",
                75.86,
                100,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV6);

        Product samsungTV7 = new Product(
                "Samsung7",
                56.25,
                125,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV7);

        Product samsungTV8 = new Product(
                "Samsung8",
                150.25,
                45,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV8);

        Product samsungTV9 = new Product(
                "Samsung9",
                200,
                10,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV9);

        Product samsungTV10 = new Product(
                "Samsung10",
                196.23,
                6,
                "Samsung Hungary Kft.",
                "00 36 1 000 000",
                "samsung@tv.com",
                "android.resource://com.chimpee.com.inventory/drawable/samsungtv");
        insertProduct(samsungTV10);
    }
}