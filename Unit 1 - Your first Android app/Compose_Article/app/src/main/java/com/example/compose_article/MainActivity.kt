package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article.ui.theme.Compose_ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleImage(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ArticleText(modifier: Modifier) {
        Text(
            text = stringResource(R.string.heading_article),
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)

        )
        Text(
            text = stringResource(R.string.introduction_para),
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(
                start = 16.dp,
                end  = 16.dp
            )
        )
        Text(
            text = stringResource(R.string.content_para),
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
}

@Composable
fun ArticleImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        ArticleText(modifier.align(alignment = Alignment.CenterHorizontally))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeArticlePreview() {
    Compose_ArticleTheme {
        ArticleImage()
    }
}