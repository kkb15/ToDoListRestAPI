package com.example.ToDo_App.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ToDo_App.model.TodoItem;
import com.example.ToDo_App.repo.TodoRepo;

@RestController
@RequestMapping(value="/todo")
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    // Retrieve all tasks
    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepo.findAll();
    }

    // Add a new task
    @PostMapping("/add")
    public TodoItem save(@RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    // Retrieve a single task by ID
    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> findById(@PathVariable Long id) {
        return todoRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a task
    @PutMapping("/update/{id}")
    public TodoItem update(@RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    // Delete a task
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return todoRepo.findById(id).map(existingItem -> {
                    todoRepo.delete(existingItem);
                    System.out.println("deleted successfully");
                    return ResponseEntity.ok().<Void>build() ;
                    
                })
                .orElse(ResponseEntity.notFound().build());
        
    }

    
}