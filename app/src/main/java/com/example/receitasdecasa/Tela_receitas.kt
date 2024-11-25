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
    }
}