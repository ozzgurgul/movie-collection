package com.ozgur.ozgurflix.controller;


import com.ozgur.ozgurflix.entity.product.Movie;
import com.ozgur.ozgurflix.entity.enums.product.Category;
import com.ozgur.ozgurflix.entity.enums.product.Language;
import com.ozgur.ozgurflix.entity.enums.product.Media;
import com.ozgur.ozgurflix.response.movie.MovieAward;
import com.ozgur.ozgurflix.response.movie.MovieCast;
import com.ozgur.ozgurflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/create/{name}/{publishedDate}/{director}/{category}/{media}/{language}")
    public ResponseEntity<Movie> createMovie(@PathVariable String name, @PathVariable long publishedDate,@PathVariable String director ,@PathVariable Category category, @PathVariable Media media, @PathVariable Language language){

        return movieService.createMovie(name, publishedDate, director, category, media, language);
    }

    @GetMapping("/list/cast")
    public List<MovieCast> listCast(long movieId){

        return movieService.listCastByMovieId(movieId);
    }

    @GetMapping("/list/award")
    public  List<MovieAward> listAwards(long movieId){

        return movieService.listAwardsByMovieId(movieId);
    }

    @GetMapping("/asc")
    public List<Movie> findAllByOrderAsc(){

        return movieService.findAllByOrderAsc();
    }

    @GetMapping("/desc")
    public List<Movie> findAllByOrderDesc(){

        return movieService.findAllByOrderDesc();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable long id){

        return movieService.deleteMovie(id);

    }
    @GetMapping("/{movie_name}")
    public Movie findByName(@RequestParam(value="movie_name") String movie_name){

        return movieService.findMovieByName(movie_name);

    }

    @GetMapping("/{category}")
    public List<Movie> listByCategory(@RequestParam(value = "category") Category category){

        return movieService.findMovieByCategory(category);
    }
    @GetMapping("/{language}")
    public List<Movie> listByLanguage(@RequestParam(value = "language") Language language){

        return movieService.findMovieByLanguage(language);
    }
    @PutMapping("/update/{name}/{publishedDate}/{category}/{media}/{language}")
    public ResponseEntity<Object> updateMovie(String name, long publishedDate, Category category, Media media, Language language){

        return movieService.updateMovie(name, publishedDate, category, media, language);

    }

}
