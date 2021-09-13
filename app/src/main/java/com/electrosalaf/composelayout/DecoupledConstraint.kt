package com.electrosalaf.composelayout

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.electrosalaf.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun ConstraintLayoutContentSample() {
  ConstraintLayout() {

    val (button, text) = createRefs()

    Button(
      onClick = { /*TODO*/ }, 
      modifier = Modifier.constrainAs(button) {
        top.linkTo(parent.top, margin = 16.dp)
      }
    ) {
      Text("Button")
    }
    
    Text("Text", modifier = Modifier.constrainAs(text) {
      top.linkTo(button.bottom, margin = 16.dp)
    })
  }
}

@Composable
fun DecoupledConstraintLayout() {
  BoxWithConstraints() {
    val constraints = if (maxWidth < minHeight) {
      decoupledConstraints(margin = 16.dp)  // portrait constraints
    } else {
      decoupledConstraints(margin = 32.dp)  // Landscape constraints
    }
    
    ConstraintLayout(constraints) {
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

@Preview
@Composable
fun ConstraintLayoutContentSamplePreview() {
  ComposeLayoutTheme() {
    ConstraintLayoutContentSample()
  }
}

@Preview
@Composable
fun DecoupledConstraintPreview() {
  ComposeLayoutTheme {
    DecoupledConstraintLayout()
  }
}