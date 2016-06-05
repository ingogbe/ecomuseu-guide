package com.ingoguilherme.ecomuseuguide.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.ortiz.touch.TouchImageView;
import com.ingoguilherme.ecomuseuguide.utils.Thumbnail;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 04-Jun-16.
 */
public class ImageAdapter extends PagerAdapter {

    private Activity _activity;
    private ArrayList<String> mStrings;
    private LayoutInflater inflater;


    // constructor
    public ImageAdapter(Activity activity, ArrayList<String> mStrings) {
        this._activity = activity;
        this.mStrings = mStrings;
    }

    @Override
    public int getCount() {
        return this.mStrings.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TouchImageView imgDisplay;
        final Button btnClose;

        inflater = (LayoutInflater) _activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.item_list_gallery, container, false);
        RelativeLayout parentview = (RelativeLayout) viewLayout .findViewById(R.id.rel);
        imgDisplay = (TouchImageView) viewLayout.findViewById(R.id.imgDisplay);
        imgDisplay.setImageBitmap(Thumbnail.generateThumbnail(container, mStrings.get(position),600));

        ((ViewPager) container).addView(viewLayout);
        /**
         * Setting the object for animation
         * */


        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
