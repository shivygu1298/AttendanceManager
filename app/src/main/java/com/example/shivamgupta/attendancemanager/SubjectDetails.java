package com.example.shivamgupta.attendancemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubjectDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        final EditText etSubjectName = findViewById(R.id.etSubName);
        final EditText etBunkedClasses = findViewById(R.id.etBunkedClasses);
        final EditText etTotalClasses = findViewById(R.id.etTotalClasses);

        Button btnDone = findViewById(R.id.btnDone);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SubjectName = etSubjectName.getText().toString();
                String BunkedClasses = etBunkedClasses.getText().toString();
                String TotalClasses = etTotalClasses.getText().toString();

                Intent i = new Intent(SubjectDetails.this , MainPage.class );
                i.putExtra("subjectname" , SubjectName);
                i.putExtra("bunkedclasses" , BunkedClasses);
                i.putExtra("totalclasses" , TotalClasses);
                startActivity(i);
            }
        });
    }
}
