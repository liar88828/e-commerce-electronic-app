package com.tutor.ecommerce_electronic.screen.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.ecommerce_electronic.R
import com.tutor.ecommerce_electronic.model.ProductData
import com.tutor.ecommerce_electronic.model.exampleProductData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductCart(
	item: ProductData,
	modifier: Modifier = Modifier,
) {
	ElevatedCard() {
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(10.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Image(
				painter = painterResource(R.drawable.ic_launcher_foreground),
				contentDescription = "Icon Location",
				modifier = modifier.height(100.dp),
				contentScale = ContentScale.Crop,
			)
			Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
				Text(
					text = item.name,
					style = MaterialTheme.typography.titleMedium,
					fontWeight = FontWeight.Bold
				)
				FlowRow(
					maxItemsInEachRow = 3
				) {

					Text(
						text = item.color[0],
						style = MaterialTheme.typography.bodySmall,
						fontWeight = FontWeight.Light
					)
					Text(
						text = item.ram,
						style = MaterialTheme.typography.bodySmall,
						fontWeight = FontWeight.Light
					)
					Text(
						text = item.memory,
						style = MaterialTheme.typography.bodySmall,
						fontWeight = FontWeight.Light
					)
				}

				Row(
					modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {

					Text(
						text = "$${item.price}",
						style = MaterialTheme.typography.titleLarge,
						fontWeight = FontWeight.Bold
					)
					Text(
						text = "x1",
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.Medium
					)
				}
			}
		}
	}
}

@Preview
@Composable
private fun ProductCartPrev() {
	ProductCart(
		item = exampleProductData
	)
}