package com.ozgur.ozgurflix.entity.product;

import com.ozgur.ozgurflix.entity.award.Award;
import com.ozgur.ozgurflix.entity.award.Oscar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actorId;

    private String name;
    private String surname;


    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cast> castList;

}
