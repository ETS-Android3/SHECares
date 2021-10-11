package com.example.shecares;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shecares.data.MyDbHandler;
import com.example.shecares.model.DatesModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Dtaes extends AppCompatActivity {


TextView btn , duration ,cycleLength;

    MyDbHandler db =new MyDbHandler(Dtaes.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtaes);

        btn=findViewById(R.id.Add);
duration= findViewById(R.id.duration);
cycleLength =findViewById(R.id.cyclelength);
ListView listview  = findViewById(R.id.listview);

//if(db.getCount()>0) {
    duration.setText(String.valueOf(db.averagePeriodLength()) + " days");
    cycleLength.setText(String.valueOf(db.average()) + " days");
//}
        ArrayList<DatesModel> datesModelArrayList=db.getAllData();
        int s=datesModelArrayList.size();
        ArrayList<String> dates=new ArrayList<>();
        ArrayList<String> dur=new ArrayList<>();
        ArrayList<String> cycle=new ArrayList<>();

        for(int i=0; i<s; i++){
            dates.add(datesModelArrayList.get(i).getStart()+" - "+datesModelArrayList.get(i).getEnd());
            dur.add(datesModelArrayList.get(i).getDuration()+" Days");
            cycle.add(datesModelArrayList.get(i).getCycle()+" Days");
        }

        MyAdapter adapter = new MyAdapter(this, dates, dur , cycle);
        listview.setAdapter(adapter);


btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent(Dtaes.this,Updates.class);
               startActivity(intent);
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList<String> dates = new ArrayList<String>();
        ArrayList<String> dur =new ArrayList<String>();
        ArrayList<String> cycle =new ArrayList<String>();
        MyAdapter(Context c, ArrayList<String> ds, ArrayList<String> dr , ArrayList<String> Cycle){
            super(c,R.layout.row,R.id.date_txt,ds);
            this.context=c;
            this.dates=ds;
            this.dur=dr;
            this.cycle=Cycle;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= layoutInflater.inflate(R.layout.row,parent,false);
            TextView textView = row.findViewById(R.id.date_txt);
            TextView textView1 = row.findViewById(R.id.dur_txt);
            TextView textview2 = row.findViewById(R.id.cycle_txt);
            String date = new String();
            String currdate = dates.get(position);
            int i=0;
            while(currdate.charAt(i)!=' ')
            {
                date+=String.valueOf(currdate.charAt(i));
                i++;
            }
            String temp =date;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.deleteDate(temp);
                }
            });
            textView.setText(dates.get(position));
            textView1.setText("Duration : " + dur.get(position));
            textview2.setText("CycleLength : " + cycle.get(position));
//            pb.setProgress(Integer.valueOf(dur.get(position)));
            return row;
        }
    }



}