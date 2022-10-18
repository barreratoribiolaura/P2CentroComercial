package com.example.practica2

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.practica2.Clases.Tienda
import com.example.practica2.databinding.ActivityTiendasBinding
import java.io.Serializable


class TiendasActivity : AppCompatActivity() {

    private var mediaPlayer:MediaPlayer? = null

    private lateinit var binding: ActivityTiendasBinding

    var position:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityTiendasBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val extras = intent.extras
        if (extras != null){
            position = extras.getInt("position")
            mediaPlayer?.seekTo(position!!)
        }


        val ntAlehop = intent.extras?.get("ntAle-hop")
        val ntGame = intent.extras?.get("ntGame")
        val ntPrimark = intent.extras?.get("ntPrimark")
        val ntZara = intent.extras?.get("ntZara")
        val ntMango = intent.extras?.get("ntMango")
        val ntPhoneHouse = intent.extras?.get("ntPhoneHouse")
        val ntBershka = intent.extras?.get("ntBershka")

        val dtAlehop = intent.extras?.get("dtAle-hop")
        val dtGame = intent.extras?.get("dtGame")
        val dtPrimark = intent.extras?.get("dtPrimark")
        val dtZara = intent.extras?.get("dtZara")
        val dtMango = intent.extras?.get("dtMango")
        val dtPhoneHouse = intent.extras?.get("dtPhoneHouse")
        val dtBershka = intent.extras?.get("dtBershka")


        val idCC = intent.extras?.get("id")

        if (idCC == 1){

            binding.nt1.text=ntAlehop.toString()
            binding.des1.text=dtAlehop.toString()

            binding.nt2.text=ntGame.toString()
            binding.des2.text=dtGame.toString()

            binding.nt3.text=ntPrimark.toString()
            binding.des3.text=dtPrimark.toString()

            binding.nt4.text=ntZara.toString()
            binding.des4.text=dtZara.toString()

        }

        if (idCC == 2){

            binding.nt1.text=ntMango.toString()
            binding.des1.text=dtMango.toString()

            binding.nt2.text=ntPrimark.toString()
            binding.des2.text=dtPrimark.toString()

            binding.nt3.text=ntBershka.toString()
            binding.des3.text=dtBershka.toString()


            binding.nt4.text=ntZara.toString()
            binding.des4.text=dtZara.toString()

        }

        if (idCC == 3){

            binding.nt1.text=ntPhoneHouse.toString()
            binding.des1.text=dtPhoneHouse.toString()

            binding.nt2.text=ntZara.toString()
            binding.des2.text=dtZara.toString()

            binding.nt3.text=ntMango.toString()
            binding.des3.text=dtMango.toString()


            binding.nt4.text=ntBershka.toString()
            binding.des4.text=dtBershka.toString()

        }
        if (idCC == 4){

            binding.nt1.text=ntPrimark.toString()
            binding.des1.text=dtPrimark.toString()

            binding.nt2.text=ntPhoneHouse.toString()
            binding.des2.text=dtPhoneHouse.toString()

            binding.nt3.text=ntBershka.toString()
            binding.des3.text=dtBershka.toString()


            binding.nt4.text=ntZara.toString()
            binding.des4.text=dtZara.toString()

        }



    }

    override fun onStart() {
        super.onStart()

        mediaPlayer = MediaPlayer.create(this,R.raw.neighborhood_corto)


    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if (mediaPlayer != null) {
            position = mediaPlayer!!.currentPosition
        }

    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position!!)
        mediaPlayer?.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var returnIntent = Intent()
        returnIntent.putExtra("returnposition",position)
        setResult(RESULT_OK,returnIntent)
        finish()
    }




}