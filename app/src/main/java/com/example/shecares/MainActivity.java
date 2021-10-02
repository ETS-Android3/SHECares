package com.example.shecares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shecares.data.MyDbHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ImageView profile,reminder,note;
    int year,month,day;
    TextView calendar,Support,Profile, days,date;
//    MyDbHandler db= new MyDbHandler(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Profile = findViewById(R.id.Profile);
        Support = findViewById(R.id.Support);
        date=findViewById(R.id.date);
        calendar = findViewById(R.id.Calendar);
        Calendar c= Calendar.getInstance();
        String currdate= DateFormat.getDateInstance().format(c.getTime());
        date.setText(currdate);
        Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Support.class);
                startActivity(intent);

            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dtaes.class);
                startActivity(intent);

            }
        });
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);

            }
        });

    }
}

