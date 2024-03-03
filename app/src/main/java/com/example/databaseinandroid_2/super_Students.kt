package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class super_Students : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_students)

        val signIn_stud_super=findViewById<Button>(R.id.btnSignIn_sup_stud)

        signIn_stud_super.setOnClickListener {

            val intent_sup_stud=Intent(this,SignInActivity::class.java)
            startActivity(intent_sup_stud)
        }

    }
}