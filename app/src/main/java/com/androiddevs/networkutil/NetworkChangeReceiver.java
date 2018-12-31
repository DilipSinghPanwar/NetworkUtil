package com.androiddevs.networkutil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * A wrapper of a broadcast receiver which provides network connectivity information
 * for all kinds of network: wifi, mobile, etc.
 */
public class NetworkChangeReceiver extends BroadcastReceiver {

    public static final String TAG = NetworkChangeReceiver.class.getSimpleName();

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Log.v(TAG, "");
        String status = NetworkChangeReceiver.getConnectivityType(context);
        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }

    public static String getConnectivityType(Context context) {
        String connectionStatus = null;
        // Get an instance of ConnectivityManager
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //If connectivity object is not null
        if (cm != null) {
            //Get network info - connection status
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    connectionStatus = "WIFI ENABLED";
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    connectionStatus = "Mobile DATA ENABLED";
                }
            } else {
                connectionStatus = "NO INTERNET CONNECTION";
            }
        }
        return connectionStatus;
    }
}