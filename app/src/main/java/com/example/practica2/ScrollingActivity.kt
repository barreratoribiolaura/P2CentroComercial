package com.example.practica2

import android.app.ActivityOptions
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practica2.Clases.CentroComercial

import com.example.practica2.Clases.Tienda
import com.example.practica2.databinding.ActivityScrollingBinding
import java.io.Serializable

class ScrollingActivity : AppCompatActivity() {

    var mediaPlayer:MediaPlayer? = null
    var position:Int= 0


    private lateinit var binding: ActivityScrollingBinding

    var tAlehop = Tienda("Ale-hop", "Es una cadena española de tiendas de regalo que comercializa moda, papelería, diferentes accesorios de hogar y decoración española.")
    var tGame = Tienda("Game", "Game Retail Limited es un minorista británico de videojuegos, propiedad de Frasers Group desde junio de 2019. Los orígenes de la empresa se encuentran en la fundación de Rhino Group por Terry Norris y Bev Ripley en 1992.")
    var tMango = Tienda("Mango", "Es una empresa multinacional española dedicada al diseño, la fabricación y la comercialización de prendas de vestir y complementos para mujer, niño y hombre.")
    var tBershka = Tienda("Bershka", "Líderes en Belleza online. Compra tus PERFUMES y productos de MAQUILLAJE, COSMÉTICA y PARAFARMACIA de las mejores marcas a los mejores precios del mercado.")
    var tBurgerKing = Tienda("BurgerKing", "Es una cadena de tiendas de ropa perteneciente al grupo español Inditex, fundado por el empresario Amancio Ortega.En abril de 1998, Bershka abrió su primer comercio.")

    var tDruni = Tienda("Druni", "Cadena de establecimientos de comida rápida estadounidense con sede central en Miami, Florida, fundada por James McLamore y David Edgerton.")
    var tPrimark = Tienda("Primark", "Es una cadena irlandesa de ropa y complementos que pertenece al grupo Associated British Foods.")
    var tZara = Tienda("Zara", "Es una cadena de moda española de Arteijo, España. Perteneciente al grupo Inditex, fue fundada por Amancio Ortega y Rosalía Mera.")
    var tPullBear = Tienda("Pull&Bear", "Es una cadena de moda joven que está englobada en el grupo Inditex. Sus oficinas centrales se encuentran en Narón España. PullandBear está presente en 74 mercados con una red de más de 970 tiendas.")
    var tCortefiel = Tienda("Cortefiel", "Tendam, anteriormente denominada Grupo Cortefiel,es una de las principales compañías europeas del sector moda en el segmento de las cadenas especializadas.")

    var tCaixabank = Tienda("CaixaBank", "CaixaBank es un banco español con domicilio social en Valencia y sedes operativas en Madrid y en Barcelona, fundado en 2011 por la Caja de Ahorros y Pensiones de Barcelona, que aportó los activos y pasivos de su negocio bancario.")
    var tVips = Tienda("VIPS", "Grupo Vips es un grupo español multimarca y multiformato del sector de la restauración y el comercio.")
    var tAlcampo = Tienda("Alcampo", "Alcampo es una empresa de distribución, filial del grupo francés Auchan, que opera en España bajo los formatos de supermercados, hipermercados y comercio online.")
    var tPhoneHouse = Tienda("PhoneHouse","Tienda de Móviles, Tarifas, Informática, Tecnología online y servicios para las personas y el hogar." )
    var tSephora = Tienda("Sephora", "Sephora es una cadena de cosméticos fundada en Francia en 1969 y adquirida por el conglomerado LVMH, primera empresa del mundo de artículos de lujo, con sede en París, en 1997.")

    var lista_NuevoCentro: List<Tienda> = listOf(tAlehop, tGame, tMango, tBershka, tBurgerKing)
    var lista_Bonaire: List<Tienda> = listOf(tPrimark, tCaixabank, tAlcampo, tPhoneHouse, tBershka, tAlehop)
    var lista_MN4: List<Tienda> = listOf(tVips, tPullBear, tDruni, tMango, tZara)
    var lista_ElSaler: List<Tienda> = listOf(tSephora, tCortefiel, tBershka, tDruni, tGame, tZara, tMango, tPullBear)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        crearCC()

        binding.content.cv1.setOnClickListener {

            pasarDatos(1)

        }

