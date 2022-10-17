/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Reto4G14.Interface;

import com.example.Reto4G14.Modelo.Cabin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author MG1323
 */
public interface CabinInterface extends CrudRepository <Cabin, Integer > {
    
}
