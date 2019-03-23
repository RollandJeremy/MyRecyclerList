package com.example.myrecyclerlist.View;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myrecyclerlist.Controller.DescriptionController;
import com.example.myrecyclerlist.R;

public class DescriptionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        DescriptionController descriptionController = DescriptionController.getInstance(this);
        descriptionController.onCreate();

    }
}
