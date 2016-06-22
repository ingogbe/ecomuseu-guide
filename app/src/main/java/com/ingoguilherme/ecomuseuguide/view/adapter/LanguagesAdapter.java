package com.ingoguilherme.ecomuseuguide.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.dao.controller.RoomDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.fragments.MapFragment;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by IngoGuilherme on 11-May-16.
 */
public class LanguagesAdapter extends ArrayAdapter<Room> {

	ArrayList<Language> languages;
	Context context;
	private final LayoutInflater inflater;
	TextView textViewLanguage;
	FragmentTransaction ft;
	Activity activity;

	public LanguagesAdapter(Activity activity, Context context, int resource, ArrayList<Language> languages, FragmentTransaction ft) {
		super(context, resource);
		this.context = context;
		this.ft = ft;
		inflater = LayoutInflater.from(context);
		this.languages = languages;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		return languages.size();
	}

    @Override
    public View getView(int position, View view, ViewGroup parent) {
    	final Language language = languages.get(position);

		view = inflater.inflate(R.layout.item_list_language, null);

		textViewLanguage = (TextView) view.findViewById(R.id.textViewLanguage);

		Locale loc = new Locale(language.getLanguage(),language.getCountryCode());
		String name = loc.getDisplayLanguage(loc);
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		String country = loc.getDisplayCountry(loc);

		textViewLanguage.setText(name + " (" + country + ")");
		textViewLanguage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(MainActivity.selectedLanguage.getId() != language.getId())
					languageClick(language);
			}
		});

		if(MainActivity.selectedLanguage.getId() == language.getId())
			textViewLanguage.setBackgroundResource(R.color.light_gray);
 
        return view;
    }
    
    public void languageClick(Language l){
		MainActivity.selectedLanguage = l;

		Resources res = context.getResources();
		// Change locale settings in the app.
		DisplayMetrics dm = res.getDisplayMetrics();
		android.content.res.Configuration conf = res.getConfiguration();
		conf.locale = new Locale(l.getLanguage(),l.getCountryCode());
		res.updateConfiguration(conf, dm);

		MainActivity.refreshDrawerTexts();

		String mapIdentification = MapFragment.currentRoom.getMapIdentification();

		DatabaseHandler dh = new DatabaseHandler(getContext());
		RoomDAO roomDAO = new RoomDAO(dh);
		Room room = roomDAO.queryRoomByIdAndLanguage(MapFragment.currentRoom.getId(), l);

		if(!room.getMapIdentification().equals(mapIdentification)){
			room = roomDAO.queryNonClickableRoomsByLanguageAndMapIdentification(l, mapIdentification);
		}

		MapFragment.currentRoom = room;

		dh.close();

		Fragment f = MainActivity.getLastOpenedFragment();
		ft.replace(R.id.your_placeholder, f);
		ft.commit();
    }
}
