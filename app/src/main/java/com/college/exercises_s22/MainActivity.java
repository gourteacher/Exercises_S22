package com.college.exercises_s22;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.college.exercises_s22.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = AppDatabase.getInstance(this);

        binding.btnSave.setOnClickListener(v -> {
            saveData();
        });

        binding.btnClear.setOnClickListener( v -> {
            clearData();
        });

        binding.btnList.setOnClickListener( v -> {
            listData();
        });
    }


    private void saveData() {
        String lastname = binding.lnameEdit.getText().toString();
        String firstname = binding.fnameEdit.getText().toString();
        new Thread(() -> {
            Person person = new Person(lastname, firstname);
            PersonDAO dao = db.getPersonDAO();
            dao.insertPerson(person);
            List<Person> people = dao.listPeople();
            for(Person p:people) {
                System.out.printf("%s, %s\n", p.last_name, p.first_name );
            }
        }).start();
    }

    private void  clearData() {
        binding.lnameEdit.setText("");
        binding.fnameEdit.setText("");
    }

    private void listData() {
        new Thread(() -> {
            PersonDAO dao = db.getPersonDAO();
            List<Person> people = dao.listPeople();
            for(Person p:people) {
                System.out.printf("%s, %s\n", p.last_name, p.first_name );
            }
        }).start();
    }
}

