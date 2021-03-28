package com.ozgur.ozgurflix.entity.award;

import com.ozgur.ozgurflix.entity.award.Award;
import com.ozgur.ozgurflix.entity.enums.award.EmmyEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Emmy extends Award {


    @Enumerated(EnumType.STRING)
    private EmmyEnum emmyEnum;

}
