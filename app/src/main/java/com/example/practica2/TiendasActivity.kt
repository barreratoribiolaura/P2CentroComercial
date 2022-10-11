package com.example.practica2

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.practica2.Clases.Tienda
import com.example.practica2.databinding.ActivityTiendasBinding
import java.io.Serializable

class TiendasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTiendasBinding

    val bundle = intent.extras

    var lista = bundle?.getString("lista_NuevoCentro")
    //var lista = intent.getSerializableExtra("lista_NuevoCentro") as List<Tienda>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTiendasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.texto.text=lista_NuevoCentro.toString()

    }
}