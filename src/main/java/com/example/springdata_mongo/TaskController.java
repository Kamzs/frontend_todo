package com.example.springdata_mongo;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/mongo")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/findAll")
    public ResponseEntity<List<Task>> findall(){
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity addSingle(@RequestBody Task task){
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @PutMapping("/update")
    public ResponseEntity updateSingle (@RequestBody Task task){
        taskRepository.deleteById(task.id);
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteSingle (@RequestParam String id){
        taskRepository.deleteById(id);
        return ResponseEntity.ok(JSONParser.quote("deleted"));
    }

}