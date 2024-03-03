package com.example.interfacesimple.calendrier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.interfacesimple.R
import java.util.Calendar


data class Tache(
    val date: String,
    var listeAFaire: List<String>,
)

class CalendrierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendrier)


        var tache = listOf<Tache>(
            Tache("1/3/2024", listOf("Faire les courses", "Ranger la maison")),
            Tache("2/4/2024", listOf("Faire les courses", "Ranger la chambre", "Faire le menage")),
            Tache("3/3/2024", listOf("Faire les courses", "Ranger la cuisine", "Faire le menage", "Faire la vaisselle")),
            Tache("4/3/2024", listOf("Faire les courses", "Ranger la maison")),
        )

        val calendar = findViewById<CalendarView>(R.id.calendarView)

        val listeEvenemet = findViewById<ListView>(R.id.listeTache)
        val inputEvenement = findViewById<EditText>(R.id.tacheInput)


        var currentDate = getCurrentDate()
        addTask(currentDate, tache, listeEvenemet)

        calendar.setOnDateChangeListener {
            view, year, month, dayOfMonth ->
            currentDate = "$dayOfMonth/${month + 1}/$year"
            addTask(currentDate, tache, listeEvenemet)
        }

        //ajout une tache
        val ajoutTache = findViewById<Button>(R.id.addButton)
        ajoutTache.setOnClickListener {
            val tacheDuJour = tache.find { it.date == currentDate }
            if (tacheDuJour != null) {
                tacheDuJour.listeAFaire += inputEvenement.text.toString()
            } else {
                tache += Tache(currentDate, listOf(inputEvenement.text.toString()))
            }
            Toast.makeText(this, "evenement ajoutée", Toast.LENGTH_SHORT).show()
            addTask(currentDate, tache, listeEvenemet)
        }


        // quand on clique sur une tache on a une boite de dialogue qui s'ouvre et qui demande si on veut supprimer la tache
        listeEvenemet.setOnItemClickListener { parent, view, position, id ->
            val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setTitle("Supprimer la tache")
            builder.setMessage("Voulez-vous supprimer cette tache ?")
            builder.setPositiveButton("Oui") { dialog, which ->
                val tacheDuJour = tache.find { it.date == currentDate }
                if (tacheDuJour != null) {
                    tacheDuJour.listeAFaire -= tacheDuJour.listeAFaire[position]
                }
                Toast.makeText(this, "evenement supprimée", Toast.LENGTH_SHORT).show()

                // recharger la liste des taches
                addTask(currentDate, tache, listeEvenemet)
            }
            builder.setNegativeButton("Non") { dialog, which ->
                Toast.makeText(this, "evenement non supprimée", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
    }

    private fun addTask(currentDate: String, tache: List<Tache>, listeTache: ListView) {
        val tacheDuJour = tache.find { it.date == currentDate }
        listeTache.adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_list_item_1, tacheDuJour?.listeAFaire ?: listOf())
    }

    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return "$day/${month + 1}/$year"
    }

}

