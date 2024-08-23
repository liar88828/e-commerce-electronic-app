package com.tutor.ecommerce_electronic.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.ecommerce_electronic.R

@Composable
fun ProductList() {
	LazyVerticalStaggeredGrid(
		columns = StaggeredGridCells.Fixed(2),
		verticalItemSpacing = 10.dp,
		horizontalArrangement = Arrangement.spacedBy(10.dp),
	) {
		items(10) {
			ProductItem(exampleProductData)
		}
	}
}

@Composable
private fun ProductItem(product: ProductData) {
	ElevatedCard(
		elevation = CardDefaults.elevatedCardElevation(
			defaultElevation = 2.dp
		),
	) {
		Column(
			modifier = Modifier.padding(10.dp),
//			verticalArrangement = Arrangement.spacedBy(4.dp)
		) {
			Box() {
				Box() {
					Image(
						painter = painterResource(R.drawable.ic_launcher_foreground),
						contentDescription = "Product Image",
						modifier = Modifier
							.fillMaxWidth()
							.height(170.dp)
					)
					Box() {
						Badge() {
							Text(text = "New")
						}
					}
					Box(modifier = Modifier.align(Alignment.TopEnd)) {
						Badge() {
							Text(text = "16% off")
						}
					}
				}
			}
			Text(
				text = product.name,
				style = MaterialTheme.typography.titleSmall,
				maxLines = 2
//				fontWeight = FontWeight.SemiBold
			)
			Text(
				text = "$ ${product.price}",
				style = MaterialTheme.typography.titleLarge,
				fontWeight = FontWeight.SemiBold
			)
			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					Icons.Default.Star,
					contentDescription = "Star",
					tint = Color.Yellow.copy(
						alpha = 0.9f,
//						red = 0.2f
					),
				)
				Text(
					text = "${product.rating}",
					style = MaterialTheme.typography.bodySmall,
				)
				Text(text = " . ${product.sold} sold")
			}
			Row(
				verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					imageVector = Icons.Default.LocationOn,
					contentDescription = "Location",
					tint = MaterialTheme.colorScheme.primary
				)
				Text(
					text = "Jakarta",
					style = MaterialTheme.typography.bodySmall,

					)
			}
		}
	}
}

@Preview
@Composable
private fun ProductListPrev() {
	ProductList()
}