package com.example.phonepractice.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.phonepractice.R

@Composable
fun QuadrantContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = modifier.weight(1f)) {
            QuadrantPart(stringResource(R.string.quadrant_title1), stringResource(R.string.quadrant_content1), Color(0xFFEADDFF), Modifier.weight(1F))
            QuadrantPart(stringResource(R.string.quadrant_title2), stringResource(R.string.quadrant_content2), Color(0xFFD0BCFF), Modifier.weight(1F))
        }
        Row(modifier = modifier.weight(1f)) {
            QuadrantPart(stringResource(R.string.quadrant_title3), stringResource(R.string.quadrant_content3), Color(0xFFB69DF8), Modifier.weight(1F))
            QuadrantPart(stringResource(R.string.quadrant_title4), stringResource(R.string.quadrant_content4), Color(0xFFF6EDFF), Modifier.weight(1F))
        }
    }
}

@Composable
fun QuadrantPart(title: String, content: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}