package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.dao.controller.ExpositionDAO;
import com.ingoguilherme.ecomuseuguide.dao.controller.LanguageDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.adapter.ExpositionListAdapter;

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

    private OnExpositionListFragmentInteractionListener mListener;

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
            Room r = new Room();
            r.setId(idRoom);

            DatabaseHandler dh = new DatabaseHandler(getContext());
            LanguageDAO languageDAO = new LanguageDAO(dh);
            Language lang = languageDAO.queryCurrentSysLanguage();

            ExpositionDAO expositionDAO = new ExpositionDAO(dh);
            expositions = expositionDAO.queryExpositionByRoomAndLanguage(r, lang);
            dh.close();

        }
        else{
            expositions = new ArrayList<Exposition>();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_exposition_list, container, false);

        listView = (ListView) rootView.findViewById(R.id.listViewExpositions);

        View empty = rootView.findViewById(R.id.empty);
        listView.setEmptyView(empty);

        ExpositionListAdapter expositionsAdapter = new ExpositionListAdapter(rootView.getContext(), R.layout.item_list_exposition, expositions, getActivity().getSupportFragmentManager().beginTransaction());
        listView.setAdapter(expositionsAdapter);

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onExpositionListFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnExpositionListFragmentInteractionListener) {
            mListener = (OnExpositionListFragmentInteractionListener) context;
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

    public interface OnExpositionListFragmentInteractionListener {
        void onExpositionListFragmentInteraction(Uri uri);
    }
}
