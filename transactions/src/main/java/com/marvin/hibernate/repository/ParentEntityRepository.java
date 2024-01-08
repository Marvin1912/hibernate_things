package com.marvin.hibernate.repository;

import com.marvin.hibernate.entity.ParentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentEntityRepository extends JpaRepository<ParentEntity, Integer> {
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    default <S extends ParentEntity> List<S> saveAllInNewTx(Iterable<S> entities) {
        return this.saveAll(entities);
    }
}
