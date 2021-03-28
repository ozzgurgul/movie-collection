package com.ozgur.ozgurflix.repository;

import com.ozgur.ozgurflix.entity.product.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Cast,Long> {


}
