package com.omarmohamed.randomp3.utilities;

import android.Manifest;
import android.os.Environment;

/**
 * Utility class that collect all the constants used in the application
 * Created by omarmohamed on 4/09/2016.
 */
public class Constants {

    /**
     * Class that collect constants that represent the actions available for the widget
     */
    public static class WidgetActions{

        /**
         * Action trigger for play
         */
        public static final String ACTION_PLAY = "actionPlay";

        /**
         * Action trigger for pause
         */
        public static final String ACTION_PAUSE = "actionPause";

        /**
         * Action trigger for stop
         */
        public static final String ACTION_STOP = "actionStop";

        /**
         * Action trigger for next
         */
        public static final String ACTION_NEXT = "actionNext";

        /**
         * Action trigger for another kind of action not listed here
         */
        public static final String ACTION_GENERIC = "actionGeneric";
    }


    /**
     * Class that contains all the constants related to the properties and the manipulation of the mp3 files
     */
    public static class Mp3Files {

        /**
         * Represent the path to the media folder
         */
        public static final String MEDIA_PATH = Environment.getExternalStorageDirectory().getPath() + "/Ringtones/";

        /**
         * Constant that is used to understand if in the device there are mp3 files or not
         */
        public static final String NO_MP3_FILES_AVAILABLE = "noMp3Available";

        /**
         * Constant used to request permision to operate on external storage
         */
        public static final int REQUEST_EXTERNAL_STORAGE = 1;

        /**
         * Read permission for the app
         */
        public static final String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
    }
}
