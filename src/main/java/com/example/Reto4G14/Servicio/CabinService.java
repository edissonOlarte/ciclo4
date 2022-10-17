/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Servicio;

import com.example.Reto4G14.Modelo.Cabin;

import com.example.Reto4G14.Repositorio.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CabinService {
    @Autowired
    private CabinRepository cabinRepository;
    
    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    
     public Cabin save(Cabin cabin){
        if ( cabin.getId()== null){
            return cabinRepository.save(cabin);
        }else{
            Optional<Cabin> room1 = cabinRepository.getCabin(cabin.getId());
            if(room1.isEmpty()){
                return cabinRepository.save(cabin);
            }else{
                return cabin;
            }
        }
    }
    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin>g= cabinRepository.getCabin(cabin.getId());
            if(!g.isEmpty()){
                if(cabin.getName()!=null){
                    g.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    g.get().setBrand(cabin.getBrand());
                }

                if(cabin.getRooms()!=null){
                    g.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    g.get().setDescription(cabin.getDescription());
                }
                if(cabin.getMessages()!=null){
                    g.get().setMessages(cabin.getMessages());
                }
                if(cabin.getReservations()!=null){
                    g.get().setReservations(cabin.getReservations());
                }

                return cabinRepository.save(g.get());
            }
        }
        return cabin;
    }

     
     
     
     public boolean deleteCabin(int id){
        Boolean d = getCabin(id).map( cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);
        return d;
    }
     
}
