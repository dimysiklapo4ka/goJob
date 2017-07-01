package com.example.dev.gojob.serverUtils.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

/**
 * Created by d1mys1klapo4ka on 19.06.2017.
 */

public class InternetConection {

    public static boolean checInternet(@NonNull Context context){
        return ((ConnectivityManager)context.getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
}
