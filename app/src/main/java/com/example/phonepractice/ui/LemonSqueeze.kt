package com.example.phonepractice.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepractice.R

@Composable
fun LemonSqueeze(modifier: Modifier = Modifier) {
    val stages: List<String> = listOf("lemon_tree", "lemon_squeeze", "lemon_drink", "lemon_restart")
    var stageIndex by remember { mutableIntStateOf(1) }
    val imageResource = when(stageIndex) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LemonSqueezeTitle()
        LemonSqueezeContent(imageResource,
            stages[stageIndex],
            onImageClick = { stageIndex = (stageIndex + 1) % 4 }
        )
    }
}

@Composable
fun LemonSqueezeTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .height(30.dp)
    ) {
        Text(
            text = "Lemonade",
            fontSize = 20.sp,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun LemonSqueezeContent(imageResource: Int, content: String, onImageClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(40.dp)
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null
                )
            }
            Text(
                text = content
            )
        }
    }
}