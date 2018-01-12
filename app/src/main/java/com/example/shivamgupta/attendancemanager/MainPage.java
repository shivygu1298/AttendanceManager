package com.example.shivamgupta.attendancemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
      ListView lvList;

      static ArrayList<subjects> subjectList = new ArrayList<>();
      attendanceAdapter attendanceAdapter = new attendanceAdapter();
      static float tvPercentage = 0;
      static int tvtotalBunks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        TextView tvPercentageBunks = findViewById(R.id.tvpercentageBunks);
        TextView tvTotalBunks = findViewById(R.id.tvTotalBunks);

        Button btnAdd = findViewById(R.id.btnAdd);
        lvList = findViewById(R.id.lvItems);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage.this, SubjectDetails.class);
                startActivity(i);

            }
        });

        lvList.setAdapter(attendanceAdapter);
        attendanceAdapter.notifyDataSetChanged();
        tvTotalBunks.setText(tvtotalBunks + "");
        tvPercentageBunks.setText(tvPercentage + "");

        GraphView graph = findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {

                  new DataPoint(0,7),
                  new DataPoint(1, 5),
                  new DataPoint(2, 3),
                  new DataPoint(3, 2),
                  new DataPoint(4, 6)

        });
        graph.addSeries(series);


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
        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater li = getLayoutInflater();
            view = li.inflate(R.layout.list_item , viewGroup , false);

            TextView tvSubName = view.findViewById(R.id.tvsubName);
            TextView tvPercentage = view.findViewById(R.id.tvPercentage);

            final subjects thisSubject = getItem(i);

            tvSubName.setText(thisSubject.getSubjectName());
            tvPercentage.setText(thisSubject.getPercentage().toString());

            Button btnDelte = view.findViewById(R.id.btnDelete);
            btnDelte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    subjectList.remove(thisSubject);
                    lvList.setAdapter(attendanceAdapter);
                    attendanceAdapter.notifyDataSetChanged();
                }
            });

            Button btnUpdate = view.findViewById(R.id.btnUpdate);

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainPage.this, "List Item On Click Succesful", Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(MainPage.this, OnListItemCLick.class);
                j.putExtra("position" , i);
                    startActivity(j);
                }
            });

            return view;

        }
    }
}