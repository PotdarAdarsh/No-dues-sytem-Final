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
    private lateinit var databaseReference_acc: DatabaseReference
    private lateinit var databaseReference1: DatabaseReference
    private lateinit var databaseReference_req_acc: DatabaseReference
    private lateinit var databaseReference_req_lib: DatabaseReference
    private lateinit var databaseReference_req_hos: DatabaseReference
    private lateinit var databaseReference_req_exm: DatabaseReference

    // private lateinit var Acc_sts: String
   // private lateinit var Lib_sts: String
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

        var ac_st: Any? = null

        /**  databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(uniqueId).get().addOnSuccessListener {

        // if user exist or not
        if(it.exists()){
        // welcome user in your app, with intent and also pass
        val email = it.child("email").value
        val name = it.child("name").value
        val userId = it.child("uniqueId").value
         **/

        databaseReference_acc = FirebaseDatabase.getInstance().getReference("Users_status")
        databaseReference_acc.get().addOnSuccessListener { it ->

            if (it.exists()) {
                val Acc_sts = it.child("Accounts_"+name).value.toString()
                val Lib_sts=it.child("Library_"+name).value.toString()
                val hos_sts=it.child("Hostel_"+name).value.toString()
                val exm_sts=it.child("Exam_"+name).value.toString()

                val Dep_nm = arrayOf("Accounts", "Library", "Hostel", "Exam")
                val Stud_sts = arrayOf(
                    "Department Dues: " + Acc_sts.toString(),
                    "Department Dues:" +Lib_sts.toString(),
                    "Department Dues:"+hos_sts.toString(),
                    "Department Dues:"+exm_sts.toString()
                )
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
                listView.isClickable = true
                listView.adapter = Stud_Adapter(this, array_dept_name)


            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed, Error in DB", Toast.LENGTH_SHORT).show()
        }


        // val listView = findViewById<ListView>(R.id.listView)


//*************************************update button**********************************************************
            val Update_btn = findViewById<Button>(R.id.request)

            Update_btn.setOnClickListener {
                val req = name.toString()

                databaseReference_req_acc= FirebaseDatabase.getInstance().getReference("Users_request_Accounts")
                databaseReference_req_acc.child(name.toString()).setValue(":")
                databaseReference_req_lib= FirebaseDatabase.getInstance().getReference("Users_request_Library")
                databaseReference_req_lib.child(name.toString()).setValue(":")
                databaseReference_req_hos= FirebaseDatabase.getInstance().getReference("Users_request_Hostel")
                databaseReference_req_hos.child(name.toString()).setValue(":")
                databaseReference_req_exm= FirebaseDatabase.getInstance().getReference("Users_request_Exam")
                databaseReference_req_exm.child(name.toString()).setValue(":").addOnSuccessListener {

                    Toast.makeText(this, "Request sent Successfully", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

/** val Dep_nm = arrayOf("Accounts", "Library", "Hostel", "Exam")
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


}**/