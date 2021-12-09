package com.pranav.caprimul.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.pranav.caprimul.R;

public class MainActivity extends AppCompatActivity {
    private EditText etCarName,etCarColor;
    private Button btAdd;
    private RecyclerView rvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIds();
    }

    private void initIds() {
        etCarName=findViewById(R.id.etCarName);
        etCarColor=findViewById(R.id.etCarColor);
        btAdd=findViewById(R.id.btAdd);
        rvDisplay=findViewById(R.id.rvDisplay);
    }
}