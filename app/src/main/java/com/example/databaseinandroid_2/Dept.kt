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

class Dept : AppCompatActivity() {
    lateinit var database: DatabaseReference
    lateinit var database_adarsh: DatabaseReference
    lateinit var database_ankita: DatabaseReference
    lateinit var database_ankali: DatabaseReference

    lateinit var databaseReference: DatabaseReference
    lateinit var databaseReference_del: DatabaseReference


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dept)

        //     val textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
        //   val textInputEditText = textInputLayout.editText

// Now you can work with textInputEditText

        val Ankita_sts = findViewById<TextInputEditText>(R.id.ankita_sts)
        val Adarsh_sts = findViewById<TextInputEditText>(R.id.adarsh_sts)
        val Anjali_sts = findViewById<TextInputEditText>(R.id.anjali_sts)
        val request = findViewById<TextView>(R.id.req)
        val Update = findViewById<Button>(R.id.update_btn)


        databaseReference_del = FirebaseDatabase.getInstance().getReference("Users_request_Accounts")
        databaseReference_del.get().addOnSuccessListener {
            if(it.exists()){

                val Acc_req=it.value.toString()
                request.text=Acc_req
            }
        }
      /**  databaseReference = FirebaseDatabase.getInstance().getReference("Users_request")
        databaseReference.child("Accounts").get().addOnSuccessListener {

            if (it.exists()) {

                val Acc_sts = it.value.toString()
                request.text =Acc_sts

            }else{
                request.text="Empty"
            }
        }
**/
        Update.setOnClickListener {
            val ankita_acc = Ankita_sts.text.toString()
         val Anku_sts_acc = Ankita_sts.text.toString()
            val Adu_sts_acc = Adarsh_sts.text.toString()
            val Anju_sts_acc = Anjali_sts.text.toString()


            val Status = Students_data(Anku_sts_acc, Adu_sts_acc, Anju_sts_acc)
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("Accounts_adarsh").setValue(Adu_sts_acc)

            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("Accounts_Ankita Mane").setValue(ankita_acc)

            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("Accounts_Anjali Potdar").setValue(Anju_sts_acc)

            request.text="Empty"
            Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show()

            databaseReference_del=FirebaseDatabase.getInstance().getReference("Users_request_Accounts")
            val nodeToDelete = databaseReference_del
            // Use removeValue() method to delete data at that node
            nodeToDelete.removeValue()

        }




    }
}

    /** .addOnSuccessListener {
    Adarsh_sts.text?.clear()
    Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener {
    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
    }
    Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show()
    }**/