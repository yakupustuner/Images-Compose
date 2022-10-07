package com.learn.images_compose.Repository

import com.learn.images_compose.model.Image
import com.learn.images_compose.util.Resource
import com.learn.images_compose.util.Util.API_KEY
import dagger.hilt.android.scopes.ActivityScoped
import com.learn.images_compose.API.Retrofit
import javax.inject.Inject

@ActivityScoped
class ImagesRepository @Inject constructor(
    private val retrofit: Retrofit
) {

    suspend fun Search(c:String): Resource<Image> {
        return try {
            val result = retrofit.Search(c, API_KEY,"photo")
            Resource.Success(result)
        } catch (e:Exception){
            Resource.Error(e.message.toString())
        }

    }
}

