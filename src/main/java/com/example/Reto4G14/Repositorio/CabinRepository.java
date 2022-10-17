/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Repositorio;

import com.example.Reto4G14.Interface.CabinInterface;
import com.example.Reto4G14.Modelo.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

  @Repository

public class CabinRepository {
     @Autowired
    private CabinInterface extensionesCrud;
    
    public List<Cabin> getAll(){
        return (List<Cabin>) extensionesCrud.findAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return extensionesCrud.findById(id);
    }
    
    public Cabin save (Cabin cabin){
        return extensionesCrud.save(cabin);
    } 
    
    public void delete (Cabin cabin){
        extensionesCrud.delete(cabin);
    }


}


