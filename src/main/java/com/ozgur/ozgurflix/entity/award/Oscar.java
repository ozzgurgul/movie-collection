package com.ozgur.ozgurflix.entity.award;

import com.ozgur.ozgurflix.entity.award.Award;
import com.ozgur.ozgurflix.entity.enums.award.OscarEnum;
import com.ozgur.ozgurflix.entity.product.Actor;
import com.ozgur.ozgurflix.entity.product.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Oscar extends Award {


    @Enumerated(EnumType.STRING)
    private OscarEnum oscarEnum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

}
