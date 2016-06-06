package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class MapFragment extends Fragment {

    private OnMapFragmentInteractionListener mListener;
    private View rootView;
    public static Room actualRoom;
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

        final int deltaX = (int) (labels.getWidth() / 2);
        final int deltaY = (int) -1 * (labels.getHeight() / 2);

        labels.setScaleX(0);
        labels.setScaleY(0);
        labels.setTranslationX(0);
        labels.setTranslationY(0);

        fab = MainActivity.fabMap;
        fab.setVisibility(View.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Change visibility labels
                if(labels.getVisibility() == View.INVISIBLE && animationEnded){
                    animationEnded = false;
                    labels.setVisibility(View.VISIBLE);

                    labels.animate().scaleY(1).scaleX(1).translationX(deltaX).translationY(deltaY).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            animationEnded = true;
                        }
                    });;

                }
                else if(labels.getVisibility() == View.VISIBLE && animationEnded){
                    animationEnded = false;
                    labels.animate().scaleY(0).scaleX(0).translationX(0).translationY(0).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            labels.setVisibility(View.INVISIBLE);
                            animationEnded = true;
                        }
                    });
                }
            }
        });

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
