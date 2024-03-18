package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Intent

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


      /**  val ankita_acc = Ankita_sts.text.toString()
        val Adu_sts_acc = Adarsh_sts.text.toString()
        val Anju_sts_acc = Anjali_sts.text.toString()

        val Ankita_sts_red=findViewById<Button>(R.id.ankita_sts_not_clread)
        val Ankita_sts_grn=findViewById<Button>(R.id.ankita_sts_clread)
        val Adarsh_sts_red=findViewById<Button>(R.id.adarsh_sts_not_clread)
        val Adarsh_sts_grn=findViewById<Button>(R.id.adarsh_sts_clread)
        val Anjali_sts_red=findViewById<Button>(R.id.anjali_sts_not_clread)
        val Anjali_sts_grn=findViewById<Button>(R.id.anjali_sts_clread)
      **/
        databaseReference_del = FirebaseDatabase.getInstance().getReference("Users_request_Accounts")
        databaseReference_del.get().addOnSuccessListener {
            if(it.exists()){

                val Acc_req=it.value.toString()
                request.text=Acc_req
            }
        }
        /**
        //ANKITA
        //Ankita_sts_grn.setBackgroundColor(#0E80D0)
        Ankita_sts_red.setOnClickListener {
            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("Accounts_Ankita Mane").setValue("Dues are not clread "+ankita_acc)
            Ankita_sts_red.setBackgroundColor(Color.RED)
            Ankita_sts_grn.setBackgroundColor(Color.parseColor("#0E80D0"))

        }
        Ankita_sts_grn.setOnClickListener {
            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("Accounts_Ankita Mane").setValue("Dues are  clread "+ankita_acc)
            Ankita_sts_grn.setBackgroundColor(Color.GREEN)
            Ankita_sts_red.setBackgroundColor(Color.parseColor("#0E80D0"))

        }
        //ADARSH
        Adarsh_sts_red.setOnClickListener {
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("Accounts_adarsh").setValue("Dues are not clread "+Adarsh_sts.text.toString())
            Adarsh_sts_red.setBackgroundColor(Color.RED)
            Adarsh_sts_grn.setBackgroundColor(Color.parseColor("#0E80D0"))

        }
        Adarsh_sts_grn.setOnClickListener {
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("Accounts_adarsh").setValue("Dues are  clread "+Adu_sts_acc)
            Adarsh_sts_grn.setBackgroundColor(Color.GREEN)
            Adarsh_sts_red.setBackgroundColor(Color.parseColor("#0E80D0"))

        }
        //ANJALI
        Anjali_sts_red.setOnClickListener {
            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("Accounts_Anjali Potdar").setValue("Dues are not clread "+Anju_sts_acc)
            Anjali_sts_red.setBackgroundColor(Color.RED)
            Anjali_sts_grn.setBackgroundColor(Color.parseColor("#0E80D0"))

        }
        Anjali_sts_grn.setOnClickListener {
            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("Accounts_Anjali Potdar").setValue("Dues are  clread "+Anju_sts_acc)
            Anjali_sts_grn.setBackgroundColor(Color.GREEN)
            Anjali_sts_red.setBackgroundColor(Color.parseColor("#0E80D0"))
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

        val Suggestion=findViewById<Button>(R.id.suggestion_view)
Suggestion.setOnClickListener {

    val intent_sug=Intent(this,DeptSuggestionActivity::class.java)
    startActivity(intent_sug)
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