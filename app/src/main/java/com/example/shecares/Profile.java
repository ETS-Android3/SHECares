package com.example.shecares;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
import android.widget.Toast;

import com.example.shecares.data.MyDbHandler;

public class Profile extends AppCompatActivity {

    TextView feedback , nxtdate, cycleLength, periodLength, delete;
    EditText Feedback;
    MyDbHandler db= new MyDbHandler(Profile.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        feedback=findViewById(R.id.feedback);
        nxtdate=findViewById(R.id.nextdate);
        cycleLength=findViewById(R.id.cyclelength);
        periodLength=findViewById(R.id.periodlength);
        delete=findViewById(R.id.delete);
        Feedback=findViewById(R.id.review);
//     if(db.getCount() > 0) {
//    nxtdate.setText(String.valueOf(db.nextDate()));
//    periodLength.setText(String.valueOf(db.averagePeriodLength()));
//    cycleLength.setText(String.valueOf(db.average()));
//}


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteDatabase();
                Toast.makeText(Profile.this, "Profile Deleted Successfully!!", Toast.LENGTH_SHORT).show();
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        final AlertDialog.Builder dialog =new AlertDialog.Builder(this);
//        dialog.setTitle("Feedback Form");
//        dialog.setMessage("Provide Us Your Valuable Feedback");

        LayoutInflater inflater = LayoutInflater.from(this);
        View reg_layout = inflater.inflate(R.layout.feedback, null);
        dialog.setView(reg_layout);
        //set button
        dialog.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(Profile.this, "Feedback Recived!", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}