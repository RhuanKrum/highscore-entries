package com.highscores.service;

import com.highscores.model.Highscore;
import com.highscores.repository.HighscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighscoreService implements HighscoreServiceI{

    @Autowired // Marks field to be injected with the repository
    private HighscoreRepository highscoreRepository;

    @Override
    public List<Highscore> findAll(){
        return highscoreRepository.findAllByOrderByScoreDesc();
    }
}
