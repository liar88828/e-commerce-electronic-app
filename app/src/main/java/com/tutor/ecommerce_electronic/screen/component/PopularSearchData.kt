package com.tutor.ecommerce_electronic.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Watch
import androidx.compose.ui.graphics.vector.ImageVector

data class PopularSearchData(val icon: ImageVector, val title: String)

val examplePopularDataList = listOf(
	PopularSearchData(Icons.Default.Watch, "Fossil Watch"),
	PopularSearchData(Icons.Default.PhoneAndroid, "Phone"),
	PopularSearchData(Icons.Default.Chair, "Chair"),
	PopularSearchData(Icons.Default.Computer, "Computer")
)
