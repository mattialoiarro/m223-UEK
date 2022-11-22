package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Equipment;

@ApplicationScoped

public class EquipmentService {

    @Inject
    private EntityManager entityManager;

    //create one
    @Transactional
    public Equipment createEquipment(Equipment equipment) {
        entityManager.persist(equipment);
        return equipment;
    }

    //Delete one equipment
    @Transactional
    public void deleteEquipment(int id){
        var query = entityManager.find(Equipment.class, id);
        entityManager.remove(query);
    }

    //print 1 out
    @Transactional
    public Equipment getEquipment(int id) {
        var entity = entityManager.find(Equipment.class, id);
        return entity;

    }

    //All Equipments
    public List<Equipment> getEquipments() {
        var query = entityManager.createQuery("FROM Booking", Equipment.class);
        return query.getResultList();
    }


    
}
