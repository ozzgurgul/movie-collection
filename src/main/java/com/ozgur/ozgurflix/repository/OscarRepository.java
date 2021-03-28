package com.ozgur.ozgurflix.repository;

import com.ozgur.ozgurflix.entity.award.Oscar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OscarRepository extends JpaRepository<Oscar,Long> {

}
