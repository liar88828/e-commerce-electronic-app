package com.tutor.ecommerce_electronic.screen.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Badge
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tutor.ecommerce_electronic.R
import com.tutor.ecommerce_electronic.model.ProductData
import com.tutor.ecommerce_electronic.model.exampleProductData
import com.tutor.ecommerce_electronic.screen.component.text.ExpandableText
import com.tutor.ecommerce_electronic.screen.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
	product: ProductData, modifier: Modifier = Modifier, navController: NavHostController
) {

	val isLike = remember {

		mutableStateOf(false)
	}
	Scaffold(bottomBar = {
		BottomAppBar(
			modifier = Modifier.fillMaxWidth()
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 10.dp),
				horizontalArrangement = Arrangement.spacedBy(10.dp)
			) {
				OutlinedButton(
					{ navController.navigate(Routes.Cart) },
					modifier
						.weight(.5f)
						.height(50.dp),
					shape = MaterialTheme.shapes.small

				) {
					Icon(
						imageVector = Icons.Default.ShoppingBag, contentDescription = "ShoppingBag"
					)
					Spacer(Modifier.padding(4.dp))
					Text("Add to Cart")
				}
				Button(
					{ navController.navigate(Routes.CheckOut) },

					modifier
						.weight(.5f)
						.height(50.dp), shape = MaterialTheme.shapes.small
				) {

					Text("Checkout")
				}
			}
		}
	}, topBar = {
		CenterAlignedTopAppBar(actions = {
			IconButton({}) {
				Icon(
					imageVector = Icons.Default.Share, contentDescription = "Icon Share"
				)
			}
		}, navigationIcon = {
			IconButton({
				navController.navigateUp()
			}) {
				Icon(
					imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Icon Back"
				)
			}
		}, title = {
			Text(text = "Detail Product")
		})
	}) { innerPadding ->
		LazyColumn(
			modifier
				.padding(innerPadding)
				.padding(10.dp),
		) {
			item() { CarouselDetailProduct() }
			item() {
				Column(
					verticalArrangement = Arrangement.spacedBy(6.dp)

				) {
					Column(
						verticalArrangement = Arrangement.spacedBy(2.dp)
					) {
						Row(
							Modifier.fillMaxWidth(),
							horizontalArrangement = Arrangement.SpaceBetween,
//							verticalAlignment = Alignment.Bottom
							verticalAlignment = Alignment.CenterVertically
						) {
							Text(
								product.name,
								style = MaterialTheme.typography.titleLarge,
								maxLines = 2,
//					fontWeight = FontWeight.Medium
							)
							FilledIconToggleButton(
								onCheckedChange = { isLike.value = !isLike.value },
//								modifier = Modifier.size(40.dp),
								checked = isLike.value,
//								colors = IconButtonDefaults.filledIconToggleButtonColors(
//									containerColor = MaterialTheme.colorScheme.primary,
//									contentColor = MaterialTheme.colorScheme.onPrimary
//								)
							) {
								Icon(
									imageVector = Icons.Default.FavoriteBorder,
									contentDescription = "Icon Favorite",
								)
							}
						}

						Row(
							Modifier,
							horizontalArrangement = Arrangement.spacedBy(10.dp)
						) {
							Text(
								text = "$${product.price}",
								style = MaterialTheme.typography.titleLarge,
								fontWeight = FontWeight.Bold,
								maxLines = 1
							)

							Badge() {
								Text(
									text = "${product.discount}% off",
									style = MaterialTheme.typography.titleSmall
								)
							}

						}
						Text(
							text = "$${product.sold}",
							style = MaterialTheme.typography.titleMedium,
							fontWeight = FontWeight.Light,
							maxLines = 1,
							textDecoration = TextDecoration.LineThrough,
						)
					}

					Column(
						verticalArrangement = Arrangement.spacedBy(6.dp)
					) {
						Text(
							"Description Product",
							style = MaterialTheme.typography.titleMedium,
							fontWeight = FontWeight.SemiBold
						)

						ExpandableText(
							text = product.description,
						)
//						Text(
//							"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et",
//							style = MaterialTheme.typography.bodyMedium,
//							fontWeight = FontWeight.Light,
//							maxLines = 3,
//							overflow = TextOverflow.Ellipsis,
//							textAlign = TextAlign.Justify
//						)
					}

					Column(
						verticalArrangement = Arrangement.spacedBy(6.dp)
					) {
						Text(
							"Type",
							style = MaterialTheme.typography.titleMedium,
							fontWeight = FontWeight.SemiBold
						)
						Row(modifier.fillMaxWidth()) {
							ColorPicker(
								product.color,
								modifier.weight(.5f),
							)
							SpecPicker(
								product.addSpec, modifier.weight(.5f)
							)
						}
					}
				}
			}
		}
	}
}

