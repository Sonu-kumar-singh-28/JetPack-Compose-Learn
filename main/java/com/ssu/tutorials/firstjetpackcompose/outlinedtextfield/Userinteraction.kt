package com.ssu.tutorials.firstjetpackcompose.outlinedtextfield

import android.text.Selection
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun partially_selectabletext(){

    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SelectionContainer {
            Column{
                Text("This is a first text")
                Text("This is a second text")
                Text("This is a third text")
                Text("This is a fourth  text")
                Text("This is a fifth text")

                DisableSelection {
                    Text("This text is not Selectable")
                    Text("This text is not Selectable Text")
                }
            }
        }
    }
}




@Composable

fun Annotateedstringlistenersample() {
    var urihandler = LocalUriHandler.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            buildAnnotatedString {
                append("Build Better app Faster ")
                var link = LinkAnnotation.Url(
                    "https://developer.android.com/courses/android-basics-compose/course?_gl=1*kxg8pt*_up*MQ..&gclid=Cj0KCQjw8KrFBhDUARIsAMvIApY79qvE5ufCMuU7ulo4lXUqPMYRqpkReVw2sY45GriOCq8UeZ-9l2kaAn-UEALw_wcB&gclsrc=aw.ds&gbraid=0AAAAAC-IOZmYnObbvc6RMPOoVu4uiwCKW",
                    TextLinkStyles(
                        SpanStyle(
                            Color.Blue
                        )
                    )
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    urihandler.openUri(url)
                }
                withLink(link) {
                    append("Jetpack Compose")
                }
            }
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun previews() {
    partially_selectabletext()
}