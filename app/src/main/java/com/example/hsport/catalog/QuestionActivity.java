package com.example.hsport.catalog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.view.LayoutInflater;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 36;
    private static final String FRAG_NUMBER = "intFragmentNumber";
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private Boolean firstRun = false;

    public static final String wheelPrefs = "MyPrefs";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


//        Viewpager stuff here
        mPager = (ViewPager) findViewById(R.id.questionPager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

//        Data storage stuff
        sharedpreferences = getSharedPreferences(wheelPrefs, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putInt(FRAG_NUMBER, 0);
        editor.commit();

//        Code to reference the other activity with the percent bar
        LayoutInflater inflater = getLayoutInflater();
        LinearLayout tmpView = (LinearLayout) inflater.inflate(R.layout.frag_question, null);

//        Hobo if to check the initial screen value, onPageSelected doesn't proc first run through
        if (firstRun == false) {
            firstRun = true;
            Log.d(QuestionActivity.class.getSimpleName(), "QuestionActivityCheat " + Integer.toString(0));
            for (int i = 0; i < 36; i++) {
                editor.putInt("strWedge" + Integer.toString(i), 0);
            }
            if (sharedpreferences.contains("strWedge0")) {
                editor.putInt("strWedge0", 0);
            } else {
                editor.putInt("strWedge0", 0);
            }
            editor.commit();
        }
        ;

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            LayoutInflater inflater = getLayoutInflater();
            View tmpView = inflater.inflate(R.layout.frag_question, null);

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//                editor.putInt("strWedge" + Integer.toString(position), tmpSeek.getProgress());
                editor.putInt(FRAG_NUMBER, position);
                editor.commit();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        sharedpreferences = getSharedPreferences(wheelPrefs, Context.MODE_PRIVATE);

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.actionDebugPage:
                String strPageNum = Integer.toString(sharedpreferences.getInt(FRAG_NUMBER, 0));
                Toast.makeText(this, "Number is " + sharedpreferences.getInt("strWedge" + strPageNum, 10), Toast.LENGTH_LONG).show();
                break;
            case R.id.actionDrawWheel:
                Intent intent = new Intent(this, WheelDisplay.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return QuestionSSPFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
