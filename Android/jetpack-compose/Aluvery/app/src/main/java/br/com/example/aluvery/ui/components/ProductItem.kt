package br.com.example.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.aluvery.extensions.toBrazilianCurrency
import br.com.example.aluvery.model.Product
import br.com.example.aluvery.ui.theme.Purple40

@Composable
fun ProductItem(product: Product) {
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