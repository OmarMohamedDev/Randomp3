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
