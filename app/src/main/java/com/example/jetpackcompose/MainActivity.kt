package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        TutorialImage()
                        TutorialText(
                            firstText = stringResource(R.string.title_text),
                            secondText = stringResource(R.string.about_text),
                            thirdText = stringResource(R.string.desc_text)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TutorialText(firstText: String, secondText: String, thirdText: String, modifier: Modifier = Modifier
) {
    Box {
        Column(
            //verticalArrangement = Arrangement.Top,
            modifier = modifier
        ) {
            Text(
                text = firstText, // add a Text composable passing in the text message as a named argument.
                fontSize = 24.sp, //Add a fontSize argument with value of 24.sp.
                modifier = Modifier
                    .padding(16.dp)

                //lineHeight = 116.sp, //Add a lineHeight argument with a value of 116.sp.
                //textAlign = TextAlign.Center // align the greeting text to the center
            )
            Text(
                text = secondText, //Add Text composable that accepts text argument set to the from value.
                fontSize = 11.sp, //Add a fontSize argument with a value of 11.sp.
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = thirdText, // add a Text composable passing in the text message as a named argument.
                fontSize = 11.sp, //Add a fontSize argument with value of 100.sp.
                modifier = Modifier
                    .padding(16.dp, 16.dp, 16.dp, 16.dp),
                textAlign = TextAlign.Justify // align the greeting text to the center
            )
        }
    }
}

@Composable
fun TutorialImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box(modifier) {
        Image(
                painter = image,
                contentDescription = null, //add argument called contentDescription and set its value to null.
                contentScale = ContentScale.FillWidth, // use the ContentScale.Crop parameter scaling, which
                // scales the image uniformly to maintain the aspect ratio.
       ) 
    } 
}

@Preview(showBackground = true)
@Composable
fun TutorialPreview() {
    JetpackComposeTheme {
        TutorialText(
            stringResource(R.string.title_text),
            stringResource(R.string.about_text),
            stringResource(R.string.desc_text)

        )
    }
}