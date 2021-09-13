package com.electrosalaf.composelayout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.electrosalaf.composelayout.ui.theme.ComposeLayoutTheme


val topics = listOf(
  "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
  "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
  "Religion", "Social sciences", "Technology", "TV", "Writing"
)
@Composable
fun ComposeLayout() {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(text = "Compose Layout")
        },
        actions = {
          IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
          }
        }
      )
    }
  ) { innerPadding ->
    BodyContent1(Modifier.padding(innerPadding))
  }
}

@Composable
fun BodyContent1(modifier: Modifier = Modifier) {
  Row(modifier = modifier
    .background(color = Color.LightGray)
    .padding(16.dp)
    .size(200.dp)
    .horizontalScroll(rememberScrollState()),
    content = {
      StaggeredGrid(modifier = modifier, rows = 5 ) {
        for (topic in topics) {
          Chip(modifier = Modifier.padding(8.dp), text = topic)
        }
      }
    })
}

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
  Card(
    modifier = modifier,
    border = BorderStroke(color = Color.Black, width = Dp.Hairline),
    shape = RoundedCornerShape(8.dp)
  ) {
    Row(
      modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(16.dp, 16.dp)
          .background(color = MaterialTheme.colors.secondary)
      )
      Spacer(Modifier.width(4.dp))
      Text(text = text)
    }
  }
}

@Preview
@Composable
fun ChipPreview() {
  ComposeLayoutTheme { 
   Chip(text = "Hi there")
  }
}

@Preview
@Composable
fun ComposeLayoutPreview() {
  ComposeLayoutTheme {
    ComposeLayout()
  }
}