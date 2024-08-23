package com.tutor.ecommerce_electronic.screen.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.ecommerce_electronic.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
	Scaffold(
		bottomBar = {
			BottomAppBar {
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween
				) {

					Row(verticalAlignment = Alignment.CenterVertically) {
						Checkbox(checked = false, onCheckedChange = { })
						Text("Select All")
					}

					Column {
						Text("Total")
						Text(
							"$${1000.00}",
							style = MaterialTheme.typography.titleMedium,
							fontWeight = FontWeight.Bold
						)

					}
					Button({}) {
						Text(text = "Checkout")

					}
				}
			}
		},
		topBar = {
			TopAppBar(navigationIcon = {
				IconButton({}) {
					Icon(
						imageVector = Icons.Default.ArrowBackIosNew,
						contentDescription = "Icon Back"
					)
				}
			}, title = { Text("My Cart") })
		},
	) { innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding)
				.padding(horizontal = 10.dp)
		) {
			LazyColumn(
				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {
				items(10) {
					ProductItemHorizontal()
				}
			}
		}

	}
}

@Composable
private fun ProductItemHorizontal() {
	ElevatedCard(
		modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.elevatedCardElevation(
			defaultElevation = 2.dp
		)
	) {
		Row(modifier = Modifier.padding(10.dp)) {
			Box() {
				Box() {
					Image(
						painter = painterResource(
							R.drawable.ic_launcher_foreground,
						),
						contentDescription = "Product Image",
						modifier = Modifier.size(100.dp),
						contentScale = ContentScale.Crop

					)
				}
				Box() {
					Checkbox(checked = false, onCheckedChange = { })
				}
			}
			Column(modifier = Modifier.padding(start=10.dp)) {
				Text(
					text = "Product Name",
					style = MaterialTheme.typography.titleSmall,
					fontWeight = FontWeight.Light
				)
				Text(
					text = "$12313423", style = MaterialTheme.typography.titleLarge
				)
//				SelectText()
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
				) {
					IconButton({}) {
						Icon(
							imageVector = Icons.Default.FavoriteBorder,
							contentDescription = "Icon Favorite"
						)
					}
					Row(
						horizontalArrangement = Arrangement.spacedBy(10.dp),
						verticalAlignment = Alignment.CenterVertically
					) {
						FilledIconButton({}) {
							Icon(imageVector = Icons.Default.Remove,
								contentDescription = "Icon Add")
						}
						Text(
							text = "1", style = MaterialTheme.typography.titleLarge
						)
						FilledIconButton({}) {
							Icon(imageVector = Icons.Default.Add,
								contentDescription = "Icon Add")

						}
					}

				}
			}

		}
	}
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SelectText(modifier: Modifier = Modifier) {
//
//	val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
//	var expanded by remember { mutableStateOf(false) }
//	var selectedOptionText by remember { mutableStateOf(options[0]) }
//// We want to react on tap/press on TextField to show menu
//	ExposedDropdownMenuBox(
//		expanded = expanded,
//		onExpandedChange = { expanded = it },
//	) {
//		OutlinedTextField(readOnly = true,
//			value = selectedOptionText,
//			onValueChange = { },
//			trailingIcon = {
//				ExposedDropdownMenuDefaults.TrailingIcon(
//					expanded = expanded
//				)
//			},
//			colors = ExposedDropdownMenuDefaults.textFieldColors()
//		)
//		ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
//			expanded = false
//		}) {
//			options.forEach { selectionOption ->
//				DropdownMenuItem(text = {
//					Text(text = selectionOption)
//				}, onClick = {
//					selectedOptionText = selectionOption
//					expanded = false
//				})
//			}
//		}
//	}
//}

@Preview
@Composable
private fun CartScreenPrev() {
	CartScreen()
}