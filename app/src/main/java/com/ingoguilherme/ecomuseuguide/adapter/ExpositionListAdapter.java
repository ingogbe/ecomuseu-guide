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
import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.fragments.ExpositionFragment;

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

		try{
			int id = context.getResources().getIdentifier(exposition.getCoverImageSrc(), "drawable", context.getPackageName());
			imageCover.setImageResource(id);
		}catch (Exception e) {
			imageCover.setImageResource(R.drawable.ic_no_image);
		}

        TextView textViewExpositionName = (TextView) view.findViewById(R.id.text_view_exposition_name);
		textViewExpositionName.setText(exposition.getName());
 
        TextView textViewExpositionSummary = (TextView)view.findViewById(R.id.text_view_exposition_summary);
		textViewExpositionSummary.setText(exposition.getDescription());

        RelativeLayout itemExpositionListLayout = (RelativeLayout) view.findViewById(R.id.item_list_exposition_layout);
		itemExpositionListLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				expositionClick(exposition);
			}
		});
 
        return view;
    }
    
    public void expositionClick(Exposition e){
		ft.replace(R.id.your_placeholder, ExpositionFragment.newInstance(e));
		ft.commit();
    }
}
