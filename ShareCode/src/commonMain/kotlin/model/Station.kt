package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Station(
    val results: Results
)

@Serializable
data class Results(
    @SerialName("api_version") val api_version: String,
    @SerialName("results_available") val results_available: Int,
    @SerialName("results_returned") val results_returned: Int,
    @SerialName("results_start") val results_start: Int,
    @SerialName("station") val station: List<StationX>
)

@Serializable
data class StationX(
    @SerialName("along") val along: Along,
    @SerialName("city") val city: City,
    @SerialName("code") val code: String,
    @SerialName("facility_cd") val facility_cd: String,
    @SerialName("name") val name: String,
    @SerialName("prefecture") val prefecture: Prefecture
)

@Serializable
data class Along(
    @SerialName("along_type") val along_type: AlongType,
    @SerialName("code") val code: String,
    @SerialName("name") val name: String
)

@Serializable
data class AlongType(
    @SerialName("code") val code: String,
    @SerialName("name") val name: String
)

@Serializable
data class City(
    @SerialName("code") val code: String,
    @SerialName("name") val name: String
)

@Serializable
data class Prefecture(
    @SerialName("code") val code: String,
    @SerialName("name") val name: String
)