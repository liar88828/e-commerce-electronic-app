package com.tutor.ecommerce_electronic.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PrecisionManufacturing
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.twotone.Computer
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.ecommerce_electronic.R
import com.tutor.ecommerce_electronic.screen.component.ProductData
import com.tutor.ecommerce_electronic.screen.component.exampleProductData

@OptIn(
	ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
	ExperimentalFoundationApi::class
)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
	Scaffold(
		topBar = {
			TopAppBar(title = {
				Text(text = "Ecommerce Electronic")

			},
				actions = {
					OutlinedIconButton(
						{},
						shape = MaterialTheme.shapes.medium
					) {
						BadgedBox(
							badge = { Badge() },
						) {
							Icon(Icons.Outlined.Notifications, contentDescription = "Notification")
						}
					}
					OutlinedIconButton(
						{},
						shape = MaterialTheme.shapes.medium
					) {
						BadgedBox(
							badge = { Badge() },
						) {
							Icon(Icons.Outlined.ShoppingBag, contentDescription = "ShopBag")
						}
					}
				},
				navigationIcon = {
					IconButton({}) {
						Icon(Icons.Default.Menu, contentDescription = "Menu")
					}
				})
		},
		bottomBar = {
			NavigationBar {
				MyNavigationBarItem(true, {}, Icons.Default.Home, "Home")
				MyNavigationBarItem(false, {}, Icons.Default.FavoriteBorder, "Wishlist")
				MyNavigationBarItem(false, {}, Icons.Default.Description, "Transaction")
				MyNavigationBarItem(false, {}, Icons.Default.Person, "Profile")
			}
		},

		) { innerPadding ->
		val search = remember { mutableStateOf("") }
		val statePager = rememberPagerState(pageCount = { 10 })
		Column(
			modifier = modifier
				.padding(innerPadding)
				.padding(horizontal = 15.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Search(search)
			Location()
			Category()
			Carousel(statePager)
			ProductList()
		}
	}
}

@Composable
private fun ProductList(modifier: Modifier = Modifier) {
	Card(
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.background
		)
	) {
		Column(
//			modifier = modifier.padding( 10.dp),
		) {
			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
			) {
				Row(
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.spacedBy(4.dp)
				) {
					Text(
						text = "Flash Sale",
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.Bold
					)
					Text(
						text = "Ends In",
						style = MaterialTheme.typography.titleSmall,
					)
					Badge() {
						Text(text = "20:20:20")
					}
				}
				TextButton(
					{},
					modifier
						.padding(0.dp)
						.height(20.dp),
					contentPadding = PaddingValues(0.dp)
				) {
					Text(
						text = "See all",
						modifier.padding(0.dp)
					)
				}
			}

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
	}
}

@Composable
fun ProductItem(product: ProductData) {
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
							.height(180.dp)
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
//				fontWeight = FontWeight.SemiBold
			)
			Text(
				text = "R${product.price}",
				style = MaterialTheme.typography.titleLarge,
				fontWeight = FontWeight.Bold

			)
			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {

				Icon(
					Icons.Default.Star,
					contentDescription = "Star",
					tint = Color.Yellow.copy(alpha = 0.8f),
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

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun Carousel(statePager: PagerState) {
	HorizontalPager(state = statePager) { page ->
		Card(
			modifier = Modifier.fillMaxWidth(),
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween
			) {

				Column(
					modifier = Modifier.padding(20.dp),
					verticalArrangement = Arrangement.spacedBy(10.dp),

					) {
					Text(
						text = "6.6 Flash Sale",
						style = MaterialTheme.typography.titleLarge,
						fontWeight = FontWeight.Bold
					)
					Text(
						text = "Cashback Up to 100%",
						style = MaterialTheme.typography.titleSmall,
					)
					Button(
						{},
						shape = MaterialTheme.shapes.medium,
					) {
						Text(text = "Shop Now")
					}
				}
				Image(
					painter = painterResource(R.drawable.ic_launcher_foreground),
					contentDescription = "Image Carousel",
					modifier = Modifier.align(Alignment.Bottom)

				)
			}
		}
	}
}

@Composable
private fun Search(
	search: MutableState<String>,
	modifier: Modifier = Modifier
) {
	OutlinedTextField(
		modifier = modifier.fillMaxWidth(),
		colors = OutlinedTextFieldDefaults.colors(),
		maxLines = 1,
		placeholder = { Text("Find you needed...") },
		value = search.value,
		onValueChange = { search.value = it },
		leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
		trailingIcon = {
			Icon(Icons.Default.FilterList, contentDescription = "Filter")
		}
	)
}

@Composable
private fun Location() {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(4.dp)
	) {
		Icon(
			Icons.Default.LocationOn, contentDescription = "Location",
			tint = MaterialTheme.colorScheme.primary
		)
		Text(
			text = "Deliver To ",
			style = MaterialTheme.typography.bodySmall,
//			fontWeight = FontWeight.Light

		)
		Text(
			text = "Jl Panjang 5 Wisma AKR Lt 6 Ruang 607, Dki Jakarta",
			style = MaterialTheme.typography.bodyMedium,
			fontWeight = FontWeight.Bold,
			maxLines = 1,
			overflow = TextOverflow.Ellipsis
		)
	}
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun Category() {
	FlowRow(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 10.dp),
		maxItemsInEachRow = 4,
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalArrangement = Arrangement.spacedBy(10.dp)
	) {
		CategoryItem("Electronic", Icons.TwoTone.Computer)
		CategoryItem("FootDrink", Icons.Default.Fastfood)
		CategoryItem("Accessorise", Icons.Default.Watch)
		CategoryItem("Ticket", Icons.Default.ConfirmationNumber)
		//
		CategoryItem("Furniture", Icons.Default.Chair)
		CategoryItem("Fashion", Icons.Default.Checkroom)
		CategoryItem("Health", Icons.Default.HealthAndSafety)
		CategoryItem("Robot", Icons.Default.PrecisionManufacturing)
	}
}

@Composable
private fun CategoryItem(title: String, icon: ImageVector) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		OutlinedIconButton(
			{},
			modifier = Modifier.size(50.dp)

		) {
			Icon(
				imageVector = icon, contentDescription = title,
				modifier = Modifier
					.size(25.dp)
//					.padding(10.dp)

			)
		}
		Text(
			modifier = Modifier.padding(top = 5.dp),
			text = title,
			style = MaterialTheme.typography.bodySmall,
//			fontWeight = FontWeight.Medium
		)
	}
}

@Composable
private fun RowScope.MyNavigationBarItem(
	select: Boolean, onClick: () -> Unit, icon: ImageVector, title: String
) {
	NavigationBarItem(
		selected = select,
		onClick = onClick,
		icon = {
			Icon(
				imageVector = icon,
				contentDescription = title
			)
		},
		label = {
			Text(text = title)
		}
	)
}

@Preview
@Composable
private fun ProductListPrev() {
	ProductList()
}

@Preview
@Composable
private fun HomeScreenPrev() {
	HomeScreen()
}