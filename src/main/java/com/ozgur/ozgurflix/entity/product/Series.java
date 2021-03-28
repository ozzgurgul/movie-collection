package com.ozgur.ozgurflix.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ozgur.ozgurflix.entity.enums.product.Category;
import com.ozgur.ozgurflix.entity.product.Cast;
import com.ozgur.ozgurflix.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Series extends Product {

    private String season;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cast> castList;
}
