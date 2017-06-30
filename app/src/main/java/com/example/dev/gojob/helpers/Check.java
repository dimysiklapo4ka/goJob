package com.example.dev.gojob.helpers;

import android.text.TextUtils;

/**
 * Created by manj on 24.05.17.
 */

public class Check {

    public boolean checkEmail(String text){
        return !TextUtils.isEmpty(text) && android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }
    public boolean checkPassword(String password1, String password2){
        return password1.equals(password2);
    }

    public boolean checkPasword(String text){
        if(text.length() < 8){
            return false;
        }
        return true;
    }
}
