package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent
import android.widget.Toast

class Log_in_Acc : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_acc)

        val acc_login = findViewById<TextInputEditText>(R.id.acc_id)
        val btn_signin_acc = findViewById<Button>(R.id.btnSignIn_acc)

        val Acc_login = acc_login.text.toString()

        btn_signin_acc.setOnClickListener {
            if (acc_login.text.toString() == "Accounts123") {
                val accIntent = Intent(this, Dept::class.java)
                startActivity(accIntent)
            }else {

                Toast.makeText(this,"Wrong password for Accounts department:",Toast.LENGTH_SHORT).show()
            }
        }
    }
}