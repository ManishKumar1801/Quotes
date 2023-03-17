package com.example.quotes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("/quotes")
    fun getQuotes(@Query("page") page:Int):Call<Data>
}