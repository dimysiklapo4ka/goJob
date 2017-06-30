package com.example.dev.gojob.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.dev.gojob.R;
import com.example.dev.gojob.helpers.Check;
import com.example.dev.gojob.roles.RolesActivity;

import java.util.ArrayList;



public class RegistrationActivity extends AppCompatActivity {

    ArrayList<EditText> info = new ArrayList<>();
    Check check = new Check();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        info.add((EditText) findViewById(R.id.et_surname));
        info.add((EditText) findViewById(R.id.et_name));
        info.add((EditText) findViewById(R.id.et_patronymic));
        info.add((EditText) findViewById(R.id.et_phone));
        info.add((EditText) findViewById(R.id.et_new_email));
        info.add((EditText) findViewById(R.id.et_new_password));
        info.add((EditText) findViewById(R.id.et_new_repassword));
    }

    public void signUp(View view){
        if(!check.checkEmail(info.get(4).getText().toString()) ||
                !check.checkPasword(info.get(5).getText().toString()) ||
                !check.checkPassword(info.get(5).getText().toString(), info.get(6).getText().toString())){
            dialogInvalidData().show();
        } else {
            Intent intent = new Intent(RegistrationActivity.this, RolesActivity.class);
            startActivity(intent);
        }
    }

    private AlertDialog dialogInvalidData(){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
        builder.setTitle("Registration")
                .setMessage(R.string.invalid_data_message)
                .setCancelable(false)
                .setNegativeButton(R.string.invalid_data_button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        return builder.create();
    }



}
