package com.marvin.hibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "root_object")
public class RootObject {

    @Id
    @GeneratedValue(generator = "root_object_seq")
    @SequenceGenerator(name = "root_object_seq", sequenceName = "root_object_seq")
    private int id;

    @Column(name = "property_one")
    private String propertyOne;

    @Column(name = "property_two")
    private String propertyTwo;

    @Column(name = "property_three")
    private String propertyThree;

    @OneToMany(mappedBy = "rootObject", cascade = CascadeType.ALL)
    private List<Attribute> attributes;

    public RootObject() {
        this.attributes = new ArrayList<>();
    }

    public RootObject(int id, String propertyOne) {
        this.id = id;
        this.propertyOne = propertyOne;
    }

    public RootObject(String propertyOne) {
        this.attributes = new ArrayList<>();
        this.propertyOne = propertyOne;
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

    public String getPropertyThree() {
        return propertyThree;
    }

    public void setPropertyThree(String propertyThree) {
        this.propertyThree = propertyThree;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RootObject that = (RootObject) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
        attribute.setRootObject(this);
    }
}
