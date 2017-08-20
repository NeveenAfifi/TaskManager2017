package com.afifi.neveen.taskmanager2017;

import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.afifi.neveen.taskmanager2017.data.DBUtils;
import com.afifi.neveen.taskmanager2017.data.MyTasks;
import com.afifi.neveen.taskmanager2017.main_fragments.MyGroupsFragment;
import com.afifi.neveen.taskmanager2017.main_fragments.MyTasksFragment;
import com.afifi.neveen.taskmanager2017.main_fragments.TitleAble;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private MyPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Fragment[]fragments;//tkhona shel array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creat data source
       fragments = new  Fragment[2];
        fragments[0]=new MyTasksFragment();
        fragments[1]=new MyGroupsFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final MyTasks myTasks=new MyTasks();
                myTasks.setCreateAt((System.currentTimeMillis()));
                myTasks.setText("todo"+System.currentTimeMillis());
                myTasks.setCompleted(false);
                myTasks.setAdress("HAIFA");
                myTasks.setgKey("group");
                myTasks.setuKey(DBUtils.auth.getCurrentUser().getEmail());
                myTasks.settKey(DBUtils.myTaskRef.push().getKey());//push=add
                DBUtils.myTaskRef.child(myTasks.getgKey()).setValue(myTasks).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, myTasks.getText()+"Added", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,myTasks.getText()+ "Faild", Toast.LENGTH_LONG ).show();
                        }
                    }
                });

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.mnitemSignOut) {
            DBUtils.auth.signOut();
            finish();//to close this activity
            //another option:to return to logIn activity
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }//constructor

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return fragments[position];
        }

        @Override
        public int getCount() {
            // Show 3 total pages.

            return fragments.length;
        }

        //TODO change it to be dynamic

        @Override
        public CharSequence getPageTitle(int position)
        {
            return ((TitleAble)fragments[position]).getTilte();
//            switch (position) {
//                case 0:
//                    return "SECTION 1";
//                case 1:
//                    return "SECTION 2";
//                case 2:
//                    return "SECTION 3";
//            }
//            return null;
        }
    }
}
