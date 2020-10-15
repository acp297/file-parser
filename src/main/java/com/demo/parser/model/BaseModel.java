package com.demo.parser.model;

public interface BaseModel {
    void appendObject(BaseModel object);
    void deleteObject(BaseModel object);
    void modifyObject(BaseModel object);
}
