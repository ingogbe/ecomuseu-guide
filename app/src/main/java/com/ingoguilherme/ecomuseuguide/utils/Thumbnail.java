package com.ingoguilherme.ecomuseuguide.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import com.ingoguilherme.ecomuseuguide.R;

import java.io.ByteArrayOutputStream;

/**
 * Created by IngoGuilherme on 14-May-16.
 */
public class Thumbnail {

    public static Bitmap generateThumbnail(View rootView, String drawableString, int thumbSize){

        byte[] imageData = null;

        try {
            //InputStream is=getAssets().open("apple-android-battle.jpg");
            int id = rootView.getContext().getResources().getIdentifier(drawableString, "drawable", rootView.getContext().getPackageName());
            Bitmap imageBitmap = BitmapFactory.decodeResource(rootView.getContext().getResources(), id);

            Float width = new Float(imageBitmap.getWidth());
            Float height = new Float(imageBitmap.getHeight());
            Float ratio = width / height;
            imageBitmap = Bitmap.createScaledBitmap(imageBitmap, (int) (thumbSize * ratio), thumbSize, false);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            imageData = baos.toByteArray();

            return imageBitmap;
        } catch (Exception ex) {
            //InputStream is=getAssets().open("apple-android-battle.jpg");
            int id = R.drawable.ic_no_image;
            Bitmap imageBitmap = BitmapFactory.decodeResource(rootView.getContext().getResources(), id);

            Float width = new Float(imageBitmap.getWidth());
            Float height = new Float(imageBitmap.getHeight());
            Float ratio = width / height;
            imageBitmap = Bitmap.createScaledBitmap(imageBitmap, (int) (thumbSize * ratio), thumbSize, false);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            imageData = baos.toByteArray();

            return imageBitmap;
        }
    }
}
