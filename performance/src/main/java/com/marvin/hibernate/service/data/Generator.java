package com.marvin.hibernate.service.data;

import com.marvin.hibernate.entity.ChildEntity;
import com.marvin.hibernate.entity.ParentEntity;
import com.marvin.hibernate.repository.ChildEntityRepository;
import com.marvin.hibernate.repository.ParentEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class Generator {

    private final ParentEntityRepository parentEntityRepository;
    private final ChildEntityRepository childEntityRepository;

    public Generator(
            ParentEntityRepository parentEntityRepository,
            ChildEntityRepository childEntityRepository
    ) {
        this.parentEntityRepository = parentEntityRepository;
        this.childEntityRepository = childEntityRepository;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public long generateRootObjects(int parentAmount, int childAmount) {

        for (int i = 0; i < parentAmount; i++) {

            final ParentEntity parentEntity = new ParentEntity("one_p " + i, "two_p " + i);
            parentEntityRepository.save(parentEntity);

            for (int a = 0; a < childAmount; a++) {
                final ChildEntity childEntity = new ChildEntity("one_c " + i, "two_c " + i);
                childEntity.setParentEntity(parentEntity);
                childEntityRepository.save(childEntity);
            }
        }

        long rootObjects = parentEntityRepository.count();
        long attributes = childEntityRepository.count();

        return rootObjects + attributes;
    }
}
