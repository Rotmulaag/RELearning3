package com.example.relearning3.presentation.home_screen.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.relearning3.presentation.home_screen.HomeScreenViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun HomeScreen(
    destination: DestinationsNavigator,
    viewModel: HomeScreenViewModel = hiltViewModel()) {

}