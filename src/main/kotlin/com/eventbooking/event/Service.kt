package com.eventbooking.event

import com.eventbooking.dto.Event
import javax.enterprise.context.ApplicationScoped
import com.eventbooking.event.Event as EntityEvent

interface EventService {
    fun create(event: Event.Create)
    fun list(): List<Event.Overview>
}

@ApplicationScoped
class RepositoryBackedEventService(
    private val repository: EventRepository
) : EventService {
    override fun create(
        event: Event.Create
    ) = EntityEvent(
        title = event.title,
        date = event.dateAndTime,
        bookings = mutableSetOf(),
        ageRating = event.ageRating
    )
        .apply {
            event.description?.let { it -> description = it }
            event.maxSeats?.let { it -> maxSeats = it }
            event.maxWheelChairs?.let { it -> maxWheelChairs = it }
        }
        .run { repository.persist(this) }

    override fun list(): List<Event.Overview> =
        repository.listAll()
            .map { event ->
                Event.Overview(
                    title = event.title,
                    ageRating = event.ageRating,
                    dateAndTime = event.date
                )
            }
}