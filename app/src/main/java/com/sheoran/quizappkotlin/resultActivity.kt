package com.sheoran.quizappkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class resultActivity : AppCompatActivity() {
    lateinit var txtmarks: TextView
    lateinit var txttotalmarks:TextView
    lateinit var btnfinish: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)


        txtmarks = findViewById(R.id.txtmarks)
        txttotalmarks = findViewById(R.id.txttotalMarks)
        btnfinish = findViewById(R.id.btnfinish)


        val i = intent
        val marks = i.getIntExtra("marks", 1).toString()
        val totalMarks = i.getIntExtra("totalMarks", 1).toString()

        txtmarks.text = marks
        txttotalmarks.text = totalMarks

        btnfinish.setOnClickListener { finish() }

    }
}