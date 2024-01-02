package com.example.meettotapp.newsapi.retro

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("top-headlines?country=in&category=sport&apiKey=1ee831619156425192704ed881bf244e")
    fun getCountryNews():Call<NewsModel>


}