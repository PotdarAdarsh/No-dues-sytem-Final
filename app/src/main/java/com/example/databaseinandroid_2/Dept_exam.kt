package com.example.databaseinandroid_2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Dept_exam : AppCompatActivity() {
    lateinit var database_adarsh: DatabaseReference
    lateinit var database_ankita: DatabaseReference
    lateinit var database_ankali: DatabaseReference
    lateinit var databaseReference: DatabaseReference
    lateinit var databaseReference_del: DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dept_exam)
        val Ankita_sts = findViewById<TextInputEditText>(R.id.ankita_sts_lib)
        val Adarsh_sts = findViewById<TextInputEditText>(R.id.adarsh_sts_lib)
        val Anjali_sts = findViewById<TextInputEditText>(R.id.anjali_sts_lib)
        val request = findViewById<TextView>(R.id.req_lib)
        val Update = findViewById<Button>(R.id.update_btn_lib)


        databaseReference_del = FirebaseDatabase.getInstance().getReference("Users_request_Exam")
        databaseReference_del.get().addOnSuccessListener {
            if(it.exists()){

                val exm_req=it.value.toString()
                request.text=exm_req
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
            val Dep_name = "Hostel"
            val ankita_exm=Ankita_sts.text.toString()
            val Anku_sts_exm = Ankita_sts.text.toString()
            val Adu_sts_exm = Adarsh_sts.text.toString()
            val Anju_sts_exm = Anjali_sts.text.toString()


            //val Status = Students_data(Anku_sts, Adu_sts, Anju_sts)
            database_adarsh = FirebaseDatabase.getInstance().getReference("Users_status")
            database_adarsh.child("Exam_adarsh").setValue(Adu_sts_exm)

            database_ankita = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankita.child("Exam_Ankita Mane").setValue(ankita_exm)

            database_ankali = FirebaseDatabase.getInstance().getReference("Users_status")
            database_ankali.child("Exam_Anjali Potdar").setValue(Anju_sts_exm)


            // database.child(Dep_name).setValue(Anku_sts)
            request.text="Empty"
            Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show()

            databaseReference_del=FirebaseDatabase.getInstance().getReference("Users_request_Exam")
            val nodeToDelete = databaseReference_del
            // Use removeValue() method to delete data at that node
            nodeToDelete.removeValue()

        }




    }

}