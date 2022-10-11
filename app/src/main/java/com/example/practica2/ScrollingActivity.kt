package com.example.practica2

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practica2.Clases.CentroComercial
import com.example.practica2.Clases.Tienda
import com.example.practica2.databinding.ActivityScrollingBinding
import java.io.Serializable

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    var tAlehop = Tienda("Ale-hop", R.string.dAlehop.toString())
    var tGame = Tienda("Game", R.string.dGame.toString())
    var tMango = Tienda("Mango", R.string.dMango.toString())
    var tBershka = Tienda("Bershka", R.string.dBerska.toString())
    var tBurgerKing = Tienda("BurgerKing", R.string.dBurger.toString())

    var tDruni = Tienda("Druni", R.string.dDruni.toString())
    var tPrimark = Tienda("Primark", R.string.dPrimark.toString())
    var tZara = Tienda("Zara", R.string.dZara.toString())
    var tPullBear = Tienda("Pull&Bear", R.string.dPullBear.toString())
    var tCortefiel = Tienda("Cortefiel", R.string.dCortefiel.toString())

    var tCaixabank = Tienda("CaixaBank", R.string.dCaixaBank.toString())
    var tVips = Tienda("VIPS", R.string.dVips.toString())
    var tAlcampo = Tienda("Alcampo", R.string.dAlcampo.toString())
    var tPhoneHouse = Tienda("PhoneHouse", R.string.dPhoneHouse.toString())
    var tSephora = Tienda("Sephora", R.string.dSephora.toString())

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
            val intent = Intent(this, TiendasActivity::class.java)

            intent.putExtra("lista_NuevoCentro", lista_NuevoCentro.toString())

            startActivity(intent)


        }
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

        val c1 = CentroComercial(
            1,
            "Nuevo Centro",
            R.string.dirNuevoCentro.toString(),
            lista_NuevoCentro.size,
            lista_NuevoCentro
        )
        rellenarCC(
            c1,
            binding.content.nombreNuevoCentro!!,
            binding.content.direccionNuevoCentro!!,
            binding.content.tiendasNuevoCentro!!
        )
        loadImage(
            "https://www.lovevalencia.com/wp-content/uploads/2012/01/Nuevo-centro2.jpg",
            binding.content.imgNuevoCentro!!
        )

        val c2 = CentroComercial(
            2,
            "Bonaire",
            R.string.dirBonaire.toString(),
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
            CentroComercial(3, "MN4", R.string.dirMN4.toString(), lista_MN4.size, lista_MN4)
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
            R.string.dirElSaler.toString(),
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
}





