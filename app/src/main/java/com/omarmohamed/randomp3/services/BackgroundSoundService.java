package com.omarmohamed.randomp3.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.omarmohamed.randomp3.R;
import com.omarmohamed.randomp3.utilities.Constants;
import com.omarmohamed.randomp3.utilities.MusicManager;
import com.omarmohamed.randomp3.utilities.Utils;

import java.io.IOException;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer mPlayer;
    String mDataSource;

    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = new MediaPlayer();
        mDataSource = new MusicManager().getMp3Path();

        if(!mDataSource.equals(Constants.Mp3Files.NO_MP3_FILES_AVAILABLE)) {

            try {
                //Getting mp3 from the device
                mPlayer.setDataSource(new MusicManager().getMp3Path());
            } catch (IOException e) {
                e.printStackTrace();
            }
            mPlayer.setLooping(true); // Set looping
            mPlayer.setVolume(100, 100);
        } else {
            Toast.makeText(this, getString(R.string.error_no_mp3_available), Toast.LENGTH_LONG).show();
        }

    }

    public int onStartCommand(Intent intent, int flags, int startId) {

//        try {
//            mPlayer.prepare();
            mPlayer.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //We should continue to play music if the service crash because the system needed memory to be freed
        return START_STICKY;
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {
        mPlayer.stop();
        mPlayer.release();
    }

    public void onPause() {

    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        mPlayer.release();
    }

    @Override
    public void onLowMemory() {

    }
//TODO: Methods to modify the widget
//    @Override
//    public void onStart(Intent intent, int startId) {
//        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this
//                .getApplicationContext());
//
//        int[] allWidgetIds = intent
//                .getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
//
////                ComponentName thisWidget = new ComponentName(getApplicationContext(),
////                                MyWidgetProvider.class);
////                int[] allWidgetIds2 = appWidgetManager.getAppWidgetIds(thisWidget);
//
//        for (int widgetId : allWidgetIds) {
//            // create some random data
//            int number = (new Random().nextInt(100));
//
//            RemoteViews remoteViews = new RemoteViews(this
//                    .getApplicationContext().getPackageName(),
//                    R.layout.widget_layout);
//            Log.w("WidgetExample", String.valueOf(number));
//            // Set the text
//            remoteViews.setTextViewText(R.id.update,
//                    "Random: " + String.valueOf(number));
//
//            // Register an onClickListener
//            Intent clickIntent = new Intent(this.getApplicationContext(),
//                    MyWidgetProvider.class);
//
//            clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,
//                    allWidgetIds);
//
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(
//                    getApplicationContext(), 0, clickIntent,
//                    PendingIntent.FLAG_UPDATE_CURRENT);
//            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
//            appWidgetManager.updateAppWidget(widgetId, remoteViews);
//        }
//        stopSelf();
//
//        super.onStart(intent, startId);
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
}
