package com.example.shecares;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shecares.data.MyDbHandler;
import com.example.shecares.model.DatesModel;

import java.util.Calendar;


public class Dtaes extends AppCompatActivity {


TextView btn , duration ,cycleLength;

//    MyDbHandler db =new MyDbHandler(Dtaes.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtaes);

        btn=findViewById(R.id.Add);
duration= findViewById(R.id.duration);
cycleLength =findViewById(R.id.cyclelength);
//if(db.getCount()>0) {
//    duration.setText(String.valueOf(db.averagePeriodLength()) + " days");
//    cycleLength.setText(String.valueOf(db.average()) + " days");
//}
btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent(Dtaes.this,Updates.class);
               startActivity(intent);
            }
        });



    }

}