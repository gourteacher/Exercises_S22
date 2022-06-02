package com.college.exercises_s22;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final float RATE_CAD_EURO = 0.70F;

    private static final String TAG = "MainActivity";

    private static final String KEY_RESULT = "saved_result";

    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate called");

        setContentView(R.layout.activity_main);
    }


    public void convertAmount(View v) {

        EditText edit = findViewById(R.id.amountId);

        TextView tv = findViewById(R.id.resultId);
        tv.setTextColor(Color.BLACK);

        String amount_str = edit.getText().toString(); // "11.6" != 11.6

        if (!amount_str.equals("")) {

            float amount_cad = Float.parseFloat(amount_str);

            float amount_euro = amount_cad * RATE_CAD_EURO;

            result = "" + String.format("%.2f", amount_euro) +  " euros";

            tv.setText(result);

        } else {
            tv.setTextColor(Color.RED);
            tv.setText(R.string.error_msg);

        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_RESULT, result); // outState { "saved_result"="12.5" }

        Log.i(TAG, "onSaveInstanceState called");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle outState) {
        super.onRestoreInstanceState(outState);

        result = outState.getString(KEY_RESULT);

        TextView tv = findViewById(R.id.resultId);

        tv.setText(result);
        Log.i(TAG, "onRestoreInstanceState called ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause called");
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume called");
    }

}
