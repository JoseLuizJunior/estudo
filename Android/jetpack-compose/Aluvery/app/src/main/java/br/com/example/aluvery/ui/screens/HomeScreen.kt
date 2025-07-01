package br.com.example.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.example.aluvery.model.Product
import br.com.example.aluvery.ui.components.ProductsSection


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    LazyColumn(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        for (section in sections) {
            val title = section.key
            val products = section.value
            item {
                ProductsSection(
                    title = title,
                    products = products
                )
            }
        }
    }
}