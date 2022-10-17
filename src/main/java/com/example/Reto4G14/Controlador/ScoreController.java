package com.example.Reto4G14.Controlador;


import org.springframework.http.HttpStatus;
import com.example.Reto4G14.Modelo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Reto4G14.Servicio.ScoreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/Score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @GetMapping(value="/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Score> getScore(@PathVariable("id") int scoreId){
        return scoreService.getScore(scoreId);
    }

    @PostMapping(value="/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p){
        return scoreService.save(p);
    }
    @PutMapping(value="/update")
    public Score update (@RequestBody Score score) {return scoreService.update(score);
    }
    @DeleteMapping(value="/{id}")
    public boolean delete (@PathVariable("id")int carId){ return scoreService.delete(carId);
    }
}
