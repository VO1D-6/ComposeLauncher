package com.example.composeui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.R

@Preview(device = Devices.TABLET)
@Composable
fun StatusBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.hmi_status_bar_height)),
        color = colorResource(R.color.hmi_surface),
        shape = RoundedCornerShape(dimensionResource(R.dimen.hmi_radius_card))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 40.dp, end = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DayTime()
            Greeting()
            VehicleInfo()
        }
    }

}

@Composable
private fun DayTime() {
    Row(Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
        // Data Time
        Text(
            "09:41",
            fontSize = dimensionResource(R.dimen.status_bar_time_text_size).value.sp,
            color = colorResource(R.color.hmi_text_primary)
        )
        Spacer(modifier = Modifier.width(50.dp))
        Text(
            "9月15日 周二",
            modifier = Modifier.offset(y = (-1).dp),
            fontSize = dimensionResource(R.dimen.status_bar_time_text_size).value.sp,
            color = colorResource(R.color.hmi_text_secondary),
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )
    }
}

@Composable
private fun RowScope.Greeting() {
    Text(
        text = "Hi,Alex.",
        modifier = Modifier
            .width(0.dp)
            .weight(1f)
            .wrapContentHeight(),
        textAlign = TextAlign.Center,
        fontSize = dimensionResource(R.dimen.status_bar_greeting_text_size).value.sp,
        color = colorResource(R.color.hmi_text_primary),
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        )
    )
}

@Composable
private fun VehicleInfo() {
    Row(modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        Image(painterResource(R.drawable.status_bar_ic_signal), contentDescription = "")
        Text("5G", color = Color.White, fontSize = 30.sp)
        Image(painterResource(R.drawable.status_bar_ic_bluetooth), contentDescription = "")
        Image(painterResource(R.drawable.status_bar_ic_location), contentDescription = "")
        Image(painterResource(R.drawable.status_bar_ic_weather_partly_cloudy), contentDescription = "")
        Text("24‘C", color = Color.White, fontSize = 30.sp)
    }
}
