package com.marvin.hibernate.service.persistence_context;

import com.marvin.hibernate.repository.ChildEntityRepository;
import com.marvin.hibernate.repository.ParentEntityRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Supplier;

@Component
public class DataProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataProcessor.class);

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
    public BigDecimal fetchDataEntity() {
        return doIteration(childEntityRepository::findAll);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public BigDecimal fetchDataDto() {
        return doIteration(childEntityRepository::findBy);
    }

    private <T> BigDecimal fetchDataEntity(Supplier<List<T>> childrenSupplier) {

        childrenSupplier.get();

        final Instant start = Instant.now();
        final List<Integer> ids = parentEntityRepository.getAllIds();
        for (final Integer id : ids) {
            parentEntityRepository.getReferenceById(id);
        }

        return BigDecimal.valueOf(
                Duration.between(start, Instant.now()).toNanos()
        ).divide(BigDecimal.valueOf(1000 * 1000), 2, RoundingMode.HALF_UP);
    }

    private <T> BigDecimal doIteration(Supplier<List<T>> childrenSupplier) {

        List<T> list = childrenSupplier.get();

        final Instant start = Instant.now();
        for (final T t : list) {

        }


//        final List<Integer> ids = parentEntityRepository.getAllIds();
//        for (final Integer id : ids) {
//            parentEntityRepository.getReferenceById(id);
//        }

        return BigDecimal.valueOf(
                Duration.between(start, Instant.now()).toNanos()
        ).divide(BigDecimal.valueOf(1000 * 1000), 2, RoundingMode.HALF_UP);
    }
}
