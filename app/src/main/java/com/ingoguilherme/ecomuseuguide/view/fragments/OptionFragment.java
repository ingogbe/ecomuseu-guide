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
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.dao.controller.LanguageDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.adapter.LanguagesAdapter;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class OptionFragment extends Fragment {

    private OnOptionFragmentInteractionListener mListener;

    View rootView;
    ListView listView;
    ArrayList<Language> languages;

    public OptionFragment() {
        // Required empty public constructor
    }

    public static OptionFragment newInstance() {
        OptionFragment fragment = new OptionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHandler dh = new DatabaseHandler(getContext());
        LanguageDAO languageDAO = new LanguageDAO(dh);
        languages = languageDAO.queryAllLanguages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_option, container, false);

        listView = (ListView) rootView.findViewById(R.id.listViewLanguages);

        View empty = rootView.findViewById(R.id.empty);
        listView.setEmptyView(empty);

        LanguagesAdapter languagesAdapter = new LanguagesAdapter(getActivity(), rootView.getContext(), R.layout.item_list_language, languages, getActivity().getSupportFragmentManager().beginTransaction());
        listView.setAdapter(languagesAdapter);

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onOptionFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOptionFragmentInteractionListener) {
            mListener = (OnOptionFragmentInteractionListener) context;
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

    public interface OnOptionFragmentInteractionListener {
        void onOptionFragmentInteraction(Uri uri);
    }
}
