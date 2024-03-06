package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class Super_Module : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_module)

        val Student=findViewById<Button>(R.id.sup_Stud)
        val Accounts=findViewById<Button>(R.id.supAccounts)
        val Library=findViewById<Button>(R.id.supLibrary)
        val Hostel=findViewById<Button>(R.id.supHostel)
        val Exam=findViewById<Button>(R.id.supExam)
        val HOD=findViewById<Button>(R.id.sup_hod)

        Student.setOnClickListener {
            val Stud_intent=Intent(this,super_Students::class.java)
            startActivity(Stud_intent)
        }
        Accounts.setOnClickListener {
            val Acc_intent=Intent(this,Dept::class.java)
            startActivity(Acc_intent)
        }
        Library.setOnClickListener {
            val Lib_intent=Intent(this,Dept_lib::class.java)
            startActivity(Lib_intent)
        }
        Hostel.setOnClickListener {
            val Hos_intent=Intent(this,Dept_hostel::class.java)
            startActivity(Hos_intent)
        }
        Exam.setOnClickListener {
            val Exm_intent=Intent(this,Dept_exam::class.java)
            startActivity(Exm_intent)
        }
        HOD.setOnClickListener {
            val HOD_intent=Intent(this,Dept_HOD::class.java)
            startActivity(HOD_intent)
        }
    }
}