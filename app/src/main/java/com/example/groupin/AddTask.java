package com.example.groupin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {

    EditText task_name,task_due,task_member;
    Spinner tstatusSpinner;
    Button btn_task;
    int projectid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        tstatusSpinner= findViewById(R.id.enter_tstatus);
        ArrayAdapter<String> tchoose = new ArrayAdapter<>(AddTask.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.statusOpt));
        tchoose.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tstatusSpinner.setAdapter(tchoose);
        String task_status = tstatusSpinner.getSelectedItem().toString();

        projectid=Integer.parseInt( getIntent().getStringExtra("pid"));
        task_name = findViewById(R.id.enter_name);
        task_due = findViewById(R.id.enter_tend);
        task_member = findViewById(R.id.enter_tmem);
        btn_task = findViewById(R.id.add_task);

        btn_task.setOnClickListener(view -> {
            DBHelper myDB = new DBHelper(AddTask.this);
            String res=myDB.addTask(task_name.getText().toString().trim(),task_due.getText().toString().trim(),task_member.getText().toString().trim(), task_status,projectid);
            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddTask.this, Tasks.class);
            intent.putExtra("pid",projectid);
            startActivity(intent);
        });

    }
}