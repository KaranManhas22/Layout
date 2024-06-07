package com.karan.layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name: EditText? = null
    var number: EditText? = null
    var dob: EditText? = null

    var MOVE: Button? = null
    var yes: Button?= null
    var no: Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        dob = findViewById(R.id.dob)
        MOVE = findViewById(R.id.MOVE)
        yes = findViewById(R.id.yes)
        no = findViewById(R.id.no)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        MOVE?.setOnClickListener {
            if (name?.text?.trim().isNullOrEmpty()) {
                name?.error = "Please fill the name"


            } else if (number?.text?.trim().isNullOrEmpty()) {
                number?.error = "Please enter the number"
            } else if (dob?.text?.trim().isNullOrEmpty()) {
                dob?.error = "Please fill the dob"
            } else {
                Toast.makeText(this, "Button is pressed ${name?.text}", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Layout_secondscreen::class.java)
                startActivity(intent)
                MOVE?.setOnClickListener {
                    var intent = Intent(this, Layout_secondscreen::class.java)
                    startActivity(
                        intent
                    )

                }

            }
        }
    }
}

