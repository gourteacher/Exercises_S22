package com.college.exercises_s22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    static public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize a pool of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //Create all these threads
        for (int i=0; i < 15; i++ ) {
            final int threadNum = i;
            executorService.submit(new Thread(() -> {
                doSomething(threadNum);
            }));
        }

        //Shutdown the Executor Service
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    // Threads will all execute this
    private void doSomething(int num) {
        int j=0;
        while (j++ < 5) {
            Log.i(TAG, "Thread #" + num + "; Loop: " + j);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (Exception ex) {
                Log.w(TAG, "Exception in Thread #" + num);
            }
        }
    }
}