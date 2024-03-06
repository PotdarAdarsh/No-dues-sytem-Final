package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.graphics.Color

class Dept_HOD : AppCompatActivity() {
    lateinit var database: DatabaseReference
    lateinit var database_adarsh: DatabaseReference
    lateinit var database_ankita: DatabaseReference
    lateinit var database_ankali: DatabaseReference

    lateinit var databaseReference: DatabaseReference
    lateinit var databaseReference_del: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dept_hod)
       /** val Ankita_sts = findViewById<TextInputEditText>(R.id.ankita_sts)
        val Adarsh_sts = findViewById<TextInputEditText>(R.id.adarsh_sts)
        val Anjali_sts = findViewById<TextInputEditText>(R.id.anjali_sts)**/
        val request = findViewById<TextView>(R.id.req)
        val Update = findViewById<Button>(R.id.update_btn)

        //ankita_sts_clread

        val Ankita_sts_red=findViewById<Button>(R.id.ankita_sts_not_clread)
        val Ankita_sts_grn=findViewById<Button>(R.id.ankita_sts_clread)
        val Adarsh_sts_red=findViewById<Button>(R.id.adarsh_sts_not_clread)
        val Adarsh_sts_grn=findViewById<Button>(R.id.adarsh_sts_clread)
        val Anjali_sts_red=findViewById<Button>(R.id.anjali_sts_not_clread)
        val Anjali_sts_grn=findViewById<Button>(R.id.anjali_sts_clread)

        databaseReference_del = FirebaseDatabase.getInstance().getReference("Users_request_HOD")
        databaseReference_del.get().addOnSuccessListener {
            if(it.exists()){

                val hod_req=it.value.toString()
                request.text=hod_req
            }
        }


            //ANKITA
        Ankita_sts_red.setOnClickListener {
            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("HOD_Ankita Mane").setValue("Dues are not clread")
            Ankita_sts_red.setBackgroundColor(Color.RED)
        }
        Ankita_sts_grn.setOnClickListener {
            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("HOD_Ankita Mane").setValue("Dues are  clread")
            Ankita_sts_grn.setBackgroundColor(Color.GREEN)
        }
        //ADARSH
        Adarsh_sts_red.setOnClickListener {
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("HOD_adarsh").setValue("Dues are not clread")
            Adarsh_sts_red.setBackgroundColor(Color.RED)
        }
        Adarsh_sts_grn.setOnClickListener {
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("HOD_adarsh").setValue("Dues are  clread")
            Adarsh_sts_grn.setBackgroundColor(Color.GREEN)
        }
        //ANJALI
        Anjali_sts_red.setOnClickListener {
            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("HOD_Anjali Potdar").setValue("Dues are not clread")
            Anjali_sts_red.setBackgroundColor(Color.RED)
        }
        Anjali_sts_grn.setOnClickListener {
            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("HOD_Anjali Potdar").setValue("Dues are  clread")
            Anjali_sts_grn.setBackgroundColor(Color.GREEN)
        }



   //************************************************************UPDATE DATA**************************************************************************

        Update.setOnClickListener {
            request.setText("Empty")
            databaseReference_del= FirebaseDatabase.getInstance().getReference("Users_request_HOD")
            val nodeToDelete = databaseReference_del
            // Use removeValue() method to delete data at that node
            nodeToDelete.removeValue()

            Toast.makeText(this,"UPDATED",Toast.LENGTH_SHORT).show()
        }
       /** Update.setOnClickListener {
            val ankita_hod = Ankita_sts.text.toString()
            val Anku_sts_hod = Ankita_sts.text.toString()
            val Adu_sts_hod = Adarsh_sts.text.toString()
            val Anju_sts_hod = Anjali_sts.text.toString()



           // val Status = Students_data(Anku_sts_acc, Adu_sts_acc, Anju_sts_acc)
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("HOD_adarsh").setValue(Adu_sts_hod)

            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("HOD_Ankita Mane").setValue(ankita_hod)

            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("HOD_Anjali Potdar").setValue(Anju_sts_hod)

            request.text="Empty"
            Toast.makeText(this,"updated", Toast.LENGTH_SHORT).show()

            databaseReference_del= FirebaseDatabase.getInstance().getReference("Users_request_HOD")
            val nodeToDelete = databaseReference_del
            // Use removeValue() method to delete data at that node
            nodeToDelete.removeValue()

        }
**/




    }
}