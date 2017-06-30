package com.example.dev.gojob.roles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dev.gojob.R;
import com.example.dev.gojob.vacancy.activity.ValidVacancyActivity;


public class CurrentStatusActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtNoPass;
    Button mBtNoVisa;
    Button mBtNoWork;
    Button mBtIamAlreadyInPoland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_status);

        mBtNoPass = (Button) findViewById(R.id.bt_bt_list_of_documents);
        mBtNoPass.setOnClickListener(this);
        mBtNoVisa = (Button) findViewById(R.id.bt_I_do_not_have_work_visa);
        mBtNoVisa.setOnClickListener(this);
        mBtNoWork = (Button) findViewById(R.id.bt_I_have_no_job);
        mBtNoWork.setOnClickListener(this);
        mBtIamAlreadyInPoland = (Button) findViewById(R.id.bt_I_am_already_in_poland);
        mBtIamAlreadyInPoland.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.bt_bt_list_of_documents:
                intent = new Intent(CurrentStatusActivity.this, PassportExecutionActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_I_do_not_have_work_visa:
                intent = new Intent(CurrentStatusActivity.this, TypeOfVisaActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_I_have_no_job:
                intent = new Intent(CurrentStatusActivity.this, ValidVacancyActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_I_am_already_in_poland:
                Toast.makeText(this, "IamInPolandActivity will be implemented in the future", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
