package com.example.composeui.home

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.R

@Preview(widthDp = 2426, heightDp = 116)
@Composable
fun BottomNavigation() {
    val shape = RoundedCornerShape(dimensionResource(R.dimen.hmi_radius_card))
    val items = listOf(
        NaviItem("首页", R.drawable.bottom_navigation_ic_home),
        NaviItem("导航", R.drawable.bottom_navigation_ic_navigation),
        NaviItem("音乐", R.drawable.bottom_navigation_ic_music),
        NaviItem("车辆", R.drawable.bottom_navigation_ic_vehicle),
        NaviItem("电话", R.drawable.bottom_navigation_ic_phone),
        NaviItem("设置", R.drawable.bottom_navigation_ic_settings),
    )
    var selected by remember { mutableIntStateOf(0) }
    val interactions = remember(items.size) { List(items.size) { MutableInteractionSource() } }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.bottom_navigation_height))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            colorResource(R.color.hmi_surface_top),
                            colorResource(R.color.hmi_surface_bottom),
                        )
                    )
                )
                .border(
                    width = dimensionResource(R.dimen.hmi_surface_border_width),
                    color = colorResource(R.color.hmi_surface_border),
                    shape = shape,
                )
        )
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEachIndexed { index, item ->
                NavigationItem(
                    item = item,
                    selected = index == selected,
                    interactionSource = interactions[index],
                    onClick = { selected = index },
                )
            }
        }
    }
}

@Composable
private fun NavigationItem(
    item: NaviItem,
    selected: Boolean,
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit,
) {
    val tint = colorResource(if (selected) R.color.hmi_primary else R.color.hmi_text_primary)
    Box(
        modifier = Modifier
            .width(dimensionResource(R.dimen.bottom_navigation_item_width))
            .fillMaxHeight()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        if (selected) {
            SelectedBackground()
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.bottom_navigation_icon_text_spacing)
            ),
        ) {
            Image(
                painter = painterResource(item.iconRes),
                contentDescription = item.title,
                modifier = Modifier.size(dimensionResource(R.dimen.bottom_navigation_icon_size)),
                colorFilter = ColorFilter.tint(tint),
            )
            Text(
                text = item.title,
                color = tint,
                fontSize = dimensionResource(R.dimen.bottom_navigation_label_text_size).value.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Composable
private fun BoxScope.SelectedBackground() {
    Box(
        modifier = Modifier
            .height(10.dp)
            .width(160.dp)
            .background(
                colorResource(R.color.hmi_primary),
                RoundedCornerShape(10.dp)
            ).align(Alignment.BottomCenter)
    ) {

    }
    if (true) return
    val shape = RoundedCornerShape(dimensionResource(R.dimen.hmi_radius_card))
    val glow = colorResource(R.color.hmi_primary_glow)
    Box(
        modifier = Modifier
            .width(dimensionResource(R.dimen.bottom_navigation_selected_width))
            .height(dimensionResource(R.dimen.bottom_navigation_selected_height))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .softBlur(
                    radius = dimensionResource(R.dimen.hmi_active_glow_blur),
                    color = glow,
                    corner = dimensionResource(R.dimen.hmi_radius_card),
                )
                .background(glow, shape)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(glow, shape)
        )
    }
}

private fun Modifier.softBlur(radius: Dp, color: Color, corner: Dp): Modifier {
    return if (Build.VERSION.SDK_INT >= 31) {
        blur(radius, BlurredEdgeTreatment.Unbounded)
    } else {
        drawBehind { drawSoftOutset(radius, color, corner) }
    }
}

private fun DrawScope.drawSoftOutset(radius: Dp, color: Color, corner: Dp) {
    val outset = radius.toPx()
    val cornerPx = corner.toPx()
    drawRoundRect(
        color = color,
        topLeft = Offset(-outset, -outset),
        size = Size(size.width + outset * 2, size.height + outset * 2),
        cornerRadius = CornerRadius(cornerPx + outset),
    )
}

data class NaviItem(
    val title: String,
    val iconRes: Int,
)
