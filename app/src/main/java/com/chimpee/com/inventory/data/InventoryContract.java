package com.chimpee.com.inventory.data;

import android.provider.BaseColumns;

/**
 * API Contract for the Inventory app.
 */
public final class InventoryContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private InventoryContract() {
    }

    /**
     * Inner class that defines constant values for the products database table.
     * Each entry in the table represents a single product.
     */
    public static final class InventoryEntry implements BaseColumns {
        /** Name of database table for Samsung Tvs */
        public static final String TABLE_NAME = "samsungTVs";

        /**
         * Unique ID number for the product (only for use in the database table).
         *
         * Type: INTEGER
         */
        public static final String _ID = BaseColumns._ID;

        /**
         * Name of the product.
         *
         * Type: TEXT
         */
        public static final String COLUMN_NAME = "name";

        /**
         * Price of the product.
         *
         * Type: TEXT
         */
        public static final String COLUMN_PRICE = "price";

        /**
         * Quantity of the product.
         *
         * Type: INTEGER
         */
        public static final String COLUMN_QUANTITY = "quantity";

        /**
         * Name of the product's supplier.
         *
         * Type: TEXT
         */
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";

        /**
         * Phone number of the product's supplier.
         *
         * Type: TEXT
         */
        public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";

        /**
         * Email address of the product's supplier.
         *
         * Type: TEXT
         */
        public static final String COLUMN_SUPPLIER_EMAIL = "supplier_email";

        /**
         * Image address of the products.
         *
         * Type: TEXT
         */
        public static final String COLUMN_IMAGE = "image";

        // Create a String that contains the SQL statement to create the samsungTVs table
        public static final String CREATE_TABLE_STOCK = "CREATE TABLE " +
                InventoryContract.InventoryEntry.TABLE_NAME + "(" +
                InventoryContract.InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                InventoryContract.InventoryEntry.COLUMN_NAME + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.COLUMN_PRICE + " DOUBLE NOT NULL DEFAULT 0," +
                InventoryContract.InventoryEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_EMAIL + " TEXT NOT NULL," +
                InventoryEntry.COLUMN_IMAGE + " TEXT NOT NULL" + ");";
    }
}