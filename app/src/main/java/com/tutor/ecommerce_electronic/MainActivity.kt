package com.tutor.ecommerce_electronic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tutor.ecommerce_electronic.screen.navigation.NavigationScreen
import com.tutor.ecommerce_electronic.ui.theme.EcommerceelectronicTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			EcommerceelectronicTheme {
				NavigationScreen()
			}
		}
	}
}

