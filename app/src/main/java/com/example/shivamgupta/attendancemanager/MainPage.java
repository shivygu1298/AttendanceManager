package com.example.shivamgupta.attendancemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
      ListView lvList;
      static ArrayList<subjects> subjectList = new ArrayList<>();
      attendanceAdapter attendanceAdapter = new attendanceAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button btnAdd = findViewById(R.id.btnAdd);
        lvList = findViewById(R.id.lvItems);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage.this, SubjectDetails.class);
                startActivity(i);

            }
        });

        subjects currentSubject;
        lvList.setAdapter(attendanceAdapter);
        attendanceAdapter.notifyDataSetChanged();

        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
//        String subjectName = get3Intent().getStringExtra("subjectname");
//        String bunkedClasses = getIntent().getStringExtra("bunkedclasses");
//        String totalClasses = getIntent().getStringExtra("totalclasses");
//
//        int BunkedClasses = Integer.parseInt(bunkedClasses);
//        int TotalClasses = Integer.parseInt(totalClasses);
//        Float percentage = Float.valueOf((TotalClasses - BunkedClasses)/TotalClasses);
//
//        subjectList.add(new subjects(subjectName ,percentage));
//        lvList.setAdapter(attendanceAdapter);
//        attendanceAdapter.notifyDataSetChanged();
    }

    class attendanceAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return subjectList.size();
        }

        @Override
        public subjects getItem(int i) {
            return subjectList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater li = getLayoutInflater();
            view = li.inflate(R.layout.list_item , viewGroup , false);

            TextView tvSubName = view.findViewById(R.id.tvsubName);
            TextView tvPercentage = view.findViewById(R.id.tvPercentage);

            subjects thisSubject = getItem(i);

            tvSubName.setText(thisSubject.getSubjectName());
            tvPercentage.setText(thisSubject.getPercentage().toString());

            return view;

        }
    }
}
