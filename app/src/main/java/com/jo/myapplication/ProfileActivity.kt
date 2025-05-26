package com.jo.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jo.myapplication.ui.theme.MyComposeAppTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Body()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Body() {
    Box(modifier = Modifier.fillMaxSize()) {
        ImageComposable(
            id = R.drawable.background,
            modifier = Modifier
                .fillMaxSize()
        )
        Column() {
            ImageComposable(R.drawable.cover, modifier = Modifier
                .fillMaxWidth()
                .height(150.dp))
            ProfilePhotoName()
            HorizontalDivider(Modifier.padding(12.dp))
            DescriptionText()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DescriptionText() {
    Text(
        text = stringResource(id = R.string.profile_description),
        color = Color.Black,
        fontSize = 18.sp,
        modifier = Modifier.padding(8.dp),
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ImageComposable(id: Int, modifier: Modifier) {
    Image(
        painter = painterResource(id),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop

    )
}

@Preview(showBackground = true)
@Composable
fun ProfilePhotoName() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Surface(modifier = Modifier.clip(CircleShape)) {
            ImageComposable(
                R.drawable.profile,
                modifier = Modifier
                    .padding(3.dp)
                    .height(105.dp)
                    .width(105.dp)
                    .clip(CircleShape)
            )
        }
        Text(
            text = "${stringResource(id = R.string.name)} ${stringResource(id = R.string.surname)}",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
    }
}