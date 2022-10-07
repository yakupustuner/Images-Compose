package com.learn.images_compose.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.learn.images_compose.model.Image
import com.learn.images_compose.util.Resource
import com.learn.images_compose.viewModel.SecondScreenViewModel

@Composable
fun SecondScreen(id: String,  viewModel:SecondScreenViewModel= hiltViewModel()) {


    val image = produceState<Resource<Image>>(initialValue =Resource.Loading()){
        value= viewModel.get(id)
    }.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        contentAlignment = Alignment.Center,
    ){
        Column(

        ) {
            when(image){
                is Resource.Success ->{

                    Card(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .border(BorderStroke(3.dp, color = Color.Black))


                    ) {
                        Image(painter = rememberImagePainter(data = id) , contentDescription =null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth()


                        )

                    }
                }
            }
        }
    }




}


