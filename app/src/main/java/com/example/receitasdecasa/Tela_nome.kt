package com.example.receitasdecasa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.databinding.ActivityTelaCadastroBinding
import com.example.receitasdecasa.databinding.ActivityTelaNomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.HashMap

class Tela_nome : AppCompatActivity() {
    private val bancoDados = FirebaseFirestore.getInstance()
    private val autenticacao = FirebaseAuth.getInstance()
    private val binding by lazy {
        ActivityTelaNomeBinding.inflate(layoutInflater)
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
        binding.btnConfirmar.setOnClickListener {
            val nome = binding.txtNome.text.toString()
            val sobrenome = binding.txtSobrenome.text.toString()
            val uid = autenticacao.currentUser?.uid

            if (validacao(nome, sobrenome)){

                val dados = mapOf(
                    "Nome" to nome,
                    "Sobrenome" to sobrenome
                )

                bancoDados.collection("InfoUsers").document("$uid").set(dados)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Informações salvas", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, Tela_Principal::class.java))
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Não sei", Toast.LENGTH_LONG).show()
                    }


            }
        }
    }

    private fun validacao(nome: String, sobrenome: String):Boolean {
        binding.inputNome.error = null
        binding.inputSobre.error = null

        if (nome.isEmpty() && sobrenome.isEmpty()){
            binding.inputNome.error = "Preencha este campo"
            binding.inputSobre.error = "Preencha este campo"
            return false
        } else if (nome.isEmpty()){
            binding.inputNome.error = "Preencha este campo"
            return false
        } else if (sobrenome.isEmpty()){
            binding.inputSobre.error = "Preencha este campo"
            return false
        }

        return true
    }
}