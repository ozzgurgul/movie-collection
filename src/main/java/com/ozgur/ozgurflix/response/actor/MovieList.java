package com.ozgur.ozgurflix.response.actor;

import com.ozgur.ozgurflix.entity.enums.product.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieList {

    private String movieName;
    private String characterName;
    private Category movieCategory;

}
