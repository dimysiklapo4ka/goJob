package com.example.dev.gojob.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by catchman on 20.06.17.
 */

public class ServerDell {

    public void logout(String token) throws IOException {
        URL url = new URL("http://server.gojob.com.ua/api/sessions/logout");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("DELETE");
        if(token != null){
            urlConnection.setRequestProperty("HTTP_API_TOKEN", "Token " + token);
        }
        urlConnection.setConnectTimeout(5000);
        urlConnection.setReadTimeout(5000);
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        StringBuilder buffer = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
    }

    public void delete(String token) throws IOException {
        URL url = new URL("http://server.gojob.com.ua/api/sessions/logout");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("DELETE");
        if(token != null){
            urlConnection.setRequestProperty("HTTP_API_TOKEN", "Token " + token);
        }
        urlConnection.setConnectTimeout(5000);
        urlConnection.setReadTimeout(5000);
        urlConnection.connect();
    }

}