@Composable
private fun SpecPicker(
	spec: List<String>, modifier: Modifier = Modifier
) {
	val selectSpec = remember { mutableStateOf(spec[0]) }
	Column(modifier) {
		Row {
			Text(
				"Colors : ",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Light
			)
			Text(
				selectSpec.value,
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Bold
			)
		}
		LazyRow(
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			items(spec) {
				InputChip(onClick = {
					selectSpec.value = it
				}, selected = true, label = {
					Text(text = it)
				})
			}
		}
	}
}

@Composable
private fun ColorPicker(
	itemColor: List<String>, modifier: Modifier = Modifier
) {
	val selectSpec = remember { mutableStateOf(itemColor[0]) }

	Column(modifier) {
		Row {
			Text(
				"Colors : ",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Light
			)
			Text(
				selectSpec.value,
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Bold
			)
		}
		LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
			items(itemColor) {
				FilledIconButton(
					onClick = { selectSpec.value = it },
//				modifier = modifier
//					.size(35.dp)
//					.border(
//					color = MaterialTheme.colorScheme.primary,
//					shape = CircleShape,
//					width = 2.dp
//				),
					colors = IconButtonDefaults.filledIconButtonColors(
						containerColor = Color.LightGray, contentColor = Color.Yellow
					)
				) {
					Box(
						modifier = Modifier
							.size(30.dp)
							.clip(CircleShape)
							.background(color = Color.Red.copy(.5f))
					) {}
//					Icon(
//						imageVector = Icons.Default.Check, contentDescription = "icon check"
//					)
				}
			}

		}

	}
}

@Composable
private fun CarouselDetailProduct(modifier: Modifier = Modifier) {
	val pagerState = rememberPagerState(pageCount = { 3 })
	HorizontalPager(
		state = pagerState,
//		modifier=Modifier.padding(top=10.dp)
	) { page ->
		Image(
			painter = painterResource(R.drawable.ic_launcher_foreground),
			contentDescription = "Image Product ${page}",
			modifier = modifier
				.fillMaxWidth()
				.height(330.dp),
//			contentScale = ContentScale.Crop
		)
	}

	IndicatorPager(
		total = pagerState.pageCount, current = pagerState.currentPage
	)
}

@Composable
private fun IndicatorPager(total: Int, current: Int) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 10.dp), contentAlignment = Alignment.Center
	) {

		Row(
			horizontalArrangement = Arrangement.spacedBy(10.dp)
//		modifier = Modifier.fillMaxWidth()
		) {
			repeat(total) {
				Box(
					Modifier
						.size(height = 5.dp, width = 20.dp)
//					.align(Alignment.Center)
						.border(
							shape = CircleShape, width = 4.dp,
//						color = MaterialTheme.colorScheme.primary
							color = if (current == it) MaterialTheme.colorScheme.primary
							else Color.LightGray.copy(.5f)
						)
						.padding(horizontal = 3.dp)
				)
			}
		}
		Box(Modifier.align(Alignment.BottomEnd)) {
			Badge(
			) {
				Text(
					text = "${current + 1}/${total + 1}"
				)
			}
		}
	}
}

@Preview
@Composable
private fun DetailScreenPrev() {
	val navController = rememberNavController()
	DetailScreen(
		navController = navController, product = exampleProductData
	)
}

