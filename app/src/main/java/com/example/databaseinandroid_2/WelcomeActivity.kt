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
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
//import android.widget.Toolbar
import androidx.appcompat.widget.Toolbar

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.sign


class WelcomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var databaseReference_acc: DatabaseReference
    private lateinit var databaseReference1: DatabaseReference
    private lateinit var databaseReference_req_acc: DatabaseReference
    private lateinit var databaseReference_req_lib: DatabaseReference
    private lateinit var databaseReference_req_hos: DatabaseReference
    private lateinit var databaseReference_req_exm: DatabaseReference
    private lateinit var databaseReference_req_hod: DatabaseReference

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

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        //  val Acc_sts:String
        val listView = findViewById<ListView>(R.id.listView)

        val name = intent.getStringExtra(Unlock_form.KEY2)
        val mail = intent.getStringExtra(Unlock_form.KEY1)
        val userId = intent.getStringExtra(Unlock_form.KEY3)

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
                val Hod_sts = it.child("HOD_" + name).value.toString()
                val Acc_sts = it.child("Accounts_" + name).value.toString()
                val Lib_sts = it.child("Library_" + name).value.toString()
                val hos_sts = it.child("Hostel_" + name).value.toString()
                val exm_sts = it.child("Exam_" + name).value.toString()

                val Dep_nm = arrayOf("HOD", "Accounts", "Library", "Hostel", "Exam")

                val Stud_sts = arrayOf(
                    "Department Dues:" + Hod_sts.toString(),
                    "Department Dues: " + Acc_sts.toString(),
                    "Department Dues:" + Lib_sts.toString(),
                    "Department Dues:" + hos_sts.toString(),
                    "Department Dues:" + exm_sts.toString()
                )
                val dept_pic = arrayOf(
                    R.drawable.hodfinal,
                    R.drawable.accfinal,
                    R.drawable.libraryfinal,
                    R.drawable.hostel_new,
                    R.drawable.exam_dept_new
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

            databaseReference_req_acc =
                FirebaseDatabase.getInstance().getReference("Users_request_Accounts")
            databaseReference_req_acc.child(name.toString()).setValue(":")
            databaseReference_req_lib =
                FirebaseDatabase.getInstance().getReference("Users_request_Library")
            databaseReference_req_lib.child(name.toString()).setValue(":")
            databaseReference_req_hos =
                FirebaseDatabase.getInstance().getReference("Users_request_Hostel")
            databaseReference_req_hos.child(name.toString()).setValue(":")
            databaseReference_req_exm =
                FirebaseDatabase.getInstance().getReference("Users_request_Exam")
            databaseReference_req_exm.child(name.toString()).setValue(":").addOnSuccessListener {

                Toast.makeText(this, "Request sent Successfully", Toast.LENGTH_SHORT).show()
            }
        }

        val navigationView1 = findViewById<NavigationView>(R.id.nav_view)
        navigationView1.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_Admission_information -> {
                    // Perform action when Admission Information item is clicked
                    // For example, open a new activity or fragment
                    // Replace the commented code below with your desired action

                    // Example: Open a new activity
                    val intent = Intent(this, Admission_info::class.java)
                    startActivity(intent)

                    // Example: Replace a fragment
                    // val fragment = YourFragment()
                    // supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()

                    // Close the navigation drawer if needed
                    drawerLayout.closeDrawers()

                    true // Return true to indicate that the click event has been handled
                }
                // Add cases for other menu items if needed
                else -> false // Return false for items that are not handled
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}
  /** private fun replacefragment(fragment:admissionFragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }**/

   /** override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_Admission_information -> {
                // Open the new activity here
                replaceFragment(admissionFragment())
            }
            // Handle other menu items if needed
        }
        // Close the navigation drawer after handling the click event
        drawerLayout.closeDrawers()
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}*/
//***************************************************************************************************************
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