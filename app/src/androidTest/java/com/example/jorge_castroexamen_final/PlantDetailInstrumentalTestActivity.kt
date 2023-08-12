package com.example.jorge_castroexamen_final

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jorge_castroexamen_final.View.MainActivity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PlantDetailInstrumentalTestActivity {


    // Simulacion que envia datos a la Main Activity
    @Test
    fun testShowValidatePhone() {

        // Se crea el contexto
        val context = androidx.test.platform.app.InstrumentationRegistry.getInstrumentation()
            .targetContext

        // Establecemos Intent que navega de este contexto a la Main Activity
        val intent = Intent(context, MainActivity::class.java)

        // Se remiten los datos con clave, valor
        intent.putExtra("id", 1)
        intent.putExtra("nombre", " prueba unitaria")
        intent.putExtra("imagen", "imagen")
        intent.putExtra("descripcion", "descripcion")

        val activityScenario = ActivityScenario.launch<MainActivity>(intent)

        // Una vez lanzada la actividad la declaramos y empezamos a revisar lo recibido en el intent
        activityScenario.onActivity { activity ->

            // Revisar que no sea null
            assertNotNull(activity)

            // Verificar que lo enviado sea recibido en la activity
            assertEquals(1, activity.intent.getIntExtra("id", -1))
            assertEquals(" prueba unitaria", activity.intent.getStringExtra("nombre"))
            assertEquals("imagen", activity.intent.getStringExtra("imagen"))
            assertEquals("descripcion", activity.intent.getStringExtra("descripcion"))
        }
    }
}