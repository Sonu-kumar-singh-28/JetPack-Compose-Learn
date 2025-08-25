package com.ssu.tutorials.firstjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ssu.tutorials.firstjetpackcompose.ui.theme.FirstJetpackComposeTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import com.ssu.tutorials.firstjetpackcompose.outlinedtextfield.Annotateedstringlistenersample
import com.ssu.tutorials.firstjetpackcompose.outlinedtextfield.SimpleOutlinedtextfield
import com.ssu.tutorials.firstjetpackcompose.outlinedtextfield.partially_selectabletext
import com.ssu.tutorials.firstjetpackcompose.outlinedtextfield.rememberPasswordTextfield


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstJetpackComposeTheme {
                Annotateedstringlistenersample()
            }
        }
    }
}

// String + Color resource example
@Composable
fun AccessStringResource() {
    Text(
        text = stringResource(R.string.My_name),
        color = colorResource(R.color.teal_200)
    )
}

// Image resource example
@Composable
fun ImagesAccess() {
    Image(
        painter = painterResource(R.drawable.profile),
        contentDescription = "Image View"
    )
}

// Combine both in one screen
@Composable
fun ContentScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Stack elements inside the Box
        ImagesAccess()
        //AccessStringResource()
        simpletext()
        colorfulltext()
    }
}

// text in typography
@Composable
fun simpletext() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = stringResource(R.string.jetpackcompose),
            color = colorResource(R.color.teal_200),
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(color = Color.Blue, blurRadius = 20f)
            )
        )
    }
}


@Composable
fun colorfulltext(){
    val ranbowcolor = listOf(
        Color.Red,
        Color.Blue,
        Color.Yellow,
        Color.Cyan,
        Color.Green,
        Color.Magenta
    )
    Text(text = buildAnnotatedString {
        append("Do noT allow People to dim Your Shine \n")
        withStyle(
            SpanStyle(
                brush = Brush.linearGradient(colors = ranbowcolor)
            )
        ){
            append("because They are Blinded.")
        }
        append("\n tell tehem to put some sunglasses on")
    }
    )
}



@Composable
fun BasicmarquieSample(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text("hii I am Sonu Kumar Singh Experimenting with the jetpack compose ".repeat(50),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 30.sp
            )
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewContent() {
    FirstJetpackComposeTheme {
        Annotateedstringlistenersample()
    }
}
