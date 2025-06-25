package br.com.example.aluvery

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
                Surface {
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

@Preview(
    showBackground = true
)
@Composable
private fun ColumnPreview() {
    Column {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
    Text(text = "Texto 3")

}

@Preview(
    showBackground = true
)
@Composable
private fun RowPreview() {
    Row {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
    Text(text = "Texto 3")

}

@Preview(
    showBackground = true
)
@Composable
private fun BoxPreview() {
    Box {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
    Text(text = "Texto 3")

}

@Preview(
    showBackground = true
)
@Composable
private fun CustomPreview() {
    Column {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Row {
            Text(text = "Texto 3")
            Text(text = "Texto 4")
        }
        Box {
            Row {
                Text(text = "Texto 5")
                Text(text = "Texto 6")
            }
            Column {
                Text(text = "Texto 7")
                Text(text = "Texto 8")
            }
        }
    }


}