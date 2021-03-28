package com.ozgur.ozgurflix.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ozgur.ozgurflix.entity.award.Oscar;
import com.ozgur.ozgurflix.entity.enums.product.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Movie extends Product {


    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cast> castList;

    @OneToMany(mappedBy = "movie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Oscar> oscarList;

}
