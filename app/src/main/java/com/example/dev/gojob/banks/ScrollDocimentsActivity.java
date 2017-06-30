package com.example.dev.gojob.banks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dev.gojob.R;

/**
 * Created by catchman on 22.06.17.
 */

public class ScrollDocimentsActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_documents);
    }

    public void goNext(View view){
        intent = new Intent(ScrollDocimentsActivity.this,RecvisiveForPayActivity.class);
        startActivity(intent);
    }
}
