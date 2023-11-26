package com.example.relearning3.presentation.home_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.relearning3.presentation.destinations.UniqueNoteDestination
import com.example.relearning3.presentation.home_screen.HomeScreenViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator



@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
@RootNavGraph(start = true)
fun HomeScreen(
    destination: DestinationsNavigator,
    viewModel: HomeScreenViewModel = hiltViewModel()) {

    val state = viewModel.state

    MaterialTheme() {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(text = "Add") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "Add") },
                    onClick = { destination.navigate(UniqueNoteDestination(-1)) },
                    expanded = true)
            }
        ) { it ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    //.background(MaterialTheme.colorScheme.background)
            ) {
                Card (
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    TextField(
                        value = state.query,
                        onValueChange = { viewModel.onSeachQueryChange(it) },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Search")
                        },
                        placeholder = {
                            Text(text = "Search...")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                LazyColumn() {
                    items(state.notes.size) {
                        val note = state.notes[it]
                        HomeScreenListItem(
                            note = note,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable { destination.navigate(UniqueNoteDestination(note.id!!)) }
                                //.background(MaterialTheme.colorScheme.primaryContainer)
                        )
                    }
                }

            }
        }
        }



}