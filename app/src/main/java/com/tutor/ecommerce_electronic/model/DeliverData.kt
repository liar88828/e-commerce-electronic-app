package com.tutor.ecommerce_electronic.model

data class DeliverData(
	val name: String,
	val time: String,
	val price: Double
)

val defaultDeliverData = DeliverData(
	name = "JNE",
	time = "2-3 Days",
	price = 10.0
)