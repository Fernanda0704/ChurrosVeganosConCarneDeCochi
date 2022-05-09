package com.agente.churrosveganosconcarnedecochi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        agregarAccionAlBotonWeb()
        agregarAccionAlBotonEmail()
        agregarAccionAlBotonPhone()
        agregarAccionAlBotonCamera()

        // agregar soporte para que muestre el icono en la barra de accion
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)
    }

    private fun agregarAccionAlBotonCamera() {
        // Obtener el enlace al botonCamera
        val botonCamera = findViewById<ImageButton>(R.id.imageButtonCamera)
        // asignar la accion al boton
        botonCamera.setOnClickListener {
            // definir el intent para llamar a la camara
            val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // ejecutar el intent
            startActivity(intentCamera)
        }
    }

    private fun agregarAccionAlBotonPhone() {
        // Obtener el enlace al botonPhone
        val botonPhone = findViewById<ImageButton>(R.id.imageButtonPhone)
        // asignar la accion al botonPhone para intentar llamar al telefono
        botonPhone.setOnClickListener {
            // obtener el numero telefonico de la caja de texto
            val telefono = findViewById<EditText>(R.id.editTextPhone).text
            // validar que el numero telefonico haya sido ingresado
            // de lo contrario enviar mensaje de cochi
            if (telefono.isEmpty()) {
                Toast.makeText(this, "No te hgas cochi, ingresa el telefono", Toast.LENGTH_SHORT).show()
            } else {
                val intentPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telefono"))
                startActivity(intentPhone)
            }
        }
        }

    private fun agregarAccionAlBotonEmail() {
        // Obtener el enlace al botonEmail
        val botonCorreo = findViewById<Button>(R.id.buttonEmail)
        // asignar la accion al botonCorreo para que envie un mensaje por correo
        botonCorreo.setOnClickListener {
            val email = "maria.garcia.felix.2019@cetis108.edu.mx"
            // inicializar el internet con el remitente
            val intentEmail = Intent(Intent.ACTION_SEND, Uri.parse(email))
            // agregar el asunto del correo
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Hola desde Android")
            // agregar el mensaje de correo
            intentEmail.putExtra(Intent.EXTRA_TEXT, "Responde por favor no te hagas cochi")
            // agregar el destinatario
            intentEmail.putExtra(Intent.EXTRA_EMAIL, "convenencieros@del.sexto.a.matutino")
            // definir el tipo de contenido
            intentEmail.type = "text/plain"
            // ejecutar el intent
            startActivity(Intent.createChooser(intentEmail, "Enviar con..."))
        }
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


