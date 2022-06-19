package com.victorcaveda.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import com.victorcaveda.composecourse.ui.theme.ComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MediaItem()
                }
            }
        }
    }

}

@Composable
private fun LabelButton(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier
                .clickable { /*TODO*/ }
                .background(Color.Green)
                .border(width = 1.dp, color = Color.Black)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(name = "mediaItem", showBackground = true)
@Composable
private fun MediaItem() {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)
        )
        {
            Image(
                painter = rememberImagePainter(data = "https://picsum.photos/400",
                    builder = {
                        transformations(BlurTransformation(LocalContext.current))
                    }),
                contentDescription = "Random image"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Movie title",
                maxLines = 1,
                style = MaterialTheme.typography.h6.copy(
                    fontFamily = FontFamily.Monospace
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "labelButton",
    widthDp = 200,
    heightDp = 100
)
@Composable
private fun ButtonSample() {
    LabelButton("hola")
}