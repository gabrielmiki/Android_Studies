package miki.learn.milanapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StartScreenLayout(
    images: List<Int>,
    names: List<Int>,
    viewModel: MilanViewModel,
    modifier: Modifier = Modifier,
    onCardClicked: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1F)
        ) {
            StartScreenCard(
                image = images[0],
                name = names[0],
                onCardClicked = { onCardClicked("Coffee Shops") }
            )
            StartScreenCard(
                image = images[1],
                name = names[1],
                onCardClicked = { onCardClicked("Restaurants") }
            )
        }
        Column(
            modifier = Modifier
                .weight(1F)
        ) {
            StartScreenCard(
                image = images[2],
                name = names[2],
                onCardClicked = { onCardClicked("Parks") }
            )
            StartScreenCard(
                image = images[3],
                name = names[3],
                onCardClicked = { onCardClicked("Shoppings") }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreenCard(
    @DrawableRes image: Int,
    @StringRes name: Int,
    modifier: Modifier = Modifier,
    onCardClicked: () -> Unit
) {
    Card(
        onClick = onCardClicked,
        modifier = modifier
            .height(200.dp)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300F
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart,
            ) {
                Text(
                    text = stringResource(id = name),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}