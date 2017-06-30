package com.example.dev.gojob.banks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.dev.gojob.R;

/**
 * Created by catchman on 22.06.17.
 */

public class RegisterYourselfActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    LinearLayout mStandartPassport;
    LinearLayout mFastPassport;
    LinearLayout mChildPassport;
    ImageButton mIBStandartPassport;
    ImageButton mIBFastPassport;
    ImageButton mIBChildPassport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_yourself);
        mStandartPassport =(LinearLayout)findViewById(R.id.standard_passport);
        mFastPassport =(LinearLayout)findViewById(R.id.fast_passport);
        mChildPassport = (LinearLayout)findViewById(R.id.child_passport);
        mIBStandartPassport = (ImageButton)findViewById(R.id.bt_for_registration_your_self);
        mIBFastPassport = (ImageButton)findViewById(R.id.bt_for_registration_your_self_two);
        mIBChildPassport = (ImageButton)findViewById(R.id.bt_for_registration_your_self_three);
        mStandartPassport.setOnClickListener(this);
        mFastPassport.setOnClickListener(this);
        mChildPassport.setOnClickListener(this);
        mIBStandartPassport.setOnClickListener(this);
        mIBFastPassport.setOnClickListener(this);
        mIBChildPassport.setOnClickListener(this);
        unvisibleButton();
    }



    private void unvisibleButton(){
        mIBStandartPassport.setVisibility(View.GONE);
        mIBFastPassport.setVisibility(View.GONE);
        mIBChildPassport.setVisibility(View.GONE);
    }



    public void createBiometric(View view){
        intent = new Intent(RegisterYourselfActivity.this,IssuePasspotActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.standard_passport:
                unvisibleButton();
                mIBStandartPassport.setVisibility(View.VISIBLE);
                break;
            case R.id.fast_passport:
                unvisibleButton();
                mIBFastPassport.setVisibility(View.VISIBLE);
                break;
            case R.id.child_passport:
                unvisibleButton();
                mIBChildPassport.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_for_registration_your_self:
                intent = new Intent(RegisterYourselfActivity.this,ScrollDocimentsActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_for_registration_your_self_two:
                intent = new Intent(RegisterYourselfActivity.this,ScrollDocumentationFastActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_for_registration_your_self_three:
                intent = new Intent(RegisterYourselfActivity.this,ScrollDocimentsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
