package com.example.receitasdecasa.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAIService {

    @POST("chat/completions")  // Endpoint para ChatGPT
    fun sendPrompt(@Body request: OpenAIRequest): Call<OpenAIResponse>  // Envia o prompt para o modelo
}
