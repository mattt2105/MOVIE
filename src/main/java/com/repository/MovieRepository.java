package com.repository;

import com.domain.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository <MovieModel, Integer> {
    List<MovieModel> findAll();

    MovieModel findAllById(Integer id);
}
