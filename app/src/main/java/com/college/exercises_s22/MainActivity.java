package com.college.exercises_s22;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initData();

        TextView tvInfo = findViewById(R.id.textview);

        //Method #1
        //tvInfo.setText("There are " + userList.size()  + " in file " + fileName);
/*
        //Method #2
        String numUsers = getResources().getString(R.string.numUsers);
        String getNumUsers = String.format(numUsers, userList.size(), fileName);
        tvInfo.setText(getNumUsers);
 */

        //Method #3
        String itemName = "user_data";
        tvInfo.setText(getString(R.string.numUsers, userList.size(), itemName));

    }

    private void initData() {
        for (int i=0; i < 5; i++) {
            userList.add("Item #" + i);
        }
    }

}