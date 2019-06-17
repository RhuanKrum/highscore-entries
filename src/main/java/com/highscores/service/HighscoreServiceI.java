package com.highscores.service;

import com.highscores.model.Highscore;

import java.util.List;
import java.util.Optional;

public interface HighscoreServiceI {

    List<Highscore> findAll();

    Highscore save(Highscore highscore);

    Optional<Highscore> findById(Long id);

    void delete(Highscore highscore);
}
