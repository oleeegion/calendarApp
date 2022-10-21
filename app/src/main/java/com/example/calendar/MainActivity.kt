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



//    class MainActivity : AppCompatActivity() {
//
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.activity_main)


//            // инициализация переменных
//            // представления списка с их идентификаторами.
//            dateTV = findViewById(R.id.idTVDate)
//            calendarView = findViewById(R.id.idCalendarView)
//
//
//            // в строке ниже мы добавляем set on
//            // прослушиватель изменения даты для просмотра календаря.
//            calendarView.setOnDateChangeListener(
//                    OnDateChangeListener { view, year, month, dayOfMonth ->
//                        // В этом Listener мы получаем значения
//                        // например, год, месяц и день месяца
//                        // в строке ниже мы создаем переменную
//                        // в который мы добавляем все переменные в нем.
//                        val Date = (dayOfMonth.toString() + "-"
//                                + (month + 1) + "-" + year)
//
//                        // установите эту дату в TextView для отображения
//                        dateTV.setText(Date)
//                    })
//        }
//    }
//}
