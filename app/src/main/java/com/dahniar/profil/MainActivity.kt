package com.dahniar.profil

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dahniar.profil.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_profile.setOnClickListener {
            val profile = Intent(this@MainActivity,ProfilActivity::class.java)
            startActivity(profile)
        }

        btn_produk.setOnClickListener{
            val dataIntent = Intent(this@MainActivity,ProdukActivity::class.java)
            dataIntent.putExtra(ProdukActivity.EXTRA_PRODUK, "Bunga Kering")
            dataIntent.putExtra(ProdukActivity.EXTRA_BERAT, " 8 gram - 10 gram")
            dataIntent.putExtra(ProdukActivity.EXTRA_DETAIL, "Sesuai dengan namanya, bunga kering merupakan bunga yang telah melalui proses pengeringan atau dehidrasi secara alami. Sehingga bunga tersebut akan menjadi kering seutuhnya, yang mana untuk pewarnaannya tetap harus melalui satu proses lagi agar tampak terlihat lebih segar.")
            startActivity(dataIntent)
        }

        btn_intent_parcelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcleActivity::class.java)
            val user = User("Bunga Kering", " 8 gram - 10 gram", "Sesuai dengan namanya, bunga kering merupakan bunga yang telah melalui proses pengeringan atau dehidrasi secara alami. Sehingga bunga tersebut akan menjadi kering seutuhnya, yang mana untuk pewarnaannya tetap harus melalui satu proses lagi agar tampak terlihat lebih segar.")
            parcelIntent.putExtra(ParcleActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "081257288672"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body", "Haii")
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}