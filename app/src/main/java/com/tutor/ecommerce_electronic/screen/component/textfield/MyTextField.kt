package com.tutor.ecommerce_electronic.screen.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(
	icon: ImageVector? = null,
	isError: Boolean,
	value: String,
	isChange: (String) -> Unit,
	label: String,
	keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
	visualTransformation: VisualTransformation = VisualTransformation.None,
	msgError: @Composable (() -> Unit)? = null,
	modifier: Modifier = Modifier,
) {
	OutlinedTextField(
		modifier = modifier
			.fillMaxWidth()
			.padding(0.dp),
		trailingIcon = {
			if (icon != null) {
				IconButton({}) {
					Icon(imageVector = icon, contentDescription = label)
				}
			}
		},
		shape = MaterialTheme.shapes.large,
		value = value,
		onValueChange = isChange,
		label = { Text(label) },
		isError = isError,
		visualTransformation = visualTransformation,
		keyboardOptions = keyboardOptions,
		supportingText = msgError
	)
}