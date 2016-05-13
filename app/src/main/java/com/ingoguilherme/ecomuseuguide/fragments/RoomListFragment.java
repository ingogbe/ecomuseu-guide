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
import com.ingoguilherme.ecomuseuguide.adapter.RoomListAdapter;
import com.ingoguilherme.ecomuseuguide.bo.Room;

import java.util.ArrayList;


/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class RoomListFragment extends Fragment {
    ArrayList<Room> rooms;
    ListView listView;
    View rootView;

    private OnRoomListFragmentInteractionListener mListener;

    public RoomListFragment() {
        // Required empty public constructor
    }


    public static RoomListFragment newInstance() {
        RoomListFragment fragment = new RoomListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: Buscar Rooms no BD

        //ArrayList de Testes
        rooms = new ArrayList<Room>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_room_list, container, false);

        listView = (ListView) rootView.findViewById(R.id.listViewRooms);

        View empty = rootView.findViewById(R.id.empty);
        listView.setEmptyView(empty);

        RoomListAdapter roomsAdapter = new RoomListAdapter(rootView.getContext(), R.layout.item_list_room, rooms, getActivity().getSupportFragmentManager().beginTransaction());
        listView.setAdapter(roomsAdapter);

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onRoomListFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRoomListFragmentInteractionListener) {
            mListener = (OnRoomListFragmentInteractionListener) context;
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

    public interface OnRoomListFragmentInteractionListener {
        void onRoomListFragmentInteraction(Uri uri);
    }
}
