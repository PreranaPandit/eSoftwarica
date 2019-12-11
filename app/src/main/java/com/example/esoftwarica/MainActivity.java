package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //creating a list of students to display in recycler view

        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students("Martin Loius",23,"Pokhara","Male",R.drawable.man,R.drawable.delete));
        studentsList.add(new Students("Tim John",25,"Biratnagar","Female",R.drawable.female,R.drawable.delete));
        studentsList.add(new Students("Charley Crooke",28,"Rajbiraj","Others",R.drawable.others,R.drawable.delete));

        StudentsAdapter studentsAdapter = new StudentsAdapter(this, studentsList);
        recyclerView.setAdapter(studentsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
