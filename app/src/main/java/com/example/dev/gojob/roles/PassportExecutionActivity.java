package com.example.dev.gojob.roles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dev.gojob.R;
import com.example.dev.gojob.banks.RegisterYourselfActivity;


public class PassportExecutionActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton mBtForRegisterYourSelf;
    ImageButton mBtForNeedHelp;
    LinearLayout mLlForRegisterYourSelf;
    LinearLayout mLlForNeedHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport_execution);

        mBtForRegisterYourSelf = (ImageButton) findViewById(R.id.bt_for_registration_your_self);
        mBtForRegisterYourSelf.setVisibility(View.GONE);
        mBtForRegisterYourSelf.setOnClickListener(this);
        mBtForNeedHelp = (ImageButton) findViewById(R.id.bt_for_need_help);
        mLlForRegisterYourSelf = (LinearLayout)findViewById(R.id.register_your_self);
        mLlForRegisterYourSelf.setOnClickListener(this);
        mLlForNeedHelp = (LinearLayout)findViewById(R.id.need_help);
        mLlForNeedHelp.setOnClickListener(this);
        mBtForNeedHelp.setOnClickListener(this);
        mBtForNeedHelp.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.register_your_self:
                mLlForNeedHelp.setLayoutParams(new LinearLayout.LayoutParams(0,0, 0.67f));
                mLlForRegisterYourSelf.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.67f));
                mBtForRegisterYourSelf.setVisibility(View.VISIBLE);
                break;
            case R.id.need_help:
                mBtForNeedHelp.setVisibility(View.VISIBLE);
                mLlForRegisterYourSelf.setLayoutParams(new LinearLayout.LayoutParams(0,0, 0.67f));
                mBtForNeedHelp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.67f));

                break;
            case R.id.bt_for_registration_your_self:
                intent = new Intent(PassportExecutionActivity.this,RegisterYourselfActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_for_need_help:
//                intent = new Intent(PassportExecutionActivity.this,ObtainingForeignPassport.class);
//                startActivity(intent);
                Toast.makeText(PassportExecutionActivity.this,"button click",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}