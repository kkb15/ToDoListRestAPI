package com.example.ToDo_App.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDo_App.model.TodoItem;

public interface TodoRepo extends JpaRepository<TodoItem, Long> {

	Optional<TodoItem> findById(Integer id);

}
