package com.jo.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jo.myapplication.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    MyText()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeAppTheme {
        MyColumn()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingJoPreview() {
    MyComposeAppTheme {
        Greeting("Jo")
    }
}

@Preview(showBackground = true)
@Composable
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        MyBox()
        MyText()
        HorizontalDivider(thickness = 5.dp, color = Color.Red)
        Spacer(modifier = Modifier.height(125.dp))
        MyRow()
    }
}

@Composable
fun MyRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        MyVectorImage(Icons.Default.DateRange)
        MyVectorImage(Icons.Default.AccountBox)
        MyVectorImage(Icons.Filled.Call)
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        propagateMinConstraints = false,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.basic_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .blur(5.dp)
        )
        Surface(
            modifier = Modifier
                .clip(CircleShape)
                .padding(2.dp),
            color = Color.White,
            shadowElevation = 10.dp
        ) {
            MyImage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MySurface() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        color = colorResource(R.color.purple_700),
        border = BorderStroke(1.dp, color = Color.DarkGray)
    ) {
        Row {
            //MyText()
            MyImage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.basic_image),
        contentDescription = stringResource(R.string.image_description),
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyVectorImage(imageVector: ImageVector) {
    Image(
        imageVector = imageVector, contentDescription = ""
    )
}

@Preview(showBackground = true)
@Composable
fun MyText() {
    Text(
        text = stringResource(id = R.string.hello),
        color = Color.Gray,
        fontWeight = FontWeight.Black,
        fontStyle = FontStyle.Italic,
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(16.dp, 12.dp, 15.dp, 18.dp)
    )
}

