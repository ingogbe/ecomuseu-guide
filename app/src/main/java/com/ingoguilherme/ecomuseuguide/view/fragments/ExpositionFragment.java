package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Panel;
import com.ingoguilherme.ecomuseuguide.dao.controller.PanelDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.utils.Audio;
import com.ingoguilherme.ecomuseuguide.utils.Thumbnail;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;

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
    Audio audio;
    String audioSrc = "";

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
            exposition = new Exposition();
            exposition.setId(getArguments().getInt(ARG_PARAM1));
            exposition.setName(getArguments().getString(ARG_PARAM2));
            exposition.setDescription(getArguments().getString(ARG_PARAM3));

            DatabaseHandler dh = new DatabaseHandler(getContext());
            PanelDAO panelDAO = new PanelDAO(dh);
            exposition.setPanels(panelDAO.queryPanelByExposition(exposition));
            dh.close();
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
            TextView tvText = (TextView) rootView.findViewById(R.id.textViewText);
            String text = "";

            TextView tvTitle = (TextView) rootView.findViewById(R.id.textViewTitle);
            tvTitle.setText(exposition.getName());

            final ImageButton imPlay = (ImageButton) rootView.findViewById(R.id.buttonPlayPause);

            final ProgressBar audioPb = (ProgressBar) rootView.findViewById(R.id.audioProgressBar);

            for(Panel p :exposition.getPanels()) {
                for(String s :p.getParagraphs()){
                    text = text + s + "\n\n";
                }
                text = text + "\n\n\n\n";

                for (int i = 0; i < p.getImageSources().size(); i++) {
                    String s = p.getImageSources().get(i);
                    ImageView im = new ImageView(rootView.getContext());

                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(10, 10, 10, 10);
                    im.setLayoutParams(lp);

                    im.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));

                    im.setImageBitmap(Thumbnail.generateThumbnail(rootView,s,150));
                    im.setPadding(10,10,10,10);

                    final int final_i = i;
                    final Panel final_p = p;

                    im.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            Fragment f = GalleryFragment.newInstance(final_p.getImageSources(), final_i);
                            MainActivity.addLastOpenedFragment(f);
                            ft.replace(R.id.your_placeholder, f);
                            ft.commit();
                        }
                    });

                    ll.addView(im);
                }

                audioSrc = p.getAudioSource();
                audio = new Audio(audioSrc, rootView);

                if(audio.isReady()) {
                    audio.getMediaPlayer().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            imPlay.setBackgroundResource(R.drawable.ic_button_play);
                            audioPb.setProgress(0);
                        }
                    });
                    audioPb.setMax(audio.getMediaPlayer().getDuration());
                }
            }

            tvText.setText(text);


            imPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(audio.isReady()) {
                        if (audio.isPlaying()) {
                            audio.pause();
                            imPlay.setBackgroundResource(R.drawable.ic_button_play);
                        } else {
                            if (audio.isStop()) {
                                audio = new Audio(audioSrc, rootView);
                                audio.getMediaPlayer().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        imPlay.setBackgroundResource(R.drawable.ic_button_play);
                                        audioPb.setProgress(0);
                                    }
                                });
                                audioPb.setMax(audio.getMediaPlayer().getDuration());
                            }
                            audio.startResume(audioPb);
                            imPlay.setBackgroundResource(R.drawable.ic_button_pause);
                        }
                    }
                    else{
                        Snackbar snack = Snackbar.make(rootView, R.string.no_audio, Snackbar.LENGTH_LONG).setAction("Message", null);
                        View sbView = snack.getView();
                        sbView.setBackgroundResource(R.color.colorPrimary);
                        snack.show();
                    }
                }
            });

            ImageButton imStop = (ImageButton) rootView.findViewById(R.id.buttonStop);
            imStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(audio.isReady()) {
                        audio.stop();
                        audioPb.setProgress(0);
                        imPlay.setBackgroundResource(R.drawable.ic_button_play);
                    }
                }
            });

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
