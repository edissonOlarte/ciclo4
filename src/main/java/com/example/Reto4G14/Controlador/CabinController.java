/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Controlador;

import com.example.Reto4G14.Modelo.Cabin;
import com.example.Reto4G14.Servicio.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author MG1323
 */
@RestController
@RequestMapping("/api/Cabin")

public class CabinController {
     @Autowired
    private CabinService cabinService;
    @GetMapping("/all")
    public List<Cabin> getAll(){
        return cabinService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cabin> getRoom(@PathVariable("id") int id){
        return cabinService.getCabin(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin){
        return cabinService.save(cabin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return cabinService.update(cabin);
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cabinId){
        return cabinService.deleteCabin(cabinId);
    }

    
}
