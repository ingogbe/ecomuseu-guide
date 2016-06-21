package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.bo.Achievement;
import com.ingoguilherme.ecomuseuguide.bo.Room;
import com.ingoguilherme.ecomuseuguide.dao.controller.AchievementDAO;
import com.ingoguilherme.ecomuseuguide.dao.controller.RoomDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;
import com.ingoguilherme.ecomuseuguide.view.dialog.MessageDialog;

import java.util.ArrayList;


/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class AchievementsFragment extends Fragment {

    private OnAchievementsFragmentInteractionListener mListener;

    View rootView;

    public AchievementsFragment() {
        // Required empty public constructor
    }

    public static AchievementsFragment newInstance() {
        AchievementsFragment fragment = new AchievementsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_achievements, container, false);

        TableLayout table = (TableLayout) rootView.findViewById(R.id.table_achievement);

        DatabaseHandler dh = new DatabaseHandler(rootView.getContext());
        AchievementDAO achievementDAO = new AchievementDAO(dh);
        ArrayList<Achievement> all = achievementDAO.queryAllAchievement();
        ArrayList<Achievement> completed = achievementDAO.queryAllCompletedAchievement();

        if(completed.size() == 0){
            MessageDialog md = new MessageDialog();
            md.setInstance(getResources().getString(R.string.dialog_achievements_msg));
            FragmentManager fm = getActivity().getSupportFragmentManager();
            md.show(fm, "Dialog Fragment");
        }

        TableRow row = new TableRow(rootView.getContext());
        int counter = 0;
        int pontos = 0;
        int totalPontos = 0;

        for(final Achievement a :all) {
            totalPontos = totalPontos + a.getPoints();

            if(counter == 3){
                table.addView(row);
                row = new TableRow(rootView.getContext());
                counter = 0;
            }

            View viewAchievement = inflater.inflate(R.layout.item_achievement, row, false);

            LinearLayout ll = (LinearLayout) viewAchievement.findViewById(R.id.item_achievement);
            ImageView im = (ImageView) viewAchievement.findViewById(R.id.imageView_achievement);
            TextView tv_name = (TextView) viewAchievement.findViewById(R.id.textView_achievement_name);
            TextView tv_points = (TextView) viewAchievement.findViewById(R.id.textView_achievement_points);

            RoomDAO roomDAO = new RoomDAO(dh);
            final Room r = roomDAO.queryRoomsByAchievementAndLanguage(a, MainActivity.selectedLanguage);
            tv_name.setText(r.getName());

            tv_points.setText(a.getPoints() + " " + getResources().getString(R.string.points));

            for(Achievement c :completed){
                if(a.getId() == c.getId()){
                    im.setImageResource(R.drawable.achievement_trophy);
                    pontos = pontos + a.getPoints();
                    break;
                }
            }

            ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment f = ExpositionListFragment.newInstance(r);
                    MainActivity.addLastOpenedFragment(f);
                    ft.replace(R.id.your_placeholder, f);
                    ft.commit();
                }
            });

            row.addView(viewAchievement);

            counter++;
        }

        table.addView(row);
        table.setShrinkAllColumns(true);

        TextView tvPontos = (TextView) rootView.findViewById(R.id.totalPontos);
        tvPontos.setText(getResources().getString(R.string.points) + ": " + pontos + "/" + totalPontos);

        dh.close();

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onAchievementsFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (context instanceof OnAchievementsFragmentInteractionListener) {
            mListener = (OnAchievementsFragmentInteractionListener) context;
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

    public interface OnAchievementsFragmentInteractionListener {
        void onAchievementsFragmentInteraction(Uri uri);
    }
}
