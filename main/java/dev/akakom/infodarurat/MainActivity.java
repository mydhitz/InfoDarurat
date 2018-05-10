package dev.akakom.infodarurat;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ContentTeleponDarurat()).commit();
        }

        initView();
        initToolbar();
        initDrawer();
        initNavigationViewListener();
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void initNavigationViewListener() {
        mNavigationView
                .setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(final MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        //Check to see which item was being clicked and perform appropriate action
                        switch (menuItem.getItemId()) {

                            //Replacing the main content with ContentFragment Which is our Inbox View;
                            case R.id.nav_emergency_call:
                                ContentTeleponDarurat emergency = new ContentTeleponDarurat();
                                android.support.v4.app.FragmentTransaction emergencyTransaction = getSupportFragmentManager().beginTransaction();
                                emergencyTransaction.replace(R.id.frame, emergency);
                                emergencyTransaction.commit();
                                return true;

                            case R.id.nav_learn:
                                ContentPertolongan learn = new ContentPertolongan();
                                android.support.v4.app.FragmentTransaction learnTransaction = getSupportFragmentManager().beginTransaction();
                                learnTransaction.replace(R.id.frame, learn);
                                learnTransaction.commit();
                                return true;

                            case R.id.nav_about_app:
                                ContentFragment aboutapp = new ContentFragment();
                                android.support.v4.app.FragmentTransaction aboutTransaction = getSupportFragmentManager().beginTransaction();
                                aboutTransaction.replace(R.id.frame, aboutapp);
                                aboutTransaction.commit();
                                return true;

                            default:
                                Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                                return true;

                        }
                    }
                });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

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
}
