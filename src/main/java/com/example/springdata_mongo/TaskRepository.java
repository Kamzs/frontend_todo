package com.example.springdata_mongo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, String> {

    List<Task> findAllByFire (String fire);

}
