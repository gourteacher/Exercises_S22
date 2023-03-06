package com.college.exercises_s22;


import android.graphics.Bitmap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.college.exercises_s22.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;import java.net.URLEncoder;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private final String MY_KEY = "YOUR_KEY_HERE"; //Replace it with your own key
    private final String URL_REQUEST_IMG = "https://openweathermap.org/img/w/";
    private final String URL_REQUEST_DATA = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String URL_API_PARAM = "&appid=" + MY_KEY +  "&units=metric";

    protected String cityName;
    protected RequestQueue queue = null;
    private  String iconName = null;
    private  ImageRequest imgReq;
    private  Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        queue = Volley.newRequestQueue(this);
        ActivityMainBinding binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView(binding.getRoot());

        binding.forecastButton.setOnClickListener(click -> {
            cityName = binding.editText.getText().toString();

            try {
                if (!cityName.isEmpty()) {

                    String url = URL_REQUEST_DATA + URLEncoder.encode(cityName, "UTF-8") + URL_API_PARAM;

                    //this goes in the button click handler:
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                            (response) -> {
                                try {
                                    JSONObject coord = response.getJSONObject("coord");
                                    JSONArray weatherArray = response.getJSONArray("weather");
                                    JSONObject position0 = weatherArray.getJSONObject(0);
                                    iconName = weatherArray.getJSONObject(0).getString("icon");
                                    String description = position0.getString("description");

                                    JSONObject mainObject = response.getJSONObject("main");
                                    double current = mainObject.getDouble("temp");
                                    double min = mainObject.getDouble("temp_min");
                                    double max = mainObject.getDouble("temp_max");
                                    int humidity = mainObject.getInt("humidity");

                                    imgReq = new ImageRequest(URL_REQUEST_IMG + iconName + ".png", bitmap -> {
                                        image = bitmap;
                                        binding.imageView.setImageBitmap(image);
                                    }, 1024, 1024, ImageView.ScaleType.CENTER, null, (error) -> {
                                    });
                                    queue.add(imgReq);

                                    binding.tvDescription.setText(description);
                                    binding.tvCurrentVal.setText(String.format(Locale.CANADA, "%.1f°", current));
                                    binding.tvMinVal.setText(String.format(Locale.CANADA, "%.1f°", min));
                                    binding.tvMaxVal.setText(String.format(Locale.CANADA, "%.1f°", max));

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            },
                            (error) -> {
                                Log.e(TAG, "error");
                            });
                    queue.add(request);
                } else {
                    Snackbar.make(click, R.string.error_msg, Snackbar.LENGTH_SHORT).show();
                }
            }
            catch (Exception e) {
                Log.e(TAG, "error encoding city name");
            }
        });
    }
}