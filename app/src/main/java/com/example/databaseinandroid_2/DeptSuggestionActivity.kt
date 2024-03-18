package com.example.databaseinandroid_2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DeptSuggestionActivity : AppCompatActivity() {
    private lateinit var suggestionListView: ListView
    private lateinit var databaseReference: DatabaseReference
    private lateinit var suggestions: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dept_suggestion)
        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().reference.child("suggestions")

        suggestionListView = findViewById(R.id.suggestionListView)
        suggestions = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, suggestions)
        suggestionListView.adapter = adapter

        // Retrieve suggestions from Firebase database
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                suggestions.clear()
                for (suggestionSnapshot in snapshot.children) {
                    val suggestion = suggestionSnapshot.getValue(String::class.java)
                    if (suggestion != null) {
                        suggestions.add(suggestion)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle database error
            }
        })
    }
}
