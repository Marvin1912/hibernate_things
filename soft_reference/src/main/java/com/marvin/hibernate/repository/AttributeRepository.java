package com.marvin.hibernate.repository;

import com.marvin.hibernate.dto.AttributeDTO;
import com.marvin.hibernate.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
    List<AttributeDTO> findBy();
}
