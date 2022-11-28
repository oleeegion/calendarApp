package com.example.DB

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

//        @Synchronized
//        fun getInstance(context: Context): TaskDatabase {
//            var instance = INSTANCE
//            if (instance == null) {
//                instance = Room.databaseBuilder(context.applicationContext,
//                    TaskDatabase::class.java, "room-database")
//                    .build()
//                INSTANCE = instance
//            }
//            return instance
//        }
//    }


}}

