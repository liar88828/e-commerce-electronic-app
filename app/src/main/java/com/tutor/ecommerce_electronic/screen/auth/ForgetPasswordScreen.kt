package com.tutor.ecommerce_electronic.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.RemoveRedEye
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.ecommerce_electronic.screen.navigation.Routes

data class FormPassword(
	var email: MutableState<String> = mutableStateOf(""),
	var isErrorEmail: MutableState<Boolean> = mutableStateOf(false),
	var isError: MutableState<Boolean> = mutableStateOf(false),
	var msgError: MutableState<String> = mutableStateOf(""),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgetPasswordScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {
	val form by remember { mutableStateOf(FormPassword()) }
	fun sendEmailOtp() {
		if (form.email.value.isNotEmpty()) {
			if (form.email.value.contains("@")) {
				navController.navigate(Routes.Otp)
			} else {
				form.msgError.value = "Email is Invalid. please add @"
			}
		} else {
			form.isErrorEmail.value = form.email.value.isNotEmpty()
			form.msgError.value = "Email is Required"
		}
	}

	Scaffold(bottomBar = {
		NavigationBar() {
			Button(
				{ sendEmailOtp() },
				modifier = modifier
					.fillMaxWidth()
					.height(50.dp)
					.padding(horizontal = 10.dp)
			) {
				Text(
					text = "Send OTP",
					style = MaterialTheme.typography.titleMedium,
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
		}, title = { Text("Forget Password") })
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
				text = "Enter a new password to update your password",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Light,
				textAlign = TextAlign.Center,
				modifier = modifier
					.padding(vertical = 10.dp)
					.width(250.dp)
			)

			MyTextField(icon = Icons.Default.RemoveRedEye,
				isError = form.isError.value,
				value = form.email.value,
				isChange = { form.email.value = it },
				label = " Send Email",
				msgError = {
					if (form.isError.value) {
						Text(text = "Email is  Required")
					}
				})

			Text(
				text = form.msgError.value,
				color = MaterialTheme.colorScheme.error,
				style = MaterialTheme.typography.titleSmall
			)
		}
	}
}

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

@Preview
@Composable
private fun ForgetPasswordPrev() {
	ForgetPasswordScreen(
		navController = NavHostController(LocalContext.current),
	)
}