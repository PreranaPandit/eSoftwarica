package com.example.esoftwarica.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.NavActivity;
import com.example.esoftwarica.R;
import com.example.esoftwarica.Students;

public class DashboardFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private DashboardViewModel dashboardViewModel;
    private String fullName, gender, address;
    private int age;
    private EditText etFullName, etAddress, etAge;
    private RadioGroup rdGroup;
    private Button btnAdd;

    public static DashboardFragment newInstance()
    {
        return new DashboardFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        etFullName = root.findViewById(R.id.etFullName);
        etAddress = root.findViewById(R.id.etAddress);
        etAge = root.findViewById(R.id.etAge);
        rdGroup = root.findViewById(R.id.radioGroup);
        btnAdd = root.findViewById(R.id.btnSave);

        rdGroup.setOnCheckedChangeListener(this);
        btnAdd.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnSave)
        {

            if(validate())
            {
                NavActivity.students.add(new Students(fullName,age,address,gender));
                Toast.makeText(getContext(),"Students added successfully", Toast.LENGTH_SHORT).show();
                etFullName.setText("");
                etAge.setText("");
                etAddress.setText("");
                rdGroup.clearCheck();

            }



        }
    }

    private boolean validate() {
        fullName = etFullName.getText().toString();
        age=Integer.parseInt(etAge.getText().toString());
        address=etAddress.getText().toString();
        if(TextUtils.isEmpty(fullName))
        {
            etFullName.setError("Please enter full name");
            etFullName.requestFocus();
            return false;
        }
//        if(TextUtils.isEmpty(age))
//        {
//            etAge.setError("Please enter age");
//            etAge.requestFocus();
//            return false;
//        }
//
//        if(!TextUtils.isDigitsOnly(age))
//        {
//            editTextAge.setError("Please enter age");
//            editTextAge.requestFocus();
//            return false;
//        }

        if(TextUtils.isEmpty(address))
        {
            etAddress.setError("Please enter an address");
            etAddress.requestFocus();
            return false;
        }



        if(TextUtils.isEmpty(gender))
        {
            Toast.makeText(getContext(), "Please select a gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId== R.id.radioMale)
        {
            gender="Male";
        }
        if(checkedId == R.id.radioFemale)
        {
            gender = "Female";
        }
        if(checkedId== R.id.radioOthers)
        {
            gender ="Others";
        }

    }
}