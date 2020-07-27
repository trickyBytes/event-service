package com.eventbooking.event

import com.eventbooking.dto.Event
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/screening")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ScreeningResource(
    private val service: EventService
) {
    @POST
    fun create(request: Event.Create) = service.create(request)

    @GET
    fun list() = service.list()
}