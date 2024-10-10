package com.hsb.composesplash.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hsb.composesplash.R
import com.hsb.extensions_hsb.utils.globalextensions.Extensions.logIt

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }

    @Composable
    fun SplashScreen() {

        ImageButton(R.drawable.pro_app_icon, "Smart Printer App") {
            it.logIt()
        }

    }

    @Composable
    fun ImageButton(icon: Int, title: String, onClick: ((title: String) -> Unit)? = null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { onClick?.invoke(title) }.height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(30.dp),

                ) {
                Column(
                    modifier = Modifier
                        .padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ImageView(icon)
                    BoldText(title, Color.Blue)
                }
            }
        }
    }

    @Composable
    fun BoldText(text: String, color: Color = Color.Black) {
        Text(
            text = text,
            color = color,
            fontSize = 32.sp,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun ImageView(image: Int, size: Dp = 50.dp) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(size)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewSplash() {
        ImageButton(R.drawable.pro_app_icon, "Unity Game Splash") {
            it.logIt()
        }
    }
}