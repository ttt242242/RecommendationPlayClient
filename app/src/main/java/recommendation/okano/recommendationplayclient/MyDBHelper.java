package recommendation.okano.recommendationplayclient;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * Created by okano on 16/02/28.
 */
public class MyDBHelper extends SQLiteOpenHelper implements Serializable {
    public MyDBHelper(Context context) {
        //DBを作成
        super(context, "playDB", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS playDB (_id INTEGER PRIMARY KEY AUTOINCREMENT,date TEXT,playName TEXT,num INTEGER,memo TEXT);");
        //db.execSQL("CREATE TABLE IF NOT EXISTS titleDB (_id INTEGER PRIMARY KEY AUTOINCREMENT,date TEXT,title TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
