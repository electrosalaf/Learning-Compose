package com.electrosalaf.composelayout

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.electrosalaf.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun ConstraintLayoutContent() {
  ConstraintLayout() {

    // Create references for the composable to constraint
    val (button, text) = createRefs()
    
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier.constrainAs(button) {
        top.linkTo(parent.top, margin = 16.dp)
      }
    ) {
      Text("Button")
    }
    
    Text("Text", Modifier.constrainAs(text) {
      top.linkTo(button.bottom, margin = 16.dp)
      centerHorizontallyTo(parent)
    })
  }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
  ComposeLayoutTheme {
    ConstraintLayoutContent()
  }
}