package com.tutor.ecommerce_electronic.screen.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tutor.ecommerce_electronic.model.DeliverData
import com.tutor.ecommerce_electronic.model.PaymentData
import com.tutor.ecommerce_electronic.model.UserData
import com.tutor.ecommerce_electronic.model.defaultDeliverData
import com.tutor.ecommerce_electronic.model.defaultUserData
import com.tutor.ecommerce_electronic.model.examplePaymentDataList
import com.tutor.ecommerce_electronic.model.exampleProductData
import com.tutor.ecommerce_electronic.screen.component.TitleCard
import com.tutor.ecommerce_electronic.screen.component.card.ProductCart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutScreen(modifier: Modifier = Modifier, navController: NavHostController) {
	Scaffold(
		bottomBar = {
			BottomAppBar {
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 10.dp),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					Column(
//						verticalArrangement = Arrangement.spacedBy(10.dp)
					) {
						Text(
							text = "Total",
							style = MaterialTheme.typography.titleSmall,
							fontWeight = FontWeight.Light
						)
						InputChip(
							modifier = modifier.padding(0.dp),
							border = InputChipDefaults.inputChipBorder(
								enabled = false,
								selected = false
							),
							selected = false,
							onClick = {},
							trailingIcon = {
								Icon(
									imageVector = Icons.Default.ArrowDropDown,
									contentDescription = "ArrowDropDown"
								)
							},
							label = {
								Text(
									"$${1000.00}",
									style = MaterialTheme.typography.titleSmall,
									fontWeight = FontWeight.SemiBold
								)

							}
						)

					}


					Button(
						{},
						modifier.height(40.dp),
						shape = MaterialTheme.shapes.medium
					) {
						Text(
							text = "Checkout",
							style = MaterialTheme.typography.titleMedium
						)

					}
				}
			}
		},
		topBar = {
			CenterAlignedTopAppBar(
				navigationIcon = {
					IconButton({}) {
						Icon(
							imageVector = Icons.Default.ArrowBackIosNew,
							contentDescription = "Icon Back"
						)
					}
				}, title = { Text("Checkout") })
		},
	) { innerPadding ->
		Column(
			modifier = modifier
				.padding(innerPadding)
				.padding(horizontal = 10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			ShippingAddress(item = defaultUserData)
			ProductCart(exampleProductData)
			SelectShipping(item = defaultDeliverData)
			HorizontalDivider()
			PaymentMethod()
		}
	}
}

@Composable
private fun PaymentMethod(modifier: Modifier = Modifier) {
	Column() {
		TitleCard(title = "Payment Method", clickEnabled = false)
		LazyRow(
			modifier = modifier.padding(top = 10.dp),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			items(examplePaymentDataList) { PaymentItem(it) }
		}
	}
}

@Composable
private fun PaymentItem(
	item: PaymentData,
	modifier: Modifier = Modifier,
) {
	ElevatedCard(
		modifier.width(200.dp)
	) {
		Column(
			modifier = modifier.padding(10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
				Icon(
					imageVector = item.icon,
					contentDescription = item.type
				)
				Text(
					text = item.type,
					style = MaterialTheme.typography.titleMedium,
					fontWeight = FontWeight.Medium
				)
			}
			Text(text = item.desc)

		}
	}
}

@Composable
fun SelectShipping(
	item: DeliverData, modifier: Modifier = Modifier,
) {
	Column(
		modifier.fillMaxWidth(),
		verticalArrangement = Arrangement.spacedBy(10.dp)

	) {
		TitleCard(textButton = "See all option", title = "Select Shipping", click = {})
		ElevatedCard(onClick = {}) {
			Row(
				modifier
					.fillMaxWidth()
					.padding(20.dp),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically

			) {
				Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
					Text(
						item.name,
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.SemiBold
					)
					Text(
						"Estimated arrived : ${item.time}",
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.Light
					)
				}
				Text(
					"$${item.price}",
					style = MaterialTheme.typography.titleLarge,
					fontWeight = FontWeight.Bold
				)
			}
		}


		Row(
			modifier = modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(
				text = "Note : ",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Bold
			)
			OutlinedTextField(
				value = "",
				onValueChange = {},
				modifier = modifier.width(200.dp),
				maxLines = 1,
				placeholder = {
					Text(
						text = "Enter your note here", maxLines = 1

					)
				}
			)
		}

		Row(
			modifier = modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(
				text = "Subtotal : 1 items",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Bold
			)
			Text(
				text = "$${item.price}",
				style = MaterialTheme.typography.titleLarge,
				fontWeight = FontWeight.Bold
			)
		}

	}
}

@Composable
private fun ShippingAddress(item: UserData, modifier: Modifier = Modifier) {
	ElevatedCard() {
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(10.dp),
			verticalAlignment = CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Column() {
				Row(
					modifier = modifier
						.fillMaxWidth(),
					verticalAlignment = CenterVertically,
					horizontalArrangement = Arrangement.SpaceBetween
				) {
					Row(
						horizontalArrangement = Arrangement.spacedBy(4.dp)
					) {
						Icon(
							imageVector = Icons.Default.LocationOn,
							contentDescription = "Icon Location"
						)

						Text(
							text = "Shipping Address",
							style = MaterialTheme.typography.titleMedium,
							fontWeight = FontWeight.Bold
						)

					}
					InputChip(
						onClick = {},
						label = { Text("Home") },
						selected = false,
					)
				}

				Text(
					text = item.address,
					style = MaterialTheme.typography.titleSmall,
					fontWeight = FontWeight.Light
				)

				Row() {

					Text(
						text = item.name,
						style = MaterialTheme.typography.titleSmall,
					)
					Text(
						text = item.phone,
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.Light
					)
				}

			}
			Icon(
				imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
				contentDescription = "Icon Arrow Forward"
			)
		}
	}
}

@Preview
@Composable
private fun CheckoutScreenPrev() {
	val navController = rememberNavController()
	CheckOutScreen(navController = navController)
}