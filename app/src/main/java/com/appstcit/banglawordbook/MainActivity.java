package com.appstcit.banglawordbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String[] english={"Admission","Answer","Atlas","Bell","Bench","Blackboard","Book","Chair","Chancellor","college","Demonstrator","Examination","Exercise book","Fee","Fine","Fountain pen","Globe","Gymnasium","Hall","Headmaster","Hostel","Ink","Leave","Lesson","Library","Map","Medal","Nib","Paper","Pen","Pencil","Playground","Poem","Poetry","Principal","Prize","Professor","Prose","Pupil","Question","Recess","Result","School","Slate","Student","Subject","Table","Transfer","Tution","Tutor","University","Vacation","Vice-chancellor"};
    String[] bangla={"প্রবেশাধিকার","উত্তর,জবাব","মানচিত্রাবলী","ঘণ্টাধ্বনি","কাঠের বা পাথরের তৈরি লম্বা আসন,বিচারকের আসন","বিদ্যালয়ে লিপির জন্য তক্তা","বই","কেদারা,সভাপতির পদ","আচার্য","কলেজ,মহাবিদ্যালয়","সক্রিয় অংশগ্রহণকারী,প্রদর্শনকারী","পরীক্ষা,অনুসন্ধান","অনুশীলনের বই","পারিশ্রমিক","জরিমানা","ঝর্ণা কলম","পৃথিবী","ব্যায়ামাগার","ছাত্রাবাস","বিদ্যালয়ের প্রধানশিক্ষক","ছাত্রাবাস","কালি","ত্যাগ","পাঠ","গ্রন্থাগার","মানচিত্র","পদক","কলমের নিব","কাগজ","লেখনী","পেন্সিল","খেলার মাঠ","কবিতা","কবিতা","অধ্যক্ষ","পুরস্কার","অধ্যাপক","গদ্য","চক্ষুর তারা","প্রশ্ন","ছুটি","ফল","বিদ্যালয়","সিলিট্-পাথর","শিক্ষার্থী","বিষয়","ডেস্ক,সারণী","হস্তান্তর","শিক্ষাদান","গৃহশিক্ষক","বিশ্ববিদ্যালয়","অবকাশ","উপাচার্য"};
String[] edu;
    String [] food;

    LinearLayout btn1;

    String[] viewSts= new String[english.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn1 = (LinearLayout) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("english",english);
                intent.putExtra("bangla",bangla);



                intent.putExtra("viewStd",viewSts);

                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(MainActivity.this,Favorite.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
