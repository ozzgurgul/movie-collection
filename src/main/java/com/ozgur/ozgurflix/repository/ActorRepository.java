package com.ozgur.ozgurflix.repository;

import com.ozgur.ozgurflix.entity.product.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    Actor findByActorId(long id);
    Actor findByName(String name);

}
