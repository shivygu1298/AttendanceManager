package com.example.shivamgupta.attendancemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class SubjectDetails extends AppCompatActivity {
    EditText etSubjectName;
    EditText etBunkedClasses;
    EditText etTotalClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        etSubjectName = findViewById(R.id.etSubName);

        etBunkedClasses = findViewById(R.id.etBunkedClasses);

        etTotalClasses = findViewById(R.id.etTotalClasses);

        Button btnDone = findViewById(R.id.btnDone);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SubjectName = etSubjectName.getText().toString();
                float BunkedClasses = Float.valueOf(etBunkedClasses.getText().toString());
                float TotalClasses = Float.valueOf(etTotalClasses.getText().toString());

                Intent i = new Intent(SubjectDetails.this , MainPage.class );
//                i.putExtra("subjectname" , SubjectName);
//                i.putExtra("bunkedclasses" , BunkedClasses);
//                i.putExtra("totalclasses" , TotalClasses);
                float percentage = ((TotalClasses-BunkedClasses)/TotalClasses)*100;
                Log.d("lola", "onClick: " + percentage);

                subjects currentSubject = new subjects(SubjectName ,percentage);
                MainPage.subjectList.add(currentSubject);
                startActivity(i);
            }
        });
    }
}
