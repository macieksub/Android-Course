package com.example.buildabasiclayouthappybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildabasiclayouthappybirthday.ui.theme.BuildABasicLayoutHappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildABasicLayoutHappyBirthdayTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
//                    GreetingText(message = stringResource(R.string.happy_birthday_sam),
//                        stringResource(R.string.from_xyz), modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}


@Composable
fun Square(firstText: String, secondText: String, modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = firstText, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = secondText, textAlign = TextAlign.Justify)
    }
}

@Composable
fun composeQuadrant(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.weight(0.5F)) {
            Square(modifier = Modifier.weight(0.5F).background(color = Color(0xFFEADDFF)).fillMaxSize(), firstText = "Text composable", secondText = "Displays text and follows the recommended Material Design guidelines.")
            Square(modifier = Modifier.weight(0.5F).background(color = Color(0xFFD0BCFF)).fillMaxSize(), firstText = "Image composable", secondText = "Creates a composable that lays out and draws a given Painter class object.")
        }
        Row(modifier = Modifier.weight(0.5F)) {
            Square(modifier = Modifier.weight(0.5F).background(color = Color(0xFFB69DF8)).fillMaxSize(), firstText = "Row composable", secondText = "A layout composable that places its children in a horizontal sequence.")
            Square(modifier = Modifier.weight(0.5F).background(color = Color(0xFFF6EDFF)).fillMaxSize(), firstText = "Column composable", secondText = "A layout composable that places its children in a vertical sequence.")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun preview() {
    BuildABasicLayoutHappyBirthdayTheme{
        composeQuadrant(Modifier.fillMaxSize())
    }
}