package com.codingapps.myrecipes.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.codingapps.myrecipes.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}