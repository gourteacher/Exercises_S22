package com.college.exercises_s22;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        View v = findViewById(R.id.my_rectangle);

        switch(id) {
            case R.id.red_id:
                v.setBackgroundColor(Color.RED);
                break;

            case R.id.blue_id:
                v.setBackgroundColor(Color.BLUE);
                break;

            case R.id.green_id:
                v.setBackgroundColor(Color.GREEN);
                break;

            case R.id.yellow_id:
                v.setBackgroundColor(Color.YELLOW);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

