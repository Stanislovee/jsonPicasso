package com.example.testspacex

class Model (private val image: String, private val ship_id: String, private val ship_name: String, private val year_built: Int) {

    fun getImageUrl(): String {
        return image
    }

    fun getShipId(): String {
        return ship_id
    }

    fun getShipName(): String {
        return ship_name
    }

    fun getYearBuilt(): Int {
        return year_built
    }
}