package com.example.calendar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.DB.TaskDatabase
import com.example.DB.TaskEntity


class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val db: TaskDatabase = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java, "room-database"
            ).allowMainThreadQueries()
             .build()


        val taskDao = db.getTaskDao()
            val task = TaskEntity(1, "testTasks", "01/02/1973")
            taskDao.addTask(task)
            taskDao.deleteTask(task)
            val query = taskDao.getById(1)
            if (query != null) {
                println("task added. Name: " + query.name + query.id)
            } else {
                println("Пустая строка")
            }



        val buttonTestReturn: Button = findViewById(R.id.button_test_return)
        buttonTestReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val button: Button = findViewById(R.id.button_test)
        button.setOnClickListener {
            println("Пустая строка")
//            val taskDao = db.getTaskDao()
//
//            val print = taskDao.getAll()
//            print(print)

//            if (query != null) {
//                print("task added. Name: " + query.name + query.id)
//            } else {
//                print("Пустая строка")
//            }

        }



    }
}