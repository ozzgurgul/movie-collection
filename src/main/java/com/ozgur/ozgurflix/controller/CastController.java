package com.ozgur.ozgurflix.controller;


import com.ozgur.ozgurflix.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cast")
public class CastController {

    @Autowired
    private CastService castService;

    @PostMapping("/add/{movieId}/{actorId}/{characterName}")
    public ResponseEntity<Object> addCast(@PathVariable long movieId, @PathVariable Long actorId, @PathVariable String characterName){

        return castService.addCast(movieId,actorId,characterName);
    }


}