        binding.content.cv2.setOnClickListener {

            pasarDatos(2)

        }
        binding.content.cv3.setOnClickListener {

            pasarDatos(3)

        }
        binding.content.cv4.setOnClickListener {

            pasarDatos(4)

        }
    }



    private fun pasarDatos(id:Int) {
        val intent = Intent(this, TiendasActivity::class.java)

        if(mediaPlayer != null){

            position = mediaPlayer!!.currentPosition
            intent.putExtra("position",position)

        }


        intent.putExtra("id",id)

        intent.putExtra("ntAle-hop",tAlehop.nombre_tienda)
        intent.putExtra("ntGame",tGame.nombre_tienda)
        intent.putExtra("ntPrimark",tPrimark.nombre_tienda)
        intent.putExtra("ntZara",tZara.nombre_tienda)
        intent.putExtra("ntMango",tMango.nombre_tienda)
        intent.putExtra("ntPhoneHouse",tPhoneHouse.nombre_tienda)
        intent.putExtra("ntBershka",tBershka.nombre_tienda)

        intent.putExtra("dtAle-hop",tAlehop.descripcion)
        intent.putExtra("dtGame",tGame.descripcion)
        intent.putExtra("dtPrimark",tPrimark.descripcion)
        intent.putExtra("dtZara",tZara.descripcion)
        intent.putExtra("dtMango",tMango.descripcion)
        intent.putExtra("dtPhoneHouse",tPhoneHouse.descripcion)
        intent.putExtra("dtBershka",tBershka.descripcion)

        startActivity(intent)
    }

    //Glide
    private fun loadImage(
        url: String,
        iv: ImageView
    ) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(iv)
    }

    private fun rellenarCC(
        CC: CentroComercial,
        nombreCC: TextView,
        direccionCC: TextView,
        ntiendasCC: TextView
    ) {
        nombreCC.text = CC.nombre
        direccionCC.text = CC.direccion
        ntiendasCC.text = CC.n_tiendas.toString()
    }

    private fun crearCC() {

        val c1 = CentroComercial(1, "Nuevo Centro","Av.de Pius XII,2,46009 València", lista_NuevoCentro.size,lista_NuevoCentro)
        rellenarCC(c1, binding.content.nombreNuevoCentro, binding.content.direccionNuevoCentro, binding.content.tiendasNuevoCentro)

        loadImage(
            "https://www.lovevalencia.com/wp-content/uploads/2012/01/Nuevo-centro2.jpg",
            binding.content.imgNuevoCentro
        )

        val c2 = CentroComercial(
            2,
            "Bonaire",
            "Autovía del Este, Km. 345, 46960, Valencia",
            lista_Bonaire.size,
            lista_Bonaire
        )
        rellenarCC(
            c2,
            binding.content.nombreBonaire,
            binding.content.direccionBonaire,
            binding.content.tiendasBonaire
        )
        loadImage(
            "https://www.lovevalencia.com/wp-content/uploads/2017/12/Navidad-en-Bonaire-Valencia.jpg",
            binding.content.imgBonaire
        )

        val c3 =
            CentroComercial(3, "MN4", "C. Alcalde José Puertes, 46910 Alfafar, Valencia", lista_MN4.size, lista_MN4)
        rellenarCC(
            c3,
            binding.content.nombreMN4,
            binding.content.direccionMN4,
            binding.content.tiendasMN4
        )
        loadImage(
            "https://e00-expansion.uecdn.es/assets/multimedia/imagenes/2016/05/16/14633521170346.jpg",
            binding.content.imgMN4
        )

        val c4 = CentroComercial(
            4,
            "El Saler",
            "Av. del Professor López Piñero, 16, 46013 València",
            lista_ElSaler.size,
            lista_ElSaler
        )
        rellenarCC(
            c4,
            binding.content.nombreElSaler,
            binding.content.direccionElSaler,
            binding.content.tiendasElSaler
        )
        loadImage(
            "https://www.valenciablog.com/wp-content/uploads/2006/11/saler-centro-comercial-valencia.jpg",
            binding.content.imgElSaler
        )

    }

    override fun onStart() {
        super.onStart()

        mediaPlayer = MediaPlayer.create(this,R.raw.neighborhood_corto)

    }

    override fun onResume() {
        super.onResume()
        val extras = intent.extras
        if (extras != null){
            position = extras.getInt("returnposition")
        }
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()

        mediaPlayer?.pause()
        if (mediaPlayer != null){
            position  = mediaPlayer!!.currentPosition
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }





}





