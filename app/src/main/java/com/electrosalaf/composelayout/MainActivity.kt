package com.electrosalaf.composelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.electrosalaf.composelayout.ui.theme.ComposeLayoutTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeLayoutTheme {
        LayoutCompose()
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview
@Composable
fun DefaultPreview() {
  ComposeLayoutTheme() {
    Greeting("Android")
  }
}