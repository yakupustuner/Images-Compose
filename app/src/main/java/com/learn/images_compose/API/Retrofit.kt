package com.learn.images_compose.API

import com.learn.images_compose.model.Image
import com.learn.images_compose.util.Util.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
interface Retrofit {
    @GET("api/")
    suspend fun Search(
        @Query("q") Query:String,
        @Query("key") Key : String = API_KEY,
        @Query("image_type") imageType:String
    ): Image
}