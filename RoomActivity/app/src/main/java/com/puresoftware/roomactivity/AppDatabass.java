package com.puresoftware.roomactivity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//@Database{entities={User.class}, version= 1}
@Database(entities = {User.class},version = 1)
public abstract class AppDatabass extends RoomDatabase {

    private static AppDatabass INSTANCE = null;

    public abstract UserDao userDao();

    public static AppDatabass getInstance(Context context) {

        // Room을 사용하기 위한 객체 인스턴스
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabass.class, "room.db").build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
