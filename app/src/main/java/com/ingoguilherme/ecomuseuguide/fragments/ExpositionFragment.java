package com.ingoguilherme.ecomuseuguide.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Exposition;

/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class ExpositionFragment extends Fragment {
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "name";
    private static final String ARG_PARAM3 = "description";

    public static final int THUMBNAIL_HEIGHT = 150;
    public static final int THUMBNAIL_WIDTH = 150;

    Exposition exposition;

    View rootView;

    public static final int REQUEST_CODE = 0;

    private OnExpositionFragmentInteractionListener mListener;

    public ExpositionFragment() {
        // Required empty public constructor
    }

    public static ExpositionFragment newInstance(Exposition e) {
        ExpositionFragment fragment = new ExpositionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, e.getId());
        args.putString(ARG_PARAM2, e.getName());
        args.putString(ARG_PARAM3, e.getDescription());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            exposition.setId(getArguments().getInt(ARG_PARAM1));
            exposition.setName(getArguments().getString(ARG_PARAM2));
            exposition.setDescription(getArguments().getString(ARG_PARAM3));

            //TODO: GET PANELS DA EXPOSIÇÃO NO BANCO
            //TODO: GET IMAGENS DESSES PANEL
            //TODO: GET PARAGRAFOS DESSES PANEL
        }
        else{
            exposition = new Exposition();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_exposition, container, false);

        if(exposition.getId() != 0) {
            LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.room_images);

            /* CARREGA IMAGENS
            try {
                for(String s : mParamDescription) {
                    byte[] imageData = null;
                    ImageView im = new ImageView(rootView.getContext());

                    final int THUMBNAIL_SIZE = 100;
                    //InputStream is=getAssets().open("apple-android-battle.jpg");
                    int id = rootView.getContext().getResources().getIdentifier(s, "drawable", rootView.getContext().getPackageName());
                    Bitmap imageBitmap = BitmapFactory.decodeResource(rootView.getContext().getResources(), id);

                    Float width = new Float(imageBitmap.getWidth());
                    Float height = new Float(imageBitmap.getHeight());
                    Float ratio = width / height;
                    imageBitmap = Bitmap.createScaledBitmap(imageBitmap, (int) (THUMBNAIL_SIZE * ratio), THUMBNAIL_SIZE, false);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    imageData = baos.toByteArray();
                    im.setImageBitmap(imageBitmap);
                    im.setMaxHeight(100);
                    im.setMaxWidth(100);

                    ll.addView(im);
                }
            }
            catch(Exception ex) {
                ImageView im = new ImageView(rootView.getContext());
                im.setImageResource(R.drawable.ic_no_image);
                ll.addView(im);
                Log.d("TESTE","Deu pau");
            }
            */
        }
        else{
            //Sem exposição
        }

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onExpositionFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnExpositionFragmentInteractionListener) {
            mListener = (OnExpositionFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnExpositionFragmentInteractionListener {
        void onExpositionFragmentInteraction(Uri uri);
    }
}
