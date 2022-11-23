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

import ch.zli.m223.model.Equipment;
import ch.zli.m223.service.EquipmentService;

@Path("/equipment")
@Tag(name = "Equipments",  description = "Annotations for equipments")
public class EquipmentController {
 
    @Inject
    EquipmentService equipmentService;

    //Give back 1 booking
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "One equipment", description = "Gives back one equipment")
    public Equipment find(@PathParam("id") int id) {
        return equipmentService.getEquipment(id);
    }

    //Create bookings
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new equipment.", description = "Creates a new booking and returns it")
    public Equipment create(Equipment equipment) {
       return equipmentService.createEquipment(equipment);
    }

    //Gives every booking back
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "All equipments", description = "Gives every equipment back")
    public List<Equipment> index() {
        return equipmentService.getEquipments();
    }

    //Delete Booking
    @Path("/delete/{id}")
    @DELETE
    @Operation(summary = "Deletes one equipment.", description = "Deletes one equipment.")
    public void delete(@PathParam("id") int id) {
        equipmentService.deleteEquipment(id);
    }



}
