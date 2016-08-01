package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Panel;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.dao.controller.ExpositionDAO;
import com.ingoguilherme.ecomuseuguide.dao.controller.PanelDAO;
import com.ingoguilherme.ecomuseuguide.dao.controller.RoomDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.utils.Audio;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.adapter.ImageAdapter;
import com.ingoguilherme.ecomuseuguide.view.custom.MyViewPager;

/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class ExpositionFragment extends Fragment {
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "name";
    private static final String ARG_PARAM3 = "description";
    private static final String ARG_PARAM4 = "qrCodeLink";
    private static final String ARG_PARAM5 = "idRoom";

    public static final int THUMBNAIL_HEIGHT = 150;
    public static final int THUMBNAIL_WIDTH = 150;

    Exposition exposition;
    Room room;
    Audio audio;
    String audioSrc = "";

    View rootView;

    public static final int REQUEST_CODE = 0;

    private OnExpositionFragmentInteractionListener mListener;

    public ExpositionFragment() {
        // Required empty public constructor
    }

    public static ExpositionFragment newInstance(Exposition e, int roomID) {
        ExpositionFragment fragment = new ExpositionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, e.getId());
        args.putString(ARG_PARAM2, e.getName());
        args.putString(ARG_PARAM3, e.getDescription());
        args.putString(ARG_PARAM4, e.getQrCodeLink());
        args.putInt(ARG_PARAM5,roomID);
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
            exposition.setQrCodeLink(getArguments().getString(ARG_PARAM4));
            exposition.setDescription(getArguments().getString(ARG_PARAM3));

            room = new Room();
            room.setId(getArguments().getInt(ARG_PARAM5));

            DatabaseHandler dh = new DatabaseHandler(getContext());
            PanelDAO panelDAO = new PanelDAO(dh);
            exposition.setPanels(panelDAO.queryPanelByExposition(exposition));

            RoomDAO roomDAO = new RoomDAO(dh);
            room = roomDAO.queryRoomByIdAndLanguage(room.getId(),MainActivity.selectedLanguage);

            dh.close();
        }
        else{
            exposition = new Exposition();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_exposition, container, false);

        //Caso a pessoa troque o idioma enquanto estiver com a exposicao aberta
        DatabaseHandler dh = new DatabaseHandler(rootView.getContext());
        ExpositionDAO expositionDAO = new ExpositionDAO(dh);
        exposition = expositionDAO.queryExpositionByQrCodeAndLanguage(exposition.getQrCodeLink(),MainActivity.selectedLanguage);

        if(exposition.getId() != 0) {
            TextView tvText = (TextView) rootView.findViewById(R.id.textViewText);
            String text = "";

            TextView tvTitle = (TextView) rootView.findViewById(R.id.textViewTitle);
            tvTitle.setText(exposition.getName());

            TextView tvRoom = (TextView) rootView.findViewById(R.id.textViewRoom);
            tvRoom.setText(getResources().getString(R.string.room) + ": " + room.getName());

            final ImageButton imPlay = (ImageButton) rootView.findViewById(R.id.buttonPlayPause);

            final ProgressBar audioPb = (ProgressBar) rootView.findViewById(R.id.audioProgressBar);

            for(Panel p :exposition.getPanels()) {
                for(int i = 0; i < p.getParagraphs().size(); i++){
                    if(i == p.getParagraphs().size()-1)
                        text = text + p.getParagraphs().get(i);
                    else
                        text = text + p.getParagraphs().get(i) + "\n\n";
                }

                if(p.getImageSources().size() > 0) {
                    LinearLayout ll_dots = (LinearLayout) rootView.findViewById(R.id.linear_layout_dots);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    MyViewPager viewPager = (MyViewPager) rootView.findViewById(R.id.view_pager_expo);
                    ImageAdapter adapter = new ImageAdapter(ll_dots, ft, getActivity(), p.getImageSources());
                    viewPager.setAdapter(adapter);
                }
                else{
                    MyViewPager viewPager = (MyViewPager) rootView.findViewById(R.id.view_pager_expo);
                    viewPager.setVisibility(View.GONE);
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

        dh.close();

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
        getActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        audio.stop();
        getActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        mListener = null;
    }

    public interface OnExpositionFragmentInteractionListener {
        void onExpositionFragmentInteraction(Uri uri);
    }
}
