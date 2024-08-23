package com.tutor.ecommerce_electronic.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TitleCard(
	textButton: String = "See all",
	title: String,
	click: () -> Unit = {},
	clickEnabled: Boolean = true,
	modifier: Modifier = Modifier,
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
//			.padding(10.dp)
		,
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Text(
			text = title,
			style = MaterialTheme.typography.titleMedium,
			fontWeight = FontWeight.Bold
		)
		if (clickEnabled) {
			TextButton(
				click,
				modifier
//					.padding(0.dp)
					.height(20.dp),
				contentPadding = PaddingValues(0.dp)
			) {
				Text(text = textButton)
			}
		}
	}
}

@Preview
@Composable
private fun TitleCardPrev() {
	TitleCard(
		title = "Example title",
		click = {},
		clickEnabled = true,
		textButton = "example click title"

	)
}