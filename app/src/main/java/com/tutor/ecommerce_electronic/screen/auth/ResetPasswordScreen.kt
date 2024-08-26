package com.tutor.ecommerce_electronic.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.ecommerce_electronic.screen.component.error.ErrorMsg
import com.tutor.ecommerce_electronic.screen.navigation.Routes

data class FormResetPassword(
	var password: MutableState<String> = mutableStateOf(""),
	var isErrorPassword: MutableState<Boolean> = mutableStateOf(false),
	var confirmPassword: MutableState<String> = mutableStateOf(""),
	var isErrorConfirmPassword: MutableState<Boolean> = mutableStateOf(false),
	var msgError: MutableState<String> = mutableStateOf(""),
	var isError: MutableState<Boolean> = mutableStateOf(false),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewForgetPasswordScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {
	val form by remember { mutableStateOf(FormResetPassword()) }
	fun newPassword() {
		try {
			if (form.password.value.isEmpty() && form.confirmPassword.value.isEmpty()) {

				throw Exception("Please Fill All Field")
			}
			if (form.password.value != form.confirmPassword.value) {
				throw Exception("Password Not Match")
			}
			form.isErrorPassword.value = form.password.value.isEmpty()
			form.isErrorConfirmPassword.value = form.confirmPassword.value.isEmpty()
			navController.navigate(Routes.Login)
		} catch (e: Exception) {
			form.isError.value = false
			form.msgError.value = e.message.toString()
		}
	}

	Scaffold(
		bottomBar = {
			NavigationBar() {
				Button(
					{ newPassword() },
//				shape = MaterialTheme.shapes.,
					modifier = modifier
						.fillMaxWidth()
						.height(50.dp)
						.padding(horizontal = 10.dp)
				) {
					Text(
						text = "New Password",
						style = MaterialTheme.typography.titleMedium,
					)
				}
			}
		},
		topBar = {
			CenterAlignedTopAppBar(navigationIcon = {
				IconButton(onClick = { navController.navigateUp() }) {
					Icon(
						imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Back"
					)
				}
			}, title = { Text("Reset Password") })
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
			OutlinedTextField(modifier = modifier
				.fillMaxWidth()
				.padding(0.dp),
				trailingIcon = {
					IconButton({}) {
						Icon(imageVector = Icons.Default.RemoveRedEye, contentDescription = "Eye")
					}
				},
				shape = MaterialTheme.shapes.large,
				value = form.password.value,
				onValueChange = { form.password.value = it },
				label = { Text("Set New Password") },
				isError = form.isErrorPassword.value,
				supportingText = {
					if (form.isErrorPassword.value) {
						Text(text = "Password Required")
					}
				})
			OutlinedTextField(modifier = modifier
				.fillMaxWidth()
				.padding(0.dp),
				shape = MaterialTheme.shapes.large,
				value = form.confirmPassword.value,
				onValueChange = {
					form.confirmPassword.value = it
				},
				label = { Text("Confirm Your New Password") },
				trailingIcon = {
					IconButton({}) {
						Icon(imageVector = Icons.Default.RemoveRedEye, contentDescription = "Eye")
					}
				},
				isError = form.isErrorConfirmPassword.value,
				supportingText = {
					if (form.isErrorConfirmPassword.value) {
						Text(text = "Confirm Password Required")
					}
				})
			ErrorMsg(
				msgError = form.msgError,
				isError = form.isError
			)

		}
	}
}

@Preview
@Composable
private fun ForgetPasswordPrev() {
	NewForgetPasswordScreen(
		navController = NavHostController(LocalContext.current),

		)
}