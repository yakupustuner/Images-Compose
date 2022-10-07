package com.learn.images_compose.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.learn.images_compose.Repository.ImagesRepository
import com.learn.images_compose.model.Image2
import com.learn.images_compose.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel@Inject constructor(
    private val imagesRepository: ImagesRepository
):ViewModel(){
    val imageList = mutableStateOf<List<Image2>>(listOf())

    fun getAll(c:String){
        viewModelScope.launch {
            val result = imagesRepository.Search(c)
            when(result){
                is Resource.Success ->{
                    result.data?.hits?.let {
                        imageList.value = it

                    }
                }
            }
        }
    }
}