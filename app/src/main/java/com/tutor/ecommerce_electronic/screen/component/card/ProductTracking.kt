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
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ProductTracking(
	item: ProductData,
	modifier: Modifier = Modifier,
) {
	Card(

	) {
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
					horizontalArrangement = Arrangement.spacedBy(4.dp),
					verticalAlignment = Alignment.CenterVertically
				) {

					Text(
						text = "ID Order : ",
						style = MaterialTheme.typography.titleSmall,
					)
					Text(
						text = "6cafe1aa78d8sas8",
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.Medium
					)
					IconButton(
						{},
						modifier = modifier.size(25.dp)
					) {
						Icon(
							imageVector = Icons.Default.ContentCopy,
							contentDescription = "CopyText",
							modifier.size(20.dp)
						)
					}
				}
			}
		}
	}
}

@Preview
@Composable
private fun ProductTrackingPrev() {
	ProductTracking(
		item = exampleProductData,

		)
}
