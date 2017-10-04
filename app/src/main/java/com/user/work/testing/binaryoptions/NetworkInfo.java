package com.user.work.testing.binaryoptions;

import android.content.Context;
import android.net.ConnectivityManager;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class NetworkInfo {

  public static boolean isConnected(Context context) {
    ConnectivityManager cm = (ConnectivityManager)
        context.getSystemService(CONNECTIVITY_SERVICE);

    boolean isNetworkAvailable = cm.getActiveNetworkInfo() != null;
    boolean isNetworkConnected = isNetworkAvailable
        && cm.getActiveNetworkInfo().isConnected();

    return isNetworkConnected;
  }
}