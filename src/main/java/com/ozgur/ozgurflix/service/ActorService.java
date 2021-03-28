package com.ozgur.ozgurflix.service;

import com.ozgur.ozgurflix.entity.product.Actor;
import com.ozgur.ozgurflix.repository.ActorRepository;
import com.ozgur.ozgurflix.response.actor.MovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;


    public ResponseEntity<Actor> addActor(String name, String surname){

        Actor actor = new Actor();

        actor.setName(name);
        actor.setSurname(surname);

        actorRepository.save(actor);

        return ResponseEntity.ok(actor);

    }

    public List<MovieList> getMovieList(long actorId){


        Actor actor = actorRepository.findByActorId(actorId);
        List<MovieList> movieLists = new ArrayList<>();

        for(int i=0;i<actor.getCastList().size();i++){

            MovieList movieList = new MovieList();

            movieList.setMovieName(actor.getCastList().get(i).getMovie().getName());
            movieList.setMovieCategory(actor.getCastList().get(i).getMovie().getCategory());
            movieList.setCharacterName(actor.getCastList().get(i).getCharacterName());
            movieLists.add(movieList);
        }

        return movieLists;
    }


}
