/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Repositorio;

import com.example.Reto4G14.Interface.ClientInterface;
import com.example.Reto4G14.Modelo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author MG1323
 */
@Repository

public class ClientRepository {
     @Autowired
    private ClientInterface extensionesCrud;

    public List<Client> getAll(){
        return (List<Client>) extensionesCrud.findAll();
    }

    public Optional<Client> getClient(int id){
        return extensionesCrud.findById(id);
    }

    public Client save (Client client){
        return extensionesCrud.save(client);
    }

    public void delete(Client client){
        extensionesCrud.delete(client);
    }
    
}
    


