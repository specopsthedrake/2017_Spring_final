package com.example.djohnson7823.a2017_spring_final;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by djohnson7823 on 5/24/2017.
 */

public class finalCursorAdaptor extends CursorAdapter {

    public finalCursorAdaptor (Context context, Cursor c) {super(context, c, 0);}

    public View newView(Context context,Cursor cursor, ViewGroup parent)
    {
        return LayoutInflater.from(context).inflate(R.layout.support_simple_spinner_dropdown_item,parent,false);
    }
    public void bindView(View view, Context context, Cursor cursor)
    {
    int boolColumnIndex = cursor.getColumnIndex(final_contract.FinalEntry.Bool);
    int _IDColumnIndex = cursor.getColumnIndex(final_contract.FinalEntry._ID);

        int _IDColumn = cursor.getInt(_IDColumnIndex);
        boolean boolColumn = cursor.getInt(boolColumnIndex)==1;


    }
}
