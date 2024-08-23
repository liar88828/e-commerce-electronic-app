package com.tutor.ecommerce_electronic.screen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchField(
	search: MutableState<String>,
	modifier: Modifier = Modifier
) {
	CustomTextField(
		modifier = modifier
			.fillMaxWidth()
			.padding(0.dp)
			.height(40.dp)
			.clip(MaterialTheme.shapes.extraSmall)
			.border(
				1.dp,
				shape = MaterialTheme.shapes.extraSmall,
				color = Color.LightGray
			),
		colors = OutlinedTextFieldDefaults.colors(
			unfocusedBorderColor = Color.Transparent,
			focusedBorderColor = Color.Transparent,
			disabledBorderColor = Color.Transparent,
			errorBorderColor = Color.Transparent,
//			unfocusedContainerColor = Color.LightGray.copy(0.2f)
		),

		maxLines = 1,
		placeholder = { Text("Find you needed...") },
		value = search.value,
		onValueChange = { search.value = it },
		leadingIcon = { Icon(Icons.Default.Search, contentDescription = "SearchProduct") },
		trailingIcon = {
			Icon(Icons.Default.FilterList, contentDescription = "Filter")
		}
	)
}

@Preview(
	showBackground = true, showSystemUi = true
)
@Composable
private fun SearchFieldPrev() {
	SearchField(
		search = remember { mutableStateOf("") }
	)
}