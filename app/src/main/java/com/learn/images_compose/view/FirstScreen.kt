package com.learn.images_compose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.learn.images_compose.model.Image2
import com.learn.images_compose.viewModel.FirstScreenViewModel

@Composable
fun FirstScreen(
    navController: NavHostController,
    viewModel: FirstScreenViewModel = hiltViewModel()
) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
        Column(modifier = Modifier.padding(10.dp)) {
            SearchList(
                hint = "Search", modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                viewModel.getAll(it)
            }
            Spacer(modifier = Modifier.height(15.dp))
            LazyVerticalGrid(columns = GridCells.Fixed(4), content ={
                viewModel.imageList.value.let {
                    items(it){
                        Row(navController = navController, image =it )
                    }
                }



            } )
        }
    }



}

@Composable
fun SearchList(
    hint: String, modifier: Modifier,Search:(String) ->Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var Hint by remember { mutableStateOf(hint != "") }
    Box(modifier = modifier){
        BasicTextField(value = text, onValueChange ={
            text = it
            Search(it)
        }, singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow, CircleShape)
                .shadow(3.dp, CircleShape)
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .onFocusChanged {
                    Hint = it.isFocused != true && text.isEmpty()
                }
        )
        if (Hint){
            Text(text = hint,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                color = Color.Blue

                )
        }
    }
}





@Composable
fun Row(navController:NavController,image: Image2){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Image(painter = rememberImagePainter(image.previewURL), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .clickable {
                    navController.navigate("SecondScreen?url=${image.previewURL}")
                }
        )
    }

}