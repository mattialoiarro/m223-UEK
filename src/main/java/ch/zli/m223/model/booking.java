package ch.zli.m223.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Booking {

    @ManyToOne
    public User user;

    @ManyToMany
    @JoinTable(name = "booking_equipments", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    @JsonIgnoreProperties("bookings")
    @Fetch(FetchMode.JOIN)
    private Set<Equipment> equipments;

    @ManyToOne
    public Room rooms;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int id; 

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean ganzerTag;

    @Column(nullable = false)
    private Long buchungsnummer;

    @Column(nullable = true)
    private String text;

    @Column(nullable = false)
    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    public Room getRooms() {
        return rooms;
    }

    public void setRooms(Room rooms) {
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isGanzerTag() {
        return ganzerTag;
    }

    public void setGanzerTag(boolean ganzerTag) {
        this.ganzerTag = ganzerTag;
    }

    public Long getBuchungsnummer() {
        return buchungsnummer;
    }

    public void setBuchungsnummer(Long buchungsnummer) {
        this.buchungsnummer = buchungsnummer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
