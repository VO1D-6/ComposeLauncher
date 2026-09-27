package com.example.composeui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.composeui.R
import com.google.android.material.slider.Slider

@Preview(device = Devices.PIXEL_TABLET, widthDp = 2430, heightDp = 909)
@Composable
fun ContentCards() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.navigation_card_height))
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .width(dimensionResource(R.dimen.navigation_card_width)),
            shape = RoundedCornerShape(dimensionResource(R.dimen.hmi_radius_card))
        ) {
            Image(
                painterResource(R.drawable.navigation_card_map_dark_background),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
        MusicCards()
        VehicleInfoCards()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun BoxScope.MusicCards() {
    Surface(
        modifier = Modifier
            .height(dimensionResource(R.dimen.music_card_height))
            .width(dimensionResource(R.dimen.music_card_width))
            .align(Alignment.TopEnd),
        color = colorResource(R.color.hmi_surface),
        shape = RoundedCornerShape(dimensionResource(R.dimen.hmi_radius_card))
    ) {
        Column(modifier = Modifier.padding(40.dp)) {
            Row {
                Image(
                    painterResource(R.drawable.music_card_album_night_drive),
                    contentDescription = "",
                    modifier = Modifier
                        .size(210.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Column(
                    modifier = Modifier
                        .padding(top = 40.dp, start = 40.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        "Title", color = Color.White, fontSize = 36.sp, fontWeight = FontWeight.W800
                    )
                    Text("Subtitle", color = Color.LightGray, fontSize = 34.sp)
                }
                Image(
                    painterResource(R.drawable.music_card_ic_equalizer),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(50.dp)
                )
            }

            val state = SliderState(0.3f, onValueChangeFinished = {

            })
            Slider(
                state, modifier = Modifier.padding(top = 16.dp), thumb = {
                    Surface(
                        modifier = Modifier
                            .size(24.dp)
                            .background(colorResource(R.color.hmi_primary), shape = CircleShape)
                    ) { }
                }, colors = SliderDefaults.colors(
                    thumbColor = colorResource(R.color.hmi_primary),
                    activeTrackColor = colorResource(R.color.hmi_secondary)
                )
            )
            Box(
                modifier = Modifier
                    .padding(top = 2.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "1:40",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                Text(
                    "4:40",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .weight(1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painterResource(R.drawable.music_card_ic_shuffle),
                    contentDescription = "",
                    modifier = Modifier.size(56.dp)
                )
                Image(
                    painterResource(R.drawable.music_card_ic_previous),
                    contentDescription = "",
                    modifier = Modifier.size(56.dp)
                )

                Image(
                    painterResource(R.drawable.music_card_ic_pause),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(88.dp)
                        .border(
                            4.dp, Color.White, shape = RoundedCornerShape(80.dp)
                        )
                        .padding(16.dp)

                )
                Image(
                    painterResource(R.drawable.music_card_ic_next),
                    contentDescription = "",
                    modifier = Modifier.size(56.dp)
                )
                Image(
                    painterResource(R.drawable.music_card_ic_favorite),
                    contentDescription = "",
                    modifier = Modifier.size(56.dp)
                )
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun BoxScope.VehicleInfoCards() {
    Surface(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .height(dimensionResource(R.dimen.vehicle_card_height))
            .width(dimensionResource(R.dimen.vehicle_card_width)),
        color = colorResource(R.color.hmi_surface),
        shape = RoundedCornerShape(dimensionResource(R.dimen.hmi_radius_card))
    ) {
        Row {
            Image(
                painterResource(R.drawable.vehicle_card_car_top_view),
                contentDescription = "",
                modifier = Modifier
                    .width(320.dp)
                    .fillMaxHeight()
            )
            Column(modifier = Modifier.padding(40.dp)) {
                Text(
                    "续航",
                    color = colorResource(R.color.hmi_text_secondary),
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600)
                )
                Text(
                    "480 km",
                    color = colorResource(R.color.hmi_text_primary),
                    fontSize = 66.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    val state = SliderState(0.3f, onValueChangeFinished = {})
                    Slider(
                        state, modifier = Modifier.padding(top = 6.dp).weight(1f), thumb = {
                            Surface(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(colorResource(R.color.hmi_primary), shape = CircleShape)
                            ) { }
                        }, colors = SliderDefaults.colors(
                            thumbColor = colorResource(R.color.hmi_primary),
                            activeTrackColor = colorResource(R.color.hmi_secondary)
                        )
                    )
                    Text("76%", fontSize = 28.sp, color = colorResource(R.color.hmi_text_secondary),
                        modifier = Modifier.padding(start = 4.dp))
                }

                Surface(modifier = Modifier.padding(top = 40.dp).fillMaxWidth().height(1.dp).clip(CircleShape), color = colorResource(R.color.hmi_surface_border)) { }
                Row(Modifier.padding(top =36.dp), verticalAlignment = Alignment.CenterVertically) {
                    Image(painterResource(R.drawable.vehicle_card_ic_tire_pressure), contentDescription = ""
                    , modifier = Modifier.size(50.dp))
                    Text("胎压正常", fontSize = 28.sp, color = colorResource(R.color.hmi_text_secondary),
                        modifier = Modifier.padding(start = 14.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(R.drawable.vehicle_card_ic_chevron_right), contentDescription = "",
                        modifier = Modifier.size(40.dp))
                }
            }
        }
    }
}