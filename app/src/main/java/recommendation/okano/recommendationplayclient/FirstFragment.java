package recommendation.okano.recommendationplayclient;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by okano on 16/02/23.
 */
public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private MyDBHelper myDBHelper ;
    private SQLiteDatabase db;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //page = getArguments().getInt("someInt", 0);
        //title = getArguments().getString("someTitle");
        myDBHelper = (MyDBHelper) getArguments().getSerializable("dbHelper");
        db = myDBHelper.getWritableDatabase();
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment0, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.play_name);
        tvLabel.setText(" -- ");

        // ボタンクリック　→　DBに保存
        Button saveButton = (Button) view.findViewById(R.id.save_memo);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("date","test");
                values.put("playName","test");
                values.put("num",2);
                values.put("memo","test");
                db.insert("playDB", null, values);
            }
        });
        return view;
    }
}

