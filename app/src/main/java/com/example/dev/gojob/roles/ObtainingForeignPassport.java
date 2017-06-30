package com.example.dev.gojob.roles;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dev.gojob.R;
import com.example.dev.gojob.maps.MapsActivity;


/**
 * Created by d1mys1klapo4ka on 03.06.2017.
 */

public class ObtainingForeignPassport extends AppCompatActivity implements View.OnClickListener {

    Button mListOfDocument;
    Button mNearestOvir;
    Button mCertificateOfCriminalRecord;
    Button mSynhroCalendarCloud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtaining_foreign_passport);

        mListOfDocument = (Button)findViewById(R.id.bt_list_of_documents);
        mNearestOvir = (Button)findViewById(R.id.bt_nearest_ovir);
        mCertificateOfCriminalRecord = (Button)findViewById(R.id.bt_certificate_of_criminal_record);
        mSynhroCalendarCloud = (Button)findViewById(R.id.bt_synhronize_calendar_cloud);

        mListOfDocument.setOnClickListener(this);
        mNearestOvir.setOnClickListener(this);
        mCertificateOfCriminalRecord.setOnClickListener(this);
        mSynhroCalendarCloud.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt_list_of_documents:
                Toast.makeText(ObtainingForeignPassport.this, "list_of_documents_and_payments", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_nearest_ovir:
                Intent intent = new Intent(ObtainingForeignPassport.this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_certificate_of_criminal_record:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.igov.org.ua/subcategory/1/1/situation/12"));
                startActivity(browserIntent);
//                Toast.makeText(ObtainingForeignPassport.this, "order_a_certificate_of_criminal_records", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_synhronize_calendar_cloud:
                Toast.makeText(ObtainingForeignPassport.this, "synchronization_calendar_cloud", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
