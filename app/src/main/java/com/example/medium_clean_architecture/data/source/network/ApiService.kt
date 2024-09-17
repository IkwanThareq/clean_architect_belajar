package com.example.medium_clean_architecture.data.source.network

import retrofit2.http.Query
import com.example.medium_clean_architecture.data.model.NewsListsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("everything?q=sports&apiKey=b0b90bff982042f6a8e03fb6430dbc50")
    suspend fun getPagedNews(@Query("page") page: Int,@Query("pageSize") pageSize: Int) : Response<NewsListsModel>
}