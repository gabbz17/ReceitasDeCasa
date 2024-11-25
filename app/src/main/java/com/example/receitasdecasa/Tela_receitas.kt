package com.example.receitasdecasa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.databinding.ActivityTelaNomeBinding
import com.example.receitasdecasa.databinding.ActivityTelaReceitasBinding

class Tela_receitas : AppCompatActivity() {
    private val binding by lazy {
        ActivityTelaReceitasBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.back1.setOnClickListener {
            startActivity(Intent(this, Tela_snack::class.java))
        }
        binding.sb1.setOnClickListener {
            startActivity(Intent(this, Tela_snack::class.java))
        }
        binding.sbt1.setOnClickListener {
            startActivity(Intent(this, Tela_snack::class.java))
        }
        binding.title1.setOnClickListener {
            startActivity(Intent(this, Tela_snack::class.java))
        }
        binding.foto1.setOnClickListener {
            startActivity(Intent(this, Tela_snack::class.java))
        }
        binding.back2.setOnClickListener {
            startActivity(Intent(this, Tela_frango::class.java))
        }
        binding.sb2.setOnClickListener {
            startActivity(Intent(this, Tela_frango::class.java))
        }
        binding.sbt2.setOnClickListener {
            startActivity(Intent(this, Tela_frango::class.java))
        }
        binding.title2.setOnClickListener {
            startActivity(Intent(this, Tela_frango::class.java))
        }
        binding.foto2.setOnClickListener {
            startActivity(Intent(this, Tela_frango::class.java))
        }
        binding.back3.setOnClickListener {
            startActivity(Intent(this, Tela_molho::class.java))
        }
        binding.sb3.setOnClickListener {
            startActivity(Intent(this, Tela_molho::class.java))
        }
        binding.sbt3.setOnClickListener {
            startActivity(Intent(this, Tela_molho::class.java))
        }
        binding.title3.setOnClickListener {
            startActivity(Intent(this, Tela_molho::class.java))
        }
        binding.foto3.setOnClickListener {
            startActivity(Intent(this, Tela_molho::class.java))
        }
        binding.back4.setOnClickListener {
            startActivity(Intent(this, Tela_bolo::class.java))
        }
        binding.sb4.setOnClickListener {
            startActivity(Intent(this, Tela_bolo::class.java))
        }
        binding.sbt4.setOnClickListener {
            startActivity(Intent(this, Tela_bolo::class.java))
        }
        binding.title4.setOnClickListener {
            startActivity(Intent(this, Tela_bolo::class.java))
        }
        binding.foto4.setOnClickListener {
            startActivity(Intent(this, Tela_bolo::class.java))
        }
        binding.back5.setOnClickListener {
            startActivity(Intent(this, Tela_mamao::class.java))
        }
        binding.sb5.setOnClickListener {
            startActivity(Intent(this, Tela_mamao::class.java))
        }
        binding.sbt5.setOnClickListener {
            startActivity(Intent(this, Tela_mamao::class.java))
        }
        binding.title5.setOnClickListener {
            startActivity(Intent(this, Tela_mamao::class.java))
        }
        binding.foto5.setOnClickListener {
            startActivity(Intent(this, Tela_mamao::class.java))
        }
        binding.back6.setOnClickListener {
            startActivity(Intent(this, Tela_picao::class.java))
        }
        binding.sb6.setOnClickListener {
            startActivity(Intent(this, Tela_picao::class.java))
        }
        binding.sbt6.setOnClickListener {
            startActivity(Intent(this, Tela_picao::class.java))
        }
        binding.title6.setOnClickListener {
            startActivity(Intent(this, Tela_picao::class.java))
        }
        binding.foto6.setOnClickListener {
            startActivity(Intent(this, Tela_picao::class.java))
        }
        binding.back7.setOnClickListener {
            startActivity(Intent(this, Tela_tortilha::class.java))
        }
        binding.sb7.setOnClickListener {
            startActivity(Intent(this, Tela_tortilha::class.java))
        }
        binding.sbt7.setOnClickListener {
            startActivity(Intent(this, Tela_tortilha::class.java))
        }
        binding.title7.setOnClickListener {
            startActivity(Intent(this, Tela_tortilha::class.java))
        }
        binding.foto7.setOnClickListener {
            startActivity(Intent(this, Tela_tortilha::class.java))
        }
        binding.back8.setOnClickListener {
            startActivity(Intent(this, Tela_panqueca::class.java))
        }
        binding.sb8.setOnClickListener {
            startActivity(Intent(this, Tela_panqueca::class.java))
        }
        binding.sbt8.setOnClickListener {
            startActivity(Intent(this, Tela_panqueca::class.java))
        }
        binding.title8.setOnClickListener {
            startActivity(Intent(this, Tela_panqueca::class.java))
        }
        binding.foto8.setOnClickListener {
            startActivity(Intent(this, Tela_panqueca::class.java))
        }
    }
}