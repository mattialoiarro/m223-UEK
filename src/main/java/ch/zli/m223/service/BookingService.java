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

    @Transactional
    public Booking getBooking(int id) {
        var entity = entityManager.find(Booking.class, id);
        return entity;

    }

    @Transactional
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    public List<Booking> getBookings() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    


}
