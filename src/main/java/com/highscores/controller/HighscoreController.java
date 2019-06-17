package com.highscores.controller;

import com.highscores.exceptions.ResourceNotFoundException;
import com.highscores.model.Highscore;
import com.highscores.service.HighscoreServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HighscoreController {

    @Autowired // Marks field to be injected with the repository
    private HighscoreServiceI highscoreService;

    @GetMapping("/") // maps HTTP request with a desired path
    public String index(){
        return "index";
    }

    @GetMapping("/highscores")
    public List<Highscore> getAllHighscores(){
        return highscoreService.findAll();
    }

    @PostMapping("/highscores")
    public Highscore createHighScore(@Valid @RequestBody Highscore highscore) {
        return highscoreService.save(highscore);
    }

    @GetMapping("/highscores/{id}")
    public Highscore getHighscoreById(@PathVariable(value = "id") Long highscoreId) {
        return highscoreService.findById(highscoreId)
                .orElseThrow(() -> new ResourceNotFoundException("Highscore", "id", highscoreId));
    }

    // Update a highscore
    @PutMapping("/highscores/{id}")
    public Highscore updateHighscore(@PathVariable(value = "id") Long highscoreId, @Valid @RequestBody Highscore highscoreDetails) {
        Highscore highscore = highscoreService.findById(highscoreId)
                .orElseThrow(() -> new ResourceNotFoundException("Highscore", "id", highscoreId));

        highscore.setName(highscoreDetails.getName());
        highscore.setScore(highscoreDetails.getScore());

        return highscoreService.save(highscore);
    }

    // Delete a highscore
    @DeleteMapping("/highscores/{id}")
    public ResponseEntity<Highscore> deleteHighscore(@PathVariable(value = "id") Long highscoreId) {
        Highscore highscore = highscoreService.findById(highscoreId)
                .orElseThrow(() -> new ResourceNotFoundException("Highscore", "id", highscoreId));

        highscoreService.delete(highscore);

        return ResponseEntity.ok().build();
    }
}
