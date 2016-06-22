package com.ingoguilherme.ecomuseuguide.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
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
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.dao.controller.AchievementDAO;
import com.ingoguilherme.ecomuseuguide.dao.controller.LanguageDAO;
import com.ingoguilherme.ecomuseuguide.dao.controller.RoomDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.fragments.AboutFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.AchievementsFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.ExpositionFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.ExpositionListFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.GalleryFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.MapFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.OptionFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.QRCodeFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.RoomListFragment;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ExpositionFragment.OnExpositionFragmentInteractionListener,
        QRCodeFragment.OnQRCodeFragmentInteractionListener, MapFragment.OnMapFragmentInteractionListener,
        AchievementsFragment.OnAchievementsFragmentInteractionListener, RoomListFragment.OnRoomListFragmentInteractionListener,
        OptionFragment.OnOptionFragmentInteractionListener, ExpositionListFragment.OnExpositionListFragmentInteractionListener,
        GalleryFragment.OnGalleryFragmentInteractionListener, AboutFragment.OnAboutFragmentInteractionListener{

    public static ArrayList<Fragment> lastOpenedFragmentList = new ArrayList<Fragment>();
    public static Language selectedLanguage = null;
    public static NavigationView navigationView;
    public static FloatingActionButton fabMap;
    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this.deleteDatabase(DatabaseHandler.db_name);

        activity = this;

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fabMap = (FloatingActionButton) findViewById(R.id.fab_map);

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

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        DatabaseHandler dh = new DatabaseHandler(this);

        if(selectedLanguage == null){
            LanguageDAO languageDAO = new LanguageDAO(dh);
            selectedLanguage = languageDAO.queryCurrentSysLanguage();
        }

        RoomDAO roomDAO = new RoomDAO(dh);
        MapFragment.currentRoom = roomDAO.queryNonClickableRoomsByLanguageAndMapIdentification(selectedLanguage,"flecha");

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

        dh.close();

    }

    @Override
    protected void onResume() {
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(selectedLanguage.getLanguage(),selectedLanguage.getCountryCode());
        res.updateConfiguration(conf, dm);

        refreshDrawerTexts();

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

    public static void refreshDrawerTexts(){

        activity.setTitle(R.string.app_name);

        MainActivity.navigationView.getMenu().getItem(0).setTitle(R.string.nav_rooms);
        MainActivity.navigationView.getMenu().getItem(1).setTitle(R.string.nav_qrcode);
        MainActivity.navigationView.getMenu().getItem(2).setTitle(R.string.nav_map);
        MainActivity.navigationView.getMenu().getItem(3).setTitle(R.string.nav_achievements);
        MainActivity.navigationView.getMenu().getItem(4).setTitle(R.string.nav_options);
        MainActivity.navigationView.getMenu().getItem(5).setTitle(R.string.nav_about);
        MainActivity.navigationView.getMenu().getItem(6).setTitle(R.string.nav_title_social);
        MainActivity.navigationView.getMenu().getItem(6).getSubMenu().getItem(0).setTitle(R.string.nav_share);

        ((TextView)MainActivity.navigationView.getHeaderView(0).findViewById(R.id.tv_app_title)).setText(R.string.app_name);
        ((TextView)MainActivity.navigationView.getHeaderView(0).findViewById(R.id.tv_app_description)).setText(R.string.app_description);
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
        // Handle action bar lazylist_item clicks here. The action bar will
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
        // Handle navigation view lazylist_item clicks here.
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
        } else if (id == R.id.nav_about) {
            Fragment f = AboutFragment.newInstance();
            addLastOpenedFragment(f);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, f);
            ft.commit();
        } else if (id == R.id.nav_share) {
            DatabaseHandler dh = new DatabaseHandler(this);
            AchievementDAO achievementDAO = new AchievementDAO(dh);
            int completed = achievementDAO.queryAllCompletedCountAchievement();
            int all = achievementDAO.queryAllCountAchievement();
            int points = achievementDAO.queryCurrentAchievementPoints();
            int totalPoints = achievementDAO.queryTotalPointsAchievement();

            String appName = getResources().getString(R.string.app_name);
            int porcentagem = (completed * 100) / all;

            String langCode = selectedLanguage.getLanguage() + "-r" + selectedLanguage.getCountryCode();

            String texto = "";

            if(langCode.equals("pt-rBR"))
                texto = "Eu visitei o Ecomuseu (Foz do Iguaçu - PR) e consegui " + points + "/" + totalPoints + " pontos, totalizando " +
                        porcentagem + "% das conquistas no aplicativo " + appName + " para Android. Venha visitar-lo também! " +
                        "https://goo.gl/mJ5mI9";
            else if(langCode.equals("en-rUS"))
                texto = "I visited the Ecomuseu (Foz do Iguassu - PR) and got " + points + "/" + totalPoints + " points, totaling " +
                        porcentagem + "% of the achievements in " + appName + " app for Android. Come and visit you too! " +
                        "https://goo.gl/mJ5mI9";
            else
                texto = "I visited the Ecomuseu (Foz do Iguassu - PR) and got " + points + "/" + totalPoints + " points, totaling " +
                        porcentagem + "% of the achievements in " + appName + " app for Android. Come and visit you too! " +
                        "https://goo.gl/mJ5mI9";

            dh.close();

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, texto);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void addLastOpenedFragment(Fragment f){
        boolean insere = true;

        if(lastOpenedFragmentList.size() >= 1) {
            Fragment f1 = lastOpenedFragmentList.get(lastOpenedFragmentList.size() - 1);
            if(f1.getClass().equals(f.getClass()))
                insere = false;
        }

        if(insere) {
            lastOpenedFragmentList.add(f);

            checkMenuItem(f);

        }
    }

    public static void checkMenuItem(Fragment f){
        if(f instanceof AchievementsFragment)
            navigationView.getMenu().getItem(3).setChecked(true);
        else if(f instanceof ExpositionFragment)
            navigationView.getMenu().getItem(0).setChecked(true);
        else if(f instanceof ExpositionListFragment)
            navigationView.getMenu().getItem(0).setChecked(true);
        else if(f instanceof GalleryFragment)
            navigationView.getMenu().getItem(0).setChecked(true);
        else if(f instanceof MapFragment)
            navigationView.getMenu().getItem(2).setChecked(true);
        else if(f instanceof OptionFragment)
            navigationView.getMenu().getItem(4).setChecked(true);
        else if(f instanceof QRCodeFragment)
            navigationView.getMenu().getItem(1).setChecked(true);
        else if(f instanceof RoomListFragment)
            navigationView.getMenu().getItem(0).setChecked(true);
        else if(f instanceof AboutFragment)
            navigationView.getMenu().getItem(5).setChecked(true);
    }

    public static Fragment getLastOpenedFragment(){
        lastOpenedFragmentList.remove(lastOpenedFragmentList.size()-1);
        Fragment f = lastOpenedFragmentList.get(lastOpenedFragmentList.size()-1);
        checkMenuItem(f);
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

    @Override
    public void onGalleryFragmentInteraction(Uri uri) {

    }

    @Override
    public void onAboutFragmentInteraction(Uri uri) {

    }
}
