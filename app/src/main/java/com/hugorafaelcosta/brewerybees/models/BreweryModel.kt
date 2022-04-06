package com.hugorafaelcosta.brewerybees.database.models

import com.google.gson.annotations.SerializedName

data class BreweryModel(
    val id: String? = null,
    val name: String? = null,
    val address2: String? = null,
    val address3: String? = null,
    val average: Double? = null,
    @SerializedName("brewery_type")
    val breweryType: String? = null,
    val city: String? = null,
    val country: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val phone: String? = null,
    @SerializedName("postal_code")
    val postalCode: String? = null,
    @SerializedName("size_evaluations")
    val sizeEvaluations: Int? = null,
    val state: String? = null,
    val street: String? = null,
    @SerializedName("website_url")
    val websiteUrl: String? = null,
    val photos: List<String>? = null,
)

