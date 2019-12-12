package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //Data Binding
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogIn = findViewById(R.id.btnLogIn);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etEmail.getText().toString().equals("prerana@gmail.com") && etPassword.getText().toString().equals("admin"))
                {
                    Toast.makeText(getApplicationContext(),"LogIn successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogInActivity.this, NavActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid login, please check credentials again!!..",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
