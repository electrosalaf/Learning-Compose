package com.electrosalaf.composelayout

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.*

// How to create a modifier
@Stable
fun Modifier.padding(all: Dp) =
  this.then(
    PaddingModifier(start = all, top = all, end = all, bottom = all, rtlAware = true)
  )

// Implementing detail
private class PaddingModifier(
  val start: Dp = 0.dp,
  val top: Dp = 0.dp,
  val end: Dp = 0.dp,
  val bottom: Dp = 0.dp,
  val rtlAware: Boolean,
) : LayoutModifier {

  override fun MeasureScope.measure(
    measurable: Measurable,
    constraints: Constraints
  ): MeasureResult {

    val horizontal = start.roundToPx() + end.roundToPx()
    val vertical = top.roundToPx() + bottom.roundToPx()

    val placeable = measurable.measure(constraints.offset(-horizontal, -vertical))

    val width = constraints.constrainWidth(placeable.width + horizontal)
    val height = constraints.constrainHeight(placeable.height + vertical)
    return layout(height, width) {
      if (rtlAware) {
        placeable.placeRelative(start.roundToPx(), top.roundToPx())
      } else {
        placeable.place(start.roundToPx(), top.roundToPx())
      }
    }
  }
}