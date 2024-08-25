package com.tutor.ecommerce_electronic.screen.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tutor.ecommerce_electronic.model.exampleProductData
import com.tutor.ecommerce_electronic.screen.auth.ForgetPasswordScreen
import com.tutor.ecommerce_electronic.screen.auth.LoginScreen
import com.tutor.ecommerce_electronic.screen.auth.NewForgetPasswordScreen
import com.tutor.ecommerce_electronic.screen.auth.OtpScreen
import com.tutor.ecommerce_electronic.screen.auth.RegisterScreen
import com.tutor.ecommerce_electronic.screen.cart.CartScreen
import com.tutor.ecommerce_electronic.screen.checkout.CheckOutScreen
import com.tutor.ecommerce_electronic.screen.detail.DetailScreen
import com.tutor.ecommerce_electronic.screen.home.HomeScreen
import com.tutor.ecommerce_electronic.screen.search.SearchScreen
import com.tutor.ecommerce_electronic.screen.tracking.TrackingScreen
import kotlinx.serialization.Serializable

@Composable
fun NavigationScreen() {
	val navController = rememberNavController()
	NavHost(
		navController = navController, startDestination = Routes.Home
	) {
		composable<Routes.Home> { HomeScreen(navController = navController) }
		composable<Routes.Search> { SearchScreen(navController = navController) }
		composable<Routes.Detail> {
			DetailScreen(
				navController = navController, product = exampleProductData
			)
		}
		composable<Routes.Cart> { CartScreen(navController = navController) }
		composable<Routes.CheckOut> { CheckOutScreen(navController = navController) }
		composable<Routes.Tracking> { TrackingScreen(navController = navController) }
		composable<Routes.Login> { LoginScreen(navController = navController) }
		composable<Routes.Register> { RegisterScreen(navController = navController) }
		composable<Routes.ForgetPassword> { ForgetPasswordScreen(navController = navController) }
		composable<Routes.Otp> { OtpScreen(navController = navController) }
		composable<Routes.NewForgetPassword> { NewForgetPasswordScreen(navController = navController) }


		composable<Routes.Wishlist> {
			Button(onClick = {
				navController.navigateUp()
			}) { Text("White List") }
		}
		composable<Routes.Transaction> {
			Button(onClick = {
				navController.navigateUp()
			}) { Text("Transaction") }
		}
		composable<Routes.Profile> {
			Button(onClick = {
				navController.navigateUp()
			}) { Text("Profile") }
		}

	}
}

@Serializable
sealed class Routes {
	@Serializable
	data object Home : Routes()

	@Serializable
	data object Detail : Routes()

	@Serializable
	data object Search : Routes()

	@Serializable
	data object Cart : Routes()

	@Serializable
	data object Tracking : Routes()

	@Serializable
	data object CheckOut : Routes()

	@Serializable
	data object Wishlist : Routes()

	@Serializable
	data object Transaction : Routes()

	@Serializable
	data object Profile : Routes()

	@Serializable
	data object Register : Routes()

	@Serializable
	data object Login : Routes()

	@Serializable
	data object Otp : Routes()

	@Serializable
	data object ForgetPassword : Routes()

	@Serializable
	data object NewForgetPassword : Routes()

}