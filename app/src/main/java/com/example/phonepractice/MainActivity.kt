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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhonePracticeTheme {
                CalculatorShow()
            }
        }
    }

    override fun onStart() {
        super.onStart()
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

@Composable
fun CalculatorShow(modifier: Modifier = Modifier) {
    var costInput by remember { mutableStateOf("") }
    var cost = costInput.toDoubleOrNull() ?: 0.0

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculate Tip",
            modifier = modifier
                .padding(start = 70.dp)
                .align(alignment = Alignment.Start)

        )
        CalculatorField(costInput, onCostFieldChange = { costInput = it })
        TipShow(cost)
    }
}

@Composable
fun CalculatorField(cost: String, onCostFieldChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        label = { Text( text = "Bill Amount" ) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        value = cost,
        onValueChange = onCostFieldChange,
        modifier = modifier
    )
}

@Composable
fun TipShow(cost: Double, modifier: Modifier = Modifier) {
    val tipAmount = (cost * .15).toString()
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Tip Amount: $tipAmount",
            modifier = modifier
                .align(alignment = Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    PhonePracticeTheme {
        CalculatorShow()
    }
}
