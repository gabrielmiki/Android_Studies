package miki.learn.lemonade

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miki.learn.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeAppContent()
}

@Composable
fun LemonadeAppContent() {
    var displayResource by remember {
        mutableStateOf(0)
    }

    var variableRandom by remember {
        mutableStateOf(1)
    }

    when (displayResource) {
        0 -> {
            AppLayout(
                imageResource = R.drawable.lemon_tree,
                stringResource = R.string.lemon_collect,
                onClickInstruction = {
                    displayResource = 1
                    variableRandom = (2..4).random()
                })
        }
        1 -> {
            AppLayout(
                imageResource = R.drawable.lemon_squeeze,
                stringResource = R.string.lemon_squeeze,
                onClickInstruction = {
                    variableRandom--
                    if (variableRandom == 0) {
                        displayResource = 2
                    }
                })
        }
        2 -> {
            AppLayout(
                imageResource = R.drawable.lemon_drink,
                stringResource = R.string.lemon_drink,
                onClickInstruction = {
                    displayResource = 3
                })
        }
        3 -> {
            AppLayout(
                imageResource = R.drawable.lemon_restart,
                stringResource = R.string.start_again,
                onClickInstruction = {
                    displayResource = 0
                })
        }
    }


}

@Composable
fun AppLayout(
    imageResource: Int,
    stringResource: Int,
    onClickInstruction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(Color.LightGray),
            shape = RoundedCornerShape(10.dp),
            onClick = onClickInstruction
        )
        {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = stringResource),
            fontSize = 18.sp
        )
    }
}