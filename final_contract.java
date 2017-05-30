package com.example.djohnson7823.a2017_spring_final;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by djohnson7823 on 5/22/2017.
 */

public class final_contract {
    private final_contract() {}

    public static final String CONTENT_AUTHORITY = "com.example.djohnson7823.a2017_spring_final";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    //fix later
    public static final String PATH_FINAL = "final";

    public static final class FinalEntry implements BaseColumns
    {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_FINAL);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FINAL;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FINAL;

        public final static String TABLE_NAME = "final";

        public final static String _ID = BaseColumns._ID;

        public final static String Bool = "true/false";
    }
}
