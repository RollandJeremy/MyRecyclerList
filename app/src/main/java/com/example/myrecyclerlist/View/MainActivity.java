package com.example.myrecyclerlist.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;


import com.example.myrecyclerlist.Controller.MainController;
import com.example.myrecyclerlist.R;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        MainController mainC = MainController.getInstance(this);
        //MainController mainC = new MainController(this);
        mainC.onCreate();

    }
}
