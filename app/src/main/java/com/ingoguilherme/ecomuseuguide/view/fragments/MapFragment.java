package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.dao.controller.RoomDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.custom.MyWebViewClient;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class MapFragment extends Fragment {

    private OnMapFragmentInteractionListener mListener;
    private View rootView;
    public static Room currentRoom;
    FloatingActionButton fab;

    private WebView map;
    private ArrayList<Room> rooms;

    public MapFragment() {
        // Required empty public constructor
    }


    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    boolean animationEnded = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_map, container, false);

        map = (WebView) rootView.findViewById(R.id.wb_map);
        map.loadUrl("file:///android_res/raw/map.html");

        DatabaseHandler dh = new DatabaseHandler(rootView.getContext());
        RoomDAO roomDAO = new RoomDAO(dh);
        rooms = roomDAO.queryRoomsByLanguage(MainActivity.selectedLanguage);
        rooms.addAll(roomDAO.queryNonClickableRoomsByLanguage(MainActivity.selectedLanguage));

        WebSettings webSettings = map.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        MyWebViewClient wvc = new MyWebViewClient(rooms, map, getActivity());

        map.setWebViewClient(wvc);


        final FrameLayout labels = (FrameLayout) rootView.findViewById(R.id.labels);

        fab = MainActivity.fabMap;
        fab.setVisibility(View.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Change visibility labels
                if(labels.getVisibility() == View.INVISIBLE && animationEnded){
                    animationEnded = false;
                    labels.setVisibility(View.VISIBLE);

                    Animation open = AnimationUtils.loadAnimation(getContext(), R.anim.map_labels_animation_open);

                    open.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            animationEnded = true;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    labels.startAnimation(open);

                }
                else if(labels.getVisibility() == View.VISIBLE && animationEnded){
                    animationEnded = false;
                    labels.setVisibility(View.INVISIBLE);

                    Animation close = AnimationUtils.loadAnimation(getContext(), R.anim.map_labels_animation_close);

                    close.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            animationEnded = true;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    labels.startAnimation(close);
                }
            }
        });

        dh.close();

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMapFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(MainActivity.selectedLanguage.getLanguage(), MainActivity.selectedLanguage.getCountryCode());
        res.updateConfiguration(conf, dm);
        if (context instanceof OnMapFragmentInteractionListener) {
            mListener = (OnMapFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        fab.setVisibility(View.INVISIBLE);
    }


    public interface OnMapFragmentInteractionListener {
        void onMapFragmentInteraction(Uri uri);
    }
}
