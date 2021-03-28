package com.ozgur.ozgurflix.service;

import com.ozgur.ozgurflix.entity.product.Movie;
import com.ozgur.ozgurflix.entity.enums.product.Category;
import com.ozgur.ozgurflix.entity.enums.product.Language;
import com.ozgur.ozgurflix.entity.enums.product.Media;
import com.ozgur.ozgurflix.repository.MovieRepository;
import com.ozgur.ozgurflix.response.movie.MovieAward;
import com.ozgur.ozgurflix.response.movie.MovieCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepository;


    public ResponseEntity<Movie> createMovie(String name, long publishedDate,String director, Category category, Media media, Language language){

        Movie movie = new Movie();

        movie.setCategory(category);
        movie.setPublishedDate(publishedDate);
        movie.setName(name);
        movie.setLanguage(language);
        movie.setMedia(media);
        movie.setDirector(director);

        movieRepository.save(movie);

        return ResponseEntity.status(HttpStatus.OK).body(movie);

    }

    public List<MovieCast> listCastByMovieId(long movieId){


        Movie movie = movieRepository.findById(movieId);

        List<MovieCast> movieCasts = new ArrayList<>();

        for(int i=0;i<movie.getCastList().size();i++){

            MovieCast movieCast = new MovieCast();

            movieCast.setActorName(movie.getCastList().get(i).getActor().getName());
            movieCast.setActorSurname(movie.getCastList().get(i).getActor().getSurname());
            movieCast.setActorRole(movie.getCastList().get(i).getCharacterName());

            movieCasts.add(movieCast);


        }
        return movieCasts;

    }

    public List<MovieAward> listAwardsByMovieId(long movieId){

        Movie movie = movieRepository.findById(movieId);
        List<MovieAward> movieAwards = new ArrayList<>();

        for(int i =0; i<movie.getOscarList().size();i++){

            MovieAward movieAward = new MovieAward();
            movieAward.setMovieName(movie.getOscarList().get(i).getMovie().getName());
            movieAward.setMovieCategory(String.valueOf(movie.getOscarList().get(i).getMovie().getCategory()));
            movieAward.setAwardName(movie.getOscarList().get(i).getName());
            movieAward.setAwardYear(String.valueOf(movie.getOscarList().get(i).getYear()));
            movieAward.setAwardCategory(String.valueOf(movie.getOscarList().get(i).getOscarEnum()));

            movieAwards.add(movieAward);
        }
        return movieAwards;
    }

    public List<Movie> findAllByOrderAsc(){

        return movieRepository.findAllByOrderByPublishedDateAsc();
    }
    public List<Movie> findAllByOrderDesc(){

        return movieRepository.findAllByOrderByPublishedDateDesc();
    }


    public ResponseEntity<Object> deleteMovie(long id) {

        if (movieRepository.findById(id) == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found with id : " + id);

        }
        movieRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted");
    }
    public Movie findMovieByName(String movie_name){

        return movieRepository.findByName(movie_name);
    }

    public List<Movie> findMovieByCategory(Category category){

        return movieRepository.findMovieByCategory(category);
    }
    public List<Movie> findMovieByLanguage(Language language){

        return movieRepository.findMovieByLanguage(language);
    }

    public ResponseEntity<Object> updateMovie(String name, long publishedDate, Category category, Media media, Language language ){

        Movie movie = movieRepository.findByName(name);

        movie.setCategory(category);
        movie.setLanguage(language);
        movie.setPublishedDate(publishedDate);
        movieRepository.save(movie);

        return ResponseEntity.status(HttpStatus.OK).body("Movie updated");

    }

}
