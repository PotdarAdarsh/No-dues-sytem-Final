package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import javax.net.ssl.SSLEngineResult.Status
//import com.google.firebase.database.FirebaseDatabase
import kotlin.math.sign


class HomeActivity : AppCompatActivity() {


    lateinit var database : DatabaseReference

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

      //  val stetusT = findViewById<TextInputEditText>(R.id.status)
        val stetusT=findViewById<TextInputEditText>(R.id.status)
        val btn2 = findViewById<Button>(R.id.btn2)
        val userId = intent.getStringExtra(WelcomeActivity.KEY)

        btn2.setOnClickListener {

            val status = stetusT.text.toString()
            val Stetus = User2(status)
            val userId=userId.toString()
            database = FirebaseDatabase.getInstance().getReference("Users")

            database.child(userId).setValue(Stetus).addOnSuccessListener {
                //status?.clear()
                Toast.makeText(this, "status updated", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}