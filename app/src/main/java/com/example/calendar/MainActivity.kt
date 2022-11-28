package com.example.calendar

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var datePicker: DatePickerHelper
//    var pref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //метод для вызова экрана

//        pref = getSharedPreferences("table", Context.MODE_PRIVATE)

        datePicker = DatePickerHelper(this)
        val btSelectDate: TextView = findViewById(R.id.btSelectDate)
        btSelectDate.setOnClickListener {
            showDatePickerDialog()
        }

        val buttonAct: Button = findViewById(R.id.button_activity)
        buttonAct.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val buttonTest: Button = findViewById(R.id.button_test)
        buttonTest.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }


    }



    private fun showDatePickerDialog() {
        val dateTV: TextView = findViewById(R.id.idDate)
        val cal = Calendar.getInstance()
        val d = cal.get(Calendar.DAY_OF_MONTH)
        val m = cal.get(Calendar.MONTH)
        val y = cal.get(Calendar.YEAR)
        datePicker.showDialog(d, m, y, object: DatePickerHelper.Callback {

            override fun onDateSelected(dayOfMonth: Int, month: Int, year: Int) {
                val dayStr = if (dayOfMonth < 10) "0$dayOfMonth" else "$dayOfMonth"
                val mon = month + 1
                val monthStr = if (mon < 10) "0$mon" else "$mon"
                dateTV.text = "$dayStr.$monthStr.$year"
            }
        })
    }
}



class DatePickerHelper(context: Context, isSpinnerType: Boolean = false) {
    private var dialog: DatePickerDialog
    private var callback: Callback? = null
    private val listener =
        DatePickerDialog.OnDateSetListener {datePicker, year, monthOfYear, dayOfMonth ->
            callback?.onDateSelected(dayOfMonth, monthOfYear, year)
        }
    init {
        val style = if (isSpinnerType) R.style.SpinnerDatePickerDialog else 0
        val cal = Calendar.getInstance()
        dialog = DatePickerDialog(context, style, listener,
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
    }
    fun showDialog(dayOfMonth: Int, month: Int, year: Int, callback: Callback?) {
        this.callback = callback
        dialog.datePicker.init(year, month, dayOfMonth, null)
        dialog.show()
    }

    interface Callback {
        fun onDateSelected(dayOfMonth: Int, month: Int, year: Int)
    }
}




