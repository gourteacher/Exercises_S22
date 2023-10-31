package com.college.exercises_s22;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.college.exercises_s22.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.computeButton.setOnClickListener(c -> {
            String userInput = binding.userInputId.getText().toString();

            binding.resultTv.setText(userInput);
        });

    }
}