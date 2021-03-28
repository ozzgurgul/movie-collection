package com.ozgur.ozgurflix.service;

import com.ozgur.ozgurflix.entity.product.Actor;
import com.ozgur.ozgurflix.entity.product.Cast;
import com.ozgur.ozgurflix.entity.product.Movie;
import com.ozgur.ozgurflix.repository.ActorRepository;
import com.ozgur.ozgurflix.repository.CastRepository;
import com.ozgur.ozgurflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CastService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CastRepository castRepository;

    public ResponseEntity<Object> addCast(long movieId,Long actorId,String characterName){

        Movie movie = movieRepository.findById(movieId);
        Actor actor = actorRepository.findByActorId(actorId);

        Cast cast = new Cast();

        cast.setActor(actor);
        cast.setCharacterName(characterName);
        cast.setMovie(movie);
        castRepository.save(cast);

        return ResponseEntity.status(HttpStatus.OK).body("Cast added");

    }

}
