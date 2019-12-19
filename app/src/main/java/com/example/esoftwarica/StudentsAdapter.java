package com.example.esoftwarica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>{

    Context mContext;
    List<Students> studentsList = new ArrayList<>();

    //constructor, to receive data from activity


    public StudentsAdapter(Context mContext, List<Students> studentsList) {
        this.mContext = mContext;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_details,parent,false);

        StudentsViewHolder studentsViewHolder = new StudentsViewHolder(view);
        return studentsViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, final int position) {

        final Students students = studentsList.get(position);
        //holder.imgProfile.setImageResource(students.getImgProfile());
        holder.tvName.setText(students.getName());
        holder.tvAge.setText(String.valueOf(students.getAge()));
        holder.tvAddress.setText(students.getAddress());
        holder.tvGender.setText(students.getGender());
       // holder.imgBtnDel.setImageResource(students.getImgBtnDel());

        String gender = students.getGender();

        if(gender == "Male")
        {
            holder.imgProfile.setImageResource(R.drawable.man);
        }
        else if(gender == "Female")
        {
            holder.imgProfile.setImageResource(R.drawable.female);
        }
        else {
            holder.imgProfile.setImageResource(R.drawable.others);
        }


        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Hello " + students.getName(),Toast.LENGTH_LONG).show();
            }
        });
        holder.imgBtnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Students removedItems = studentsList.get(position);

                //removes item from the list
                studentsList.remove(position);
                //notify adapter about removal of item
                notifyItemRemoved(position);

                notifyItemRangeChanged(position,studentsList.size());

                //message in toast
                Toast.makeText(mContext,students.getName()+"deleted successfully", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgProfile;
        TextView tvName, tvAge, tvAddress, tvGender;
        ImageButton imgBtnDel;


        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvGender = itemView.findViewById(R.id.tvGender);
            imgBtnDel = itemView.findViewById(R.id.imgBtnDel);


        }
    }
}
