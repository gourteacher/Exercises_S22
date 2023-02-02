package com.college.exercises_s22.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.college.exercises_s22.R;
import com.college.exercises_s22.data.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        EditText editText = findViewById(R.id.input);
        TextView result = findViewById(R.id.result);
        Button compute = findViewById(R.id.compute);
        result.setText(model.editString );

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.editString = editText.getText().toString();
                result.setText(model.editString );
            }
        });

    }
}