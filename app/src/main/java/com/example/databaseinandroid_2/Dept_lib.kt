package com.example.databaseinandroid_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Dept_lib : AppCompatActivity() {
    lateinit var database_adarsh: DatabaseReference
    lateinit var database_ankita: DatabaseReference
    lateinit var database_ankali: DatabaseReference
    lateinit var databaseReference: DatabaseReference
    lateinit var databaseReference_del: DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dept_lib)

        val Ankita_sts = findViewById<TextInputEditText>(R.id.ankita_sts_lib)
        val Adarsh_sts = findViewById<TextInputEditText>(R.id.adarsh_sts_lib)
        val Anjali_sts = findViewById<TextInputEditText>(R.id.anjali_sts_lib)
        val request = findViewById<TextView>(R.id.req_lib)
        val Update = findViewById<Button>(R.id.update_btn_lib)


        databaseReference_del = FirebaseDatabase.getInstance().getReference("Users_request_Library")
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
            val Dep_name = "Accounts"
            val ankita_lib=Ankita_sts.text.toString()
            val Anku_sts_lib = Ankita_sts.text.toString()
            val Adu_sts_lib = Adarsh_sts.text.toString()
            val Anju_sts_lib = Anjali_sts.text.toString()


            //val Status = Students_data(Anku_sts, Adu_sts, Anju_sts)
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("Library_adarsh").setValue(Adu_sts_lib)

            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("Library_Ankita Mane").setValue(ankita_lib)

            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("Library_Anjali Potdar").setValue(Anju_sts_lib)


            // database.child(Dep_name).setValue(Anku_sts)
            request.text="Empty"
            Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show()

            databaseReference_del=FirebaseDatabase.getInstance().getReference("Users_request_Library")
            val nodeToDelete = databaseReference_del
            // Use removeValue() method to delete data at that node
            nodeToDelete.removeValue()

        }


        val Suggestion=findViewById<Button>(R.id.suggestion_view)
        Suggestion.setOnClickListener {

            val intent_sug= Intent(this,DeptSuggestionActivity::class.java)
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
