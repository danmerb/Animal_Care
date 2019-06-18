package com.example.animalcare

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animalcare.database.daos.ley_dao
import com.example.animalcare.database.daos.org_dao
import com.example.animalcare.database.entities.ley_entity
import com.example.animalcare.database.entities.org_entity

@Database(entities = [ley_entity::class, org_entity::class], version = 2, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun leyDao(): ley_dao
    abstract fun orgDao(): org_dao


    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB {

            if (INSTANCE != null) {
                return INSTANCE!!
            }
            synchronized(this) {
                INSTANCE = Room
                    .databaseBuilder(context, RoomDB::class.java, "Database")
                    .fallbackToDestructiveMigration()
                    .build()
                return INSTANCE!!
            }

        }

    }

}