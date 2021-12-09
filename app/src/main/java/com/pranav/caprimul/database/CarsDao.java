package com.pranav.caprimul.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pranav.caprimul.models.CarsEntity;

import java.util.List;

@Dao
public interface CarsDao {
    @Insert(onConflict = REPLACE)
    void insertIntoCars(CarsEntity carsEntity);

    @Query("Select * from cars_table")
    List<CarsEntity> getCarsList();

    @Delete
    void deleteFromCars(CarsEntity carsEntity);

    @Update
    void updateCars(CarsEntity carsEntity);
}
