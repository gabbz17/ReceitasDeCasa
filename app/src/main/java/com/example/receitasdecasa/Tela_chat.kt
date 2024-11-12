package com.example.receitasdecasa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.databinding.ActivityTelaChatBinding
import com.example.receitasdecasa.databinding.ActivityTelaPrincipalBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Tela_chat : AppCompatActivity() {
    private val bancoDados = FirebaseFirestore.getInstance()
    private val autenticacao = FirebaseAuth.getInstance()
    private val binding by lazy {
        ActivityTelaChatBinding.inflate(layoutInflater)
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
        binding.floatingActionButton.setOnClickListener {
            val mensagem = binding.editMsg.text.toString()
            salvarMensagem(mensagem)
        }
    }

    private fun salvarMensagem(mensagem: String) {
        val idUser = autenticacao.currentUser?.uid

        if (idUser != null){
            bancoDados.collection("usuarios").document(idUser).get()
                .addOnSuccessListener { documentSnapshot ->
                    val dadoUser = documentSnapshot.data
                    if (dadoUser != null){
                        val nome = dadoUser["Nome"] as String
                        val dados = mapOf(
                            "De $nome" to mensagem
                        )

                        bancoDados.collection("mensagens")
                            .document("$idUser")
                            .set(dados)

                    }
                }
        }
    }
}