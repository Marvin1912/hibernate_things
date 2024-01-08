package com.marvin.hibernate.service.persistence_context;

import com.marvin.hibernate.repository.ChildEntityRepository;
import com.marvin.hibernate.repository.ParentEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Supplier;

@Component
public class DataProcessor {

    private final ParentEntityRepository parentEntityRepository;
    private final ChildEntityRepository childEntityRepository;

    public DataProcessor(
            ParentEntityRepository parentEntityRepository,
            ChildEntityRepository childEntityRepository
    ) {
        this.parentEntityRepository = parentEntityRepository;
        this.childEntityRepository = childEntityRepository;
    }

    @Transactional(Transactional.TxType.REQUIRED)
//    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public long fetchDataEntity() {
        return fetchDataEntity(childEntityRepository::findAll);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public long fetchDataDto() {
        return fetchDataEntity(childEntityRepository::findBy);
    }

    private <T> long fetchDataEntity(Supplier<List<T>> childrenSupplier) {

        childrenSupplier.get();

        final Instant start = Instant.now();
        final List<Integer> ids = parentEntityRepository.getAllIds();
        for (final Integer id : ids) {
            parentEntityRepository.getReferenceById(id);
        }

        return Duration.between(start, Instant.now()).toMillis();
    }
}
