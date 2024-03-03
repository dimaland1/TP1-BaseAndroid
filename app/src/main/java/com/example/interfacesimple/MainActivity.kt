package com.example.interfacesimple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.interfacesimple.HelloWorld.HelloWorld
import com.example.interfacesimple.InterfaceSimple.InterfaceSimpleKotlinActivity
import com.example.interfacesimple.InterfaceSimple.InterfaceSimpleXMLActivity
import com.example.interfacesimple.calendrier.CalendrierActivity
import com.example.interfacesimple.train.TrainActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HW : Button = findViewById(R.id.HelloWorld)

        HW.setOnClickListener {
            val intent = Intent(this, HelloWorld::class.java)
            startActivity(intent)

        }

        val InterfaceSimpleJava = findViewById<Button>(R.id.InterfaceSimpleJava)
        InterfaceSimpleJava.setOnClickListener {
            val intent = Intent(this, InterfaceSimpleKotlinActivity::class.java)
            startActivity(intent)
        }

        val InterfaceSimpleXML = findViewById<Button>(R.id.InterfaceSimpleXML)
        InterfaceSimpleXML.setOnClickListener {
            val intent = Intent(this, InterfaceSimpleXMLActivity::class.java)
            startActivity(intent)
        }


        val Train = findViewById<Button>(R.id.horaireTrain)
        Train.setOnClickListener {
            val intent = Intent(this, TrainActivity::class.java)
            startActivity(intent)
        }

        val Agenda = findViewById<Button>(R.id.Agenda)
        Agenda.setOnClickListener {
            val intent = Intent(this, CalendrierActivity::class.java)
            startActivity(intent)
        }

    }
}