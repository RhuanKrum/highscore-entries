package com.highscores.repository;

import com.highscores.model.Highscore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighscoreRepository extends CrudRepository<Highscore, Long> {

    public List<Highscore> findAllByOrderByScoreDesc();
}
