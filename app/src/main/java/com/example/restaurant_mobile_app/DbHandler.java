package com.example.restaurant_mobile_app;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "booking";
    private static final String TABLE_NAME = "booking";

    // Column names
    private static final String ID = "id";
    private static final String TNAME = "tname";
    private static final String NAME = "name";
    private static final String NIC = "nic";
    private static final String DATE = "date";
    private static final String TIME = "time";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TNAME + " TEXT,"
                +NAME + " TEXT,"
                +NIC + " TEXT,"
                +DATE+ " TEXT,"
                +TIME+" TEXT" +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;

        db.execSQL(DROP_TABLE_QUERY);

        onCreate(db);
    }


    public void addBooking(Booking tbookings){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TNAME,tbookings.getTname());
        contentValues.put(NAME,tbookings.getName());
        contentValues.put(NIC,tbookings.getNic());
        contentValues.put(DATE,tbookings.getDate());
        contentValues.put(TIME,tbookings.getTime());


        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        sqLiteDatabase.close();
    }

    public List<Booking> getAllBookings(){

        List<Booking> bookings = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {

                Booking tbookings = new Booking();

                tbookings.setId(cursor.getInt(0));
                tbookings.setTname(cursor.getString(1));
                tbookings.setName(cursor.getString(2));
                tbookings.setNic(cursor.getString(3));
                tbookings.setDate(cursor.getString(4));
                tbookings.setTime(cursor.getString(5));


                bookings.add(tbookings);
            }while (cursor.moveToNext());
        }
        return bookings;
    }


    public void deleteBooking(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }


    public Booking getSingleBooking(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,TNAME,NAME,NIC,DATE,TIME},
                ID + "= ?",new String[]{String.valueOf(id)}
                ,null,null,null);

        Booking tbookings;
        if(cursor != null){
            cursor.moveToFirst();
            tbookings = new Booking(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return tbookings;
        }
        return null;
    }


    public int updateSingleBooking(Booking tbooking){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TNAME,tbooking.getTname());
        contentValues.put(NAME,tbooking.getName());
        contentValues.put(NIC,tbooking.getNic());
        contentValues.put(DATE,tbooking.getDate());
        contentValues.put(TIME,tbooking.getTime());

        int status = db.update(TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(tbooking.getId())});

        db.close();
        return status;
    }

}

