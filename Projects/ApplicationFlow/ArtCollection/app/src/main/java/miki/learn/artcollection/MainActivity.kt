package miki.learn.artcollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miki.learn.artcollection.ui.theme.ArtCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtCollectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppLogic()
                }
            }
        }
    }
}

@Composable
fun AppLogic(
    modifier: Modifier = Modifier
) {
    var image by remember {
        mutableStateOf(0)
    }

    when (image) {
        0 -> {
            AppLayout(
                image = R.drawable.paris,
                title = R.string.first_picture_title,
                author = R.string.first_picture_author,
                year = R.string.first_picture_year,
                previousOnClick = {
                    image = 2
                },
                nextOnClick = {
                    image++
                }
            )
        }
        1 -> {
            AppLayout(
                image = R.drawable.torre,
                title = R.string.second_picture_title,
                author = R.string.second_picture_author,
                year = R.string.second_picture_year,
                previousOnClick = {
                    image--
                },
                nextOnClick = {
                    image++
                }
            )
        }
        2 -> {
            AppLayout(
                image = R.drawable.coliseu,
                title = R.string.third_picture_title,
                author = R.string.third_picture_author,
                year = R.string.third_picture_year,
                previousOnClick = {
                    image--
                },
                nextOnClick = {
                    image = 0
                }
            )
        }
    }
}

@Composable
fun AppLayout(
    @DrawableRes image: Int,
    @StringRes title: Int,
    @StringRes author: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier,
    previousOnClick: () -> Unit,
    nextOnClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(3F)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .border(
                        BorderStroke(
                            width = 15.dp,
                            color = Color.White
                        )
                    )
                    .shadow(elevation = 10.dp)
            )
        }
        ImageInfo(
            title = stringResource(id = title),
            author = stringResource(id = author),
            year = stringResource(id = year),
            modifier = Modifier
                .weight(1F)
                .fillMaxSize()
        )
        ButtonArrangement(
            nextOnClick = nextOnClick,
            previousOnClick = previousOnClick,
            modifier = Modifier
                .weight(.5F)
        )
    }
}

@Composable
fun ButtonArrangement(
    nextOnClick: () -> Unit,
    previousOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = nextOnClick,
            modifier = modifier
                .weight(1F)
                .padding(
                    4.dp
                )
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = previousOnClick,
            modifier = modifier
                .weight(1F)
                .padding(
                    4.dp
                )
            ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun ImageInfo(
    title: String,
    author: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
        )
        Row(
            modifier = Modifier
        ) {
            Text(
                text = author,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        end = 8.dp
                    )
            )
            Text(
                text = year,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppLayoutPreview() {
    ArtCollectionTheme {
        //AppLayout()
    }
}