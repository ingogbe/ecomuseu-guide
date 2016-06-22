package com.ingoguilherme.ecomuseuguide.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.utils.Thumbnail;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.fragments.ExpositionListFragment;
import com.ingoguilherme.ecomuseuguide.view.fragments.MapFragment;

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
	public int getViewTypeCount() {
		return 1;
	}

	static class ViewHolder {
		private ImageView imageCover;
		private TextView textViewRoomName;
		private TextView textViewRoomSummary;
		private LinearLayout itemRoomListLayout;
	}

	@Override
    public View getView(int position, View view, ViewGroup parent) {
    	final Room room = rooms.get(position);

		ViewHolder holder;

		if (view == null) {
			view = inflater.inflate(R.layout.item_list_room, null);
			holder = new ViewHolder();
			holder.imageCover = (ImageView) view.findViewById(R.id.imageCover);
			holder.textViewRoomName = (TextView) view.findViewById(R.id.text_view_room_name);
			holder.textViewRoomSummary = (TextView)view.findViewById(R.id.text_view_room_summary);
			holder.itemRoomListLayout = (LinearLayout) view.findViewById(R.id.item_list_room_layout);
			view.setTag(holder);
		}
		else{
			holder = (ViewHolder) view.getTag();
		}

		if(room.getId() != 0){
			holder.imageCover.setImageBitmap(Thumbnail.generateThumbnail(view, room.getCoverImageSrc(), 200));

			if(room.getCoverImageSrc().isEmpty()){
				holder.imageCover.setVisibility(View.GONE);
				holder.itemRoomListLayout.setMinimumHeight(200);
			}
			else {
				holder.imageCover.setVisibility(View.VISIBLE);
			}

			holder.textViewRoomName.setText(room.getName());
			holder.textViewRoomSummary.setText(room.getDescription());

			holder.itemRoomListLayout.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					roomClick(room);
				}
			});
		}
		else{
			holder.imageCover.setVisibility(View.GONE);
			holder.textViewRoomName.setText("");
			holder.textViewRoomSummary.setText("");
			holder.itemRoomListLayout.setMinimumHeight(170);
		}

        return view;
    }
    
    public void roomClick(Room r){
		MapFragment.currentRoom = r;
		Fragment f = ExpositionListFragment.newInstance(r);
		MainActivity.addLastOpenedFragment(f);
		ft.replace(R.id.your_placeholder, f);
		ft.commit();
    }
}
