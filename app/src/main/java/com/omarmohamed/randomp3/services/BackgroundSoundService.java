package com.omarmohamed.randomp3.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;

import java.io.IOException;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();
        try {
            //Getting mp3 from the device //TODO: Create utility method that retrieve all the mp3 files and set here a list of them
            player.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + "/your file.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);

    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //We should continue to play music if the service crash because the system needed memory to be freed
        return START_STICKY;
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }

    public void onPause() {

    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}
