package com.example.interfacesimple.InterfaceSimple

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.interfacesimple.InterfaceSimple1.TelephoneActivity
import com.example.interfacesimple.R

class ViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val textNomEtPrenom: TextView = findViewById(R.id.textNomEtPrenom)
        val textAge: TextView = findViewById(R.id.textViewAge)
        val textNumero: TextView = findViewById(R.id.textViewNumero)
        val texteCompetences: TextView = findViewById(R.id.textViewCompetences)


        // Récupérer les données
        val nom = intent.getStringExtra("NOM")
        val prenom = intent.getStringExtra("PRENOM")
        val age = intent.getIntExtra("AGE", 0)
        val numero = intent.getStringExtra("NUMERO")


        // Récupérer les états des CheckBox de l'Intent
        val etatBricolage = intent.getBooleanExtra("BRICOLAGE", false)
        val etatCuisine = intent.getBooleanExtra("CUISINE", false)
        val etatMenage = intent.getBooleanExtra("MENAGE", false)
        val etatMecanique = intent.getBooleanExtra("MECANIQUE", false)
        val etatMeuble = intent.getBooleanExtra("MEUBLE", false)

        // Mettre à jour les TextViews
        textNomEtPrenom.text = "$nom $prenom"
        textAge.text = " age : $age ans"
        textNumero.text =" numero : $numero"

        //afficher que les compétences cochées
        texteCompetences.text = "Compétences : \n"
        if (etatBricolage) texteCompetences.text = texteCompetences.text.toString() + "Bricolage\n"
        if (etatCuisine) texteCompetences.text = texteCompetences.text.toString() + "Cuisine\n"
        if (etatMenage) texteCompetences.text = texteCompetences.text.toString() + "Ménage\n"
        if (etatMecanique) texteCompetences.text = texteCompetences.text.toString() + "Mécanique\n"
        if (etatMeuble) texteCompetences.text = texteCompetences.text.toString() + "Montage de meubles\n"



        val buttonRetour = findViewById<Button>(R.id.buttonRetour)
        buttonRetour.setOnClickListener {
            //retourner à l'activité précédente
            finish()
        }

        val buttonOk = findViewById<Button>(R.id.buttonOk)
        buttonOk.setOnClickListener {
            val intent = Intent(this, TelephoneActivity::class.java).apply {
                putExtra("NUMERO", numero)
            }
            startActivity(intent)
        }
    }
}