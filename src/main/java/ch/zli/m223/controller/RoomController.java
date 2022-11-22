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

import ch.zli.m223.model.Room;
import ch.zli.m223.service.RoomService;

@Path("/room")
@Tag(name = "Rooms",  description = "Annotations for rooms")
public class RoomController {

    @Inject
     RoomService roomService;

    //Give back 1 room
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "One Room", description = "Gives back one room")
    public Room find(@PathParam("id") int id) {
        return roomService.getRoom(id);
    }

    //Create room
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new room.", description = "Creates a new room and returns it")
    public Room create(Room room) {
       return roomService.createRoom(room);
    }

    //Gives every room back
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "All rooms", description = "Gives every booking back")
    public List<Room> index() {
        return roomService.getRooms();
    }

    //Delete room
    @Path("/delete/{id}")
    @DELETE
    @Operation(summary = "Deletes one room.", description = "Deletes one room.")
    public void remove(@PathParam("id") int id) {
        roomService.deleteRoom(id);
    }
    
}
