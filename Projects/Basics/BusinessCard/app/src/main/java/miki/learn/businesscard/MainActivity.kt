package miki.learn.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miki.learn.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileContent(
                        name = "Gabriel Miki",
                        profession = "Student of Android Development"
                    )

                    ContactList(
                        cellPhone = stringResource(id = R.string.cellphone),
                        socialMedia = stringResource(id = R.string.social_media),
                        email = stringResource(id = R.string.email)
                    )
                }
            }
        }
    }
}

@Composable
fun ContactList(
    cellPhone: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                bottom = 16.dp
            )
    ) {
        ContactInfo(text = cellPhone, icone = Icons.Rounded.Call)
        ContactInfo(text = socialMedia, icone = Icons.Rounded.Send)
        ContactInfo(text = email, icone = Icons.Rounded.Email)
    }
}

@Composable
fun ContactInfo(
    text: String,
    icone: ImageVector,
    modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Icon(
            icone,
            contentDescription = null,
            tint = Color(0xFF39B047),
            modifier = modifier
                .padding(
                    end = 4.dp
                )
        )
        Text(text = text, color = Color.Gray)
    }
}

@Composable
fun ProfileContent(
    name: String,
    profession: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.ic_launcher_foreground)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .background(
                    color = Color.Green,
                    shape = CircleShape
                )
        )
        DescriptionText(
            name = name,
            profession = profession
        )
    }
}

@Composable
fun DescriptionText(
    name: String,
    profession: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        fontSize = 24.sp,
        color = Color.Gray,
        modifier = modifier
            .padding(
                bottom = 8.dp
            )
    )
    Text(
        text = profession,
        color = Color(0xFF39B047),
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    BusinessCardTheme {
        ProfileContent(
            name = "Gabriel Miki",
            profession = "Student of Android Development"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    BusinessCardTheme {
        ContactInfo(
            icone = Icons.Rounded.Call,
            text = stringResource(R.string.cellphone)
        )
    }
}