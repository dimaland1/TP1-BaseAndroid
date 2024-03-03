package com.example.interfacesimple.InterfaceSimple

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.interfacesimple.R

class TelephoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telephone)

        val telephone = intent.getStringExtra("NUMERO")
        val telephoneView = findViewById<TextView>(R.id.numeroTelephone)
        telephoneView.text = telephone

        // Appeler le numéro de téléphone
        val appeler = findViewById<Button>(R.id.appelerBTN)
        appeler.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$telephone")
            startActivity(intent)
        }

    }
}