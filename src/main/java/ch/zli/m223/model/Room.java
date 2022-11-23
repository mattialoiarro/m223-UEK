package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {

    @OneToMany
    @JoinColumn(name = "Room_id")
    @JsonIgnore
    private Set<Booking> bookings;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int id;

    @Column(nullable = false)
    private double groesse;

    @Column(nullable = false)
    private int sitzplatz;

    @Column(nullable = false)
    private String officeart;

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public int getSitzplatz() {
        return sitzplatz;
    }

    public void setSitzplatz(int sitzplatz) {
        this.sitzplatz = sitzplatz;
    }

    public String getOfficeArt() {
        return officeart;
    }

    public void setOfficeArt(String officeart) {
        this.officeart = officeart;
    }

    
    
}
