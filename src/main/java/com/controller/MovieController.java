package com.controller;

import com.domain.MovieModel;
import com.dto.MovieRequestDTO;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    MovieService service;

    @GetMapping("Movies")
    public ResponseEntity<List<MovieModel>>getAllMovies(){
        return service.getAllMovies();
    }

    @GetMapping("Movies/{id}")
    public ResponseEntity<MovieModel>getAllMovieById(
            @PathVariable Integer id){
        return service.getAllById(id);
    }

    @PostMapping("Movies")
    public ResponseEntity<List<MovieRequestDTO>> postMovie(@RequestBody MovieRequestDTO dto){
        return service.postMovie(dto);
    }

    @PatchMapping("Movies")
    public ResponseEntity<List<MovieRequestDTO>> updateMovie(@RequestBody MovieRequestDTO dto){
        return service.updateMovie(dto);
    }

    @DeleteMapping("Movies/{id}")
    public ResponseEntity<MovieModel>deleteMovieById(
            @PathVariable Integer id){
        return service.deleteById(id);
    }
}
