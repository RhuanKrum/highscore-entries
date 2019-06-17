package com.highscores.service;

import com.highscores.model.Highscore;
import com.highscores.repository.HighscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HighscoreService implements HighscoreServiceI{

    @Autowired // Marks field to be injected with the repository
    private HighscoreRepository highscoreRepository;

    @Override
    public List<Highscore> findAll(){
        return highscoreRepository.findAllByOrderByScoreDesc();
    }

    @Override
    public Highscore save(Highscore highscore){
        return highscoreRepository.save(highscore);
    }

    @Override
    public Optional<Highscore> findById(Long id){
        return highscoreRepository.findById(id);
    }

    @Override
    public void delete(Highscore highscore) {
        highscoreRepository.delete(highscore);
    }
}
