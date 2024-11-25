package com.example.receitasdecasa.api

data class OpenAIRequest(
    val model: String,  // Modelo GPT a ser utilizado
    val messages: List<Message>  // Lista de mensagens para o chat
) {
    data class Message(
        val role: String,  // 'user', 'system' ou 'assistant'
        val content: String  // Conteúdo da mensagem
    )
}

