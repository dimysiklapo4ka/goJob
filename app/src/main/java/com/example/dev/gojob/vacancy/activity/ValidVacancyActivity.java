package com.example.dev.gojob.vacancy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dev.gojob.R;
import com.example.dev.gojob.vacancy.fragment.MainFragment;

public class ValidVacancyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valid_vacancy);

        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, fragment)
                .commit();

    }
}
