package com.example.receitasdecasa.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object ApiClient {

    private const val BASE_URL = "https://api.openai.com/v1/chat/completions/"

    // Função para criar o Retrofit com cabeçalhos de autorização dinamicamente
    fun getClient(apiKey: String): Retrofit {
        val client = OkHttpClient.Builder()
            // Adiciona o Interceptor para adicionar o cabeçalho de autenticação
            .addInterceptor(Interceptor { chain ->
                val newRequest: Request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $apiKey")  // Adiciona o token da API
                    .addHeader("Content-Type", "application/json")  // Adiciona o tipo de conteúdo
                    .build()
                chain.proceed(newRequest)  // Continua a requisição
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)  // Passa o cliente OkHttp com Interceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
