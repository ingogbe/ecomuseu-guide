package com.ingoguilherme.ecomuseuguide.utils;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
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

        try{
            AssetFileDescriptor afd = rootView.getContext().getAssets().openFd("audios/" + audioSrc + ".mp3");
            is_ready = true;
            mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor());
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }catch (IOException e){
            is_ready = false;
        }

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
