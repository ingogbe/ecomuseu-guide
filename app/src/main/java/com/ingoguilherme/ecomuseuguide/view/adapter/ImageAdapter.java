package com.ingoguilherme.ecomuseuguide.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.utils.Thumbnail;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.fragments.GalleryFragment;

import java.util.ArrayList;

/**
 * Created by IngoGuilherme on 04-Jun-16.
 */
public class ImageAdapter extends PagerAdapter {

    private Activity activity;
    private ArrayList<String> imageSources;
    private LayoutInflater inflater;
    ImageView imgDisplay;
    FragmentTransaction ft;
    LinearLayout ll_dots;

    public ImageAdapter(LinearLayout lldots, FragmentTransaction ft, Activity activity, ArrayList<String> imageSources) {
        this.activity = activity;
        this.imageSources = imageSources;
        this.ft = ft;
        this.ll_dots = lldots;

        for(int i = 0; i < imageSources.size(); i++){
            ImageView im = new ImageView(activity);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            im.setLayoutParams(lp);
            im.setImageResource(R.drawable.ic_dot);
            ll_dots.addView(im);
        }
    }

    @Override
    public int getCount() {
        return this.imageSources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewLayout = inflater.inflate(R.layout.item_list_gallery_image, container, false);

        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        imgDisplay.setImageBitmap(Thumbnail.generateThumbnail(container, imageSources.get(position),600));
        imgDisplay.setContentDescription("Exposition image " + (position+1));

        final int positionAux = position;

        imgDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = GalleryFragment.newInstance(imageSources, positionAux);
                MainActivity.addLastOpenedFragment(f);
                ft.replace(R.id.your_placeholder, f);
                ft.commit();
            }
        });

        ((ViewPager) container).addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
