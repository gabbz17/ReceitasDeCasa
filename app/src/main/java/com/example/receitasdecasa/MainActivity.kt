package com.example.receitasdecasa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private val autenticacao = FirebaseAuth.getInstance()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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
        binding.btnLoginTInicial.setOnClickListener {
            startActivity(Intent(this, Tela_Login::class.java))
        }
        binding.viewCriarTInicial.setOnClickListener {
            startActivity(Intent(this, Tela_Cadastro::class.java))
        }
    }
    override fun onStart() {
        super.onStart()

        val sim = autenticacao.currentUser
        if (sim != null) {
            startActivity(Intent(this, Tela_Principal::class.java))
        }
    }
}