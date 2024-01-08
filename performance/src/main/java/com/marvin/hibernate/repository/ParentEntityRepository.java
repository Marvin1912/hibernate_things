package com.marvin.hibernate.repository;

import com.marvin.hibernate.entity.ParentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentEntityRepository extends JpaRepository<ParentEntity, Integer> {
    @Query("SELECT r.id FROM ParentEntity r")
    List<Integer> getAllIds();

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
//    @Transactional(Transactional.TxType.REQUIRES_NEW)
    <S extends ParentEntity> S save(S entity);
}
