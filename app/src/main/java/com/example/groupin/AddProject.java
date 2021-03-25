package com.example.groupin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddProject extends AppCompatActivity {

    EditText p_name,p_start, p_due;
    Button add_project_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        Spinner statusSpinner= findViewById(R.id.pstatus);
        ArrayAdapter <String> myAdapter = new ArrayAdapter<>(AddProject.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.statusOpt));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(myAdapter);

        p_name = findViewById(R.id.enter_name);
        p_start = findViewById(R.id.enter_pstart);
        p_due = findViewById(R.id.enter_pdue);
        add_project_btn = findViewById(R.id.add_p);
        String pstatus = statusSpinner.getSelectedItem().toString();

        add_project_btn.setOnClickListener(view -> {
            DBHelper myDB = new DBHelper(AddProject.this);
            myDB.addProject(p_name.getText().toString().trim(),p_start.getText().toString().trim(),p_due.getText().toString().trim(), pstatus);
        });
    }
}