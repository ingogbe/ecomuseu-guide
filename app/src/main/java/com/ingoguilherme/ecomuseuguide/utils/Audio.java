package com.ingoguilherme.ecomuseuguide.utils;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;

/**
 * Created by IngoGuilherme on 16-May-16.
 */
public class Audio {

    private MediaPlayer mp;
    private boolean is_stop;
    private boolean is_ready;

    public Audio(String audioSrc, View rootView){
        setMediaPlayer(rootView, audioSrc);
        is_stop = false;
    }

    public void setMediaPlayer(View rootView, String audioSrc){

        String TAG = "EXCEPTION";

        try {
            String path = "audios/" + audioSrc + ".mp3";

            AssetFileDescriptor afd = rootView.getContext().getAssets().openFd(path);

            mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();

            is_ready = true;
        } catch (IllegalStateException e) {
            Log.d(TAG, "IllegalStateException: " + e.getMessage());
            catchFunction();
        } catch (IllegalArgumentException e) {
            Log.d(TAG, "IllegalArgumentException: " + e.getMessage());
            catchFunction();
        } catch (SecurityException e) {
            Log.d(TAG, "SecurityException: " + e.getMessage());
            catchFunction();
        } catch (IOException e){
            Log.d(TAG, "IOException: " + e.getMessage());
            catchFunction();
        }

    }

    public void catchFunction(){
        is_ready = false;
        mp = null;
    }

    public boolean isReady(){
        return is_ready;
    }

    public MediaPlayer getMediaPlayer(){
        return this.mp;
    }

    public void startResume(ProgressBar progressBar){
        final ProgressBar pb = progressBar;

        is_stop = false;
        if(is_ready) {
            mp.start();

            Thread t = new Thread() {
                public void run() {
                    while(isPlaying()){
                        pb.setProgress(getMediaPlayer().getCurrentPosition());
                    }
                };
            };

            t.start();
        }
    }

    public boolean isStop(){
        return this.is_stop;
    }

    public boolean isPlaying(){
        return mp.isPlaying();
    }

    public void pause(){
        if(is_ready) {
            mp.pause();
        }
    }

    public void stop(){
        if(is_ready) {
            mp.stop();
        }
        is_stop = true;
    }

    public void releaseMediaPlayer() {
        if(is_ready) {
            if (mp != null) {
                mp.stop();
                mp.release();
                mp = null;
            }
        }
    }
}
