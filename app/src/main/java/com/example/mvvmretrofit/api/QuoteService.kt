package com.example.mvvmretrofit.api

import com.example.mvvmretrofit.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")  ///quotes is the end point
    suspend fun getQuotes(@Query("page") page : Int): Response<QuoteList>
      //QuoteList is the type of json response
}