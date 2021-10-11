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
    TextView calendar,Support,Profile, days,date , newdate;
    String end = new String();
    MyDbHandler db= new MyDbHandler(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Profile = findViewById(R.id.Profile);
        newdate = findViewById(R.id.newdate);
        Support = findViewById(R.id.Support);
        date=findViewById(R.id.date);
        calendar = findViewById(R.id.Calendar);
        days= findViewById(R.id.days);
        end = db.nextDate();
        Calendar c= Calendar.getInstance();
        String currdate= DateFormat.getDateInstance().format(c.getTime());
        date.setText(end);
        int length = calculatedays(currdate,end);
        String set = String.valueOf(length);
        days.setText(set + " days to go");

        newdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Updates.class);
                startActivity(intent);
            }
        });

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

    int calculatedays(String start , String end)
    {
        int duration;
        String sub= new String(),sub1= new String();
        int i=0,j=0;

        while(start.charAt(i)!=' ')
        {
            sub+=String.valueOf(start.charAt(i));
            i++;
        }
        i++;
        while(end.charAt(j)!=' ')
        {
            sub1+=String.valueOf(end.charAt(j));
            j++;
        }
        j++;
        int date= Integer.valueOf(sub);
        sub=new String();
        int date1=Integer.valueOf(sub1);
        sub1=new String();
        while(start.charAt(i)!=' ')
        {
            sub+=String.valueOf(start.charAt(i));
            i++;
        }
        while(end.charAt(j)!=' ')
        {
            sub1+=String.valueOf(end.charAt(j));
            j++;
        }

        if(sub.equals("Jan"))
            sub="1";
        else if(sub.equals("Feb"))
            sub="2";
        else if(sub.equals("Mar"))
            sub="3";
        else if(sub.equals("Apr"))
            sub="4";
        else if(sub.equals("May"))
            sub="5";
        else if(sub.equals("Jun"))
            sub="6";
        else if(sub.equals("Jul"))
            sub="7";
        else if(sub.equals("Aug"))
            sub="8";
        else if(sub.equals("Sep"))
            sub="9";
        else if(sub.equals("Oct"))
            sub="10";
        else if(sub.equals("Nov"))
            sub="11";
        else
            sub="12";

        if(sub1.equals("Jan"))
            sub1="1";
        else if(sub1.equals("Feb"))
            sub1="2";
        else if(sub1.equals("Mar"))
            sub1="3";
        else if(sub1.equals("Apr"))
            sub1="4";
        else if(sub1.equals("May"))
            sub1="5";
        else if(sub1.equals("Jun"))
            sub1="6";
        else if(sub1.equals("Jul"))
            sub1="7";
        else if(sub1.equals("Aug"))
            sub1="8";
        else if(sub1.equals("Sep"))
            sub1="9";
        else if(sub1.equals("Oct"))
            sub1="10";
        else if(sub1.equals("Nov"))
            sub1="11";
        else
            sub1="12";
        int month1=Integer.valueOf(sub1);
        int month = Integer.valueOf(sub);

        int datediff=date1-date;
        int monthdiff=month1-month;
        if(monthdiff!=0)
        {
            if(month==4||month==6||month==8||month==10)
            {
                duration = 30-date+date1+1;
            }
            else if(month==2)
            {
                duration = 28- date +date1 + 1;
            }
            else
                duration = 31- date + date1+1;
        }

        else{
            duration = date1-date;
        }


        return duration;
    }
}

