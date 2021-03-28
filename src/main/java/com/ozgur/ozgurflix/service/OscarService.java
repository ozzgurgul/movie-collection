package com.ozgur.ozgurflix.service;

import com.ozgur.ozgurflix.entity.award.Oscar;
import com.ozgur.ozgurflix.entity.enums.award.OscarEnum;
import com.ozgur.ozgurflix.entity.product.Actor;
import com.ozgur.ozgurflix.entity.product.Movie;
import com.ozgur.ozgurflix.repository.ActorRepository;
import com.ozgur.ozgurflix.repository.MovieRepository;
import com.ozgur.ozgurflix.repository.OscarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OscarService {

    @Autowired
    private OscarRepository oscarRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;


    public ResponseEntity<Object> addOscarToMovie(long movieId, String name, long year, OscarEnum oscarEnum){

        Movie movie = movieRepository.findById(movieId);

        Oscar oscar = new Oscar();
        oscar.setName(name);
        oscar.setYear(year);
        oscar.setOscarEnum(oscarEnum);
        oscar.setMovie(movie);

        oscarRepository.save(oscar);
        return ResponseEntity.status(HttpStatus.CREATED).body("Oscar added");

    }
}
