package com.college.exercises_s22;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);

        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(v -> {
            saveData();
        });
    }


    private void saveData() {
        final String mlastname = ((TextView) findViewById(R.id.lname_edit)).getText().toString();
        final String mfirstname = ((TextView) findViewById(R.id.fname_edit)).getText().toString();
        new Thread(() -> {
            Person person = new Person(mlastname, mfirstname);
            PersonDAO dao = db.getPersonDAO();
            dao.insertPerson(person);
            List<Person> people = dao.listPeople();
            for(Person p:people) {
                System.out.printf("%s, %s\n", p.last_name, p.first_name );
            }
        }).start();
    }
}

