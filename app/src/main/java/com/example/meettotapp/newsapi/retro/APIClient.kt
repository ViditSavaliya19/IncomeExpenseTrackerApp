package com.example.meettotapp.newsapi.retro

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        var retrofit: Retrofit? = null
        val BASEURL = "https://pixabay.com/"

        // Retrofit return
        fun getAPIClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
    }

}