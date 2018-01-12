package com.example.shivamgupta.attendancemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OnListItemCLick extends AppCompatActivity {

    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_list_item_click);

        Button btnIncrease = findViewById(R.id.btnIncrease);
        Button btnDecrease = findViewById(R.id.btnDecrease);

        tvDisplay = findViewById(R.id.tvDisplay);

        int position = getIntent().getIntExtra("position" , 0);
        final subjects thisSubject = MainPage.subjectList.get(position);
        tvDisplay.setText(thisSubject.getTotalClasses() + "");

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float totalClasses = thisSubject.getTotalClasses();
                totalClasses++;
                thisSubject.setTotalClasses(totalClasses);
                tvDisplay.setText(thisSubject.getTotalClasses() + "");
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OnListItemCLick.this , MainPage.class);
                startActivity(i);
            }
        });

    }
}
