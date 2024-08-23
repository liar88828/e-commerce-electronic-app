package com.tutor.ecommerce_electronic.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.CurrencyBitcoin
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.ui.graphics.vector.ImageVector

data class PaymentData(
	val type: String,
	val desc: String,
	val icon: ImageVector
)

val examplePaymentData = PaymentData(
	type = "Cash",
	desc = "Pay cash when the product arrive at the destination",
	icon = Icons.Default.AttachMoney
)

val examplePaymentDataTransfer = PaymentData(
	type = "Bank Transfer",
	desc = "Log in to your bank account and transfer the payment",
	icon = Icons.Default.AccountBalance
)

val examplePaymentDataBitCoin = PaymentData(
	type = "Bit Coin",
	desc = "Pay using Bitcoin cryptocurrency",
	icon = Icons.Default.CurrencyBitcoin
)

val examplePaymentDataWallet = PaymentData(
	type = "Digital Wallet",
	desc = "Use your digital wallet to complete the payment",
	icon = Icons.Default.Wallet
)

val examplePaymentDataCreditCard = PaymentData(
	type = "Credit Card",
	desc = "Pay securely using your credit card",
	icon = Icons.Default.CreditCard
)

val examplePaymentDataPayPal = PaymentData(
	type = "PayPal",
	desc = "Log in to your PayPal account to complete the payment",
	icon = Icons.Default.Payment
)
val examplePaymentDataList = listOf(
	examplePaymentData,
	examplePaymentDataTransfer,
	examplePaymentDataBitCoin,
	examplePaymentDataWallet,
	examplePaymentDataCreditCard,
	examplePaymentDataPayPal

)