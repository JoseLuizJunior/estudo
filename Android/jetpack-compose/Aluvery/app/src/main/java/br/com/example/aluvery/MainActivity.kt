package br.com.example.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import br.com.example.aluvery.sampledata.sampleSections
import br.com.example.aluvery.ui.screens.HomeScreen
import br.com.example.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
                true
            App()
        }
    }
}

@Composable
fun App() {
    AluveryTheme {
        Surface(
            modifier = Modifier
                .systemBarsPadding()
        ) {
            HomeScreen(
                sampleSections
            )
        }
    }
}

