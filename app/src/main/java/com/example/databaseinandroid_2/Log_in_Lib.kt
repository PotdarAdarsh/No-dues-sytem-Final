package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Log_in_Lib : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_lib)

        val lib_login = findViewById<TextInputEditText>(R.id.lib_id)
        val btn_signin_lib = findViewById<Button>(R.id.btnSignIn_lib)

        val Acc_login = lib_login.text.toString()

        btn_signin_lib.setOnClickListener {
            if (lib_login.text.toString() == "Library123") {
                val libIntent = Intent(this, Dept_lib::class.java)
                startActivity(libIntent)
            }else {

                Toast.makeText(this,"Wrong password for Library department:", Toast.LENGTH_SHORT).show()
            }
        }

    }
}