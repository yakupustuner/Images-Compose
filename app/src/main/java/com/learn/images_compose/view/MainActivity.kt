package com.learn.images_compose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.learn.images_compose.ui.theme.ImagesComposeTheme
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImagesComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination ="FirstScreen"){
                    composable("FirstScreen"){
                        FirstScreen(navController = navController)
                    }
                    composable("SecondScreen?url={previewURL}",
                        arguments = listOf(navArgument("previewURL"){
                            type = NavType.StringType

                        })

                    ){
                        val url =
                            it.arguments?.getString("previewURL")
                        SecondScreen(id = url ?:"")
            }
                }
            }
        }
    }
}