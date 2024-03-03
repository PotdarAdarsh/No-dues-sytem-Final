package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Log_in_Exam : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_exam)


        val exm_login = findViewById<TextInputEditText>(R.id.exm_id)
        val btn_signin_exm = findViewById<Button>(R.id.btnSignIn_exm)

        //  val Acc_login = acc_login.text.toString()

        btn_signin_exm.setOnClickListener {
            if (exm_login.text.toString() == "Exam123") {
                val exmIntent = Intent(this, Dept_exam::class.java)
                startActivity(exmIntent)
            }else {

                Toast.makeText(this,"Wrong password for Exam department:", Toast.LENGTH_SHORT).show()
            }
        }

    }
}