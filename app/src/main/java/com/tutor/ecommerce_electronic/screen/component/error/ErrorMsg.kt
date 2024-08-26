package com.tutor.ecommerce_electronic.screen.component.error

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorMsg(
	msgError: MutableState<String>,
	isError: MutableState<Boolean>,
	modifier: Modifier = Modifier
) {
	if (isError.value) {
		Text(
			modifier = modifier
				.padding(top = 10.dp)
				.fillMaxWidth(),
			text = msgError.value,
			color = MaterialTheme.colorScheme.error,
			style = MaterialTheme.typography.titleSmall,
			textAlign = TextAlign.Center
		)
	}
}