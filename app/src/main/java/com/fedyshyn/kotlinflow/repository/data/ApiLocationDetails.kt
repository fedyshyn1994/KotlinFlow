package com.fedyshyn.kotlinflow.repository.data

import com.google.gson.annotations.SerializedName

data class ApiLocation(
    @SerializedName("title") val title: String,
    @SerializedName("location_type") val locationType: String,
    @SerializedName("woeid") val id: Int,
    @SerializedName("latt_long") val latitudeLongitude: String
)

data class ApiLocationDetails(
    @SerializedName("consolidated_weather") val forecasts: List<ApiForecast>,
    @SerializedName("time") val time: String,
    @SerializedName("sun_rise") val sunrise: String,
    @SerializedName("sun_set") val sunset: String,
    @SerializedName("title") val title: String,
    @SerializedName("woeid") val id: Int
)

data class ApiForecast(
    @SerializedName("id") val id: Long,
    @SerializedName("weather_state_name") val weatherState: String,
    @SerializedName("weather_state_abbr") val weatherStateAbbreviation: String,
    @SerializedName("wind_direction_compass") val windDirection: String,
    @SerializedName("applicable_date") val date: String,
    @SerializedName("min_temp") val minTemp: Double,
    @SerializedName("max_temp") val maxTemp: Double,
    @SerializedName("the_temp") val temp: Double,
    @SerializedName("wind_speed") val windSpeed: Double,
    @SerializedName("air_pressure") val airPressure: Double,
    @SerializedName("humidity") val humidity: Double,
    @SerializedName("visibility") val visibility: Double,
    @SerializedName("predictability") val predictability: Int
)