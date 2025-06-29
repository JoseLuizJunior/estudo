package br.com.example.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.aluvery.R
import br.com.example.aluvery.model.Product
import java.math.BigDecimal

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