package model

import kotlinx.serialization.Serializable

@Serializable
data class Station(
    val results: Results
)

@Serializable
data class Results(
    val api_version: String,
    val results_available: Int,
    val results_returned: Int,
    val results_start: Int,
    val station: List<StationX>
)

@Serializable
data class StationX(
    val along: Along,
    val city: City,
    val code: String,
    val facility_cd: String,
    val name: String,
    val prefecture: Prefecture
)

@Serializable
data class Along(
    val along_type: AlongType,
    val code: String,
    val name: String
)

@Serializable
data class AlongType(
    val code: String,
    val name: String
)

@Serializable
data class City(
    val code: String,
    val name: String
)

@Serializable
data class Prefecture(
    val code: String,
    val name: String
)