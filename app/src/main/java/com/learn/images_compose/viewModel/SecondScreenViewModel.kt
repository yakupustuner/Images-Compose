package com.learn.images_compose.viewModel


import androidx.lifecycle.ViewModel
import com.learn.images_compose.Repository.ImagesRepository
import com.learn.images_compose.model.Image
import com.learn.images_compose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val imagesRepository: ImagesRepository,

    ): ViewModel() {


    suspend fun get(c:String): Resource<Image> {
        return imagesRepository.Search(c)

    }
}