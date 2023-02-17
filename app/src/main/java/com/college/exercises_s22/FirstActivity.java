package com.college.exercises_s22;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


//This makes it a page in your application
public class FirstActivity extends AppCompatActivity {

    static final String DATE_FORMAT = "yyyyMMdd_HHmmss";

    @Override
    public void onCreate(Bundle p){
        super.onCreate(p);

        //load XML:
        setContentView(R.layout.activity_first);

        Button submit = findViewById(R.id.submitButton);
        EditText edit = findViewById(R.id.editText);
        RecyclerView rView = findViewById(R.id.myRecycleView);

        ArrayList<Message> messages = new ArrayList<>();
        MessageRecyclerViewAdapter  theAdapter = new MessageRecyclerViewAdapter(messages, getApplicationContext());
        rView.setAdapter(theAdapter) ;
        rView.setLayoutManager(new LinearLayoutManager(this));
        //rView.setLayoutManager(new GridLayoutManager (this, 2) );

        submit.setOnClickListener( click ->{
            String whatIsTyped = edit.getText().toString();
            Date timeNow = new Date(); //when was this code run

            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
            String currentDateandTime = sdf.format( timeNow ); //convert date to String

            //adding a new message to our history if not empty
            if (!whatIsTyped.isEmpty()) {
                messages.add(new Message(whatIsTyped, currentDateandTime));
                edit.setText("");//clear the text
                //notify that new data was added at a row:
                theAdapter.notifyItemInserted(messages.size() - 1); //at the end of ArrayList,
            }
        });
    }
}