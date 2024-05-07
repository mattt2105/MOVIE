package com.service;

import com.domain.MovieModel;
import com.dto.MovieRequestDTO;
import com.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public ResponseEntity<List<MovieModel>>getAllMovies(){
        try{
            List<MovieModel> datas = repository.findAll();
            if (datas != null){
                return ResponseEntity.status(HttpStatus.OK).body(datas);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<MovieModel>getAllById(Integer id){
        try {
            MovieModel data = repository.findAllById(id);
            if (data != null){
                return ResponseEntity.status(HttpStatus.OK).body(data);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<List<MovieRequestDTO>>postMovie(MovieRequestDTO dto){
        if (dto.getId() == null || dto.getId() == 0 || dto.getId().equals("")){
            return new ResponseEntity("format id salah",HttpStatus.BAD_REQUEST);
        }
        
        try{
            MovieModel data = repository.findAllById(dto.getId());

            if (data != null){
                data.setTitle(dto.getTitle());
                data.setDescription(dto.getDescription());
                data.setRating(dto.getRating());
                data.setImage(dto.getImage());
                data.setCreated_at(dto.getCreated_at());
                data.setUpdated_at(dto.getUpdated_at());
                repository.save(data);

            }else{
                MovieModel newData = new MovieModel();
                newData.setId(dto.getId());
                newData.setTitle(dto.getTitle());
                newData.setDescription(dto.getDescription());
                newData.setRating(dto.getRating());
                newData.setImage(dto.getImage());
                newData.setCreated_at(dto.getCreated_at());
                newData.setUpdated_at(dto.getUpdated_at());
                repository.save(newData);
            }

            return new ResponseEntity(dto,HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<List<MovieRequestDTO>>updateMovie(MovieRequestDTO dto){
        if (dto.getId() == null || dto.getId() == 0 || dto.getId().equals("")){
            return new ResponseEntity("format id salah",HttpStatus.BAD_REQUEST);
        }
        
        try{
            MovieModel data = repository.findAllById(dto.getId());

            if (data != null){
                data.setTitle(dto.getTitle());
                data.setDescription(dto.getDescription());
                data.setRating(dto.getRating());
                data.setImage(dto.getImage());
                data.setCreated_at(dto.getCreated_at());
                data.setUpdated_at(dto.getUpdated_at());
                repository.save(data);

                return new ResponseEntity(dto,HttpStatus.OK);

            }else{
                return new ResponseEntity("Id tidak ditemukan",HttpStatus.OK);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<MovieModel>deleteById(Integer id){
        try{
            MovieModel data = repository.findAllById(id);

            if (data != null){
                repository.delete(data);

                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity("Id tidak ditemukan",HttpStatus.OK);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
