package com.example.Reto4G14.Repositorio;

import com.example.Reto4G14.Modelo.Score;
import com.example.Reto4G14.Interface.ScoreInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreInterface scoreInterface;
    public List<Score> getAll(){
        return (List<Score>)  scoreInterface.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreInterface.findById(id);
    }
    public Score save(Score c){
        return  scoreInterface.save(c);
    }
    public void delete(Score c){
        scoreInterface.delete(c);
    }
}

