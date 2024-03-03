package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Get_started : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        val stud_btn=findViewById<Button>(R.id.button)
        val dept_btn=findViewById<Button>(R.id.btnAccounts)
        val dept_btn_lib=findViewById<Button>(R.id.btnLibrary)
        val dept_btn_hos=findViewById<Button>(R.id.btnHostel)
        val dept_btn_exm=findViewById<Button>(R.id.btnExam)
        stud_btn.setOnClickListener {

            val intentsignup = Intent(this, MainActivity::class.java)
            startActivity(intentsignup)
        }
        dept_btn.setOnClickListener {

            val dept_intent = Intent(this, Log_in_Acc::class.java)
            startActivity(dept_intent)
        }
        dept_btn_lib.setOnClickListener {

            val lib_intent=Intent(this,Log_in_Lib::class.java)
            startActivity(lib_intent)
        }

        dept_btn_hos.setOnClickListener {
            val hos_intent=Intent(this,Log_in_Hostel::class.java)
            startActivity(hos_intent)
        }
        dept_btn_exm.setOnClickListener {
            val exm_intent=Intent(this,Log_in_Exam::class.java)
            startActivity(exm_intent)
        }

    }
}