package com.example.lab01_rpgdice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab01_rpgdice.ui.theme.Lab01_RPGDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab01_RPGDiceTheme {
                RPGDiceScreen()
            }
        }
    }
}

@Composable
fun RPGDiceScreen() {
    // Estados de los atributos
    var vitality by remember { mutableIntStateOf(10) }
    var dexterity by remember { mutableIntStateOf(10) }
    var wisdom by remember { mutableIntStateOf(10) }

    // Suma total de atributos
    val total = vitality + dexterity + wisdom

    Column {
        Text("RPG Dice Roller")

        // Filas de atributos
        StatRow(
            name = "Vitality",
            value = vitality,
            onRoll = { vitality = (1..25).random() }
        )
        StatRow(
            name = "Dexterity",
            value = dexterity,
            onRoll = { dexterity = (1..25).random() }
        )
        StatRow(
            name = "Wisdom",
            value = wisdom,
            onRoll = { wisdom = (1..25).random() }
        )

        // Mostrar total
        Text("Total: $total")

        // Mensajes según la suma total
        if (total < 30) {
            Text(
                text = "Re-roll recommended!",
                color = Color.Red
            )
        } else if (total >= 50) {
            Text(
                text = "Godlike!",
                color = Color(0xFFFFD700) // Dorado
            )
        }
    }
}

@Composable
fun StatRow(
    name: String,
    value: Int,
    onRoll: () -> Unit
) {
    Column {
        Text("$name: $value")
        Button(onClick = onRoll) {
            Text("Roll $name")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RPGDiceScreenPreview() {
    Lab01_RPGDiceTheme {
        RPGDiceScreen()
    }
}



