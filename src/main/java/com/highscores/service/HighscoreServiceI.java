package com.highscores.service;

import com.highscores.model.Highscore;

import java.util.List;

public interface HighscoreServiceI {

    List<Highscore> findAll();
}
