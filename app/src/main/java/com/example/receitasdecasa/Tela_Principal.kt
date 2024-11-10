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
import com.google.firebase.firestore.FirebaseFirestore

class Tela_Principal : AppCompatActivity() {
    private val bancoDados by lazy {
        FirebaseFirestore.getInstance()
    }
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
            finish()
        }
        binding.btnReceitas.setOnClickListener {
            startActivity(Intent(this, Tela_receitas::class.java))
        }
    }
    private fun recuperandoDados() {
        val id = autenticacao.currentUser?.uid

        if (id != null){
            bancoDados.collection("usuarios").document(id).get()
                .addOnSuccessListener { documentSnapshot ->
                    val dadoUser = documentSnapshot.data
                    if (dadoUser != null){
                        val nome = dadoUser["Nome"] as String
                        binding.name.text = nome
                    }
                }
        }
    }
    override fun onStart() {
        super.onStart()
        recuperandoDados()
    }
}