package com.example.receitasdecasa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.databinding.ActivityMainBinding
import com.example.receitasdecasa.databinding.ActivityTelaLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Tela_Login : AppCompatActivity() {
    private val autenticacao = FirebaseAuth.getInstance()
    private val binding by lazy {
        ActivityTelaLoginBinding.inflate(layoutInflater)
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
        binding.viewCriarLogin.setOnClickListener {
            startActivity(Intent(this, Tela_Cadastro::class.java))
            }

            binding.btnLog.setOnClickListener {
                val email = binding.editEnd.text.toString()
                val senha = binding.editKey.text.toString()

                if (validacao(email, senha)){
                    autenticacao.signInWithEmailAndPassword(email, senha)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Bem vindo de volta!", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this, Tela_Principal::class.java))
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Dados incorretos!", Toast.LENGTH_LONG).show()
                        }
                }
            }

    }

    private fun validacao(email: String, password: String):Boolean {
        binding.inputEnd.error = null
        binding.inputKey.error = null

        if (email.isEmpty() && password.isEmpty()){
            binding.inputEnd.error = "Preencha este campo"
            binding.inputKey.error = "Preencha este campo"
            return false
        } else if (email.isEmpty()){
            binding.inputEnd.error = "Preencha este campo"
            return false
        } else if (password.isEmpty()){
            binding.inputKey.error = "Preencha este campo"
            return false
        }

        return true
    }

}