package com.bsuir.semenowilya.stpmp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLabOne(View view) {
        Intent intent = new Intent(this, LabOneActivity.class);
        startActivity(intent);
    }

    public void openLabTwo(View view) {
        Intent intent = new Intent(this, LabTwoFirstActivity.class);
        startActivity(intent);
    }


    public void openLabThree(View view) {
        Intent intent = new Intent(this, LabThreeActivity.class);
        startActivity(intent);
    }

    public void openLabKR(View view) {

    }
}
