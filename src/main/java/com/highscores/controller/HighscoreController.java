package com.highscores.controller;

import com.highscores.model.Highscore;
import com.highscores.service.HighscoreServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HighscoreController {

    @Autowired // Marks field to be injected with the repository
    private HighscoreServiceI highscoreService;

    @RequestMapping("/") // maps HTTP request with a desired path
    public String index(Highscore highscore){
        return "index";
    }

    @RequestMapping("/highscores") // maps HTTP request with a desired path
    public ModelAndView showCities(){
        var highscores = highscoreService.findAll();

        Map<String, Object> params = new HashMap<>();
        params.put("highscores", highscores);

        return new ModelAndView("showHighscores", params);
    }
}
