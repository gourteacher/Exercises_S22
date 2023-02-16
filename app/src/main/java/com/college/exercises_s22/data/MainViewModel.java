package com.college.exercises_s22.data;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private String resultString;

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String in) {
        resultString = in;
    }
}
