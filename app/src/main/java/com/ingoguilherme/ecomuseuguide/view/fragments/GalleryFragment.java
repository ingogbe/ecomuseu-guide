package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.view.adapter.ImageAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GalleryFragment.OnGalleryFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    private static final String ARG_PARAM1 = "image_sources";
    private static final String ARG_PARAM2 = "clicked_image";

    private ArrayList<String> imageSources;
    private int clickedImage;

    View rootView;

    private OnGalleryFragmentInteractionListener mListener;

    public GalleryFragment() {
        // Required empty public constructor
    }

    public static GalleryFragment newInstance(ArrayList<String> imageSources, int clickedImage) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, imageSources);
        args.putInt(ARG_PARAM2, clickedImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageSources = getArguments().getStringArrayList(ARG_PARAM1);
            clickedImage = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        //TODO: Implementar pinch zoom
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(rootView.getContext(), imageSources);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(clickedImage);

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onGalleryFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnGalleryFragmentInteractionListener) {
            mListener = (OnGalleryFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnGalleryFragmentInteractionListener {
        void onGalleryFragmentInteraction(Uri uri);
    }
}
