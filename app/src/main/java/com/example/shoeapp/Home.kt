package com.example.shoeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var adidas: ImageView
    lateinit var nike: ImageView
    lateinit var puma: ImageView
    lateinit var fila: ImageView
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.bottommenu)
        bottomNav.setOnNavigationItemSelectedListener(this)
        adidas = findViewById(R.id.adidas)
        adidas.setOnClickListener {
            val intentAdidas = Intent(this@Home,ShoeActivity::class.java)
            startActivity(intentAdidas)
        }
        nike = findViewById(R.id.nike)
        nike.setOnClickListener {
            val intentNike = Intent(this@Home,ShoeActivity::class.java)
            startActivity(intentNike)
        }
        puma = findViewById(R.id.puma)
        puma.setOnClickListener {
            val intentPuma = Intent(this@Home,ShoeActivity::class.java)
            startActivity(intentPuma)
        }
        fila = findViewById(R.id.fila)
        fila.setOnClickListener {
            val intentFila = Intent(this@Home,ShoeActivity::class.java)
            startActivity(intentFila)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_seller ->{
                val intentSell = Intent(this@Home,UploadForm::class.java)
                startActivity(intentSell)
            }
        }
        return true
    }
}