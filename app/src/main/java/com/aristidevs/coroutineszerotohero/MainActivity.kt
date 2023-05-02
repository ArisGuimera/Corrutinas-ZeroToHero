package com.aristidevs.coroutineszerotohero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val retrofit = RetrofitHelper.getInstance()

    //Main = Hilo principal
    // IO = Retrofit
    // Default = procesar informacion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(Dispatchers.IO) {
            val response: Response<SuperHeroDataResponse> = retrofit.getSuperheroes("a")
            if (response.isSuccessful) {
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "FUNCIONA", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    fun waitForCoroutines() {
        lifecycleScope.launch(Dispatchers.IO) {
//            val deferred1 = async { retrofit.getSuperheroes("a") }
//            val deferred2 = async { retrofit.getSuperheroes("b") }
//            val deferred3 = async { retrofit.getSuperheroes("c") }
//            val deferred4 = async { retrofit.getSuperheroes("d") }
//
//           val response = deferred1.await()
//           val response2 = deferred2.await()
//           val response3 = deferred3.await()
//           val response4 = deferred4.await()

            val deferreds = listOf(
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") },
                async { retrofit.getSuperheroes("a") }
            )

            val response = deferreds.awaitAll()

        }
    }

    suspend fun suscribete() {

    }
}