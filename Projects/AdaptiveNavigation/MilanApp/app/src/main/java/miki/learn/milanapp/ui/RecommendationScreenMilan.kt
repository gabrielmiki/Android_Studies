package miki.learn.milanapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import miki.learn.milanapp.R
import miki.learn.milanapp.data.DataSource
import miki.learn.milanapp.model.PlaceInfo

@Composable
fun RecommendationScreenList(
    recommendations: List<PlaceInfo>,
    onCardClicked: (PlaceInfo) -> Unit,
    modifier: Modifier = Modifier
) {
    if (recommendations.isNotEmpty()) {
        LazyColumn(
            modifier = modifier
                .padding(8.dp)
        ) {
            items(recommendations) {
                RecommendationScreenLayout(
                    placeInfo = it,
                    onCardClicked = { onCardClicked(it) },
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp
                        )
                )
            }
        }
    }
    else Spacer(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationScreenLayout(
    placeInfo: PlaceInfo,
    modifier: Modifier = Modifier,
    onCardClicked: (PlaceInfo) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        onClick = { onCardClicked(placeInfo) },
        modifier = modifier
            .fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            Surface(
                shadowElevation = 5.dp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        bottom = 8.dp,
                        top = 8.dp
                    )
            ) {
                Image(
                    painter = painterResource(id = placeInfo.image),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .aspectRatio(1F)
                        .padding(8.dp)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = placeInfo.name),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                )
            }
        }
    }
}