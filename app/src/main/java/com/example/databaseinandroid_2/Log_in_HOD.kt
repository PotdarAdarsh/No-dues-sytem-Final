package com.example.databaseinandroid_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Log_in_HOD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_hod)
        val hod_login = findViewById<TextInputEditText>(R.id.hod_id)
        val btn_signin_acc = findViewById<Button>(R.id.btnSignIn_hod)

        val Acc_login = hod_login.text.toString()

        btn_signin_acc.setOnClickListener {
            if (hod_login.text.toString() == "HOD123") {
                val accIntent = Intent(this, Dept_HOD::class.java)
                startActivity(accIntent)
            }else {

                Toast.makeText(this,"Wrong password for HOD Module:", Toast.LENGTH_SHORT).show()
            }
        }

    }
}