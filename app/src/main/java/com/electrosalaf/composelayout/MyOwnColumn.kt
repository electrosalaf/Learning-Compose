package com.electrosalaf.composelayout

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.electrosalaf.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun MyOwnColumn(
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  Layout(
    modifier = modifier,
    content = content
  ) {
    measurables, constraints ->

    // Don't constrain child view further, measure them with the given constraint
    // List of measured children
    val placeable = measurables.map { measurable ->
      // Measure each child
      measurable.measure(constraints)
    }

    // Track the y co-od we have placed the children to
    var yPosition = 0

    // Set the size of the layout as big as it can
    layout(constraints.maxWidth, constraints.maxHeight) {
      // Place children in the parent layout
      placeable.forEach {
        placeable -> placeable.placeRelative(x = 0, y = yPosition)

        // Record the y co-od place up to
        yPosition += placeable.height
      }
    }
  }
}

@Preview
@Composable
fun MyOwnColumnPreview() {
  ComposeLayoutTheme {
    Surface(Modifier.padding(8.dp)) {
      MyOwnColumn() {
        Text("MyOwnColumn")
        Text("places items")
        Text("vertically")
        Text("We've done it by hand!")
      }
    }
  }
}