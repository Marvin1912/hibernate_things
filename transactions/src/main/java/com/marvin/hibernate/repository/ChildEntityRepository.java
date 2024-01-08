package com.marvin.hibernate.repository;

import com.marvin.hibernate.entity.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildEntityRepository extends JpaRepository<ChildEntity, Integer> {

}
