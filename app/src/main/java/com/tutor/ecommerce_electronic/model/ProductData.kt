package com.tutor.ecommerce_electronic.model

data class ProductData(
	val id: Int,
	val name: String,
	val price: Double,
	val description: String,
	val rating: Double,
	val sold: Int,
	val ram: String,
	val color: List<String>,
	val addSpec: List<String>,
	val memory: String,
	val discount: Int,
)

val exampleProductData = ProductData(
	id = 101,
	name = "Samsung Galaxy S21",
	price = 799.99,
	description = "Samsung Galaxy S21 with 6.2-inch display, Exynos 2100 processor, and triple-camera setup. pellentesque homero noluisse risus a habemus bibendum vero neque ac partiendo petentium autem sumo sem contentiones tota habitant dolore sodales animal euripidis interesset in conclusionemque turpis tincidunt disputationi arcu utamur aliquet mentitum tempus periculis dicam adolescens penatibus accommodare causae feugait",
	rating = 4.5,
	sold = 12000,
	ram = "8GB",
	color = listOf("Phantom Gray", "Red Doff"),
	memory = "128GB",
	discount = 5,
	addSpec = listOf(
		"Wi-fi",
		"Wi-fi & Cellular"
	)
)