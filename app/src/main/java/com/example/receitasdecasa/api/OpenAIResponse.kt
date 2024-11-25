package com.example.receitasdecasa.api

data class OpenAIResponse(
    val choices: List<Choice>
) {
    data class Choice(
        val message: String  // A resposta gerada pelo modelo
    )
}

