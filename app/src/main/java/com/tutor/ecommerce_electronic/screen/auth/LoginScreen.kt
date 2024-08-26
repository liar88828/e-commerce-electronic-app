package com.tutor.ecommerce_electronic.screen.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CloudQueue
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.ecommerce_electronic.screen.component.button.MyButton
import com.tutor.ecommerce_electronic.screen.component.error.ErrorMsg
import com.tutor.ecommerce_electronic.screen.component.textfield.MyTextField
import com.tutor.ecommerce_electronic.screen.navigation.Routes

data class FormLogin(
	var email: MutableState<String> = mutableStateOf(""),
	var isErrorEmail: MutableState<Boolean> = mutableStateOf(false),
	var password: MutableState<String> = mutableStateOf(""),
	var isErrorPassword: MutableState<Boolean> = mutableStateOf(false),
	var msgError: MutableState<String> = mutableStateOf(""),
	var isError: MutableState<Boolean> = mutableStateOf(false),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {
	val form by remember { mutableStateOf(FormLogin()) }
	fun login() {
		try {
			if (form.email.value.isEmpty() && form.password.value.isEmpty()) {
				throw Exception("Please Complete the Form")
			}
			if (form.password.value.length <= 8) {
				throw Exception("Password Must be 8 Character")
			}
			if (!form.email.value.contains("@")) {
				throw Exception("Email must be a @")
			}
			form.isErrorEmail.value = form.email.value.isEmpty()
			form.isErrorPassword.value = form.password.value.isEmpty()
			navController.navigate(Routes.Home)
		} catch (e: Exception) {
			form.isError.value = true
			form.msgError.value = e.message.toString()
		}
	}

	Scaffold(
		topBar = {
			CenterAlignedTopAppBar(title = { Text(text = "Login") }, navigationIcon = {
				IconButton({ navController.navigateUp() }) {
					Icon(
						imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Back"
					)
				}
			})
		},
		bottomBar = {},

		) { innerPadding ->

		Column(
			modifier
				.padding(innerPadding)
				.fillMaxWidth()
				.padding(horizontal = 10.dp),

			) {
//			Text("e ${form.isErrorPassword} p ${form.isErrorPassword}")
			Text(
				text = "Welcome Back",
				style = MaterialTheme.typography.headlineMedium,
				fontWeight = FontWeight.Bold
			)
			Text(
				text = "I am so Happy To See continue to login for management your account",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Light,
//				textAlign = TextAlign.Center,
				modifier = modifier.padding(vertical = 10.dp)
//					.width(250.dp)
			)
			MyTextField(isError = form.isErrorEmail.value,
				value = form.email.value,
				isChange = { form.email.value = it },
				label = "Email or Phone Number",
				msgError = {
					if (form.isErrorEmail.value) {
						Text(text = "Email is Required")
					}
				})
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


			Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
				TextButton(
					{ navController.navigate(Routes.ForgetPassword) },
					modifier = modifier
						.height(30.dp)
						.padding(bottom = 10.dp),
					contentPadding = PaddingValues(0.dp)
				) {
					Text(text = "Forgot my password?")
				}
			}
			Column(
				verticalArrangement = Arrangement.spacedBy(10.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				MyButton({ login() }, "Login")

				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier.padding(vertical = 10.dp)
				) {
					HorizontalDivider(modifier = modifier.weight(.5f))
					Text(
						text = "OR",
						modifier = modifier.padding(horizontal = 10.dp),
						style = MaterialTheme.typography.titleSmall
					)
					HorizontalDivider(modifier = modifier.weight(.5f))

				}
				MyButton({ login() }, "Sign up with Apple", icon = Icons.Default.AcUnit)
				MyButton({ login() }, "Sign up with Google", icon = Icons.Default.CloudQueue)
				Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
					Text(
						text = "Don't have an account?",
						style = MaterialTheme.typography.titleSmall,
					)
					Text(text = "Sign Up",
						style = MaterialTheme.typography.titleSmall,
						color = MaterialTheme.colorScheme.primary,
						modifier = Modifier.clickable {
							navController.navigate(Routes.Register)
						})
				}

			}
			ErrorMsg(
				msgError = form.msgError,
				isError = form.isError
			)

		}
	}
}

@Preview
@Composable
private fun LoginScreenPrev() {
	LoginScreen(
		navController = NavHostController(LocalContext.current),
	)
}