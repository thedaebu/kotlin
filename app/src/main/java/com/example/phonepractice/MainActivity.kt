package com.example.phonepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.phonepractice.ui.theme.PhonePracticeTheme
import com.example.phonepractice.ui.screens.QuadrantContent
import com.example.phonepractice.ui.screens.BusinessCard
import com.example.phonepractice.ui.screens.LemonSqueeze
import com.example.phonepractice.ui.screens.TipCalculator
import com.example.phonepractice.ui.screens.GameScreen
import com.example.phonepractice.ui.MarsPhotosApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhonePracticeTheme {
                MarsPhotosApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    PhonePracticeTheme {
        MarsPhotosApp()
    }
}
