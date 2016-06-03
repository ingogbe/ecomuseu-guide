package com.ingoguilherme.ecomuseuguide.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.ingoguilherme.ecomuseuguide.R;

import java.io.ByteArrayOutputStream;

/**
 * Created by IngoGuilherme on 14-May-16.
 */
public class Thumbnail {

    public static Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static Bitmap generateThumbnail(View rootView, String drawableString, int thumbSize){

        int id = rootView.getContext().getResources().getIdentifier(drawableString, "drawable", rootView.getContext().getPackageName());

        Drawable d;

        if(id == 0){
            d = rootView.getContext().getResources().getDrawable(R.drawable.ic_no_image);
        }
        else{
            d = rootView.getContext().getResources().getDrawable(id);
        }


        //TODO: Melhorar desempenho, está muito lerdo
        //Bitmap imageBitmap = BitmapFactory.decodeResource(rootView.getContext().getResources(), id);
        Bitmap imageBitmap = drawableToBitmap(d);

        Float width = new Float(imageBitmap.getWidth());
        Float height = new Float(imageBitmap.getHeight());
        Float ratio = width / height;
        imageBitmap = Bitmap.createScaledBitmap(imageBitmap, (int) (thumbSize * ratio), thumbSize, false);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        return imageBitmap;
    }
}
