package com.college.exercises_s22;



import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.ImageView;


public class SecondActivity extends AppCompatActivity {

    public final static String TAG ="SecondActivity";
    private ImageView imgv;
    private ActivityResultLauncher<Intent> myPictureTakerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myPictureTakerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult()
                ,new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            try {
                                Intent data = result.getData();
                                Bundle b = data.getExtras();
                                if (b != null) {
                                    Bitmap imgbitmap = (Bitmap) b.get("data");
                                    imgv.setImageBitmap(imgbitmap);
                                }
                            }
                            catch(Exception e){
                                e.printStackTrace();
                                Log.w(TAG, "Can't output PNG");
                            }
                        }
                        else if(result.getResultCode() == Activity.RESULT_CANCELED)
                            Log.i(TAG, "User refused to capture a picture.");
                    }
                } );

        Intent fromPrevious = getIntent();
        String input = fromPrevious.getStringExtra("USERINPUT"); //if "USERINPUT" is not found, return null
        int month = fromPrevious.getIntExtra("MONTH", 0); //if "MONTH" is not found, return 0
        double other = fromPrevious.getDoubleExtra("OTHER INFO", 0.0);//if "OTHERINFO" is not found, return 0.0

        Button cam = findViewById( R.id.start_camera);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    myPictureTakerLauncher.launch(takePictureIntent);
                }
            }
        });

        //Picture container
        imgv = findViewById( R.id.picture);

        Button term = findViewById( R.id.intent_return_button);
        term.setOnClickListener(  click ->  { finish(); } );
    }

}