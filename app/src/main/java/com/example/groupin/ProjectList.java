package com.example.groupin;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.util.List;

public class ProjectList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvProjects;
    String[] projects;
    Button newProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        newProject = (Button) findViewById(R.id.newProjBut);
        lvProjects = findViewById(R.id.lvProject);
        projects = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, projects);
        lvProjects.setAdapter(monthAdapter);
        lvProjects.setOnItemClickListener(this);


        newProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(ProjectList.this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){

                    //showImageChooser(ProjectList.this);
                }
            }
        });
    }
    /*public void showImageChooser(Activity activity){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(galleryIntent,2);
    }*/

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String project = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), "Clicked: " + project, Toast.LENGTH_SHORT).show();
    }


}