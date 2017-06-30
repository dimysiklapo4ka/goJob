package com.example.dev.gojob.serverUtils.mapServer;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by d1mys1klapo4ka on 06.06.2017.
 */

public class MyAsyncTask extends AsyncTask<String [],Void,String> {

    private OnLoadComplite onLoadComplite;

    public static final String MY_TAG = "####";

    private String mName = "";

    public void setmName(String mName) {
        this.mName = mName;
    }

    private String resultJson = "";

    @Override
    protected String doInBackground(String[]... params) {
        // получаем данные с внешнего ресурса
        try {
            URL url = new URL("http://server.gojob.com.ua/api/v1/agencies");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(MY_TAG, resultJson);

        return resultJson;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onLoadComplite.onLoadComplite(s);
        Log.e("####", "onPostExecute: load complite");
    }




    public void setOnLoadComplite(OnLoadComplite onLoadComplite) {
        this.onLoadComplite = onLoadComplite;
    }
}

