package com.example.databaseinandroid_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Get_started : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        val stud_btn=findViewById<Button>(R.id.button)
        val dept_btn=findViewById<Button>(R.id.dept)
        stud_btn.setOnClickListener {

            val intentsignup = Intent(this, MainActivity::class.java)
            startActivity(intentsignup)
        }
        dept_btn.setOnClickListener {

            val dept_intent = Intent(this, Dept::class.java)
            startActivity(dept_intent)
        }
    }
}