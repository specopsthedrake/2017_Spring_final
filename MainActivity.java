package com.example.djohnson7823.a2017_spring_final;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private int _ID;
    private boolean Bool;
    /** Adapter for the ListView */
    finalCursorAdaptor mCursorAdapter;

    /** Identifier for the pet data loader */
    private static final int finalLoader = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup FAB to open EditorActivity

        // Find the ListView which will be populated with the pet data
        ListView finalListView = (ListView) findViewById(R.id.list);

        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = findViewById(R.id.list);
        finalListView.setEmptyView(emptyView);

        // Setup an Adapter to create a list item for each row of pet data in the Cursor.
        // There is no pet data yet (until the loader finishes) so pass in null for the Cursor.
        mCursorAdapter = new finalCursorAdaptor(this, null);
        finalListView.setAdapter(mCursorAdapter);

        // Setup the item click listener
//        finalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                // Create new intent to go to {@link EditorActivity}
//                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
//
//                // Form the content URI that represents the specific pet that was clicked on,
//                // by appending the "id" (passed as input to this method) onto the
//                // {@link PetEntry#CONTENT_URI}.
//                // For example, the URI would be "content://com.example.android.pets/pets/2"
//                // if the pet with ID 2 was clicked on.
//                Uri currentPetUri = ContentUris.withAppendedId(final_contract.FinalEntry.CONTENT_URI, id);
//
//                // Set the URI on the data field of the intent
//                intent.setData(currentPetUri);
//
//                // Launch the {@link EditorActivity} to display the data for the current pet.
//                startActivity(intent);
//            }
//        });

//        // Kick off the loader
//        getLoaderManager().initLoader(finalLoader, null, this);
    }
    public void boolean_true (View v){
        _ID++;
        insertRecord(true);

    }
    public void boolean_false (View v){
        _ID++;
        insertRecord(false);

    }









    public void query (View v){

    }
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                final_contract.FinalEntry._ID,
                final_contract.FinalEntry.Bool};

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                final_contract.FinalEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update {@link PetCursorAdapter} with this new cursor containing updated pet data
        mCursorAdapter.swapCursor(data);
    }

    //@Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        mCursorAdapter.swapCursor(null);
    }
    /**
     * Helper method to insert hardcoded pet data into the database. For debugging purposes only.
     */
    private void insertRecord(Boolean boolHere) {
        int b;
        if (boolHere)
            b = 1;
        else
            b = 0;
        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(final_contract.FinalEntry._ID, _ID);
        values.put(final_contract.FinalEntry.Bool, b);

        // Insert a new row for Toto into the provider using the ContentResolver.
        // Use the {@link PetEntry#CONTENT_URI} to indicate that we want to insert
        // into the pets database table.
        // Receive the new content URI that will allow us to access Toto's data in the future.
        Uri newUri = getContentResolver().insert(final_contract.FinalEntry.CONTENT_URI, values);
    }

    //@Override



}
