package com.ozgur.ozgurflix.entity.product;

import com.ozgur.ozgurflix.entity.enums.product.Language;
import com.ozgur.ozgurflix.entity.enums.product.Media;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long publishedDate;
    private String director;

    @Enumerated(EnumType.STRING)
    private Media media;

    @Enumerated(EnumType.STRING)
    private Language language;

}
