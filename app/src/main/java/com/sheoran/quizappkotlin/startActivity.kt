package com.sheoran.quizappkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class startActivity : AppCompatActivity() {
    lateinit var btnstart: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)
        btnstart = findViewById(R.id.btnstart)
        val i = Intent(this@startActivity, MainActivity::class.java)

        btnstart.setOnClickListener { startActivity(i) }
    }
}