package com.example.groupin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProject extends AppCompatActivity {

    EditText p_name,p_start, p_due;
    Button add_project_btn;
    Spinner statusSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        statusSpinner= findViewById(R.id.pstatus);
        ArrayAdapter <String> choose = new ArrayAdapter<>(AddProject.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.statusOpt));
        choose.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(choose);
        String pstatus = statusSpinner.getSelectedItem().toString();

        p_name = findViewById(R.id.enter_name);
        p_start = findViewById(R.id.enter_pstart);
        p_due = findViewById(R.id.enter_pdue);
        add_project_btn = findViewById(R.id.add_p);


        add_project_btn.setOnClickListener(view -> {
            DBHelper myDB = new DBHelper(AddProject.this);
            String res=myDB.addProject(p_name.getText().toString().trim(),p_start.getText().toString().trim(),p_due.getText().toString().trim(), pstatus);
            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddProject.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}