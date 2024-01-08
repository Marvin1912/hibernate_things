package com.marvin.hibernate.repository;

import com.marvin.hibernate.entity.RootObject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RootObjectRepository extends JpaRepository<RootObject, Integer> {

    @Query("SELECT r.id FROM RootObject r")
    List<Integer> getAllIds();

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    <S extends RootObject> S save(S entity);

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    Optional<RootObject> findById(Integer integer);

}
