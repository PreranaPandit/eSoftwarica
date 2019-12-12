package com.example.esoftwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.R;
import com.example.esoftwarica.Students;
import com.example.esoftwarica.StudentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        recyclerView = root.findViewById(R.id.recyclerView);

        //creating a list of students to display in recycler view

        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students("Martin Loius",23,"Pokhara","Male",R.drawable.man,R.drawable.delete));
        studentsList.add(new Students("Tim John",25,"Biratnagar","Female",R.drawable.female,R.drawable.delete));
        studentsList.add(new Students("Charley Crooke",28,"Rajbiraj","Others",R.drawable.others,R.drawable.delete));

        StudentsAdapter studentsAdapter = new StudentsAdapter(studentsList);
        recyclerView.setAdapter(studentsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }
}