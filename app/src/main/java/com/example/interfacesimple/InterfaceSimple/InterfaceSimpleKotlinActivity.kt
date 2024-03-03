package com.example.interfacesimple.InterfaceSimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import com.example.interfacesimple.R

class InterfaceSimpleKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linearLayout = LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
        }
        val editNom = EditText(this).apply {
            id = R.id.editNom
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            hint = getString(R.string.nom)
        }
        linearLayout.addView(editNom)

        val editPrenom = EditText(this).apply {
            id = R.id.editPrenom
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            hint = getString(R.string.prenom)
        }
        linearLayout.addView(editPrenom)

        val editAge = EditText(this).apply {
            id = R.id.editTextNumber
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            hint = getString(R.string.age)
            inputType = InputType.TYPE_CLASS_NUMBER
        }
        linearLayout.addView(editAge)

        val editNumero = EditText(this).apply {
            id = R.id.editTextNumber2
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            hint = getString(R.string.numero)
            inputType = InputType.TYPE_CLASS_NUMBER
        }
        linearLayout.addView(editNumero)

        val checkBoxBricolage = CheckBox(this).apply {
            id = R.id.checkBox
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = getString(R.string.faire_du_bricolage)
        }
        linearLayout.addView(checkBoxBricolage)

        val checkBoxCuisine = CheckBox(this).apply {
            id = R.id.checkBox2
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = getString(R.string.faire_de_la_cuisine)
        }
        linearLayout.addView(checkBoxCuisine)

        val checkBoxMenage = CheckBox(this).apply {
            id = R.id.checkBox3
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = getString(R.string.faire_le_m_nage)
        }
        linearLayout.addView(checkBoxMenage)

        val checkBoxMeubles = CheckBox(this).apply {
            id = R.id.checkBox4
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = getString(R.string.monter_les_meubles)
        }
        linearLayout.addView(checkBoxMeubles)

        val checkBoxMecanique = CheckBox(this).apply {
            id = R.id.checkBox5
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = getString(R.string.faire_de_la_m_canique)
        }
        linearLayout.addView(checkBoxMecanique)

        // Créer le Button
        val buttonSubmit = Button(this).apply {
            id = R.id.buttonSubmit
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = getString(R.string.valider)
        }
        linearLayout.addView(buttonSubmit)

        setContentView(linearLayout)
    }
}