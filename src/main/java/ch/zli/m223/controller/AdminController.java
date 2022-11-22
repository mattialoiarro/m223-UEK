package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.AdminService;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.User;

@Path("/admin")
@Tag(name = "Admin",  description = "Annotations for Admin")
public class AdminController {

    @Inject
    AdminService adminService;

    //Gives every booking back
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "All bookings", description = "Gives every booking back to the admin")
    public List<Booking> index() {
        return adminService.getBookings();
    }

    //Create new user
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user.", description = "Creates a new user and returns it")
    public User create(User user) {
       return adminService.createUser(user);
    }

    //Delete booking
    @Path("/booking/{id}")
    @DELETE
    @Operation(summary = "Deletes one booking.", description = "Deletes one booking.")
    public void remove(@PathParam("id") int id) {
        adminService.deleteBooking(id);
    }

    //Delete user
    @Path("/user/{id}")
    @DELETE
    @Operation(summary = "Deletes one user.", description = "Deletes one user.")
    public void delete(@PathParam("id") int id) {
        adminService.deleteUser(id);
    }

    //User update
    @PUT
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates one user.", description = "Updates one user.")
    public User update(User user){
        return adminService.updateUser(user);
    }







    
}
