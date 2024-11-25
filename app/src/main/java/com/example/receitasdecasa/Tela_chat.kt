package com.example.receitasdecasa

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitasdecasa.api.ApiClient
import com.example.receitasdecasa.api.OpenAIRequest
import com.example.receitasdecasa.api.OpenAIResponse
import com.example.receitasdecasa.api.OpenAIService
import com.example.receitasdecasa.databinding.ActivityTelaChatBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tela_chat : AppCompatActivity() {
    private val bancoDados = FirebaseFirestore.getInstance()
    private val autenticacao = FirebaseAuth.getInstance()
    private val binding by lazy {ActivityTelaChatBinding.inflate(layoutInflater)}
    // Chave de API da OpenAI
    private val apiKey = "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"

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
            if (mensagem.isNotEmpty()) {
                enviarMensagemChatGPT(mensagem) // Envia a mensagem para o ChatGPT
                //salvarMensagem(mensagem)  // Salva a mensagem no Firestore
            }
        }
    }
    private fun enviarMensagemChatGPT(mensagem: String) {
        // Configura a requisição para enviar ao ChatGPT
        val model = "gpt-3.5-turbo"  // Modelo que você quer usar (ou "gpt-3.5-turbo")
        val messages = listOf(
            OpenAIRequest.Message(role = "user", content = mensagem)
        )
        val request = OpenAIRequest(model, messages)

        // Criando o Retrofit com a chave da API
        val service = ApiClient.getClient(apiKey).create(OpenAIService::class.java)

        // Fazendo a requisição
        val call = service.sendPrompt(request)

        // Enviando a requisição de forma assíncrona
        call.enqueue(object : Callback<OpenAIResponse> {
            override fun onResponse(call: Call<OpenAIResponse>, response: Response<OpenAIResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val chatResponse = response.body()?.choices?.get(0)?.message
                    Log.d("ChatGPT", chatResponse ?: "Resposta vazia")
                    Toast.makeText(this@Tela_chat, "Resposta: $chatResponse", Toast.LENGTH_SHORT).show()

                    // Exibe a resposta do ChatGPT na interface
                    binding.exibirmsg.setText(chatResponse)
                } else {
                    Log.e("ChatGPT", "Erro na resposta: ${response.message()}")
                    Toast.makeText(this@Tela_chat, "Erro na resposta", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<OpenAIResponse>, t: Throwable) {
                Log.e("ChatGPT", "Falha na requisição: ${t.message}")
                Toast.makeText(this@Tela_chat, "Erro de comunicação com a API", Toast.LENGTH_SHORT).show()
            }
        })
    }

//    private fun salvarMensagem(mensagem: String) {
//        val idUser = autenticacao.currentUser?.uid
//
//        if (idUser != null){
//            bancoDados.collection("usuarios").document(idUser).get()
//                .addOnSuccessListener { documentSnapshot ->
//                    val dadoUser = documentSnapshot.data
//                    if (dadoUser != null){
//                        val nome = dadoUser["Nome"] as String
//                        val dados = mapOf(
//                            "De $nome" to mensagem
//                        )
//
//                        bancoDados.collection("mensagens")
//                            .document("$idUser")
//                            .set(dados)
//
//                    }
//                }
//        }
//    }
}