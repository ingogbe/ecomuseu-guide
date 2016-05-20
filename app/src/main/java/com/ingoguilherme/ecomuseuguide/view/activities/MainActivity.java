package com.ingoguilherme.ecomuseuguide.view.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.dao.controller.LanguageDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.fragments.AchievementsFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.ExpositionFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.ExpositionListFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.MapFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.OptionFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.QRCodeFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.RoomListFragment;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ExpositionFragment.OnExpositionFragmentInteractionListener,
        QRCodeFragment.OnQRCodeFragmentInteractionListener, MapFragment.OnMapFragmentInteractionListener,
        AchievementsFragment.OnAchievementsFragmentInteractionListener, RoomListFragment.OnRoomListFragmentInteractionListener,
        OptionFragment.OnOptionFragmentInteractionListener, ExpositionListFragment.OnExpositionListFragmentInteractionListener{

    public static ArrayList<Fragment> lastOpenedFragmentList = new ArrayList<Fragment>();
    public static Language selectedLanguage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this.deleteDatabase(DatabaseHandler.db_name);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Fragment f = QRCodeFragment.newInstance();
                addLastOpenedFragment(f);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.your_placeholder, f);
                ft.commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(lastOpenedFragmentList.size() == 0) {
            Fragment f = RoomListFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
        }
        else{
            if(lastOpenedFragmentList.size() == 1) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.your_placeholder, lastOpenedFragmentList.get(lastOpenedFragmentList.size() - 1));
                ft.commit();
            }
        }

        if(selectedLanguage == null){
            DatabaseHandler dh = new DatabaseHandler(this);
            LanguageDAO languageDAO = new LanguageDAO(dh);
            selectedLanguage = languageDAO.queryCurrentSysLanguage();
        }

    }

    @Override
    protected void onResume() {
        if(QRCodeFragment.isBackPressed) {
            QRCodeFragment.isBackPressed = false;
            if(lastOpenedFragmentList.size() > 1) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.your_placeholder, getLastOpenedFragment());
                ft.commit();
            }
            else{
                if(lastOpenedFragmentList.size() == 1) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, lastOpenedFragmentList.get(lastOpenedFragmentList.size() - 1));
                    ft.commit();
                }
            }
        }
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(lastOpenedFragmentList.size() > 1) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.your_placeholder, getLastOpenedFragment());
                ft.commit();
            }
            else {
                super.onBackPressed();
            }
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
            Fragment f = OptionFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_qrcode) {
            Fragment f = QRCodeFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
        } else if (id == R.id.nav_map) {
            Fragment f = MapFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
        } else if (id == R.id.nav_rooms) {
            Fragment f = RoomListFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
        } else if (id == R.id.nav_achievements) {
            Fragment f = AchievementsFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
        } else if (id == R.id.nav_options) {
            Fragment f = OptionFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
        } else if (id == R.id.nav_share) {
            //TODO: Share options
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void addLastOpenedFragment(Fragment f){
        lastOpenedFragmentList.add(f);
    }

    public static Fragment getLastOpenedFragment(){
        lastOpenedFragmentList.remove(lastOpenedFragmentList.size()-1);
        Fragment f = lastOpenedFragmentList.get(lastOpenedFragmentList.size()-1);
        return f;
    }

    @Override
    public void onExpositionFragmentInteraction(Uri uri) {

    }

    @Override
    public void onQRCodeFragmentInteraction(Uri uri) {

    }

    @Override
    public void onMapFragmentInteraction(Uri uri) {

    }

    @Override
    public void onAchievementsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onRoomListFragmentInteraction(Uri uri) {

    }

    @Override
    public void onOptionFragmentInteraction(Uri uri) {

    }

    @Override
    public void onExpositionListFragmentInteraction(Uri uri) {

    }
}
