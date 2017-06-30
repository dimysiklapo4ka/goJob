package com.example.dev.gojob.vacancy.rolesRoma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dev.gojob.R;

public class TypeOfVisaActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtForVisaD05;
    Button mBtForVisaD07;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of_viza);

        mBtForVisaD05 = (Button)findViewById(R.id.bt_for_visa_d_05);
        mBtForVisaD05.setOnClickListener(this);
        mBtForVisaD07 = (Button)findViewById(R.id.bt_for_visa_d_07);
        mBtForVisaD07.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.bt_for_visa_d_05:
                intent = new Intent(this, VisaD05Activity.class);
                startActivity(intent);
                break;
            case R.id.bt_for_visa_d_07:
                intent = new Intent(this, VisaD05Activity.class);
                startActivity(intent);
//                Toast.makeText(this, "VisaD07Activity will be implemented in the future", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}





//package com.example.roman.epic1;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class TypeOfVisaActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_type_of_visa);
//    }
//}
