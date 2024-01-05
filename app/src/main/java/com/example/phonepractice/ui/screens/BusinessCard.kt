package com.example.phonepractice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.phonepractice.R

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFB69DF8))
    ) {
        BusinessCardTop(modifier = Modifier.weight(1f))
        BusinessCardBottom(modifier = Modifier.weight(1f))
    }
}

@Composable
fun BusinessCardTop(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.business_card_image),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .background(Color(0xFFF6EDFF))
                .size(50.dp)
        )
        Text(
            text = "My Name"
        )
        Text(
            text = "Software Engineer"
        )
    }
}

@Composable
fun BusinessCardBottom(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 15.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "phone number"
        )
        Text(
            text = "email"
        )
    }
}