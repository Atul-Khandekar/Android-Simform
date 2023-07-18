package com.example.trainingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.content.ContextCompat

class BookFlight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flightClass = arrayOf("Economy", "First Class", "Buisiness Class", "General Class")
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.book_flight_background)
        setContentView(R.layout.activity_book_flight)

        val adapter = ArrayAdapter<String>(
            this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, flightClass
        )
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter
    }
}