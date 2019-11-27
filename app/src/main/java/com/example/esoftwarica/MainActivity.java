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
        studentsList.add(new Students("Prerana Pandit",23,"Bhotebahal","Female",R.drawable.female,R.drawable.delete));
        studentsList.add(new Students("Ram Prajapati",25,"Kalanki","Male",R.drawable.male,R.drawable.delete));
        studentsList.add(new Students("Swaraj Giri",28,"Dillibazar","Others",R.drawable.others,R.drawable.delete));

        StudentsAdpater studentsAdpater = new StudentsAdpater(this, studentsList);
        recyclerView.setAdapter(studentsAdpater);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
