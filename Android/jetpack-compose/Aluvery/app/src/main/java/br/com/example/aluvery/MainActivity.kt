package br.com.example.aluvery

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.example.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                4 {
                    MyFirstComposable()
                }
            }

        }

    }
}


@Composable
fun MyFirstComposable(){
    Column {
        Text(
            text = "First try"
        )

        Text(
            text = "Second try"
        )
    }

}

@Composable
@Preview(
    name = "novo",
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(
    name = "TextPreview",
    heightDp = 200,
    widthDp = 300,
    showBackground = true,
    backgroundColor = 0x551243,
    showSystemUi = true
)
fun MyFirstComposablePreview(){
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }
    }
}