package com.example.animatedgradient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.animatedgradient.ui.theme.AnimatedGradientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedGradientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainView()

                }
            }
        }
    }
}


@Composable
fun MainView() {
//rotator
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            tween(700, easing = LinearEasing)
        )
    )

    //color
    val colorList = listOf(
        Color.Blue,
        Color.Red,
        Color.Yellow,
        Color.Magenta
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box{
            Image(
                painter = painterResource(id = R.drawable.with_computer), contentDescription = "",
                modifier = Modifier
                    .size(170.dp)
                    .clip(shape = CircleShape)
            )
            Box(modifier = Modifier.rotate(angle)) {
                Box(
                    modifier = Modifier
                        .size(170.dp)
                        .clip(shape = CircleShape)
                        .border(
                            width = 5.dp,
                            brush = Brush.horizontalGradient(colors = colorList),
                            shape = CircleShape,
                        )
                )
            }

        }


    }
}

