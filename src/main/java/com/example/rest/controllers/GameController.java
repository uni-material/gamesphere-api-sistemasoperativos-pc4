package com.example.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.models.Game;
import com.example.rest.repositories.GameRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/game")
public class GameController {
    
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/")
    List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    Game getGame(@PathVariable String id){
        return gameRepository.findById(id).orElse(null);
    }
    
    @PostMapping("/")
    Game getGame(@RequestBody Game game){
        return gameRepository.save(game);
    }

    @PutMapping("/{id}")
    Game getGame(@PathVariable String id, @RequestBody Game game){ 
        return gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    String deleteGame(@PathVariable String id){
        gameRepository.deleteById(id);
        return id;
    }


}
