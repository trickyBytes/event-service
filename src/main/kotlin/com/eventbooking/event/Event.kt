package com.eventbooking.event

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.PanacheMongoEntityBase
import io.quarkus.mongodb.panache.PanacheMongoRepository
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty
import java.time.LocalDateTime
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EventRepository : PanacheMongoRepository<Event>

@MongoEntity(collection = "event")
data class Event @BsonCreator constructor(
    @BsonProperty("title") val title: String,
    @BsonProperty("date") val date: LocalDateTime,
    @BsonProperty("maxSeats") var maxSeats: Int = 32,
    @BsonProperty("maxWheelChairs") var maxWheelChairs: Int = 2,
    @BsonProperty("bookings") val bookings: MutableSet<Booking>,
    @BsonProperty("description") var description: String = ""
) : PanacheMongoEntityBase()

data class Booking @BsonCreator constructor(
    @BsonProperty("customer") val customerReference: UUID,
    @BsonProperty("seatsRequired") val seatsRequired: Int = 0,
    @BsonProperty("wheelChairsRequired") val wheelChairsRequired: Int = 0
) : PanacheMongoEntityBase()