package com.tutor.ecommerce_electronic.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.ecommerce_electronic.screen.component.button.MyButton
import com.tutor.ecommerce_electronic.screen.component.error.ErrorMsg
import com.tutor.ecommerce_electronic.screen.component.textfield.OTPInputField
import com.tutor.ecommerce_electronic.screen.navigation.Routes

data class FormOtp(
	var otp: MutableState<String> = mutableStateOf(""),
	val lenOtp: Int = 6,
	var isError: MutableState<Boolean> = mutableStateOf(false),
	var msgError: MutableState<String> = mutableStateOf("")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(
	navController: NavHostController, modifier: Modifier = Modifier
) {

	val form by remember { mutableStateOf(FormOtp()) }
	fun sendData(): Boolean = true
	fun sendOtp() {
		try {
			if (form.otp.value.length != form.lenOtp) {
				throw Exception("OTP Required")
			}
			// retrofit
			if (sendData()) {
				navController.navigate(Routes.NewForgetPassword)
			}
		} catch (e: Exception) {
			form.isError.value = true
			form.msgError.value = e.message.toString()

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
				otpLength = form.lenOtp,
				otpState = form.otp,
			)
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

			ErrorMsg(
				msgError = form.msgError, isError = form.isError
			)
		}
	}
}

@Preview
@Composable
private fun ForgetPasswordPrev() {
	OtpScreen(
		navController = NavHostController(LocalContext.current),
	)
}

