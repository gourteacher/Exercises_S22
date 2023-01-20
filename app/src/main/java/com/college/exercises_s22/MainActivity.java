package com.college.exercises_s22;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear); //shows the layout

        TextView myText = findViewById(R.id.text);//brings the textView from XML to Java
        myText.setText(R.string.hello_world);//nullPointer Exception

        EditText myEdit = findViewById(R.id.edit);
        RadioButton myCb = findViewById(R.id.myCb);

        Button myBtn = findViewById(R.id.btn);
        myBtn.setOnClickListener((vw) -> {
            myText.setText(R.string.button_clicked);
            myCb.setChecked(false);
            // Toast.makeText(MainActivity.this, " ",Toast.LENGTH_LONG).show();
            Snackbar.make(myText, R.string.snackbar_message, Snackbar.LENGTH_LONG).show();
        });

        ImageButton myImgBtn = findViewById(R.id.imgView);
        myImgBtn.setOnClickListener((view) -> myEdit.setText(R.string.image_clicked));

        myCb.setOnCheckedChangeListener((btnView, onOrOff)-> {
            myBtn.setText(onOrOff?R.string.box_on : R.string.box_off);

        });
    }
}