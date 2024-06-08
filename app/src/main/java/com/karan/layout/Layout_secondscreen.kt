package com.karan.layout

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Layout_secondscreen : AppCompatActivity() {
   var name:TextView? =null
    var dob:TextView? =null
    var number:TextView? =null
    var study:RadioGroup?=null
    var previousName = ""
    var previousDob= ""
    var previousNumber= ""
    var previousstudy= ""
    private  val TAG = this::class.java.canonicalName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_layout_secondscreen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name = findViewById(R.id.name)
        dob = findViewById(R.id.dob)
        number = findViewById(R.id.number)


        intent?.extras?.let {
            previousName = it.getString("name")?:""
            previousDob = it.getString("dob")?:""
            previousNumber = it.getString("number")?:""

            Log.e(TAG, "name $previousName")
        }
        name?.setText("$previousName")
        dob?.setText("$previousDob")
        number?.setText("$previousNumber")


    }
}