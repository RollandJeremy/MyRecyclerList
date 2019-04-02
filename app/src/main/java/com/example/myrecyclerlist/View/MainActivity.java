package com.example.myrecyclerlist.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



import com.example.myrecyclerlist.Controller.MainController;
import com.example.myrecyclerlist.R;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MainController mainC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        mainC = MainController.getInstance(this);
        //MainController mainC = new MainController(this);
        mainC.onCreate();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return mainC.onCreateOptionsMenu(menu);
    }
}
