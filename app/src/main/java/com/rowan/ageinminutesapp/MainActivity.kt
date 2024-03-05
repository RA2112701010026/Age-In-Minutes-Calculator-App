package com.rowan.ageinminutesapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var TextViewInMIn:TextView?=null
   private var tvSelcetedDate:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    tvSelcetedDate=findViewById(R.id.AgeDate)
    TextViewInMIn=findViewById(R.id.textView8)


        val btnDatePicker : Button=findViewById(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {
            ClickDatePicker()

        }
    }
    fun ClickDatePicker(){
    val myCalendar=Calendar.getInstance()
     val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                Toast.makeText(this, "selected date is :$dayOfMonth/${month+1}/$year", Toast.LENGTH_SHORT).show()
               val mydate="$dayOfMonth/${month+1}/$year"
                tvSelcetedDate?.setText(mydate)



              val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate =sdf.parse(mydate)
                val selectedDateInMinutes=theDate.time/60000
                val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                var currentDateInMinutes=currentDate.time/60000
                var differenceInMin=  currentDateInMinutes-selectedDateInMinutes

                TextViewInMIn?.text=differenceInMin.toString()
            },
            year,
            month,
            day).show()


    }
}