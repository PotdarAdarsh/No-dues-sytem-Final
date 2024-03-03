package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Sign_in_super : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_super)

        val sup_login = findViewById<TextInputEditText>(R.id.sup_id)
        val btn_signin_sup = findViewById<Button>(R.id.btnSignIn_sup)

        //val Acc_login = acc_login.text.toString()

        btn_signin_sup.setOnClickListener {
            if (sup_login.text.toString() == "Super123") {
                val supIntent = Intent(this, Super_Module::class.java)
                startActivity(supIntent)
            }else {

                Toast.makeText(this,"Wrong password for Super module:", Toast.LENGTH_SHORT).show()
            }
        }

    }
}