package com.example.receitasdecasa

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.databinding.ActivityMainBinding
import com.example.receitasdecasa.databinding.ActivityTelaCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.security.Principal

class Tela_Cadastro : AppCompatActivity() {
    private val autenticacao = FirebaseAuth.getInstance()
    private val bancoDados = FirebaseFirestore.getInstance()
    private val binding by lazy {
         ActivityTelaCadastroBinding.inflate(layoutInflater)
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
        binding.viewLoginCadastro.setOnClickListener {
            startActivity(Intent(this, Tela_Login::class.java))
        }
        binding.btnCadastro.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()

            if (validacao(email, password)){

                if (validade(email)){
                    autenticacao.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Por favor, verifique seu email!", Toast.LENGTH_LONG).show()
                            autenticacao.currentUser?.sendEmailVerification()
                                ?.addOnSuccessListener {
                                    startActivity(Intent(this, Tela_nome::class.java))
                                }
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Email já cadastrado", Toast.LENGTH_LONG).show()
                        }
                }

            }
        }
    }

    private fun validade(email: String): Boolean {
        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true
        } else {
            Toast.makeText(this, "Tipo de email inválido!", Toast.LENGTH_LONG).show()
            binding.inputEmail.error = "Preencha este campo corretamente"
            return false
        }
    }

    private fun validacao(email: String, password: String):Boolean {
        binding.inputEmail.error = null
        binding.inputSenha.error = null

        if (email.isEmpty() && password.isEmpty()){
            binding.inputEmail.error = "Preencha este campo"
            binding.inputSenha.error = "Preencha este campo"
            return false
        } else if (email.isEmpty()){
            binding.inputEmail.error = "Preencha este campo"
            return false
        } else if (password.isEmpty()){
            binding.inputSenha.error = "Preencha este campo"
            return false
        }

        return true
    }
}