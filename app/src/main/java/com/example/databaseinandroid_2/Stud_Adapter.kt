package com.example.databaseinandroid_2

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class Stud_Adapter (private val context : WelcomeActivity, private val arrayList: ArrayList<User_adapter>) :
    ArrayAdapter<User_adapter>(context, R.layout.eachitem, arrayList) {

    @SuppressLint("MissingInflatedId")
    override
    fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachitem, null)

        val dep_img=view.findViewById<CircleImageView>(R.id.profile_image)
        val Dep_name=view.findViewById<TextView>(R.id.tVName)
        val Dep_status=view.findViewById<TextView>(R.id.tVLastMessage)



        Dep_name.text=arrayList[position].Dep_name
        Dep_status.text=arrayList[position].Dept_status
        dep_img.setImageResource(arrayList[position].Dept_pic)

        return view
    }
}