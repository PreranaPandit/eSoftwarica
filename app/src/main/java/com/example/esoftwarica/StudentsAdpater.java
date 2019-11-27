package com.example.esoftwarica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsAdpater extends RecyclerView.Adapter<StudentsAdpater.StudentsViewHolder>{


    Context mContext;
    List<Students> studentsList;

    //Constructor, to receive data from the activity


    public StudentsAdpater(Context mContext, List<Students> studentsList) {
        this.mContext = mContext;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout,parent,false);
       return  new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {

        Students students = studentsList.get(position);
        holder.genderImage.setImageResource(students.getImageGender());
        holder.delImage.setImageResource(students.getImageDelete());
        holder.tvName.setText(students.getName());
       holder.tvAge.setText(Integer.toString(students.getAge()));
        holder.tvAddrees.setText(students.getAddress());
        holder.tvGender.setText(students.getGender());
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder{

        ImageView genderImage, delImage;
        TextView tvName, tvAge, tvAddrees, tvGender;

        public StudentsViewHolder(View view)
        {
            super(view);

            genderImage = view.findViewById(R.id.genderImage);
            delImage = view.findViewById(R.id.delImage);
            tvName = view.findViewById(R.id.tvName);
            tvAge = view.findViewById(R.id.tvAge);
            tvAddrees = view.findViewById(R.id.tvAddress);
            tvGender = view.findViewById(R.id.tvGender);
        }
    }

}
