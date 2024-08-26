package com.tutor.ecommerce_electronic.screen.component.button

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(
	onClick: () -> Unit = {},
	title: String,
	icon: ImageVector? = null,
	modifier: Modifier = Modifier,
) {

	Button(
		{ onClick() }, modifier = myButtonMod
//			.padding(horizontal = 10.dp)
	) {
		if (icon != null) {
			Icon(imageVector = icon, contentDescription = title)
			Spacer(modifier.width(4.dp))
		}
		Text(
			text = title,
			style = MaterialTheme.typography.titleMedium,
		)
	}
}

val myButtonMod = Modifier
	.fillMaxWidth()
	.height(50.dp)