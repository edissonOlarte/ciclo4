/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Reto4G14.Servicio;

import com.example.Reto4G14.Modelo.Category;
import com.example.Reto4G14.Repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author MG1323
 */
@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    
    }
    
    public Optional<Category> getCategory (int id){
        return categoryRepository.getCategory (id);
    }

    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> e = categoryRepository.getCategory(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return categoryRepository.save(p);
            }
        }
    }
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }

                if(category.getCabins()!=null){
                    g.get().setCabins(category.getCabins());
                }
                return categoryRepository.save(g.get());
            }
        }
        return category;
    }


    public boolean deleteCategory(int id){
        Boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

}
    

