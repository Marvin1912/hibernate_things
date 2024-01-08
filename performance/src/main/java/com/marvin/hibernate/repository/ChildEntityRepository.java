package com.marvin.hibernate.repository;

import com.marvin.hibernate.dto.ChildDTO;
import com.marvin.hibernate.entity.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildEntityRepository extends JpaRepository<ChildEntity, Integer> {
    List<ChildDTO> findBy();
}
