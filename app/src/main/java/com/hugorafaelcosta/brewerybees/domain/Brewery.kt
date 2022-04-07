package com.hugorafaelcosta.brewerybees.domain

import com.google.gson.annotations.SerializedName

data class Brewery(
    val id: String? = null,
    val name: String? = null,
    val address2: String? = null,
    val address3: String? = null,
    val average: Double? = null,
    val breweryType: String? = null,
    val city: String? = null,
    val country: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val phone: String? = null,
    val postalCode: String? = null,
    val sizeEvaluations: Int? = null,
    val state: String? = null,
    val street: String? = null,
    val websiteUrl: String? = null,
    val photos: List<String>? = null,
)