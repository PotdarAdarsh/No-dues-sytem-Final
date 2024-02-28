package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Dept : AppCompatActivity() {
    lateinit var database: DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dept)

   //     val textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
     //   val textInputEditText = textInputLayout.editText

// Now you can work with textInputEditText

        val Ankita_sts=findViewById<TextInputEditText>(R.id.ankita_sts)
        val Adarsh_sts=findViewById<TextInputEditText>(R.id.adarsh_sts)
        val Anjali_sts=findViewById<TextInputEditText>(R.id.anjali_sts)

        val Update=findViewById<Button>(R.id.update_btn)

        Update.setOnClickListener {
            val Dep_name="Accounts"
            val Anku_sts=Ankita_sts.text.toString()
            val Adu_sts=Ankita_sts.text.toString()
            val Anju_sts=Anjali_sts.text.toString()


            val Status = Students_data(Anku_sts, Adu_sts, Anju_sts)
            database = FirebaseDatabase.getInstance().getReference("Users_status")

            database.child(Adu_sts).setValue(Status).addOnSuccessListener {
                Adarsh_sts.text?.clear()
                Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show()
        }



    }
}