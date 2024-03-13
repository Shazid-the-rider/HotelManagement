package com.example.hotelmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table Users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);
        String qry2 = "create table Cart(username text,product text,price float,OType text)";
        sqLiteDatabase.execSQL(qry2);
        String qry4 = "create table Book(username text,hotel_name text,cost float ,country_name text,Otype text)";
        sqLiteDatabase.execSQL(qry4);
        String qry5 = "create table Flight(username text,email text,flight_name text,cost float,Date text,Otype text)";
        sqLiteDatabase.execSQL(qry5);
        String qry6 = "create table Tour(username text,email text,price float,Otype text)";
        sqLiteDatabase.execSQL(qry6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("Users", null, cv);
        db.close();
    }

    public int signIn(String username, String password) {

        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Users where username=? and password=?", str);
        if (c.moveToFirst()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void AddCart(String username, String product, float price, String OType) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("OType", OType);
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert("Cart", null, cv);
        if (result == -1) {
            Log.e("Database", "Error inserting data into Cart table");
        } else {
            Log.d("Database", "Data inserted successfully into Cart table");
        }
        db.close();
    }

    public int CheckCartItem(String username, String product) {

        String str[] = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Cart where username=? and product=?", str);
        if (c.moveToFirst()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void RemoveCart(String username, String product, String OType) {
        String str[] = new String[3];
        str[0] = username;
        str[1] = product;
        str[2] = OType;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Cart", "username=? and product=? and OType=?", str);
        db.close();
    }

    public void booktour(String username, String email, float price, String Otype) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("price", price);
        cv.put("Otype", Otype);
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert("Tour", null, cv);
        if (result == -1) {
            Log.e("Database", "Error inserting data into Cart table");
        } else {
            Log.d("Database", "Data inserted successfully into Tour table");
        }
        db.close();
    }

    public int CheckTourItem(String username, String Otype) {

        String str[] = new String[2];
        str[0] = username;
        str[1] = Otype;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Tour where username=? and Otype=?", str);
        if (c.moveToFirst()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void RemoveTourCart(String username, String Otype) {
        String str[] = new String[2];
        str[0] = username;
        str[1] = Otype;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Tour", "username=? and Otype=?", str);
        db.close();
    }


    public void book(String username, String hotel_name, float cost, String country_name, String Otype) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("hotel_name", hotel_name);
        cv.put("cost", cost);
        cv.put("country_name", country_name);
        cv.put("OType", Otype);
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert("Book", null, cv);
        if (result == -1) {
            Log.e("Database", "Error inserting data into Cart table");
        } else {
            Log.d("Database", "Data inserted successfully into Cart table");
        }
        db.close();

    }

    public int CheckBookRoom(String username, String hotel_name, String country_name) {

        String str[] = new String[3];
        str[0] = username;
        str[1] = hotel_name;
        str[2] = country_name;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Book where username=? and hotel_name=? and country_name=?", str);
        if (c.moveToFirst()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void RemoveBook(String username, String hotel_name, String country_name, String OType) {
        String str[] = new String[4];
        str[0] = username;
        str[1] = hotel_name;
        str[2] = country_name;
        str[3] = OType;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Book", "username=? and hotel_name=? and country_name=? and OType=?", str);
        db.close();
    }

    public void Add_flight(String username, String email, String flight_name, float cost, String Date, String Otype) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("flight_name", flight_name);
        cv.put("cost", cost);
        cv.put("Date", Date);
        cv.put("Otype", Otype);
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert("Flight", null, cv);
        if (result == -1) {
            Log.e("Database", "Error inserting data into Cart table");
        } else {
            Log.d("Database", "Data inserted successfully into Cart table");
        }
        db.close();
    }

    public int checkFlight(String username, String email, String flight_name, String Date) {
        String str[] = new String[4];
        str[0] = username;
        str[1] = email;
        str[2] = flight_name;
        str[3] = Date;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Flight where username=? and email=? and flight_name=? and Date=?", str);
        if (c.moveToFirst()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void remove_flight(String username, String flight_name, String Date) {
        String str[] = new String[3];
        str[0] = username;
        str[1] = flight_name;
        str[2] = Date;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Flight", "username=? and flight_name=? and Date=?", str);
        db.close();
    }

    public ArrayList getuserinfo(String username) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Users where username=?", str);
        if (c.moveToFirst()) {
            do {
                String email = c.getString(1);
                String password = c.getString(2);
                arr.add(email);
                arr.add(password);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<String> getcartinfo(String username) {

        //String product, float price, String OType
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Cart where username=?", str);
        if (c.moveToFirst()) {
            do {

                String product = c.getString(1);
                arr.add(product);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<Float> getcartinfo1(String username) {


        //String product, float price, String OType
        ArrayList<Float> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Cart where username=?", str);
        if (c.moveToFirst()) {
            do {

                float price = c.getFloat(2);
                arr.add(price);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<String> getcartinfo2(String username) {


        //String product, float price, String OType
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Cart where username=?", str);
        if (c.moveToFirst()) {
            do {

                String Otype = c.getString(3);
                arr.add(Otype);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<String> getcartinfo3(String username) {
        //hotel_name text,cost float ,country_name text,Otype text
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Book where username=?", str);
        if (c.moveToFirst()) {
            do {

                String hotel_name = c.getString(1);
                arr.add(hotel_name);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<Float> getcartinfo4(String username) {


        //String product, float price, String OType
        ArrayList<Float> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Book where username=?", str);
        if (c.moveToFirst()) {
            do {
                float price = c.getFloat(2);
                arr.add(price);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<String> getcartinfo5(String username) {


        //String product, float price, String OType
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Book where username=?", str);
        if (c.moveToFirst()) {
            do {

                String country_name = c.getString(3);
                arr.add(country_name);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<String> getcartinfo6(String username) {
        //hotel_name text,cost float ,country_name text,Otype text
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Flight where username=?", str);
        if (c.moveToFirst()) {
            do {

                String hotel_name = c.getString(2);
                arr.add(hotel_name);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<Float> getcartinfo7(String username) {


        //String product, float price, String OType
        ArrayList<Float> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Flight where username=?", str);
        if (c.moveToFirst()) {
            do {
                float price = c.getFloat(3);
                arr.add(price);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<String> getcartinfo8(String username) {


        //String product, float price, String OType
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Flight where username=?", str);
        if (c.moveToFirst()) {
            do {

                String country_name = c.getString(4);
                arr.add(country_name);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<String> getcartinfo9(String username) {
        //hotel_name text,cost float ,country_name text,Otype text
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Tour where username=?", str);
        if (c.moveToFirst()) {
            do {

                String Order = c.getString(3);
                arr.add(Order);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }

    public ArrayList<Float> getcartinfo10(String username) {


        ArrayList<Float> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select *from Tour where username=?", str);
        if (c.moveToFirst()) {
            do {
                float Order = c.getFloat(2);
                arr.add(Order);
            } while (c.moveToNext());

        }
        db.close();
        return arr;
    }


    public ArrayList<String> getAllUsernamesWithProductsFromCart() {
        ArrayList<String> usersWithProducts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT Cart.username, Cart.product ,Cart.price,Cart.OType FROM Cart INNER JOIN Users ON Cart.username = Users.username";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String userWithProduct = cursor.getString(0) + ": " + cursor.getString(1) + ": " + cursor.getFloat(2) + ": " + cursor.getString(3);
                    usersWithProducts.add(userWithProduct);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        return usersWithProducts;
    }

    //username text,hotel_name text,cost float ,country_name text,Otype text
    public ArrayList<String> getAllUsernamesWithProductsFromBook() {
        ArrayList<String> usersWithProducts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT Book.username, Book.hotel_name ,Book.cost,Book.country_name FROM Book INNER JOIN Users ON Book.username = Users.username";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String userWithProduct = cursor.getString(0) + ": " + cursor.getString(1) + ": " + cursor.getFloat(2) + ": " + cursor.getString(3);
                    usersWithProducts.add(userWithProduct);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        return usersWithProducts;
    }

    //username text,email text,flight_name text,cost float,Date text,Otype text
    public ArrayList<String> getAllUsernamesWithProductsFromFlight() {
        ArrayList<String> usersWithProducts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT Flight.username, Flight.email ,Flight.flight_name,Flight.cost,Flight.Date FROM Flight INNER JOIN Users ON Flight.username = Users.username";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String userWithProduct = cursor.getString(0) + ": " + cursor.getString(1) + ": " + cursor.getString(2) + ": " + cursor.getFloat(3) + ": " + cursor.getString(4);
                    usersWithProducts.add(userWithProduct);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        return usersWithProducts;
    }

    public ArrayList<String> getAllUsernamesWithProductsFromTour() {
        ArrayList<String> usersWithProducts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT Tour.username, Tour.email ,Tour.price,Tour.Otype FROM Tour INNER JOIN Users ON Tour.username = Users.username";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String userWithProduct = cursor.getString(0) + ": " + cursor.getString(1) + ": " + cursor.getFloat(2) + ": " + cursor.getString(3);
                    usersWithProducts.add(userWithProduct);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        return usersWithProducts;
    }

    public boolean updateUserInfo(String currentUsername, String newUsername, String currentEmail, String newEmail, String currentPassword, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", newUsername);
        values.put("email", newEmail);
        values.put("password", newPassword);
        String[] whereArgs = {currentUsername, currentEmail, currentPassword};
        int rowsAffected = db.update("Users", values, "username=? AND email=? AND password=?", whereArgs);
        db.close();
        return rowsAffected > 0;
    }
}





