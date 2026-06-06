package com.example.practiceclickbehavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceclickbehavior.ui.theme.PracticeClickBehaviorTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeClickBehaviorTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Lemonade",
                                    fontWeight = FontWeight.Bold
                                )
                            },
                        )
                    }
                ) { innerPadding ->
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ScreenFrame(modifier: Modifier = Modifier) {
    var a by remember { mutableIntStateOf(1) }
    var clicks = (2..4).random()
    val imageAndDescryptionAndText = when (a) {
        1 -> Triple(R.drawable.lemon_tree, R.string.lemon_tree, R.string.select_lemon)
        2 -> Triple(R.drawable.lemon_squeeze, R.string.lemon, R.string.squeeze_lemon)
        3 -> Triple(R.drawable.lemon_drink, R.string.glass_of_lemonade, R.string.drink_lemonade)
        else -> Triple(R.drawable.lemon_restart, R.string.empty_glass, R.string.start_again)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if ( a > 3) a=1 else if (a == 2 && clicks > 1) clicks-- else a++
                      },
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)

        ) {
            Image(painter = painterResource(imageAndDescryptionAndText.first), contentDescription = stringResource(imageAndDescryptionAndText.second))
        }

        Spacer(Modifier.height(16.dp))

        Text(text = stringResource(imageAndDescryptionAndText.third), fontSize = 18.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ScreenFrame(modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center))
}