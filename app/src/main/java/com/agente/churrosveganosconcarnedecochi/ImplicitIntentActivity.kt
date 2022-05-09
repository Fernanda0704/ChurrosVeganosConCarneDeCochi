package com.agente.churrosveganosconcarnedecochi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        agregarAccionAlBotonWeb()
    }

    private fun agregarAccionAlBotonWeb() {
        // Obtener el enlace al botón para enviar uri a web
        val botonWeb = findViewById<ImageButton>(R.id.imageButtonWeb)
        // asignar la accion al botonWeb para que llame al navegador
        botonWeb.setOnClickListener {
            // obtener el valor de la caja de texto web
            val textoWeb = findViewById<EditText>(R.id.editTextWeb).text
            // validar que no este vacia la caja de texto
            if (textoWeb.isEmpty())
                // enviar mensaje de error, para que ingrese algo
                    Toast.makeText(this, "No te hagas cochi, escribe algo",Toast.LENGTH_SHORT).show()
            else {
                // definir el intent implicito
                val intentWeb = Intent()
                // definir la accion para el intent
                intentWeb.action = Intent.ACTION_VIEW
                // convertir texto web a uri
                intentWeb.data = Uri.parse("https://$textoWeb")
                // iniciar el intent - llamar al intent
                startActivity(intentWeb)
            }
        }
    }
}