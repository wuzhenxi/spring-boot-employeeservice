package com.wzx.it.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void createIndexForField(String field,String collecttionName){
        IndexOperations indexOperations = mongoTemplate.indexOps(collecttionName);
        Index index = new Index();
        index.on(field, Sort.Direction.ASC);
        indexOperations.ensureIndex(index);
    }
}
