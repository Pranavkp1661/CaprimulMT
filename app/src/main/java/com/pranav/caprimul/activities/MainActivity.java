package com.pranav.caprimul.activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pranav.caprimul.R;
import com.pranav.caprimul.adapter.RvAdapter;
import com.pranav.caprimul.database.RoomDataBase;
import com.pranav.caprimul.models.CarsEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RvAdapter.CarsInterface {
    private EditText etCarName;
    private EditText etCarColor;
    private Button btAdd;
    private RecyclerView rvDisplay;
    private RvAdapter rvAdapter;
    private List<CarsEntity> carsEntities = new ArrayList<>();
    private Context context;
    private RoomDataBase dataBase;
    private boolean isEdit = false;
    private CarsEntity carsEntity = new CarsEntity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIds();
        rvDisplay.setLayoutManager(new LinearLayoutManager(context));
        rvDisplay.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        rvDisplay.setAdapter(rvAdapter);

        btAdd.setOnClickListener(v -> {
            carsEntity.setCarName(etCarName.getText().toString().trim());
            carsEntity.setColor(etCarColor.getText().toString().trim());
            insertIntoDatabase();
        });
        updateList();
    }

    private void updateList() {
        carsEntities = dataBase.mainDao().getCarsList();
        rvAdapter.updateAdapter(carsEntities);
    }

    private void insertIntoDatabase() {
        if (!isEdit) {
            dataBase.mainDao().insertIntoCars(carsEntity);
        } else {
            dataBase.mainDao().updateCars(carsEntity);
            isEdit = false;
        }
        etCarColor.setText("");
        etCarName.setText("");
        carsEntity = new CarsEntity();
        updateList();
    }

    private void initIds() {
        etCarName = findViewById(R.id.etCarName);
        etCarColor = findViewById(R.id.etCarColor);
        btAdd = findViewById(R.id.btAdd);
        rvDisplay = findViewById(R.id.rvDisplay);
        rvAdapter = new RvAdapter(context, carsEntities, this);
        dataBase = RoomDataBase.getInstance(context);
    }

    @Override
    public void updateCars(CarsEntity carsEntity) {
        isEdit = true;
    }

    @Override
    public void deleteCars(CarsEntity carsEntity) {

    }
}