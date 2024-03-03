package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Log_in_Hostel : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_hostel)

        val hos_login = findViewById<TextInputEditText>(R.id.hos_id)
        val btn_signin_hos = findViewById<Button>(R.id.btnSignIn_hos)

      //  val Acc_login = acc_login.text.toString()

        btn_signin_hos.setOnClickListener {
            if (hos_login.text.toString() == "Hostel123") {
                val hosIntent = Intent(this, Dept_hostel::class.java)
                startActivity(hosIntent)
            }else {

                Toast.makeText(this,"Wrong password for Hostel department:", Toast.LENGTH_SHORT).show()
            }
        }

    }
}