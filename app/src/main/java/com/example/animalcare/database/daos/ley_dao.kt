package com.example.animalcare.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.animalcare.database.entities.ley_entity
import androidx.room.Query

@Dao
interface ley_dao {


    @Query("SELECT * from ley_table")
    fun getAllLeyes(): LiveData<List<ley_entity>>



    @Query("SELECT * from ley_table where nombre_ley = :ley")
    fun getLey(ley:String): LiveData<ley_entity>

}