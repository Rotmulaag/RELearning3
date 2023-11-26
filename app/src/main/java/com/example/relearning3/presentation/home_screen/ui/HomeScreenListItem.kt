package com.example.relearning3.presentation.home_screen.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.relearning3.domain.model.Note
import kotlin.jvm.internal.Intrinsics


@Composable
fun HomeScreenListItem(note: Note, modifier: Modifier) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
            ) {
                Card(
                    //shape = RoundedCornerShape(8.dp),
                    //modifier = Modifier.background(Color.Yellow)
                ) {
                    Text(
                        text = "#",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(horizontal = 5.dp)
                            .background(Color.Transparent))
                }

                Column (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = note.primaryTags.toString(),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 5.dp)
                            .fillMaxWidth() //testing
                    )
                    Text(
                        text = note.secondaryTags.toString(),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 5.dp)
                    )
                }

            }
            Divider(color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(3.dp).height(0.25.dp)

            )
            Text(text = note.title,
                fontSize = 25.sp,
                /*typography = MaterialTheme.typography.titleLarge,*/
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                /*modifier = Modifier.weight(.25f)*/)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = note.body,
                fontSize = 18.sp,
                /*typography = MaterialTheme.typography.titleLarge,*/
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Light,
                maxLines = 1,
                /*modifier = Modifier.weight(1f)*/)
        }
    }

}