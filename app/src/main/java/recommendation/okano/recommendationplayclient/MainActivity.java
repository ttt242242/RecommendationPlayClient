package recommendation.okano.recommendationplayclient;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentPagerAdapter adapterViewPager;
    private MyDBHelper myDBHelper ;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHelper = new MyDBHelper(this);
        db = myDBHelper.getWritableDatabase();

        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(),myDBHelper);
        vpPager.setAdapter(adapterViewPager);
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;
        private MyDBHelper myDBHelper;
        public MyPagerAdapter(FragmentManager fragmentManager,MyDBHelper myDBHelper) {
            super(fragmentManager);
            this.myDBHelper = myDBHelper;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                   Bundle bundle = new Bundle() ;
                   bundle.putSerializable("dbHelper",myDBHelper);
                    //Fragment memoFrag = FirstFragment.newInstance(0, "Page # 1");
                    Fragment memoFrag = new FirstFragment();
                    memoFrag.setArguments(bundle) ;
                   return memoFrag;
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FirstFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return FirstFragment.newInstance(2, "Page # 3");
//                    return null;
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

}
