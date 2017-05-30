package com.example.djohnson7823.a2017_spring_final;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by djohnson7823 on 5/22/2017.
 */

// make mDbHelper java class and FinalDbHelper
public class final_provider extends ContentProvider {

    @Override
    public int delete(Uri uri, String daString, String[] daStrings)
    {
        return 0;
    }
    private static final int Bool = 100;
    private static final int _ID = 101;


    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(final_contract.CONTENT_AUTHORITY, final_contract.PATH_FINAL,Bool);
        sUriMatcher.addURI(final_contract.CONTENT_AUTHORITY, final_contract.PATH_FINAL,_ID);
    }
    //use this to make mDbHelper java class and FinalDbHelper
    private finalDbHelper mDbHelper;


    //unsure on need for onCreate boolean with returning true
    public boolean onCreate() {

        mDbHelper = new finalDbHelper(getContext());
        return true;
    }

    //unsure on what goes here
    //explain if this is the conversion of sql to the java to the XML
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder)
    {
        //unsure
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        //explain this
        Cursor cursor;

        //udaacity suggests


//            // Figure out if the URI matcher can match the URI to a specific code
            int match = sUriMatcher.match(uri);
            switch (match) {
                case Bool:
                    // For the PETS code, query the pets table directly with the given
                    // projection, selection, selection arguments, and sort order. The cursor
                    // could contain multiple rows of the pets table.
                    cursor = database.query(final_contract.FinalEntry.TABLE_NAME, projection, selection, selectionArgs,
                            null, null, sortOrder);

                    break;
                case _ID:
                    // For the PET_ID code, extract out the ID from the URI.
                    // For an example URI such as "content://com.example.android.pets/pets/3",
                    // the selection will be "_id=?" and the selection argument will be a
                    // String array containing the actual ID of 3 in this case.
                    //
                    // For every "?" in the selection, we need to have an element in the selection
                    // arguments that will fill in the "?". Since we have 1 question mark in the
                    // selection, we have 1 String in the selection arguments' String array.
                    selection = final_contract.FinalEntry._ID + "=?";
                    selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                    // This will perform a query on the pets table where the _id equals 3 to return a
                    // Cursor containing that row of the table.
                    cursor = database.query(final_contract.FinalEntry.TABLE_NAME, projection, selection, selectionArgs,
                            null, null, sortOrder);
                    break;
                default:

                    throw new IllegalArgumentException("Cannot query unknown URI " + uri);
            }

            // Set notification URI on the Cursor,
            // so we know what content URI the Cursor was created for.
            // If the data at this URI changes, then we know we need to update the Cursor.
            cursor.setNotificationUri(getContext().getContentResolver(), uri);

            // Return the cursor
            return cursor;
        }

    //more udacity suggestions I have questions about




//        // * more udacity suggestions
//    private Uri insertPet(Uri uri, ContentValues values) {
//        // Check that the name is not null
////        String name = values.getAsString(PetEntry.COLUMN_PET_NAME);
////        if (name == null) {
////            throw new IllegalArgumentException("Pet requires a name");
////        }
//
//
//        Integer _ID = values.getAsInteger(final_contract.FinalEntry._ID);
//        //on click in main activity
////        if (gender == null || !PetEntry.isValidGender(gender))
////        {throw new IllegalArgumentException("Pet requires valid gender");}
//
//
//
//
//        Boolean Bool = values.getAsBoolean(final_contract.FinalEntry.Bool);
//        //onclick in main acitivity for true or false
//       // if (weight != null && weight < 0)
//        //{throw new IllegalArgumentException("Pet requires valid weight");}
//
//
//
//
//    }







    SQLiteDatabase database = mDbHelper.getWritableDatabase();
    //unsure if other stuff on udacity is needed to get an auto enteries

    //create
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case _ID:
                return insert(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }

    //update
    public int update(Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case Bool:
                return update(uri, contentValues, selection, selectionArgs);
            case _ID:
                // For the PET_ID code, extract out the ID from the URI,
                // so we know which row to update. Selection will be "_id=?" and selection
                // arguments will be a String array containing the actual ID.
                selection = final_contract.FinalEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return update(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }

    @Override
    //is used to check if correct
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case Bool:
                return final_contract.FinalEntry.CONTENT_LIST_TYPE;
            case _ID:
                return final_contract.FinalEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }
}
