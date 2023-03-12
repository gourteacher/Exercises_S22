package com.college.exercises_s22;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static private final String TAG =  MainActivity.class.getSimpleName();
    private TextView tv_entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_entries = findViewById(R.id.textViewEntries);

        //Read a JSON file
        Button btnFile = findViewById(R.id.btnReadJsonFile);
        btnFile.setOnClickListener(v -> {

            ArrayList<SecretAgent> myList = readData( "data.json");

            for (SecretAgent sa: myList) {
                Log.i(TAG, sa.toString());
            }
            tv_entries.setText( String.valueOf(myList.size()) );
        });
    }

    // Deserialize a list of states from a file in JSON format
    public ArrayList<SecretAgent> readData(String fileName){

        final ArrayList<SecretAgent> mylist = new ArrayList<>();

        try {
            // load the data in an ArrayList
            String jsonString     = MyFileReader.readJson(this, fileName);
            JSONObject json       = new JSONObject(jsonString);
            JSONArray items = json.getJSONArray("squadmembers");

            // Loop through the list in the json array
            for(int i = 0; i < items.length(); i++){

                String name = items.getJSONObject(i).getString("name");

                int age = items.getJSONObject(i).getInt ("age");

                String si = items.getJSONObject(i).getString("secretIdentity");

                SecretAgent sa = new SecretAgent(name, age, si);

                mylist.add(sa);
            }
        } catch (JSONException e) {
            // Log the error
            e.printStackTrace();
        }
        return mylist;
    }

    public void clear(View v) {
        tv_entries.setText("");
    }
}