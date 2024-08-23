package com.tutor.ecommerce_electronic.screen.tracking

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.ecommerce_electronic.model.TrackingItemData
import com.tutor.ecommerce_electronic.model.exampleProductData
import com.tutor.ecommerce_electronic.model.trackingItemList
import com.tutor.ecommerce_electronic.screen.component.card.ProductTracking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackingScreen(modifier: Modifier = Modifier) {
	Scaffold(
		bottomBar = {
			BottomAppBar {
				Button(
					{},
					modifier
						.fillMaxWidth()
						.padding(horizontal = 10.dp),
					shape = MaterialTheme.shapes.extraSmall
				) {
					Text(
						"Live Tracking",
						style = MaterialTheme.typography.titleMedium,
					)
				}
			}
		},
		topBar = {
			CenterAlignedTopAppBar(navigationIcon = {
				IconButton({}) {
					Icon(
						imageVector = Icons.Default.ArrowBackIosNew,
						contentDescription = "Icon Back"
					)
				}
			}, title = { Text("Tracking Details") })
		},
	) { innerPadding ->
		Column(
			modifier = modifier
				.padding(innerPadding)
				.padding(horizontal = 10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			ProductTracking(exampleProductData)
			HorizontalDivider()
			TrackingAddress()
			HorizontalDivider()
			StatusTracking()
		}
	}
}

@Composable
fun StatusTracking() {

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(10.dp),

		) {
		LazyColumn(
//			verticalArrangement = Arrangement.spacedBy(10.dp)

		) {
			items(trackingItemList) { TrackingItem(it) }
		}

	}
}

@Composable
private fun TrackingItem(
	item: TrackingItemData,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween
	) {

		Row(
			modifier = modifier.fillMaxHeight(1f),
//			verticalAlignment = Alignment.CenterVertically
		) {
			Stepper(isEnd = item.status == "Delivered")

			Column(
//				verticalArrangement = Arrangement.spacedBy(4.dp),
				modifier = modifier.padding(start = 10.dp)
			) {
				Text(
					text = item.status,
					style = MaterialTheme.typography.titleMedium,
					fontWeight = FontWeight.SemiBold
				)
				Text(
					item.desc,
					style = MaterialTheme.typography.bodySmall,
					fontWeight = FontWeight.Light,
					modifier = Modifier.width(270.dp)
				)
			}
		}
		Column {
			Text(
				item.date,
				style = MaterialTheme.typography.titleSmall,
				fontWeight = FontWeight.Light
			)
			Text(
				item.time,
				style = MaterialTheme.typography.titleSmall,
				fontWeight = FontWeight.Light
			)
		}
	}
}

@Preview
@Composable
private fun StepperPrev() {
	Stepper()
}

@Composable
private fun Stepper(
	isEnd: Boolean = false,
	modifier: Modifier = Modifier,
) {
	val innerColor = MaterialTheme.colorScheme.primary
	Box(
		modifier = modifier.height(70.dp)
	) {
		if (!isEnd) {
			VerticalDivider(
				thickness = 3.dp,
				color = MaterialTheme.colorScheme.primary,
				modifier = Modifier
					.align(Alignment.TopCenter)
			)
		}
		Canvas(modifier = Modifier
//			.padding(end = 10.dp)
			.size(20.dp)
			.align(Alignment.TopStart)
			.border(
				shape = CircleShape,
				width = 4.dp,
				color = MaterialTheme.colorScheme.onPrimary
			), onDraw = {
			drawCircle(color = innerColor)
		})

	}
}

@Composable
private fun TrackingAddress() {
	Card {
		Column(
			modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
		) {

			AddressItem(
				icon = Icons.Default.LocationOn,
				desc = "Jl TB Simatupang 17 RT 002/02 Seberang Trakindo Utama Ciland, Dki Jakarta",
				title = "From"
			)
			AddressItem(
				icon = Icons.Default.LocalShipping,
				desc = "Jl Tirta Kencana Tmr Kompl Bumi Kopo Kencana Bl G/1, Jawa Barat",
				title = "Send To"
			)
			AddressItem(
				icon = Icons.Default.Inventory, desc = "3,5 kg", title = "Weight"
			)
		}
	}
}

@Composable
private fun AddressItem(
	modifier: Modifier = Modifier, icon: ImageVector, desc: String, title: String
) {
	Row(
		modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)
	) {
		Icon(
			imageVector = icon, contentDescription = "Location"
		)
		Column(modifier.fillMaxWidth()) {
			Text(
				title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Light
			)
			Text(
				text = desc
			)
		}

	}
}

@Preview
@Composable
private fun TrackingScreenPrev() {
	TrackingScreen()
}
