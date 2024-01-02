package com.example.phonepractice.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TipCalculator(modifier: Modifier = Modifier) {
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