package com.omarmohamed.randomp3.utilities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import static com.omarmohamed.randomp3.utilities.Constants.Mp3Files.PERMISSIONS_STORAGE;
import static com.omarmohamed.randomp3.utilities.Constants.Mp3Files.REQUEST_EXTERNAL_STORAGE;

/**
 * Utility class that contains generics methods
 * Created by omarmohamed on 5/09/2016.
 */

public class Utils {

    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    Constants.Mp3Files.PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
