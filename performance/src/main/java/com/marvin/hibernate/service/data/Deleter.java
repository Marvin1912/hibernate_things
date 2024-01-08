package com.marvin.hibernate.service.data;

import com.marvin.hibernate.repository.ChildEntityRepository;
import com.marvin.hibernate.repository.ParentEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class Deleter {

    private final ParentEntityRepository parentEntityRepository;
    private final ChildEntityRepository childEntityRepository;

    public Deleter(
            ParentEntityRepository parentEntityRepository,
            ChildEntityRepository childEntityRepository
    ) {
        this.parentEntityRepository = parentEntityRepository;
        this.childEntityRepository = childEntityRepository;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void truncateAll() {
        childEntityRepository.deleteAll();
        parentEntityRepository.deleteAll();
    }
}
