/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Servicio;

import com.example.Reto4G14.Modelo.Reservation;
import com.example.Reto4G14.Repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation){
        if ( reservation.getIdReservation()== null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
            if(reservation1.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }  
    public Reservation update(Reservation reservation){

            if(reservation.getIdReservation()== null){
                Optional<Reservation> cab= reservationRepository.getReservation(reservation.getIdReservation());
                if(cab.isPresent()){
                    reservationRepository.save(reservation);
                }
            }
            return reservation;

    }

    public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }

  }
 

