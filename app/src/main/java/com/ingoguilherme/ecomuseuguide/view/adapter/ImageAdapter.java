package com.ingoguilherme.ecomuseuguide.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ingoguilherme.ecomuseuguide.utils.Thumbnail;

import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> imageSources;

    public ImageAdapter(Context context, ArrayList<String> imageSources){
        this.imageSources = imageSources;
        this.context=context;
    }

    @Override
    public int getCount() {
        return imageSources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        imageView.setImageBitmap(Thumbnail.generateThumbnail(container, imageSources.get(position),600));

        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}