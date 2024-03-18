package com.example.databaseinandroid_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

//import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Student_suggestion : AppCompatActivity() {
    private lateinit var suggestionEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_suggestion)
        val name = intent.getStringExtra(WelcomeActivity.KEY)



        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().reference.child("suggestions")

        suggestionEditText = findViewById(R.id.suggestionEditText)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val suggestion = suggestionEditText.text.toString().trim()

            if (suggestion.isNotEmpty()) {
                // Push suggestion to Firebase database
                val suggestionKey = databaseReference.push().key
                if (suggestionKey != null) {
                    databaseReference.child(suggestionKey).setValue(suggestion)
                        .addOnSuccessListener {
                            // Clear the EditText after successful submission
                            suggestionEditText.setText("")
                            // Show success message
                            showToast("Suggestion submitted successfully")
                        }
                        .addOnFailureListener {
                            // Show error message if submission fails
                            showToast("Failed to submit suggestion")
                        }
                }
            } else {
                showToast("Please enter a suggestion")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}