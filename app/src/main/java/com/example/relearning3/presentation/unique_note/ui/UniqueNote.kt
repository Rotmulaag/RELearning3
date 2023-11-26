package com.example.relearning3.presentation.unique_note.ui

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.Cottage
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.relearning3.domain.model.Note
import com.example.relearning3.presentation.destinations.HomeScreenDestination
import com.example.relearning3.presentation.unique_note.UniqueNoteViewModel
import com.example.relearning3.presentation.unique_note.UniqueScreenEvent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination
fun UniqueNote(
    id: Int,
    destination: DestinationsNavigator,
    viewModel: UniqueNoteViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val click = { destination.navigate(HomeScreenDestination) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(15.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()) {
                    Row {
                        Icon(
                            Icons.Filled.AutoAwesome,
                            "Basics",
                            Modifier.size(35.dp))
                        Text(
                            text = "Basics",
                            fontSize = 25.sp,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextField(
                        value = state.note.title,
                        onValueChange = { viewModel.onNoteChange(UniqueScreenEvent.Title(it)) },
                        label = { Text(text = "Title")},
                        modifier = Modifier.fillMaxWidth())

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextField(
                        value = state.note.body,
                        onValueChange = { viewModel.onNoteChange(UniqueScreenEvent.Body(it)) },
                        label = { Text(text = "Body")},
                        modifier = Modifier.fillMaxWidth())

                    Spacer(modifier = Modifier.height(5.dp))
                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            Card {
                Column(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()) {
                    Row {
                        Icon(
                            Icons.Filled.Cottage,
                            "Location",
                            Modifier.size(35.dp))
                        Text(
                            text = "Location",
                            fontSize = 25.sp,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(start = 10.dp)
                        )

                    }

                    OutlinedTextField(
                        value = state.note.primaryTags.toString(),
                        onValueChange = { viewModel.onNoteChange(UniqueScreenEvent.pTag(it)) },
                        label = { Text(text = "Path")},
                        /*colors = TextFieldDefaults.DecorationBox(
                            value = ,
                            innerTextField = { /*TODO*/ },
                            enabled = ,
                            singleLine = ,
                            visualTransformation = 
                        ) {
                            
                        },*/
                        modifier = Modifier.fillMaxWidth())

                    Divider(Modifier.padding(vertical = 8.dp))

                    Row {
                        Icon(
                            Icons.Filled.BubbleChart,
                            "Tags",
                            Modifier.size(35.dp))
                        Text(
                            text = "Tags",
                            fontSize = 25.sp,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }

                    OutlinedTextField(
                        value = state.note.secondaryTags.toString(),
                        onValueChange = { viewModel.onNoteChange(UniqueScreenEvent.sTag(it)) },
                        label = { Text(text = "List")},
                        modifier = Modifier.fillMaxWidth())

                    Spacer(modifier = Modifier.height(5.dp))
                }

            }

            Row(
                modifier = Modifier.padding(top = 5.dp)
            ) {
                if (id > -1) { // Edit,Delete

                        Spacer(modifier = Modifier.weight(5f))

                        ExtendedFloatingActionButton(
                            text = { Text(text = "Delete") },
                            icon = { Icon(Icons.Outlined.Delete,"Delete") },
                            onClick = { viewModel.deleteNote(); click() },
                            modifier = Modifier.weight(40f),
                            expanded = true)

                        Spacer(modifier = Modifier.weight(30f))

                        ExtendedFloatingActionButton(
                            text = { Text(text = "Save") },
                            icon = { Icon(Icons.Outlined.Done,"Done") },
                            onClick = { viewModel.saveNote(); click() },
                            modifier = Modifier.weight(40f),
                            expanded = true)

                        Spacer(modifier = Modifier.weight(5f))

                } else { // Add
                    Spacer(modifier = Modifier.weight(15f))

                    ExtendedFloatingActionButton(
                        text = { Text(text = "Save") },
                        icon = { Icon(Icons.Outlined.Done,"Done") },
                        onClick = { viewModel.saveNote(); click() },
                        modifier = Modifier.weight(15f),
                        expanded = true)

                    Spacer(modifier = Modifier.weight(15f))
                }
            }


        }
    }

}