package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.User;

@ApplicationScoped
public class AdminService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public void deleteBooking(int id){
        var query = entityManager.find(Booking.class, id);
        entityManager.remove(query);
    }

    
     public List<Booking> getBookings() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    //-----USERS-----\\

    //Users updaten
    @Transactional
    public User updateUser(User user){
        return entityManager.merge(user);
    }

    //Users delete
    @Transactional
    public void deleteUser(int id){
        var entity = entityManager.find(User.class, id);
        entityManager.remove(entity);
    }
    
    @Transactional
    public User createUser(User user){
        entityManager.persist(user);
        return user;

    }
}
