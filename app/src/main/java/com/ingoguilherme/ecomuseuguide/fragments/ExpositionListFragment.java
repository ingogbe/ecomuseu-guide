package com.ingoguilherme.ecomuseuguide.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.adapter.ExpositionListAdapter;
import com.ingoguilherme.ecomuseuguide.bo.Exposition;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class ExpositionListFragment extends Fragment {
    private static final String ARG_PARAM1 = "idRoom";

    private int idRoom;

    ArrayList<Exposition> expositions;
    ListView listView;
    View rootView;

    private OnFragmentInteractionListener mListener;

    public ExpositionListFragment() {
        // Required empty public constructor
    }


    public static ExpositionListFragment newInstance(int idRoom) {
        ExpositionListFragment fragment = new ExpositionListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, idRoom);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            this.idRoom = getArguments().getInt(ARG_PARAM1);
            //TODO: Pegar expositions da Room no BD
            //expositions
        }
        else{
            expositions = new ArrayList<Exposition>();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_exposition_list, container, false);

        listView = (ListView) rootView.findViewById(R.id.listViewExpositions);

        ExpositionListAdapter expositionsAdapter = new ExpositionListAdapter(rootView.getContext(), R.layout.item_list_exposition, expositions, getActivity().getSupportFragmentManager().beginTransaction());
        listView.setAdapter(expositionsAdapter);

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
