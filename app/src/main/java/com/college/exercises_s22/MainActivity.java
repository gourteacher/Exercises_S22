package com.college.exercises_s22;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //now your xml is loaded
        TextView topView = findViewById(R.id.helloTextView); //must match XML id
        String oldText = topView.getText().toString();
        topView.setText("Java put this here");

        EditText bottom = findViewById(R.id.bottomtext);

        Button btn = findViewById(R.id.button);
        btn.setText("The view was previously "+ oldText); //on startup

        btn.setOnClickListener(new View.OnClickListener() { //anonymous class
            @Override
            public void onClick(View v) {
                topView.setText("Edit text has " + bottom.getText());
            }
        });

        /* Alternate version for button onClick method : Lambda function
        btn.setOnClickListener(  (  click ) ->
        {
            //when  you click
            //text is empty
            topView.setText("Edit text has " +  bottom.getText().toString());

        }   ); //OnCLickListener goes in here
        */


        ImageButton btn_img = findViewById(R.id.btn_image);
        //Done with Lambda function
        btn_img.setOnClickListener( vw -> topView.setText("You clicked on Image View") );
    }
}