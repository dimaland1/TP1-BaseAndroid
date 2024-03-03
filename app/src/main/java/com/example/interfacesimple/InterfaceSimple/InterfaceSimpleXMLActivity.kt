package com.example.interfacesimple.InterfaceSimple

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.interfacesimple.R
import java.util.Locale


class InterfaceSimpleXMLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_project)

        val btnSubmit: Button = findViewById(R.id.buttonSubmit)
        val buttonChangeLanguage: Button = findViewById(R.id.buttonChangeLanguage)

        buttonChangeLanguage.setOnClickListener {
            // langage de l'application courrant
            val currentLanguage = resources.configuration.locale.language
            if (currentLanguage == "fr") {
                val locale = Locale("en")
                Locale.setDefault(locale)
                val config = Configuration()
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics) // mise à jour de la configuration

                finish();
                startActivity(intent);
            } else {
                val locale = Locale("fr")
                Locale.setDefault(locale)
                val config = Configuration()
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics) // mise à jour de la configuration

                finish();
                startActivity(intent);
            }

            val language = resources.configuration.locale.language
            Toast.makeText(applicationContext, "Langue : $language", Toast.LENGTH_SHORT).show()
        }


        btnSubmit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmer")
            builder.setMessage("Êtes-vous sûr de vouloir continuer ?")

            builder.setPositiveButton("confirmer") { dialog, which ->
                callViewActivity();
            }

            builder.setNegativeButton("annuler") { dialog, which ->
                Toast.makeText(applicationContext, "Action annulée", Toast.LENGTH_SHORT).show()
            }

            // Afficher la fenêtre de dialogue
            builder.show()
        }

    }

    private fun callViewActivity(){
        val intent = Intent(this, ViewActivity::class.java).apply {
            putExtra("NOM", findViewById<EditText>(R.id.editNom).text.toString())
            putExtra("PRENOM", findViewById<EditText>(R.id.editPrenom).text.toString())
            putExtra("AGE", findViewById<EditText>(R.id.editTextNumber).text.toString().toInt())
            putExtra("NUMERO", findViewById<EditText>(R.id.editTextNumber2).text.toString())
            putExtra("BRICOLAGE", findViewById<CheckBox>(R.id.checkBox).isChecked)
            putExtra("CUISINE", findViewById<CheckBox>(R.id.checkBox2).isChecked)
            putExtra("MENAGE", findViewById<CheckBox>(R.id.checkBox3).isChecked)
            putExtra("MEUBLE", findViewById<CheckBox>(R.id.checkBox4).isChecked)
            putExtra("MECANIQUE", findViewById<CheckBox>(R.id.checkBox5).isChecked)
        }
        startActivity(intent)
    }

}