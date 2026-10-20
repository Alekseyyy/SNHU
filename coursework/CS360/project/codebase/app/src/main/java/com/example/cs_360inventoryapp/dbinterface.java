package com.example.cs_360inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class dbinterface extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "inventory.db";
    private static final int DB_VERSION = 1;

    private static final String DB_TABLE_USERS = "users";
    private static final String DB_TABLE_USERS_username = "username";
    private static final String DB_TABLE_USERS_password = "password";
    private static final String DB_TABLE_INVENTORY = "inventory";
    private static final String DB_TABLE_INVENTORY_id = "_id";
    private static final String DB_TABLE_INVENTORY_name = "name";
    private static final String DB_TABLE_INVENTORY_cat = "category";
    private static final String DB_TABLE_INVENTORY_desc = "description";

    public dbinterface(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the tables
        String queryCreateUsers = "CREATE TABLE " + DB_TABLE_USERS +
                " (" + DB_TABLE_USERS_username + " TEXT PRIMARY KEY UNIQUE, " +
                DB_TABLE_USERS_password + " TEXT)";
        db.execSQL(queryCreateUsers);
        String queryCreateInventory = "CREATE TABLE " + DB_TABLE_INVENTORY +
                "(" + DB_TABLE_INVENTORY_id + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                DB_TABLE_INVENTORY_name + " TEXT, " +
                DB_TABLE_INVENTORY_cat + " TEXT, " +
                DB_TABLE_INVENTORY_desc + " TEXT)";
        db.execSQL(queryCreateInventory);

        // Insert sample data
        //  -- Starting with the "admin" user ...
        ContentValues cvUsersAdmin = new ContentValues();
        cvUsersAdmin.put(DB_TABLE_USERS_username, "admin");
        cvUsersAdmin.put(DB_TABLE_USERS_password, "password");
        long addAdminRes = db.insert(DB_TABLE_USERS, null, cvUsersAdmin);
        //  -- Then proceeding to the inventory sample ...
        ContentValues cvInventorySample = new ContentValues();
        cvInventorySample.put(DB_TABLE_INVENTORY_name, "sample 1");
        cvInventorySample.put(DB_TABLE_INVENTORY_cat, "category 1");
        cvInventorySample.put(DB_TABLE_INVENTORY_desc, "this is a test item");
        long addSampleItemRes = db.insert(DB_TABLE_INVENTORY, null, cvInventorySample);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // To "keep things simple," I will assume that the database does not
        //   really need to be upgraded, and keep this part blank.
    }

    // This function was developed with the help of [6] and "Google Gemini"
    public boolean isValidLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { DB_TABLE_USERS_username };
        String selection = DB_TABLE_USERS_username + " = ? AND " +
                DB_TABLE_USERS_password + " = ?;";
        String[] selectionArgs = { username, password };

        boolean workedValid = false;

        Cursor getCredentials = db.query(
                DB_TABLE_USERS,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int count = getCredentials.getCount();
        Log.i("dbinterface", String.valueOf(count) );
        if (count > 0) {
            workedValid = true;
        }
        getCredentials.close();
        db.close();

        return workedValid;
    }

    public boolean isUsernameExist(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { DB_TABLE_USERS_username };
        String selection = DB_TABLE_USERS_username + " = ?";
        String[] selectionArgs = { username };

        boolean workedExists = false;

        Cursor getUsername = db.query(
                DB_TABLE_USERS,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int count = getUsername.getCount();
        if (count > 0) {
            workedExists = true;
        }

        getUsername.close();
        db.close();

        return workedExists;
    }

    // this method heavily derives from [6]
    public void insertNewUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvNewUser = new ContentValues();

        cvNewUser.put(DB_TABLE_USERS_username, username);
        cvNewUser.put(DB_TABLE_USERS_password, password);

        db.insert(DB_TABLE_USERS, null, cvNewUser);
        db.close();
    }

    // this method heavily derives from [1][4][5]
    public List<List<String>> getInventory() {
        List<List<String>> inventoryData = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor getAllInventory = db.rawQuery("SELECT * FROM " + DB_TABLE_INVENTORY, null);

        if (getAllInventory.moveToFirst()) {
            do {
                List<String> currentRow = new ArrayList<>();
                currentRow.add(
                        getAllInventory.getString(
                                getAllInventory.getColumnIndexOrThrow(DB_TABLE_INVENTORY_name)
                        ));
                currentRow.add(
                        getAllInventory.getString(
                                getAllInventory.getColumnIndexOrThrow(DB_TABLE_INVENTORY_cat)
                        ));
                currentRow.add(
                        getAllInventory.getString(
                                getAllInventory.getColumnIndexOrThrow(DB_TABLE_INVENTORY_desc)
                        ));
                currentRow.add(
                        getAllInventory.getString(
                                getAllInventory.getColumnIndexOrThrow(DB_TABLE_INVENTORY_id)
                        ));
                inventoryData.add(currentRow);
            } while (getAllInventory.moveToNext());
        }
        getAllInventory.close();
        db.close();

        return inventoryData;
    }

    // this method heavily borrows from [6]
    public void insertNewItem(String name, String category, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvNewItem = new ContentValues();

        cvNewItem.put(DB_TABLE_INVENTORY_name, name);
        cvNewItem.put(DB_TABLE_INVENTORY_cat, category);
        cvNewItem.put(DB_TABLE_INVENTORY_desc, description);

        db.insert(DB_TABLE_INVENTORY, null, cvNewItem);
        db.close();
    }

    // this method heavily borrows from [6]
    public void deleteItem(String rowID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(
                DB_TABLE_INVENTORY,
                "_id=?",
                new String[] { rowID }
        );
    }

}

/*
 * References
 * 1. Chugn, A. (Aug. 3, 2022). Android SQLite Database Example Tutorial. DigitalOcean. Retrieved on Oct. 19, 2026 from:
 *   https://www.digitalocean.com/community/tutorials/android-sqlite-database-example-tutorial
 * 2. Froste, C. (n.d.). SQLite Database - Displaying Data. GitHub Repository. Retrieved on Oct. 19, 2026 from:
 *   https://github.com/CyanFroste/Android-Studio-Java/blob/master/SQLite/SQLite%20Database%20-%20Displaying%20Data.md
 * 3. w3schools (n.d.). Java Multi-Dimensional Arrays. Retrieved on Oct. 19, 2026 from:
 *   https://www.w3schools.com/JAVA/java_arrays_multi.asp
 * 4. Tutorials Point (n.d.). How to add table rows Dynamically in Android Layout?. Retrieved on Oct. 19, 2026 from:
 *   https://www.tutorialspoint.com/article/how-to-add-table-rows-dynamically-in-android-layout
 * 5. "kaloris555" (Sept. 29, 2015). Java - How to iterate through 3-dimensional ArrayList?. StackOverflow. Retrieved on
 *   Oct 19, 2026 from: https://stackoverflow.com/questions/32850460/java-how-to-iterate-through-3-dimensional-arraylist
 * 6. https://www.youtube.com/playlist?list=PLSrm9z4zp4mGK0g_0_jxYGgg3os9tqRUQ
 */
