package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent
import android.graphics.Color
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.sign


class WelcomeActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var databaseReference1: DatabaseReference
    lateinit var array_dept_name: ArrayList<User_adapter>

    companion object {
        const val KEY = "com.example.databaseinandroid_2"
    }

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        //  val Acc_sts:String
        val listView = findViewById<ListView>(R.id.listView)

        val name = intent.getStringExtra(SignInActivity.KEY2)
        val mail = intent.getStringExtra(SignInActivity.KEY1)
        val userId = intent.getStringExtra(SignInActivity.KEY3)

      /**  databaseReference = FirebaseDatabase.getInstance().getReference("Users_status_Accounts")
        val usernm = databaseReference.child("Ankita").get().addOnSuccessListener {
            if (it.exists()) {
                val user_name = it.value
            }

        }**/


        databaseReference = FirebaseDatabase.getInstance().getReference("Users_status_Accounts")
        databaseReference.child(userId.toString()).get().addOnSuccessListener {


            if (it.exists()) {
                val Acc_sts = it.value

                val Dep_nm = arrayOf("Accounts", "Library", "Hostel", "Exam")
                val Stud_sts = arrayOf("Department Dues: " + Acc_sts.toString(), "no", "yes", "no")
                val dept_pic = arrayOf(
                    R.drawable.accounts,
                    R.drawable.accounts,
                    R.drawable.hostel,
                    R.drawable.exam
                )

                array_dept_name = ArrayList()

                for (eachIndex in Dep_nm.indices) {
                    val user =
                        User_adapter(Dep_nm[eachIndex], Stud_sts[eachIndex], dept_pic[eachIndex])

                    array_dept_name.add(user)
                }
                val listView = findViewById<ListView>(R.id.listView)
                listView.isClickable = true
                listView.adapter = Stud_Adapter(this, array_dept_name)


            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed, Error in DB", Toast.LENGTH_SHORT).show()
        }

     val Update_btn=findViewById<Button>(R.id.request)

        Update_btn.setOnClickListener {
            val req=name.toString()

            databaseReference1 = FirebaseDatabase.getInstance().getReference("Users_request")

            databaseReference1.child("Accounts").setValue(req.toString()+" , ").addOnSuccessListener {

                Toast.makeText(this,"Request sent Successfully",Toast.LENGTH_SHORT).show()
            }
        }
    }
}