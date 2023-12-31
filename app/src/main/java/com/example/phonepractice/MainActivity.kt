package com.example.phonepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonepractice.ui.theme.PhonePracticeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhonePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialBox()
                }
            }
        }
    }
}

@Composable
fun TutorialBox(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        TutorialContent()
    }
}

@Composable
fun TutorialContent(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.article_header_image),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.article_title),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = stringResource(R.string.article_p1),
            modifier = Modifier
                .padding(start = 16.dp)
                .padding(end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.article_p2),
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManagerBox(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        TaskManagerContent()
    }
}

@Composable
fun TaskManagerContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.task_completed_icon),
            contentDescription = null
        )
        Text(
            text = "All Tasks Completed!",
            modifier = modifier
                .padding(top = 24.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = "Nice Work!",
            modifier = modifier,
            fontSize = 16.sp
        )
    }
}

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

@Composable
fun BusinessCardContent(modifier: Modifier = Modifier) {
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
            modifier = Modifier.background(Color(0xFFF6EDFF)).size(50.dp)
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

@Preview(showBackground = true)
@Composable
fun Preview() {
    PhonePracticeTheme {
        BusinessCardContent()
    }
}