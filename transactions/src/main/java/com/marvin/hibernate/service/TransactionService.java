package com.marvin.hibernate.service;

import com.marvin.hibernate.entity.ParentEntity;
import com.marvin.hibernate.repository.ParentEntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    o.s.orm.jpa.JpaTransactionManager        : Participating in existing transaction
 */

@Service
public class TransactionService {

    private final EntityManager entityManager;
    private final ParentEntityRepository parentEntityRepository;

    public TransactionService(
            EntityManager entityManager,
            ParentEntityRepository parentEntityRepository
    ) {
        this.entityManager = entityManager;
        this.parentEntityRepository = parentEntityRepository;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveAll() {

        final List<ParentEntity> parentEntities = IntStream.range(0, 5).boxed()
                .map(i -> new ParentEntity("a", "b"))
                .collect(Collectors.toList());

        parentEntityRepository.saveAllInNewTx(parentEntities);

        SessionImpl session = entityManager.unwrap(SessionImpl.class);
        org.hibernate.engine.spi.PersistenceContext persistenceContext = session.getPersistenceContext();
        System.out.println(persistenceContext.getEntitiesByKey());

    }
}
