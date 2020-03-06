package com.example.springdata_mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "task")
public class Task {

    @Id
    public String id;

    public String name;
    public Date created;
    public Date done;

    public Task() {}


}
