package com.example.composeui.autosize

import android.util.TypedValue
import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.min
import androidx.compose.ui.platform.LocalResources

object HmiDesign {
    const val WIDTH = 2560f
    const val HEIGHT = 1440f
}

enum class HmiAdapt {
    Width,
    Height,
    Shortest,
}

@Composable
fun HmiAutosize(
    designWidth: Float = HmiDesign.WIDTH,
    designHeight: Float = HmiDesign.HEIGHT,
    adapt: HmiAdapt = HmiAdapt.Shortest,
    content: @Composable () -> Unit,
) {
    val systemDensity = LocalDensity.current
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val widthPx = with(systemDensity) { maxWidth.toPx() }
        val heightPx = with(systemDensity) { maxHeight.toPx() }
        val scale = when (adapt) {
            HmiAdapt.Width -> widthPx / designWidth
            HmiAdapt.Height -> heightPx / designHeight
            HmiAdapt.Shortest -> min(widthPx / designWidth, heightPx / designHeight)
        }
        CompositionLocalProvider(
            LocalDensity provides Density(density = scale, fontScale = 1f)
        ) {
            content()
        }
    }
}

@Composable
@ReadOnlyComposable
fun hmiDimension(@DimenRes id: Int): Dp {
    val value = TypedValue()
    LocalResources.current.getValue(id, value, true)
    check(value.type == TypedValue.TYPE_DIMENSION) {
        "Resource is not a dimen"
    }
    return TypedValue.complexToFloat(value.data).dp
}

@Composable
@ReadOnlyComposable
fun hmiTextSize(@DimenRes id: Int): TextUnit = hmiDimension(id).value.sp
