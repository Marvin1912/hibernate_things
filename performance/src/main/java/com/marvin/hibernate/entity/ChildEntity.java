package com.marvin.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "child_entity", schema = "performance")
@SequenceGenerator(
        name = "child_entity_seq_pf",
        sequenceName = "child_entity_seq_pf",
        schema = "performance",
        allocationSize = 1
)
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_entity_seq_pf")
    @Column(name = "id")
    private int id;

    @Column(name = "property_one")
    private String propertyOne;

    @Column(name = "property_two")
    private String propertyTwo;

    @ManyToOne
    @JoinColumn(name = "parent_entity")
    private ParentEntity parentEntity;

    public ChildEntity() {
        // NOOP
    }

    public ChildEntity(String propertyOne, String propertyTwo) {
        this.propertyOne = propertyOne;
        this.propertyTwo = propertyTwo;
    }

    public ChildEntity(int id, String propertyOne, String propertyTwo) {
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

    public ParentEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(ParentEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ChildEntity that = (ChildEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
