package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DigitalLemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DigitalLemonadeApp() {
    MakingLemonade(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun MakingLemonade(modifier: Modifier = Modifier) {
    var stage by remember {mutableStateOf( 1 )}
    var lemonSqueeze by remember {mutableStateOf(2)}

    when(stage) {
        1 -> {
            LemonadeUI(
                imageID = painterResource(R.drawable.lemon_tree),
                contentDescription = stringResource(R.string.Lemon_Tree),
                textID = stringResource(R.string.Step1),
                imageOnClick = {
                    stage = 2
                    lemonSqueeze = (2..4).random()
                }
            )
        }

        2 -> {
            LemonadeUI(
                imageID = painterResource(R.drawable.lemon_squeeze),
                contentDescription = stringResource(R.string.Lemon),
                textID = stringResource(R.string.Step2),
                imageOnClick = {
                    lemonSqueeze--
                    if(lemonSqueeze == 0) {
                        stage = 3
                    }
                }
            )
        }

        3 -> {
            LemonadeUI(
                imageID = painterResource(R.drawable.lemon_drink),
                contentDescription = stringResource(R.string.Glass_of_Lemonade),
                textID = stringResource(R.string.Step3),
                imageOnClick = {
                    stage = 4
                }
            )
        }

        4 -> {
            LemonadeUI(
                imageID = painterResource(R.drawable.lemon_restart),
                contentDescription = stringResource(R.string.Empty_Glass),
                textID = stringResource(R.string.Step4),
                imageOnClick = {
                    stage = 1
                }
            )
        }
    }
}

@Composable
fun LemonadeUI (
    imageID: Painter,
    contentDescription: Any,
    textID: String,
    imageOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name)

        )
    }
}