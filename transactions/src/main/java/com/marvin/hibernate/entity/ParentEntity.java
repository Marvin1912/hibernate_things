package com.marvin.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "parent_entity", schema = "transactions")
@SequenceGenerator(
        name = "parent_entity_seq_tx",
        sequenceName = "parent_entity_seq_tx",
        schema = "transactions",
        allocationSize = 1
)
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_entity_seq_tx")
    @Column(name = "id")
    private int id;

    @Column(name = "property_one")
    private String propertyOne;

    @Column(name = "property_two")
    private String propertyTwo;

    public ParentEntity() {
        // NOOP
    }

    public ParentEntity(String propertyOne, String propertyTwo) {
        this.propertyOne = propertyOne;
        this.propertyTwo = propertyTwo;
    }

    public ParentEntity(int id, String propertyOne, String propertyTwo) {
        this.id = id;
        this.propertyOne = propertyOne;
        this.propertyTwo = propertyTwo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyOne() {
        return propertyOne;
    }

    public void setPropertyOne(String propertyOne) {
        this.propertyOne = propertyOne;
    }

    public String getPropertyTwo() {
        return propertyTwo;
    }

    public void setPropertyTwo(String propertyTwo) {
        this.propertyTwo = propertyTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ParentEntity that = (ParentEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
