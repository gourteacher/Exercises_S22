package com.college.exercises_s22;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends Activity {
  private TextView dateAndTimeLabel;
  private Calendar dateAndTime=Calendar.getInstance();
      
  @Override
  public void onCreate(Bundle state) {
    super.onCreate(state);
    setContentView(R.layout.activity_main);
    
    dateAndTimeLabel = findViewById(R.id.dateAndTime);
    
    updateLabel();

    Button btnDate = findViewById(R.id.dateBtn);
    btnDate.setOnClickListener(v -> chooseDate(v));

    Button btnTime = findViewById(R.id.timeBtn);
    btnTime.setOnClickListener(v -> chooseTime(v));
  }
  
  public void chooseDate(View v) {
    new DatePickerDialog(this, d,
                          dateAndTime.get(Calendar.YEAR),
                          dateAndTime.get(Calendar.MONTH),
                          dateAndTime.get(Calendar.DAY_OF_MONTH))
      .show();
  }
  
  public void chooseTime(View v) {
    new TimePickerDialog(this, t,
                          dateAndTime.get(Calendar.HOUR_OF_DAY),
                          dateAndTime.get(Calendar.MINUTE),
                          true)
      .show();
  }
  
  private void updateLabel() {
    dateAndTimeLabel
      .setText(DateUtils
                 .formatDateTime(this,
                                 dateAndTime.getTimeInMillis(),
                                 DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_SHOW_TIME));
  }
  
  DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
      dateAndTime.set(Calendar.YEAR, year);
      dateAndTime.set(Calendar.MONTH, monthOfYear);
      dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
      updateLabel();
    }
  };
  
  TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int hourOfDay,
                          int minute) {
      dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
      dateAndTime.set(Calendar.MINUTE, minute);
      updateLabel();
    }
  };

}
