/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Repositorio;

import com.example.Reto4G14.Interface.ReservationInterface;
import com.example.Reto4G14.Modelo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


    
@Repository

public class ReservationRepository {
      @Autowired
    private ReservationInterface extensionesCrud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) extensionesCrud.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return extensionesCrud.findById(id);
    }
    
    public Reservation save (Reservation reservation){
        return extensionesCrud.save(reservation);
    } 
    
    public void delete(Reservation reservation){
        extensionesCrud.delete(reservation);
    }

}

