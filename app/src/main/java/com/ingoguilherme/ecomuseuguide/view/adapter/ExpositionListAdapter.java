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

	public ExpositionListAdapter(Context context, int resource, ArrayList<Exposition> expositions, FragmentTransaction ft) {
		super(context, resource);
		this.context = context;
		this.ft = ft;
		inflater = LayoutInflater.from(context);
		this.expositions = expositions;
	}

	@Override
	public int getCount() {
		return expositions.size();
	}

    @Override
    public View getView(int position, View view, ViewGroup parent) {

    	final Exposition exposition = expositions.get(position);

		view = inflater.inflate(R.layout.item_list_exposition, null);

		ImageView imageCover = (ImageView) view.findViewById(R.id.imageCover);
		TextView textViewExpositionName = (TextView) view.findViewById(R.id.text_view_exposition_name);
		TextView textViewExpositionSummary = (TextView) view.findViewById(R.id.text_view_exposition_summary);
		LinearLayout itemExpositionListLayout = (LinearLayout) view.findViewById(R.id.item_list_exposition_layout);

		if(exposition.getId() != 0) {
			imageCover.setImageBitmap(Thumbnail.generateThumbnail(view, exposition.getCoverImageSrc(), 200));
			textViewExpositionName.setText(exposition.getName());
			textViewExpositionSummary.setText(exposition.getDescription());
			itemExpositionListLayout.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					expositionClick(exposition);
				}
			});
		}
		else{
			((ViewGroup) imageCover.getParent()).removeView(imageCover);
			textViewExpositionName.setText("");
			textViewExpositionSummary.setText("");
			textViewExpositionSummary.setHeight(100);
		}
 
        return view;
    }
    
    public void expositionClick(Exposition e){
		Fragment f = ExpositionFragment.newInstance(e);
		MainActivity.addLastOpenedFragment(f);
		ft.replace(R.id.your_placeholder, f);
		ft.commit();
    }
}
