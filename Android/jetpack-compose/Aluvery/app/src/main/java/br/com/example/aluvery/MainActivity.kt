package br.com.example.aluvery

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import br.com.example.aluvery.extensions.toBrazilianCurrency
import br.com.example.aluvery.model.Product
import br.com.example.aluvery.ui.theme.AluveryTheme
import br.com.example.aluvery.ui.theme.Pink40
import br.com.example.aluvery.ui.theme.Purple40
import br.com.example.aluvery.ui.theme.Purple80
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = true
            App()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun App(){
    AluveryTheme {
        Surface (
            modifier = Modifier
                .systemBarsPadding()){
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(Modifier)
                ProductsSection()
                ProductsSection()
                ProductsSection()
                Spacer(Modifier)
            }

        }
    }
}
@Composable
private fun ProductItem(product: Product) {
    Surface ( shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp ){
        Column (Modifier
            .heightIn(250.dp, 300.dp)
            .width(200.dp)){
            val boxSize: Dp = 100.dp;
            Box(modifier = Modifier
                .height(boxSize)
                .fillMaxWidth()
                .background(brush = Brush.horizontalGradient(colors = listOf(Purple40, Color.Cyan)))){
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = "Imagem do produto",
                    Modifier
                        .size(boxSize)
                        .offset(y = boxSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop

                )
            }
            Spacer(modifier = Modifier.height(boxSize/2))
            Column (Modifier
                .padding(16.dp)
                .fillMaxWidth()){
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@Composable
fun ProductsSection() {
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Spacer(Modifier)
            ProductItem(Product(
                name = "Hambúrger",
                price = BigDecimal("14.99"),
                image = R.drawable.burger
            ))
            ProductItem(Product(
                name = "Batata frita",
                price = BigDecimal("25.99"),
                image = R.drawable.fries
            ))
            ProductItem(Product(
                name = "Pizza",
                price = BigDecimal("30.99"),
                image = R.drawable.pizza
            ))
            Spacer(Modifier)
        }
    }
}

@Composable
private fun ProductsSectionPreview() {
    ProductsSection()
}
