package com.example.databaseinandroid_2

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

    companion object {
        const val KEY = "com.example.databaseinandroid_2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        //  val Acc_sts:String
        val listView = findViewById<ListView>(R.id.listView)

        databaseReference = FirebaseDatabase.getInstance().getReference("Users_status")
        databaseReference.child("Accounts").get().addOnSuccessListener {


            if(it.exists()) {
                val Acc_sts = it.child("adu").value

                val taskList = arrayListOf<String>()
                taskList.add("ACCOUNTS DEPARTMENT " + Acc_sts.toString())
                taskList.add("LIBRARY DEPARTMENT")
                taskList.add("HOSTELDEPARTMENT ")

                val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
                listView.adapter = adapterForMyListView

                listView.setOnItemClickListener { parent, view, position, id ->

                    val text = "Clicked on item : " + (view as TextView).text.toString()
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

                }
        }
       /** val taskList = arrayListOf<String>()
        taskList.add("ACCOUNTS DEPARTMENT" + Acc_sts.toString())
        taskList.add("LIBRARY DEPARTMENT")
        taskList.add("HOSTELDEPARTMENT ")

        val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        listView.adapter = adapterForMyListView

        listView.setOnItemClickListener { parent, view, position, id ->

            val text = "Clicked on item : " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

**/
        }.addOnFailureListener {
            Toast.makeText(this, "Failed, Error in DB", Toast.LENGTH_SHORT).show()
        }

    }
}

/*  val name = intent.getStringExtra(SignInActivity.KEY2)
       val mail = intent.getStringExtra(SignInActivity.KEY1)
       val userId = intent.getStringExtra(SignInActivity.KEY3)

       val welcomeText = findViewById<TextView>(R.id.tVWelcome)
       val mailText = findViewById<TextView>(R.id.tvMail)
       val idText = findViewById<TextView>(R.id.tvUnique)

       welcomeText.text = "Welcome $name"
       mailText.text = "Mail : $mail"
       idText.text = "UserId : $userId"


       val btnhome=findViewById<Button>(R.id.btnHome)

       btnhome.setOnClickListener {
           val homeintent = Intent(this, HomeActivity::class.java)
           homeintent.putExtra(SignInActivity.KEY1, mailText.toString())
           homeintent.putExtra(SignInActivity.KEY2, name.toString())
           homeintent.putExtra(SignInActivity.KEY3, userId.toString())

           startActivity(homeintent)
       }
       val btnhome2=findViewById<Button>(R.id.btnHome2)
       btnhome2.setOnClickListener {
           val homeintent2 = Intent(this, HomeActivity::class.java)
       //     homeintent2.putExtra(KEY,userId)
           startActivity(homeintent2)
       }
*/

/** val taskList = arrayListOf<String>()
taskList.add("ACCOUNTS DEPARTMENT")
taskList.add("LIBRARY DEPARTMENT")
taskList.add("HOSTELDEPARTMENT ")

val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
listView.adapter = adapterForMyListView

listView.setOnItemClickListener { parent, view, position, id ->

val text = "Clicked on item : " + (view as TextView).text.toString()
Toast.makeText(this, text, Toast.LENGTH_SHORT).show()**/
