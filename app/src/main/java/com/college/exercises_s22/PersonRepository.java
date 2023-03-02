package com.college.exercises_s22;

import android.content.Context;

public class PersonRepository {
    static PersonRepository sInstance;

    private PersonRepository(Context ctx) {}

    public PersonRepository getInstance(Context ctx) {
        if (sInstance != null) {
            sInstance = new PersonRepository (ctx);
        }
        return sInstance;
    }
}
