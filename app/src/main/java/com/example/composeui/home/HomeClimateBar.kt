package com.example.composeui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.R

@Preview(widthDp = 2430)
@Composable
fun AirConditionCard() {
    Surface(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.climate_bar_height)),
        color = colorResource(R.color.hmi_surface),
        shape = RoundedCornerShape(dimensionResource(R.dimen.hmi_radius_card))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Box {
                Row(
                    modifier = Modifier.width(500.dp).align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painterResource(R.drawable.climate_bar_ic_chevron_left),
                        contentDescription = "",
                        modifier = Modifier.size(42.dp)
                    )
                    Text("22'C", color = Color.White, fontSize = 56.sp, fontWeight = FontWeight.W500)
                    Image(
                        painterResource(R.drawable.climate_bar_ic_chevron_right),
                        contentDescription = "",
                        modifier = Modifier.size(42.dp)
                    )
                }
                Surface(modifier = Modifier.align(Alignment.TopEnd).padding(20.dp).width(1.dp).fillMaxHeight().background(color = colorResource(R.color.hmi_text_secondary))) {}
            }
            Image(painterResource(R.drawable.climate_bar_ic_seat_heat), contentDescription = "", modifier = Modifier.size(62.dp))
            Image(painterResource(R.drawable.climate_bar_ic_seat_ventilation), contentDescription = "", modifier = Modifier.size(62.dp))
            Image(painterResource(R.drawable.climate_bar_ic_fan), contentDescription = "", modifier = Modifier.size(62.dp))
            Text("AUTO", color = Color.White, fontSize = 50.sp)
            Image(painterResource(R.drawable.climate_bar_ic_airflow_person), contentDescription = "", modifier = Modifier.size(62.dp))
            Image(painterResource(R.drawable.climate_bar_ic_air_recirculation), contentDescription = "", modifier = Modifier.size(62.dp))
            Box {
                Row(
                    modifier = Modifier.width(500.dp).align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painterResource(R.drawable.climate_bar_ic_chevron_left),
                        contentDescription = "",
                        modifier = Modifier.size(42.dp)
                    )
                    Text("22'C", color = Color.White, fontSize = 56.sp, fontWeight = FontWeight.W500)
                    Image(
                        painterResource(R.drawable.climate_bar_ic_chevron_right),
                        contentDescription = "",
                        modifier = Modifier.size(42.dp)
                    )
                }
                Surface(modifier = Modifier.align(Alignment.CenterStart).padding(20.dp).width(1.dp).fillMaxHeight().background(color = colorResource(R.color.hmi_text_secondary))) {}
            }
        }

    }
}
