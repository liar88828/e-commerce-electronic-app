package com.tutor.ecommerce_electronic.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.ecommerce_electronic.screen.navigation.Routes

data class FormRegister(
	var email: MutableState<String> = mutableStateOf(""),
	var isErrorEmail: MutableState<Boolean> = mutableStateOf(false),
	var password: MutableState<String> = mutableStateOf(""),
	var isErrorPassword: MutableState<Boolean> = mutableStateOf(false),
	var confPass: MutableState<String> = mutableStateOf(""),
	var isErrorConfPass: MutableState<Boolean> = mutableStateOf(false),
	var name: MutableState<String> = mutableStateOf(""),
	var isErrorName: MutableState<Boolean> = mutableStateOf(false),
	var phone: MutableState<String> = mutableStateOf(""),
	var isErrorPhone: MutableState<Boolean> = mutableStateOf(false),
	var address: MutableState<String> = mutableStateOf(""),
	var isErrorAddress: MutableState<Boolean> = mutableStateOf(false),
	var msgError: MutableState<String> = mutableStateOf(""),
	var check: MutableState<Boolean> = mutableStateOf(false),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {
	val form by remember { mutableStateOf(FormRegister()) }

	fun onRegister() {
		if (
			form.name.value.isNotEmpty() &&
			form.phone.value.isNotEmpty() &&
			form.email.value.isNotEmpty() &&
			form.address.value.isNotEmpty() &&
			form.password.value.isNotEmpty() &&
			form.confPass.value.isNotEmpty()
		) {
			if (form.check.value) {
				if (form.password.value == form.confPass.value) {
					navController.navigate(Routes.Login)
				} else {
					form.msgError.value = "Password Not Match"
				}
			} else {
				form.msgError.value = "Please Accept Terms and Conditions"
			}
		} else {
			form.isErrorEmail.value = form.email.value.isEmpty()
			form.isErrorPassword.value = form.password.value.isEmpty()
			form.isErrorName.value = form.name.value.isEmpty()
			form.isErrorPhone.value = form.phone.value.isEmpty()
			form.isErrorAddress.value = form.address.value.isEmpty()
			form.isErrorConfPass.value = form.confPass.value.isEmpty()
			form.msgError.value = "Please Complete the Form"
		}

	}

	Scaffold(
		topBar = {
			CenterAlignedTopAppBar(title = { Text(text = "Set up your account") },
				navigationIcon = {
					IconButton({ navController.navigateUp() }) {
						Icon(
							imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Back"
						)
					}
				})
		},
		bottomBar = {
			NavigationBar(
//				windowInsets = WindowInsets(bottom = 10.dp)
				modifier = modifier.padding(bottom = 10.dp)
			) {
				Column {
					Row(
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.Center,
						modifier = modifier.fillMaxWidth()
					) {
						Checkbox(
							checked = form.check.value,
							onCheckedChange = { form.check.value = it })
						val termsPrivacy: AnnotatedString = buildAnnotatedString {
							append("I agree to the ")
							withStyle(SpanStyle(MaterialTheme.colorScheme.primary)) {
								append("Terms of Service ")
							}
							append("and ")
							withStyle(SpanStyle(MaterialTheme.colorScheme.primary)) {
								append("Privacy Policy")
							}
						}
						Text(
							text = termsPrivacy,
							style = MaterialTheme.typography.titleSmall,
						)
					}
					Button(
						{ onRegister() },
						modifier = modifier
							.fillMaxWidth()
							.height(50.dp)
							.padding(horizontal = 10.dp)
					) {
						Text(
							text = "Create Account",
							style = MaterialTheme.typography.titleMedium,
						)
					}
				}
			}
		},
	) { innerPadding ->
		Column(
			modifier
				.padding(innerPadding)
				.fillMaxSize()
				.padding(horizontal = 10.dp),
			horizontalAlignment = Alignment.CenterHorizontally,

			) {
//			Text(
//				text = "Create a New Account",
//				style = MaterialTheme.typography.headlineMedium,
//				fontWeight = FontWeight.Bold
//			)
			Text(
				text = "Create an account so you manage your account",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Light,
				textAlign = TextAlign.Center,
				modifier = modifier
//					.fillMaxWidth()
					.padding(vertical = 10.dp)
					.width(250.dp)
			)

			Text(
				text = form.msgError.value,
//				color = MaterialTheme.colorScheme.error,
//				style = MaterialTheme.typography.titleSmall
			)

			// name
			MyTextField(isError = form.isErrorName.value,
				value = form.name.value,
				isChange = { form.name.value = it },
				label = "Name",
				msgError = {
					if (form.isErrorName.value) {
						Text(text = "Name is Required")
					}
				})

			// phone
			MyTextField(isError = form.isErrorPhone.value,
				value = form.phone.value,
				isChange = { form.phone.value = it },
				label = "Phone",
				msgError = {
					if (form.isErrorPhone.value) {
						Text(text = "Phone is Required")
					}
				})

			// address
			MyTextField(isError = form.isErrorAddress.value,
				value = form.address.value,
				isChange = { form.address.value = it },
				label = "Address",
				msgError = {
					if (form.isErrorAddress.value) {
						Text(text = "Address is Required")
					}
				})

			// phone
			MyTextField(isError = form.isErrorEmail.value,
				value = form.email.value,
				isChange = { form.email.value = it },
				label = "Email",
				msgError = {
					if (form.isErrorEmail.value) {
						Text(text = "Email is Required")
					}
				})

			//password
			MyTextField(icon = Icons.Default.RemoveRedEye,
				isError = form.isErrorPassword.value,
				value = form.password.value,
				isChange = { form.password.value = it },
				label = "Password",
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
				PasswordVisualTransformation(),
				msgError = {
					if (form.isErrorPassword.value) {
						Text(text = "Password is Required")
					}
				})

			//conf password
			MyTextField(icon = Icons.Default.RemoveRedEye,
				isError = form.isErrorConfPass.value,
				value = form.confPass.value,
				isChange = { form.confPass.value = it },
				label = "Confirm Password",
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
				PasswordVisualTransformation(),
				msgError = {
					if (form.isErrorConfPass.value) {
						Text(text = "Confirm Password is Required")
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

@Preview
@Composable
private fun RegisterScreenPrev() {
	RegisterScreen(
		navController = NavHostController(LocalContext.current),
	)
}