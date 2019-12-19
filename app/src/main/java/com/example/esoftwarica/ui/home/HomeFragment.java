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

import com.example.esoftwarica.NavActivity;
import com.example.esoftwarica.R;
import com.example.esoftwarica.Students;
import com.example.esoftwarica.StudentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    List<Students> students = new ArrayList<>();

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
        if(NavActivity.students.isEmpty()) {
            NavActivity.students.add(new Students("Prerana Pandit", 22, "Bhotebahal", "Female"));
            NavActivity.students.add(new Students("John Dengard", 20, "Lumbini", "Male"));
            NavActivity.students.add(new Students("James Rian", 2, "Chitwan", "Others"));

            StudentsAdapter adapter = new StudentsAdapter(getContext(), NavActivity.students);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }else {

            StudentsAdapter adapter2 = new StudentsAdapter(getContext(), NavActivity.students);

            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager2);
            recyclerView.setAdapter(adapter2);
        }
        return root;
    }
}