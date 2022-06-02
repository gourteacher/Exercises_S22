package com.college.exercises_s22;



import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final float RATE_CAD_EURO = 0.70F;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

            String result = "" + String.format("%.2f", amount_euro) +  " euros";

            tv.setText(result);

        } else {
            tv.setTextColor(Color.RED);
            tv.setText(R.string.error_msg);

        }
    }


}
