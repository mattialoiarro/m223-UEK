package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Room;

@ApplicationScoped
public class RoomService {
    
    @Inject
    private EntityManager entityManager;

    //print 1 out
    @Transactional
    public Room getRoom(int id) {
        var entity = entityManager.find(Room.class, id);
        return entity;

    }

    //create one
    @Transactional
    public Room createRoom(Room room) {
        entityManager.persist(room);
        return room;
    }

    //All rooms
    public List<Room> getRooms() {
        var query = entityManager.createQuery("FROM Room", Room.class);
        return query.getResultList();
    }

    //Delete one room
    @Transactional
    public void deleteRoom(int id){
        var query = entityManager.find(Room.class, id);
        entityManager.remove(query);
    }
}
