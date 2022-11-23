package ch.zli.m223.controller;



import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "Bookings",  description = "Annotations for bookings")
public class BookingController {
    
    @Inject
    BookingService bookingService;

    //Give back 1 booking
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "One Booking", description = "Gives back one booking")
    public Booking find(@PathParam("id") int id) {
        return bookingService.getBooking(id);
    }

    //Create bookings
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new booking and returns it")
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }

    //Gives every booking back
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "All bookings", description = "Gives every booking back")
    public List<Booking> index() {
        return bookingService.getBookings();
    }

    //Delete Booking
    @Path("/delete/{id}")
    @DELETE
    @Operation(summary = "Deletes one booking.", description = "Deletes one booking.")
    public void delete(@PathParam("id") int id) {
        bookingService.deleteBooking(id);
    }







}
