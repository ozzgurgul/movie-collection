package com.ozgur.ozgurflix.controller;

import com.ozgur.ozgurflix.entity.enums.award.OscarEnum;
import com.ozgur.ozgurflix.service.OscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/oscar")
public class OscarController {

    @Autowired
    private OscarService oscarService;

@PostMapping("/{movieId}/{name}/{year}/{oscarEnum}")
    public ResponseEntity<Object> addOscarToActor(@PathVariable long movieId,@PathVariable String name,@PathVariable long year, @PathVariable OscarEnum oscarEnum){

        return oscarService.addOscarToMovie(movieId, name, year, oscarEnum);

    }

}
