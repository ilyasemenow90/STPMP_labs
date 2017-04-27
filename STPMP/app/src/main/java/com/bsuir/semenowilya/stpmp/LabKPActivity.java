package com.bsuir.semenowilya.stpmp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LabKPActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_kp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.studentListView);
        final ArrayList recipeList = Student.getRecipesFromFile("students.json", this);
        StudentAdapterCellHorizontal adapter = new StudentAdapterCellHorizontal(this, recipeList);
        mListView.setAdapter(adapter);

        /*
        String[] listItems = new String[recipeList.size()];

        for(int i = 0; i < recipeList.size(); i++){
            Student student = (Student) recipeList.get(i);
            listItems[i] = student.firstName + " " + student.lastName;
        }


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.student_list_item, listItems);
        mListView.setAdapter(adapter);*/
    }

}
