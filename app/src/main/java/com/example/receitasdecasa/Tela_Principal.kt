package com.example.receitasdecasa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.databinding.ActivityTelaLoginBinding
import com.example.receitasdecasa.databinding.ActivityTelaPrincipalBinding
import com.google.firebase.auth.FirebaseAuth

class Tela_Principal : AppCompatActivity() {
    private val autenticacao = FirebaseAuth.getInstance()
    private val binding by lazy {
        ActivityTelaPrincipalBinding.inflate(layoutInflater)
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
        binding.btnSair.setOnClickListener {
            autenticacao.signOut()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}