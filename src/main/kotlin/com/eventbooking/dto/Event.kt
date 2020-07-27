package com.eventbooking.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

sealed class Event {
    data class Create(
        @JsonProperty
        val title: String,
        @JsonProperty
        val description: String?,
        @JsonProperty
        val ageRating: String,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty
        val dateAndTime: LocalDateTime,
        @JsonProperty
        val maxSeats: Int?,
        @JsonProperty
        val maxWheelChairs: Int?
    )

    data class Overview(
        @JsonProperty
        val title: String,
        @JsonProperty
        val ageRating: String,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty
        val dateAndTime: LocalDateTime
    )
}