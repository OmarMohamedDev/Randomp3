package com.omarmohamed.randomp3.providers;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Form of BroadcastReceiver which is used to build the user interface of the widget.
 * As the user can add several instances of a widget to the home screen, the widget has life cycle methods which
 * are called only for the first instance added / removed to the home screen and others which are called
 * for every instance of the widget.
 */
public class Randomp3WidgetProvider extends AppWidgetProvider  {
    public Randomp3WidgetProvider() {
    }

    /**
     * The AppWidgetProvider class implements the onReceive() method, extracts the required information
     * and calls the widget life cycle methods.
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    /**
     * Called the first time an instance of the widget is added to the home screen.
     * @param context
     */
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    /**
     * Called for every update of the widget. Contains the ids of appWidgetIds for which an update is needed.
     * Note that this may be all of the AppWidget instances for this provider, or just a subset of them,
     * as stated in the method’s JavaDoc. For example, if more than one widget is added to the home screen,
     * only the last one changes (until reinstall).
     * @param context
     * @param appWidgetManager
     * @param appWidgetIds
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    /**
     * Called when the widget has been layed out at a new size.
     * @param context
     * @param appWidgetManager
     * @param appWidgetId
     * @param newOptions
     */
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    /**
     * Called when instances of this AppWidget provider have been restored from backup. If the provider maintains
     * any persistent data about its widget instances, overriding this method the app remap the old AppWidgetIds
     * to the new values and update any other app state that may be relevant.
     * This callback will be followed immediately by a call to onUpdate(Context, AppWidgetManager, int[])
     * so the provider can immediately generate new RemoteViews suitable for its newly-restored set of instances.
     * @param context
     * @param oldWidgetIds
     * @param newWidgetIds
     */
    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
    }

    /**
     * Widget instance is removed from the home screen.
     * @param context
     * @param appWidgetIds
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    /**
     *
     * Called once the last instance of the widget is removed from the home screen.
     * @param context
     */
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
}
