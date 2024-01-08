package com.marvin.hibernate.service;

import com.marvin.hibernate.entity.RootObject;
import com.marvin.hibernate.repository.AttributeRepository;
import com.marvin.hibernate.repository.RootObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SoftReference {

    private final AttributeRepository attributeRepository;
    private final RootObjectRepository rootObjectRepository;

    public SoftReference(AttributeRepository attributeRepository, RootObjectRepository rootObjectRepository) {
        this.attributeRepository = attributeRepository;
        this.rootObjectRepository = rootObjectRepository;
    }

    public void addRootObject() {

        RootObject rootObject = new RootObject();

//        rootObject.setPropertyOne("1");

        rootObject.setId(2);
        rootObject.setPropertyOne("1");

        rootObjectRepository.save(rootObject);

    }

    private RootObject getRootObject() {
        return rootObjectRepository.findById(2).orElse(null);
    }

}
