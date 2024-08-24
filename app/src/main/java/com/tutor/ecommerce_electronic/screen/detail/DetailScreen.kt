package com.tutor.ecommerce_electronic.screen.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.ecommerce_electronic.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
	Scaffold(
		bottomBar = {
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
						{},
						modifier
							.weight(.5f)
							.height(50.dp),
						shape = MaterialTheme.shapes.small

					) {
						Icon(
							imageVector = Icons.Default.ShoppingBag,
							contentDescription = "ShoppingBag"
						)
						Spacer(Modifier.padding(4.dp))
						Text("Add to Cart")
					}
					Button(
						{},

						modifier
							.weight(.5f)
							.height(50.dp),
						shape = MaterialTheme.shapes.small
					) {

						Text("Checkout")
					}
				}
			}
		},
		topBar = {
			CenterAlignedTopAppBar(actions = {
				IconButton({}) {
					Icon(
						imageVector = Icons.Default.Share, contentDescription = "Icon Share"
					)
				}
			}, navigationIcon = {
				IconButton({}) {
					Icon(
						imageVector = Icons.Default.ArrowBackIosNew,
						contentDescription = "Icon Back"
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
					verticalArrangement = Arrangement.spacedBy(10.dp)

				) {

					Row(
						Modifier.fillMaxWidth(),
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically
					) {
						Text(
							"Ipad Pro 8 Generation 11 Inch 2022",
							style = MaterialTheme.typography.titleMedium,
							maxLines = 2,
//					fontWeight = FontWeight.Medium
						)
						FilledIconToggleButton(
							onCheckedChange = {},
							checked = true
						) {
							Icon(
								imageVector = Icons.Default.FavoriteBorder,
								contentDescription = "Icon Favorite"
							)
						}
					}
					Column() {

						Row(
							Modifier, horizontalArrangement = Arrangement.spacedBy(10.dp)
						) {
							Text(
								text = "$${1242.00}",
								style = MaterialTheme.typography.titleLarge,
								fontWeight = FontWeight.Bold,
								maxLines = 1
							)

							Badge() {
								Text(
									text = "6% off",
									style = MaterialTheme.typography.titleSmall
								)
							}

						}
						Text(
							text = "$${1242.00}",
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
							"proin sociosqu lacinia interesset mattis vocibus intellegebat atomorum conclusionemque taciti dolores legere vix scripta primis maluisset omnesque sadipscing porttitor faucibus definitiones augue conubia praesent accusata vituperatoribus delenit massa libero movet oporteat suas dicunt saperet in ferri maiorum odio option ancillae",
							3
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
							ColorPicker(modifier.weight(.5f))
							SpecPicker(modifier.weight(.5f))
						}
					}
				}
			}
		}
	}
}

@Composable
private fun SpecPicker(modifier: Modifier = Modifier) {
	Column(modifier) {
		Row {
			Text(
				"Colors : ",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Light
			)
			Text(
				"Wi-fi",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Bold
			)
		}
		Row(
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {

			InputChip(
				onClick = {},
				selected = true,
				label = {
					Text(
						text = "Wi-fi"
					)
				}
			)

			InputChip(
				onClick = {},
				selected = false,
				label = {
					Text(
						text = "Wi-fi + Celullar"
					)
				}, modifier = Modifier.clickable { })
		}

	}
}

@Composable
private fun ColorPicker(modifier: Modifier = Modifier) {
	Column(
		modifier

	) {
		Row {
			Text(
				"Colors : ",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Light
			)
			Text(
				"Space Gray",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Bold
			)
		}
		Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
			FilledIconButton(
				onClick = {},
			) {
				Box(
					modifier
//						.background(color = Color.LightGray)

						.border(
							color = Color.Red,
							width = 2.dp,
							shape = CircleShape
						)

				)
			}

			FilledIconButton(
				onClick = {},
			) {
				Box(modifier.background(color = Color.Gray))
			}
		}

	}
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
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
			.padding(vertical = 10.dp),
		contentAlignment = Alignment.Center
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
							shape = CircleShape,
							width = 4.dp,
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

@Composable
fun ExpandableText(desc: String, maxLines: Int = 3) {
	var expanded by remember { mutableStateOf(false) }

	val annotatedString = buildAnnotatedString {
		if (expanded) {
			append(desc)
			pushStringAnnotation(tag = "collapse", annotation = "collapse")
			withStyle(
				style = SpanStyle(
					color = Color.Blue,
					textDecoration = TextDecoration.Underline
				)
			) {
				append(" Less text")
			}
			pop()
		} else {
			val textToShow = desc.take(100) // Example length before expansion
			append(textToShow)
			pushStringAnnotation(tag = "expand", annotation = "expand")
			withStyle(
				style = SpanStyle(
					color = Color.Blue,
					textDecoration = TextDecoration.Underline
				)
			) {
				append("... Read more")
			}
			pop()
		}
	}

	Column {
		ClickableText(
			text = annotatedString,
			maxLines = if (expanded) Int.MAX_VALUE else maxLines,
			overflow = TextOverflow.Ellipsis,
			onClick = { offset ->
				annotatedString.getStringAnnotations(offset, offset)
					.firstOrNull()
					?.let { annotation ->
						when (annotation.tag) {
							"expand" -> expanded = true
							"collapse" -> expanded = false
						}
					}
			}
		)
	}
}

//@Preview()
//@Composable
//private fun IndicatorPagerPrev() {
//	IndicatorPager(
//		4, 1
//	)
//}

@Preview
@Composable
private fun DetailScreenPrev() {
	DetailScreen()
}