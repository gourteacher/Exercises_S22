package com.college.exercises_s22;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    //this is our starting point
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()
        setContentView( R.layout.activity_main ); //loads XML on screen

        CheckBox cb =  findViewById(R.id.check);
        RadioButton radio = findViewById(R.id.radio);
        SwitchCompat sw = findViewById(R.id.sw);

        sw.setOnCheckedChangeListener( ( btn, onOrOff) -> {
            radio.setChecked(onOrOff);
            Toast.makeText(MainActivity.this, R.string.switch_clicked, Toast.LENGTH_LONG).show();
        });

        cb.setOnCheckedChangeListener( ( b, on_off) -> {
            Toast.makeText(MainActivity.this, R.string.checkbox_clicked, Toast.LENGTH_SHORT).show();
            radio.setChecked(on_off);
        });

    }
}