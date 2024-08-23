package com.tutor.ecommerce_electronic.model

data class UserData(
	val name: String,
	val address: String,
	val phone: String
)

val defaultUserData = UserData(
	name = "Tuan Taylor",
	address = "Kompl Sandang B-7 RT 001/011, Dki Jakarta",
	phone = "0-21-581-3755"
)