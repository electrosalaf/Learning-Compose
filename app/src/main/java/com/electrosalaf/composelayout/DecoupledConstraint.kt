package com.electrosalaf.composelayout

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun DecoupledConstraintLayout() {
  BoxWithConstraints() {
    val constraints = if (maxWidth < minHeight) {
      decoupledConstraints(margin = 16.dp)
    } else {
      decoupledConstraints(margin = 32.dp)
    }
    
    ConstraintLayout() {
      Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.layoutId("button")
      ) {
        Text("Button")
      }
      Text("Text", Modifier.layoutId("text"))
    }
  }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
  return ConstraintSet {
    val button = createRefFor("button")
    val text = createRefFor("text")

    constrain(button) {
      top.linkTo(parent.top, margin = margin)
    }
    constrain(text) {
      top.linkTo(button.bottom, margin)
    }
  }
}
