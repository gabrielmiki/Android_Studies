package miki.learn.composequadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import miki.learn.composequadrants.ui.theme.ComposeQuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppLayout()
                }
            }
        }
    }
}

@Composable
fun AppLayout() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1F)
        ) {
            QuadrantText(
                title = stringResource(id = R.string.title_one),
                text = stringResource(id = R.string.text_one),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1F)
            )
            QuadrantText(
                title = stringResource(id = R.string.title_two),
                text = stringResource(id = R.string.text_two),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1F)
            )
        }
        Row(
            modifier = Modifier.weight(1F)
        ) {
            QuadrantText(
                title = stringResource(id = R.string.title_three),
                text = stringResource(id = R.string.text_three),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            QuadrantText(
                title = stringResource(id = R.string.title_four),
                text = stringResource(id = R.string.text_four),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun QuadrantText(
    title: String,
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    bottom = 16.dp
                )
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantsTheme {
        AppLayout()
    }
}