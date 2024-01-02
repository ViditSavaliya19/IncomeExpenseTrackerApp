package com.example.meettotapp.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.meettotapp.R
import com.example.meettotapp.newsapi.model.PostModel
import com.example.meettotapp.newsapi.retro.APIClient.Companion.getAPIClient
import com.example.meettotapp.newsapi.retro.APIInterface
import com.example.meettotapp.newsapi.retro.NewsModel
import retrofit2.Call
import retrofit2.Callback

class NewsActivity : AppCompatActivity() {


    var newModel:NewsModel? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        getNews()

    }


    fun getNews()
    {
        var apiInterface  = getAPIClient()!!.create(APIInterface::class.java)
        apiInterface.getCountryNews().enqueue(object : Callback<NewsModel>{
            override fun onResponse(call: Call<NewsModel>?, response: retrofit2.Response<NewsModel>?) {
                Log.i("TAG", "onResponse: ${response!!.body()}")
                newModel = response.body()

            }

            override fun onFailure(call: Call<NewsModel>?, t: Throwable?) {
                Log.e("TAG", "onFailure: "+t!!.message )
            }

        })
    }




    //Volley Api Calling
//    fun getApiCall() {
//        var apiURL = "https://jsonplaceholder.typicode.com/posts"
//
//        var request = Volley.newRequestQueue(this);
//
//        var jsonArrayRequest = JsonArrayRequest(
//            Request.Method.GET, apiURL, null,
//            {
//                //JsonParsing
//                for (i in 0..it.length()) {
//                    var jsonObject = it.getJSONObject(i)
//                    var title = jsonObject.getString("title")
//                    var body = jsonObject.getString("body")
//                    var id = jsonObject.getInt("id")
//                    var userId = jsonObject.getInt("userId")
//                    var postModel = PostModel(userId, id, title, body)
//                    postList.add(postModel)
//                }
//            },
//            {
//                Log.e("TAG", "getApiCall Error: $it")
//            },
//        )
//        request.add(jsonArrayRequest)
//
//    }
//    fun translateApi() {
//        var apiLink = "https://text-translator2.p.rapidapi.com/translate"
//        var request = Volley.newRequestQueue(this)
//
//        var stringRequest = object : StringRequest(Request.Method.POST, apiLink, {
//            Log.i("TAG", "translateApi: $it")
//        }, {
//            Log.e("TAG", "translateApi: $it")
//        }) {
//            override fun getParams(): MutableMap<String, String>? {
//                var body = HashMap<String, String>()
//                body.set("source_language", "en")
//                body.set("target_language", "hi")
//                body.set("text", "hello")
//                return body
//            }
//
//            override fun getHeaders(): MutableMap<String, String> {
//                var header = HashMap<String,String>()
//                header.set("content-type","application/x-www-form-urlencoded")
//                header.set("X-RapidAPI-Key","637c4831ffmsh0639c4da9b0ecbap197ad7jsn39a7c0327946")
//                header.set("X-RapidAPI-Host","text-translator2.p.rapidapi.com")
//                return header
//            }
//        }
//        request.add(stringRequest)
//    }
}

/*
* What is API?
* - API means application programming Interface
*
* What is use of API?
* - API is bridge of server to framework.
* - SERVER TO APP & APP TO SERVER DATA TRANSFER
*
* Which types of DATA Format used in API?
* - JSON
*
* What is JSON?
* - JSON -> JAVASCRIPT OBJECT NOTATION
* - JSON is Web datatype
* - JSON is a format of data
*
* How many types of API?
* - There so many types.
* - GET
* - POST
* - PUT
* - PATCH
* - FETCH
*
* What is GET API?
* - GET API is send data from server to framework. That is a Unsecure method
*
* What is POST API?
* - POST API used to send data to server from framework.
*
* How many method to use API Calling in Android.
* - http, Volley(Google), Retrofit(Squerrup)
*
* What is API Call?
* - To get Data api to framework it Called as API Calling.
* - JSON
*
* What is JSON Parsing?
* - To convert JSON data to simple data as like List or Model
*
*
* JSON
* -> ARRAY -> []
* -> MAP (Model (Class)) {}
*
* */