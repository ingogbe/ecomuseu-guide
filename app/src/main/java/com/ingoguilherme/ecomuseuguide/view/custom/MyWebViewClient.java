package com.ingoguilherme.ecomuseuguide.view.custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.fragments.ExpositionListFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.MapFragment;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 03-Jun-16.
 */
public class MyWebViewClient extends WebViewClient{

    private ArrayList<Room> rooms;
    private WebView map;
    private FragmentActivity activity;

    public MyWebViewClient(ArrayList<Room> rooms, WebView map, FragmentActivity activity){
        super();
        this.rooms = rooms;
        this.map = map;
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String path = "file:///android_res/raw/";

        for(Room r :rooms) {

            if (url.equals(path + r.getMapIdentification())) {
                MapFragment.actualRoom = r;

                map.loadUrl("javascript:changeColor('" + MapFragment.actualRoom.getMapIdentification() + "','#ff7e7e')");

                FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
                Fragment f = ExpositionListFragment.newInstance(r.getId());
                MainActivity.addLastOpenedFragment(f);
                ft.replace(R.id.your_placeholder, f);
                ft.commit();

                break;
            }
        }

        return true;
    }

    public void onPageFinished(WebView view, String url) {

        for(Room r: rooms){
            map.loadUrl("javascript:loadTextByID('" + r.getMapIdentification() + "','" + r.getName() + "')");
        }

        map.loadUrl("javascript:changeColor('" + MapFragment.actualRoom.getMapIdentification() + "','#ff7e7e')");
    }

}
