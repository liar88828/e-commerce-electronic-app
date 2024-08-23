package com.tutor.ecommerce_electronic.model

data class TrackingItemData(
	val status: String, val date: String, val time: String, val desc: String
)

val trackingItem1 = TrackingItemData(
	status = "Being Packaged",
	date = "5 June",
	time = "12:14",
	desc = "The order is being packaged and prepared for shipment."
)

val trackingItem2 = TrackingItemData(
	status = "Orders In Delivery",
	date = "5 June",
	time = "15:14",
	desc = "The order is being shipped to the transit location."
)

val trackingItem3 = TrackingItemData(
	status = "In Transit",
	date = "6 June",
	time = "09:30",
	desc = "The order is on its way to the final destination."
)

val trackingItem4 = TrackingItemData(
	status = "Delivered",
	date = "7 June",
	time = "11:45",
	desc = "The order has been delivered to the specified address."
)

val trackingItemList = listOf(
	trackingItem1, trackingItem2, trackingItem3, trackingItem4
)
