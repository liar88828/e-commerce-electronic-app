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
import com.tutor.ecommerce_electronic.screen.navigation.Routes

data class FormResetPassword(
	var password: String = "",
	var confirmPassword: String = "",
	var isError: Boolean = false,
	var isErrorConfirmPassword: Boolean = false,
	var isErrorPassword: Boolean = false,
	var message: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewForgetPasswordScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {
	val form by remember { mutableStateOf(FormResetPassword()) }
	fun newPassword() {
		if (form.password.isNotEmpty() && form.confirmPassword.isNotEmpty()) {
			if (form.password == form.confirmPassword) {
				form.isError = false
				navController.navigate(Routes.Login)
			} else {
				form.isError = true
			}

		}
	}

	Scaffold(bottomBar = {
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
	}, topBar = {
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
				value = form.password,
				onValueChange = { form.password = it },
				label = { Text("Set New Password") },
				isError = form.isError,
				supportingText = {
					if (form.isError) {
						if (form.password.isEmpty()) {
							Text(text = "Password Required")
						} else {
							Text(text = "Password Not Match")
						}
					}
				})
			OutlinedTextField(modifier = modifier
				.fillMaxWidth()
				.padding(0.dp),
				value = form.confirmPassword,
				shape = MaterialTheme.shapes.large,
				onValueChange = { form.confirmPassword = it },
				label = { Text("Confirm Your New Password") },
				trailingIcon = {
					IconButton({}) {
						Icon(imageVector = Icons.Default.RemoveRedEye, contentDescription = "Eye")
					}
				},
				isError = form.isErrorConfirmPassword,
				supportingText = {
					if (form.isError) {
						if (form.confirmPassword.isEmpty()) {
							Text(text = "Confirm Password Required")
						} else {
							Text(text = "Password Not Match")
						}
					}
				})
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