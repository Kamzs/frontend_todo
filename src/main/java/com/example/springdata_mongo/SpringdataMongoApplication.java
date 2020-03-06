package com.example.springdata_mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdataMongoApplication implements CommandLineRunner {

    @Autowired
    private TaskRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringdataMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

    }
}
