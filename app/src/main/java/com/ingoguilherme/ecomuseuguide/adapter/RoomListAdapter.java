package com.ingoguilherme.ecomuseuguide.adapter;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.fragments.ExpositionListFragment;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class RoomListAdapter extends ArrayAdapter<Room> {

	ArrayList<Room> rooms;
	Context context;
	private final LayoutInflater inflater;
	FragmentTransaction ft;

	public RoomListAdapter(Context context, int resource, ArrayList<Room> rooms, FragmentTransaction ft) {
		super(context, resource);
		this.context = context;
		this.ft = ft;
		inflater = LayoutInflater.from(context);
		this.rooms = rooms;
	}

	@Override
	public int getCount() {
		return rooms.size();
	}

    @Override
    public View getView(int position, View view, ViewGroup parent) {
    	final Room room = rooms.get(position);

		view = inflater.inflate(R.layout.item_list_room, null);

		ImageView imageCover = (ImageView) view.findViewById(R.id.imageCover);

		try{
			int id = context.getResources().getIdentifier(room.getCoverImageSrc(), "drawable", context.getPackageName());
			imageCover.setImageResource(id);
		}catch (Exception e) {
			imageCover.setImageResource(R.drawable.ic_no_image);
		}

        TextView textViewRoomName = (TextView) view.findViewById(R.id.text_view_room_name);
		textViewRoomName.setText(room.getName());
 
        TextView textViewRoomSummary = (TextView)view.findViewById(R.id.text_view_room_summary);
		textViewRoomSummary.setText(room.getDescription());

        RelativeLayout itemRoomListLayout = (RelativeLayout) view.findViewById(R.id.item_list_room_layout);
		itemRoomListLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				roomClick(room);
			}
		});
 
        return view;
    }
    
    public void roomClick(Room r){
		ft.replace(R.id.your_placeholder, ExpositionListFragment.newInstance(r.getId()));
		ft.commit();
    }
}
