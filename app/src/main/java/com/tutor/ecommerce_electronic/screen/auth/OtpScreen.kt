package com.tutor.ecommerce_electronic.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tutor.ecommerce_electronic.screen.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {
	var otpValue = remember { mutableStateOf("") }
	var otpLength = 6
	fun sendOtp() {
		if (otpValue.value.length == otpLength) {
			navController.navigate(Routes.NewForgetPassword)
		}
	}

	Scaffold(bottomBar = {
		NavigationBar() {
			Row(
				modifier.padding(horizontal = 10.dp)
			) {
				MyButton(
					{ sendOtp() }, "Send OTP",
				)
			}
		}
	}, topBar = {
		CenterAlignedTopAppBar(navigationIcon = {
			IconButton(onClick = { navController.navigateUp() }) {
				Icon(
					imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Back"
				)
			}
		}, title = { Text("OTP Code") })
	}) { innerPadding ->
		Column(
			modifier = modifier
				.padding(innerPadding)
				.padding(horizontal = 10.dp)
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(0.dp)
		) {
			Text(
				text = "We send the OTP code via email to your testUser1@gmail.com",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Light,
				textAlign = TextAlign.Center,
				modifier = modifier
					.padding(vertical = 10.dp)
					.width(250.dp)
			)
			OTPInputField(
				otpLength = otpLength,
				otpValue = otpValue.value,
				onValueChange = { newValue ->
					if (newValue.length <= otpLength) {
						otpValue.value = newValue

					}

				})
			Row(verticalAlignment = Alignment.CenterVertically) {

				Text(
					text = "Wait for 12:12",
					style = MaterialTheme.typography.titleMedium,
					fontWeight = FontWeight.Light,
					textAlign = TextAlign.Center,
				)
				TextButton(
					{},
					modifier = modifier
						.padding(0.dp)
						.width(100.dp),
//						.height(20.dp),
					contentPadding = PaddingValues(0.dp)
				) {
					Text(
						"Send Again",
						style = MaterialTheme.typography.titleMedium,
//						fontWeight = FontWeight.Light,
						textAlign = TextAlign.Center,
					)
				}
			}
		}
	}
}

@Composable
fun MyButton(
	onClick: () -> Unit = {},
	title: String,
	icon: ImageVector? = null,
	modifier: Modifier = Modifier,
) {

	Button(
		{ onClick() },
		modifier = myButtonMod
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

@Composable
fun OTPInputField(
	otpLength: Int, otpValue: String, onValueChange: (String) -> Unit
) {
	val focusManager = LocalFocusManager.current

	Row(
		modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
	) {
		repeat(otpLength) { index ->
			OTPDigitField(value = if (index < otpValue.length) otpValue[index].toString() else "",
				onValueChange = { newValue ->
					val newOTPValue = buildString {
						for (i in otpValue.indices) {
							append(if (i == index) newValue else otpValue[i])
						}
					}
					onValueChange(newOTPValue)
					if (index < otpLength - 1) {
						focusManager.moveFocus(FocusDirection.Next)
					}
				})
		}
	}
}

@Composable
fun OTPDigitField(
	value: String, onValueChange: (String) -> Unit
) {
	OutlinedTextField(
		value = value,
		onValueChange = onValueChange,
		modifier = Modifier
			.width(48.dp)
			.height(64.dp),
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
		textStyle = TextStyle(
			fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
		),
		singleLine = true,
		maxLines = 1,
//		colors = TextFieldDefaults.colors(
////			containerColor  = Color.White,
////			cursorColor = Color.Black,
////			focusedIndicatorColor = Color.Transparent,
////			unfocusedIndicatorColor = Color.Transparent
//		)
	)
}

@Preview
@Composable
private fun ForgetPasswordPrev() {
	OtpScreen(
		navController = NavHostController(LocalContext.current),

		)
}

val myButtonMod = Modifier
	.fillMaxWidth()
	.height(50.dp)