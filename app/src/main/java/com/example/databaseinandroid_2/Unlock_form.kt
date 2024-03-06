package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Unlock_form : AppCompatActivity() {

    private lateinit var databaseReference_req_hod: DatabaseReference
    lateinit var array_dept_name: ArrayList<User_adapter>
    private lateinit var databaseReference_hod: DatabaseReference

    companion object{
        const val KEY1 = "com.example.day16database.SignInActivity.mail"
        const val KEY2 = "com.example.day16database.SignInActivity.name"
        const val KEY3 = "com.example.day16database.SignInActivity.id"
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unlock_form)

        val name = intent.getStringExtra(SignInActivity.KEY2)
        val mail = intent.getStringExtra(SignInActivity.KEY1)
        val userId = intent.getStringExtra(SignInActivity.KEY3)
        val HOD_TV=findViewById<TextView>(R.id.tv_hod_sts)
        val Hod_req_btn=findViewById<Button>(R.id.req_btn_hod)
        val Generate_from=findViewById<Button>(R.id.btn_form)

        databaseReference_hod = FirebaseDatabase.getInstance().getReference("Users_status")
        databaseReference_hod.get().addOnSuccessListener { it ->

            if (it.exists()) {
                val Hod_sts = it.child("HOD_" + name).value.toString()

                HOD_TV.setText(Hod_sts)
            }
        }
        Hod_req_btn.setOnClickListener {

            databaseReference_req_hod= FirebaseDatabase.getInstance().getReference("Users_request_HOD")
            databaseReference_req_hod.child(name.toString()).setValue(":").addOnSuccessListener {

                Toast.makeText(this, "Request sent Successfully", Toast.LENGTH_SHORT).show()
            }
        }
        Generate_from.setOnClickListener {
            databaseReference_hod = FirebaseDatabase.getInstance().getReference("Users_status")
            databaseReference_hod.get().addOnSuccessListener {

                if (it.exists())
                {
                    val Hod_sts_form = it.child("HOD_" + name).value.toString()
                    if(Hod_sts_form=="Dues are  clread")
                    {
                        val welIntent=Intent(this,WelcomeActivity::class.java)
                        welIntent.putExtra(SignInActivity.KEY1, mail.toString())
                        welIntent.putExtra(SignInActivity.KEY2, name.toString())
                        welIntent.putExtra(SignInActivity.KEY3, userId.toString())
                        startActivity(welIntent)
                    }
                    else{
                        Toast.makeText(this,"you are not authinticated yet:",Toast.LENGTH_SHORT).show()
                    }

                }
            }




        }
    }
}