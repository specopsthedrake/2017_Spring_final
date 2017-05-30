package com.example.djohnson7823.a2017_spring_final;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by DJohnson7823 on 5/23/2017.
 */


//class mDbHelper extends finalDbHelper{
//        public mDbHelper(Context context)
//        {super(context);}
//        }
public class finalDbHelper extends SQLiteOpenHelper{

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    private static final String DATABASE_NAME = "2017_final.db";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    //explain this please
    private static final int DATABASE_VERSION = 1;

        public finalDbHelper (Context context) {    super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onCreate(SQLiteDatabase db) {
        //what is the use of this and why does is want finalcontract rather than finalentery
        String SQL_CREATE_final_TABLE =  "CREATE TABLE " + final_contract.FinalEntry.TABLE_NAME + " ("
                + final_contract.FinalEntry._ID + " incrementing increases, "
                + final_contract.FinalEntry.Bool + " 1 or 0/ true or false, ";

        db.execSQL(SQL_CREATE_final_TABLE);
    }

    //why is this needed
    public void onUPgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
