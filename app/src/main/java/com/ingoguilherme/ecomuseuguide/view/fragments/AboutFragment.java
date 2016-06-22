package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ingoguilherme.ecomuseuguide.R;


public class AboutFragment extends Fragment implements OnMapReadyCallback{

    private OnAboutFragmentInteractionListener mListener;
    ScrollView sv_root;

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        sv_root = (ScrollView) view.findViewById(R.id.about_scrollView);
        sv_root.requestDisallowInterceptTouchEvent(true);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.about_maps);
        mapFragment.getMapAsync(this);


        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onAboutFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAboutFragmentInteractionListener) {
            mListener = (OnAboutFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap mMap) {
        LatLng ecomuseu = new LatLng(-25.4549052,-54.5852052);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ecomuseu, 17));

        Marker museum = mMap.addMarker(new MarkerOptions()
                .position(ecomuseu)
                .title("Ecomuseu"));
    }

    public interface OnAboutFragmentInteractionListener {
        void onAboutFragmentInteraction(Uri uri);
    }
}
