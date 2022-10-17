/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author MG1323
 */
@Entity
@Table(name ="cabin")
public class Cabin {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

    private String name;
    private String brand;
    private Integer rooms;
    private String description;
     
     
     @ManyToOne
     @JoinColumn(name = "categoryId")
     @JsonIgnoreProperties("cabins")
     private Category category;
     
     @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
     @JsonIgnoreProperties({"cabin","client"})
     private List<Message> messages;
     
     @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
     @JsonIgnoreProperties({"cabin","messages"})
     private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
