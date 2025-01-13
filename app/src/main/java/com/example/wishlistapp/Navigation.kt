package com.example.wishlistapp

import android.R.attr.type
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.util.Map.entry

@Composable
fun Navigation(viewModel: wishViewModel = viewModel(),
               navController: NavHostController = rememberNavController(),

){

    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeView(viewModel = viewModel,
                navController = navController)
        }
        composable(route = Screen.AddScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
                )) {
           val id= it.arguments?.getLong("id") ?: 0L
           // val id = if (entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddEditDetailView(id = id, viewModel = viewModel, navController = navController)
        }

    }
}













