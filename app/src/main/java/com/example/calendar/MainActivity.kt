package com.example.calendar
//package com.gtappdevelopers.kotlingfgproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView




class MainActivity : AppCompatActivity() {
    // в строке ниже мы создаем
    // переменные для текстового представления и представления календаря
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //метод для вызова экрана

        dateTV = findViewById(R.id.idDate)
        calendarView = findViewById(R.id.idCalendarView)


        calendarView.setOnDateChangeListener(
            OnDateChangeListener {view, year, month, dayOfMonth ->
                val date = (dayOfMonth.toString() + "." + (month + 1) + "." + year)
                dateTV.setText(date)
            })


    }
}

