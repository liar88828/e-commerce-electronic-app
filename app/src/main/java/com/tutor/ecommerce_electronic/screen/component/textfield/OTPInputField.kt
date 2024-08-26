package com.tutor.ecommerce_electronic.screen.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OTPInputField(
	otpLength: Int, otpState: MutableState<String>
) {
//	var otp = remember {
//		mutableStateOf("")
//	}

	BasicTextField(
		value = otpState.value,
		onValueChange = {
			if (it.length <= otpLength) {
				otpState.value = it
			}
		},
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
		decorationBox = {
			Row(
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically
			) {
				repeat(otpLength) { index ->
					val char = when {
						index >= otpState.value.length -> ""
						else -> otpState.value[index].toString()
					}
					val isFocused = otpState.value.length == index

					Text(
						modifier = Modifier
							.size(50.dp)
							.border(
								width = if (isFocused) 2.dp else {
									1.dp
								},
								shape = MaterialTheme.shapes.medium,
								color = if (isFocused) Color.DarkGray else Color.LightGray,
							)
							.padding(10.dp),
						text = char,
						style = MaterialTheme.typography.titleLarge,
						textAlign = TextAlign.Center,
						maxLines = 1,
						color = Color.DarkGray
					)
					Spacer(modifier = Modifier.width(8.dp))
				}
			}
		})
}