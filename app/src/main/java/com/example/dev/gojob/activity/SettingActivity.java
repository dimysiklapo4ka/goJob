package com.example.dev.gojob.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dev.gojob.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void logout(View view){
        goback();
    }

    public void delete(View view){
        goback();
    }

    public void goback(){
        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
