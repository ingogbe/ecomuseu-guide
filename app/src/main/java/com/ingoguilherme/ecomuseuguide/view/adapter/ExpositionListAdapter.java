package com.ingoguilherme.ecomuseuguide.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.utils.Thumbnail;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.fragments.ExpositionFragment;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class ExpositionListAdapter extends ArrayAdapter<Room> {

	ArrayList<Exposition> expositions;
	Context context;
	private final LayoutInflater inflater;
	FragmentTransaction ft;
	Room room;

	public ExpositionListAdapter(Context context, int resource, ArrayList<Exposition> expositions, FragmentTransaction ft, Room room) {
		super(context, resource);
		this.context = context;
		this.ft = ft;
		this.room = room;
		inflater = LayoutInflater.from(context);
		this.expositions = expositions;
	}

	@Override
	public int getCount() {
		return expositions.size();
	}


    @Override
    public int getViewTypeCount() {
        return 1;
    }

    static class ViewHolder {
        private ImageView imageCover;
        private TextView textViewExpositionName;
        private TextView textViewExpositionSummary;
        private LinearLayout itemExpositionListLayout;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

    	final Exposition exposition = expositions.get(position);

        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.item_list_exposition, null);
            holder = new ViewHolder();
            holder.imageCover = (ImageView) view.findViewById(R.id.imageCover);
            holder.textViewExpositionName = (TextView) view.findViewById(R.id.text_view_exposition_name);
            holder.textViewExpositionSummary = (TextView) view.findViewById(R.id.text_view_exposition_summary);
            holder.itemExpositionListLayout = (LinearLayout) view.findViewById(R.id.item_list_exposition_layout);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

		if(exposition.getId() != 0) {

            holder.imageCover.setImageBitmap(Thumbnail.generateThumbnail(view, exposition.getCoverImageSrc(), 200));

            if(room.getCoverImageSrc().isEmpty()){
                holder.imageCover.setVisibility(View.GONE);
                holder.itemExpositionListLayout.setMinimumHeight(200);
            }
            else {
                holder.imageCover.setVisibility(View.VISIBLE);
            }

			holder.textViewExpositionName.setText(exposition.getName());
            holder.textViewExpositionSummary.setText(exposition.getDescription());
            holder.itemExpositionListLayout.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					expositionClick(exposition);
				}
			});
		}
		else{
            holder.imageCover.setVisibility(View.GONE);
            holder.textViewExpositionName.setText("");
            holder.textViewExpositionSummary.setText("");
            holder.itemExpositionListLayout.setMinimumHeight(170);
		}
 
        return view;
    }
    
    public void expositionClick(Exposition e){
		Fragment f = ExpositionFragment.newInstance(e, room.getId());
		MainActivity.addLastOpenedFragment(f);
		ft.replace(R.id.your_placeholder, f);
		ft.commit();
    }
}
