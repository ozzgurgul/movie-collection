package com.ozgur.ozgurflix.controller;


import com.ozgur.ozgurflix.entity.product.Actor;
import com.ozgur.ozgurflix.response.actor.MovieList;
import com.ozgur.ozgurflix.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {


    @Autowired
    private ActorService actorService;


    @PostMapping("/create/{name}/{surname}")
    public ResponseEntity<Actor> createActor(@PathVariable String name, @PathVariable String surname){

            return actorService.addActor(name,surname);

    }

    @GetMapping("/list/movie/{actorId}")
    public List<MovieList> listMovies(@PathVariable long actorId){

            return actorService.getMovieList(actorId);

    }
}
