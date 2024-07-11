package miki.learn.milanapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import miki.learn.milanapp.R
import miki.learn.milanapp.model.PlaceInfo

@Composable
fun DetailLayout(
    modifier: Modifier = Modifier,
    placeInfo: PlaceInfo
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(2F)
                .fillMaxSize()
        )
        {
            Surface(
                shadowElevation = 5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Image(
                    painter = painterResource(id = placeInfo.image),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
        Text(
            text = stringResource(id = placeInfo.details),
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 24.dp
                )
                .weight(3F)
        )
    }
}