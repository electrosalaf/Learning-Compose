package com.electrosalaf.composelayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.electrosalaf.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun LayoutCompose() {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(text = "LayoutScaffolding")
        },
        actions = {
          IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
            // Icon(Icons.Filled.Build, contentDescription = null)
          }
        }
      )
    }
  ) { innerPadding ->
    BodyContent(Modifier.padding(innerPadding).padding(8.dp))
  }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
  Column(modifier = modifier) {
    Text(text = "Hi there!")
    Text(text = "Thanks for going through the Layout codelab")
  }
}

@Preview
@Composable
fun LayoutScaffoldPreview() {
  ComposeLayoutTheme {
    LayoutCompose()
  }
}