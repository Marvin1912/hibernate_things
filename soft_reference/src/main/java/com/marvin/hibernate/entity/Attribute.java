package com.marvin.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "attribute")
public class Attribute {

    @Id
    @GeneratedValue(generator = "attribute_seq")
    @SequenceGenerator(name = "attribute_seq", sequenceName = "attribute_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "property_one")
    private String propertyOne;

    @Column(name = "property_two")
    private String propertyTwo;

    @Column(name = "property_three")
    private String propertyThree;

    @Column(name = "property_four")
    private String propertyFour;

    @ManyToOne
    @JoinColumn(name = "root_object")
    private RootObject rootObject;

    public Attribute() {
        // NOOP
    }

    public Attribute(int id, String propertyOne) {
        this.id = id;
        this.propertyOne = propertyOne;
    }

    public Attribute(String propertyOne) {
        this.propertyOne = propertyOne;
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

    public String getPropertyThree() {
        return propertyThree;
    }

    public void setPropertyThree(String propertyThree) {
        this.propertyThree = propertyThree;
    }

    public String getPropertyFour() {
        return propertyFour;
    }

    public void setPropertyFour(String propertyFour) {
        this.propertyFour = propertyFour;
    }

    public RootObject getRootObject() {
        return rootObject;
    }

    public void setRootObject(RootObject rootObject) {
        this.rootObject = rootObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Attribute attribute = (Attribute) o;
        return id == attribute.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
