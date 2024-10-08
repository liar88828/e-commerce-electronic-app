package com.tutor.ecommerce_electronic.screen.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tutor.ecommerce_electronic.screen.component.PopularSearchData
import com.tutor.ecommerce_electronic.screen.component.ProductList
import com.tutor.ecommerce_electronic.screen.component.TitleCard
import com.tutor.ecommerce_electronic.screen.component.examplePopularDataList
import com.tutor.ecommerce_electronic.screen.component.textfield.SearchField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
	val search = remember {
		mutableStateOf("")

	}
	val scrollBehavior =
		TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = {

			TopAppBar(
				scrollBehavior = scrollBehavior,
				title = { SearchField(search = search) },
				navigationIcon = {
					IconButton({
						navController.navigateUp()
					}) {
						Icon(
							imageVector = Icons.Default.ArrowBackIosNew,
							contentDescription = "ArrowBack"
						)
					}

				})
		}) { innerPadding ->

		val visible by remember {
			derivedStateOf { scrollBehavior.state.overlappedFraction != 1f }
		}

		Column(
			modifier = Modifier
				.padding(innerPadding)
				.padding(horizontal = 10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
//			Text("${scrollBehavior.state.overlappedFraction}")
			AnimatedVisibility(visible = visible) {
				PopularSearch()
			}
			Recommended(navController)
		}
	}
}

@Composable
private fun Recommended(navController: NavHostController) {
	Card {
		Column(
			Modifier.padding(10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp),
		) {
			TitleCard(
				title = "Recommended for You",
				clickEnabled = false
			)
			ProductList(
				navController = navController,
//				stateScroll = rememberLazyStaggeredGridState()
			)
		}
	}
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun PopularSearch() {
	Card {
		Column(
			Modifier.padding(10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp),
		) {
			TitleCard(
				title = "Popular Search",
				clickEnabled = false
			)
			FlowRow(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalArrangement = Arrangement.spacedBy(10.dp),
				maxItemsInEachRow = 2,
			) {
				repeat(examplePopularDataList.size) {
					PopularSearchItem(examplePopularDataList[it]) {}
				}
			}

		}
	}
}

@Composable
private fun PopularSearchItem(item: PopularSearchData, click: () -> Unit) {
	ElevatedCard(
		onClick = click,
		modifier = Modifier
			.fillMaxWidth(.49f)
			.height(80.dp)
//			.size(
//				width = 170.dp,
//				height = 80.dp
//			)

	) {
		Row(
			modifier = Modifier
				.fillMaxSize()
				.padding(10.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center
		) {
			Icon(
				imageVector = item.icon,
				contentDescription = item.title,
				modifier = Modifier.size(30.dp)//.padding(10.dp)
			)
			Spacer(Modifier.size(10.dp))
			Text(
				text = item.title,
				style = MaterialTheme.typography.titleMedium
			)
		}
	}
}

@Preview
@Composable
private fun SearchScreenPrev() {
	val navController = rememberNavController()

	SearchScreen(navController)
}