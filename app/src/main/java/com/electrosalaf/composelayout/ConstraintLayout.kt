package com.electrosalaf.composelayout

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.electrosalaf.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun ConstraintLayoutContent() {
  ConstraintLayout {

    // Create references for the composable to constraint
    val (button1, button2, text) = createRefs()
    
    Button(
      onClick = { /*TODO*/ },
      // Assign reference "button" to the Button composable
      // and constrain it to the top of the ConstraintLayout
      modifier = Modifier.constrainAs(button1) {
        top.linkTo(parent.top, margin = 16.dp)
      }
    ) {
      Text("Button 1")
    }
    
    Text("Text", Modifier.constrainAs(text) {
      top.linkTo(button1.bottom, margin = 16.dp)
      centerAround(button1.end)
    })

    val barrier = createEndBarrier(button1, text)
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier.constrainAs(button2) {
        top.linkTo(parent.top, margin = 16.dp)
        start.linkTo(barrier)
      }
    ) {
      Text("Button 2")
    }
  }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
  ComposeLayoutTheme {
    ConstraintLayoutContent()
  }
}

@Composable
fun LargeConstraintLayout() {
  ConstraintLayout {
    val text = createRef()

    val guideline = createGuidelineFromStart(0.5f)
    Text(
      "This is a very very very very very very very long word.",
      Modifier.constrainAs(text) {
        linkTo(guideline, parent.end)
        width = Dimension.preferredWrapContent
      }
    )
  }
}

@Preview
@Composable
fun LargeConstraintLayoutPreview() {
  ComposeLayoutTheme {
    LargeConstraintLayout()
  }
}