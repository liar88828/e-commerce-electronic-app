package com.tutor.ecommerce_electronic.model

data class ProductData(
	val id: Int,
	val name: String,
	val price: Double,
	val description: String,
	val rating: Double,
	val sold: Int,
	val ram: String,
	val color: String,
	val memory: String
)

val exampleProductData = ProductData(
	id = 101,
	name = "Samsung Galaxy S21",
	price = 799.99,
	description = "Samsung Galaxy S21 with 6.2-inch display, Exynos 2100 processor, and triple-camera setup.",
	rating = 4.5,
	sold = 12000,
	ram = "8GB",
	color = "Phantom Gray",
	memory = "128GB"
)