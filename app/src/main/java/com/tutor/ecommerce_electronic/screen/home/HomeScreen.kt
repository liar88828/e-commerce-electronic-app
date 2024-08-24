package com.tutor.ecommerce_electronic.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PrecisionManufacturing
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.twotone.Computer
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tutor.ecommerce_electronic.R
import com.tutor.ecommerce_electronic.screen.component.ProductList
import com.tutor.ecommerce_electronic.screen.component.textfield.SearchField
import com.tutor.ecommerce_electronic.screen.navigation.Routes

@OptIn(
	ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalFoundationApi::class
)
@Composable
fun HomeScreen(

	modifier: Modifier = Modifier, navController: NavHostController
) {
	val scrollBehavior =
		TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
	val scrollBehaviorBottom = BottomAppBarDefaults.exitAlwaysScrollBehavior()
	Scaffold(
		modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = {

			TopAppBar(scrollBehavior = scrollBehavior, title = {

				Text(text = "Ecommerce Electronic")
			}, actions = {
				OutlinedIconButton(
					{}, shape = MaterialTheme.shapes.medium
				) {
					BadgedBox(
						badge = { Badge() },
					) {
						Icon(Icons.Outlined.Notifications, contentDescription = "Notification")
					}
				}
				OutlinedIconButton(
					{}, shape = MaterialTheme.shapes.medium
				) {
					BadgedBox(
						badge = { Badge() },
					) {
						Icon(Icons.Outlined.ShoppingBag, contentDescription = "ShopBag")
					}
				}
			}, navigationIcon = {
				IconButton({}) {
					Icon(Icons.Default.Menu, contentDescription = "Menu")
				}
			})
		},
		bottomBar = {
			BottomAppBar(
				scrollBehavior = scrollBehaviorBottom
			) {

				MyNavigationBarItem(true, {
					navController.navigate(Routes.Home)
				}, Icons.Default.Home, "Home")
				MyNavigationBarItem(false, {
					navController.navigate(Routes.Wishlist)
				}, Icons.Default.FavoriteBorder, "Wishlist")
				MyNavigationBarItem(false, {
					navController.navigate(Routes.Transaction)
				}, Icons.Default.Description, "Transaction")
				MyNavigationBarItem(false, {
					navController.navigate(Routes.Profile)
				}, Icons.Default.Person, "Profile")
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
			val shouldHideBottomBar by remember {
				derivedStateOf {
					scrollBehavior.state.heightOffset <= -100f

				}
			}
//			Text("${scrollBehavior.state.heightOffset}")
			SearchField(search)

			AnimatedVisibility(
				visible = !shouldHideBottomBar,
//				enter = slideInVertically(animationSpec = tween(durationMillis = 200)),
//				exit = slideOutVertically(animationSpec = tween(durationMillis = 200)),
			) {
				Column(
					verticalArrangement = Arrangement.spacedBy(10.dp)

				) {

					Location()
					Category()
					Carousel(statePager)
				}
			}

			FlashSale(
				navController,
			)
		}
	}
}

@Composable
private fun FlashSale(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {

	Column(
		verticalArrangement = Arrangement.spacedBy(8.dp)
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
					style = MaterialTheme.typography.titleLarge,
					fontWeight = FontWeight.Bold
				)
				Text(
					text = "Ends In",
					style = MaterialTheme.typography.titleMedium,
				)
				Badge() {
					Text(text = "20:20:20")
				}
			}
			TextButton(
				{ navController.navigate(Routes.Search) },
				modifier
					.padding(0.dp)
					.height(20.dp),
				contentPadding = PaddingValues(0.dp)
			) {
				Text(
					text = "See all", modifier.padding(0.dp)
				)
			}
		}
		ProductList(
			navController = navController,
		)
	}
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun Carousel(
	statePager: PagerState
) {
	HorizontalPager(state = statePager) { page ->
		Card(
			modifier = Modifier.fillMaxWidth(),
		) {
			Row(
				modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
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
private fun Location() {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(4.dp)
	) {
		Icon(
			Icons.Default.LocationOn,
			contentDescription = "Location",
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
			{}, modifier = Modifier.size(50.dp)

		) {
			Icon(
				imageVector = icon, contentDescription = title, modifier = Modifier.size(25.dp)
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
	NavigationBarItem(selected = select, onClick = onClick, icon = {
		Icon(
			imageVector = icon, contentDescription = title
		)
	}, label = {
		Text(text = title)
	})
}

//@Preview
//@Composable
//private fun ProductListPrev() {
//	FlashSale()
//}

@Preview
@Composable
private fun HomeScreenPrev() {
	HomeScreen(navController = rememberNavController())
}