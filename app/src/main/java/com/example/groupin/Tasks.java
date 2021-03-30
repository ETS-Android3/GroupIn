package com.example.groupin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
public class Tasks extends AppCompatActivity {
    String recPid;
    RecyclerView rctView;
    ArrayList<modelTask> datahold;
    FloatingActionButton fbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        fbt = findViewById(R.id.add_t);

        recPid =getIntent().getStringExtra("pid");

        rctView=findViewById(R.id.rctView);
        rctView.setLayoutManager(new LinearLayoutManager(this));

        fbt.setOnClickListener(v -> {
            Intent intent = new Intent(Tasks.this, AddTask.class);
            intent.putExtra("pid",recPid);
            startActivity(intent);
        });

        Cursor cursor = new DBHelper(this).readallTasks(recPid);
        datahold=new ArrayList<>();

        while(cursor.moveToNext())
        {
            modelTask obj = new modelTask(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            datahold.add(obj);
        }

        myAdapterTask adapter=new myAdapterTask(datahold,getApplicationContext());
        rctView.setAdapter(adapter);
    }
}