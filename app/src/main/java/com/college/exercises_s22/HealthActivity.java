package com.college.exercises_s22;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;


//This code has multiple run-time errors
// Fix them
// Then make it display properly the ListView
public class HealthActivity extends AppCompatActivity {

    ArrayList<String> people;
    ListView listview = findViewById(R.id.listView);
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        //Populate the ArrayList
        people.addAll(0, Arrays.asList(MyData.clientList));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, people);

    }
}