package com.example.appcounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnIncrement: Button = findViewById(R.id.btnIncrement)
        val btnDecrement: Button = findViewById(R.id.btnDecrement)
        val txtCounter: TextView = findViewById(R.id.txtCounter)
        var counter = 0

        btnIncrement.setOnClickListener {
            counter++
            txtCounter.text = counter.toString()
        }

        btnDecrement.setOnClickListener {
            if (counter == 0) {
                showErrorMsg()
                return@setOnClickListener
            }
            counter--
            txtCounter.text = counter.toString()
        }
    }

    private fun showErrorMsg() {
        Snackbar.make(
            findViewById(android.R.id.content),
            "Contador zerado!",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}