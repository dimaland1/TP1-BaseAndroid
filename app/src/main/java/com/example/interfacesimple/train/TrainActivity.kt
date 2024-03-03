package com.example.interfacesimple.train

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.interfacesimple.R

class TrainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)

        val listeville = listOf("Paris", "Lyon", "Marseille", "Lille")

        val voyages = listOf(
            Voyage("Paris", "Lyon", "08:00", "10:30"),
            Voyage("Paris", "Lyon", "10:00", "12:30"),
            Voyage("Paris", "Lyon", "14:00", "16:30"),
            Voyage("Paris", "Lyon", "16:00", "18:30"),
            Voyage("Lyon", "Paris", "11:00", "13:30"),
            Voyage("Lyon", "Paris", "15:00", "17:30"),
            Voyage("Lyon", "Paris", "17:00", "19:30"),
            Voyage("Paris", "Marseille", "07:00", "10:45"),
            Voyage("Paris", "Marseille", "09:00", "12:45"),
            Voyage("Paris", "Marseille", "13:00", "16:45"),
            Voyage("Paris", "Marseille", "15:00", "18:45"),
            Voyage("Marseille", "Paris", "07:00", "10:45"),
            Voyage("Marseille", "Paris", "13:00", "16:45"),
            Voyage("Marseille", "Paris", "15:00", "18:45"),
            Voyage("Paris", "Lille", "08:00", "09:45"),
            Voyage("Paris", "Lille", "10:00", "11:45"),
            Voyage("Paris", "Lille", "14:00", "15:45"),
            Voyage("Paris", "Lille", "16:00", "17:45"),
            Voyage("Lille", "Paris", "14:00", "15:45"),
            Voyage("Lille", "Paris", "16:00", "17:45"),
            Voyage("Lyon", "Marseille", "08:00", "10:15"),
            Voyage("Lyon", "Marseille", "10:00", "12:15"),
            Voyage("Lyon", "Marseille", "14:00", "16:15"),
            Voyage("Lyon", "Marseille", "16:00", "18:15"),
            Voyage("Marseille", "Lyon", "08:00", "10:15"),
            Voyage("Marseille", "Lyon", "14:00", "16:15"),
            Voyage("Marseille", "Lyon", "16:00", "18:15"),
            Voyage("Lyon", "Lille", "07:00", "10:30"),
            Voyage("Lyon", "Lille", "13:00", "16:30"),
            Voyage("Lyon", "Lille", "17:00", "20:30"),
            Voyage("Lille", "Lyon", "08:00", "11:30")
        )


        val searchButton = findViewById<Button>(R.id.searchButton)
        var villeDepart = findViewById<Spinner>(R.id.departureCity)
        val villeArrivee = findViewById<Spinner>(R.id.arrivalCity)

        var listeHeureDepart = findViewById<ListView>(R.id.horaireList)

        villeDepart.adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_spinner_item, listeville)

        villeDepart.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)
                villeArrivee.adapter = android.widget.ArrayAdapter(this@TrainActivity, android.R.layout.simple_spinner_item, listeville.filter { it != item })
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }



        // Quand l'utilisateur appuie sur le bouton "Rechercher", on lui affiche les horaires de train
        searchButton.setOnClickListener {
            val depart = villeDepart.selectedItem.toString()
            val arrivee = villeArrivee.selectedItem.toString()
            val horaires = voyages.filter { it.villeDepart == depart && it.villeArrivee == arrivee }

            // Afficher les horaires
            listeHeureDepart.adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_list_item_1, horaires.map {
                "De ${ it.villeDepart } à ${ it.villeArrivee } -> ${it.horaireDepart} - ${it.horaireArrivee}" })


        }
    }
}

data class Voyage(
    val villeDepart: String,
    val villeArrivee: String,
    val horaireDepart: String,
    val horaireArrivee: String
)

