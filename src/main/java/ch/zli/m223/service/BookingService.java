package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    
    @Inject
    private EntityManager entityManager;

    //print 1 out
    @Transactional
    public Booking getBooking(int id) {
        var entity = entityManager.find(Booking.class, id);
        return entity;

    }

    //create one
    @Transactional
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    //All bookings
    public List<Booking> getBookings() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    //Delete one booking
    @Transactional
    public void deleteBooking(int id){
        var query = entityManager.find(Booking.class, id);
        entityManager.remove(query);
    }

    

    


}
