package com.example.interfacesimple.InterfaceSimple

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.interfacesimple.MainActivity
import com.example.interfacesimple.R

class AlertDialog : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)


        val retour = findViewById<Button>(R.id.buttonRetour)
        retour.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}