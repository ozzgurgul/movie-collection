package com.ozgur.ozgurflix.repository;

import com.ozgur.ozgurflix.entity.product.Movie;
import com.ozgur.ozgurflix.entity.enums.product.Category;
import com.ozgur.ozgurflix.entity.enums.product.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findById(long id);
    Movie findByName(String name);
    Movie deleteById(long id);
    List<Movie> findAllByOrderByPublishedDateAsc();
    List<Movie> findAllByOrderByPublishedDateDesc();
    List<Movie> findMovieByCategory(Category category);
    List<Movie> findMovieByLanguage(Language language);



}
