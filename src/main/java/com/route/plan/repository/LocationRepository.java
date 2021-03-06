package com.route.plan.repository;

import com.route.plan.domain.Location;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LocationRepository extends CrudRepository<Location, Long> {

    @Override
    @Transactional
    <S extends Location> S save(S item);

    @Transactional
    @Modifying
    @Query("DELETE FROM Location l WHERE l.id=:id")
    void delete(@Param("id") long id);

    Location findLocationById(@Param("id") long id);

    Iterable<Location> findAllById(Iterable<Long> var1);
}
