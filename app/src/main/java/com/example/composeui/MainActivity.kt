package com.example.composeui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.composeui.home.AirConditionCard
import com.example.composeui.home.BottomNavigation
import com.example.composeui.home.ContentCards
import com.example.composeui.home.StatusBar


class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideNavigationBar()
        setContent {
            HmiPage()
        }

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideNavigationBar()
        }
    }

    private fun hideNavigationBar() {
        WindowCompat.getInsetsController(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.systemBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    @Preview(widthDp = 2560, heightDp = 1440)
    @Composable
    fun HmiPage() {
        Surface(color = colorResource(R.color.hmi_background)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = dimensionResource(R.dimen.hmi_page_padding_left),
                        end = dimensionResource(R.dimen.hmi_page_padding_right),
                        top = dimensionResource(R.dimen.hmi_page_padding_top)
                    ),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.hmi_space_card))
            ) {
                StatusBar()
                ContentCards()
                AirConditionCard()
                BottomNavigation()
            }
        }
    }


}
