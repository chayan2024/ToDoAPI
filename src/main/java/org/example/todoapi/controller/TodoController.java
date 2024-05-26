package org.example.todoapi.controller;

import lombok.AllArgsConstructor;
import org.example.todoapi.dto.ToDoDTo;
import org.example.todoapi.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private ToDoService toDoService;

    // Build Add TOdo REST API

    @PostMapping
    public ResponseEntity<?> addTodo(@RequestBody ToDoDTo todo) {
        ToDoDTo savedDto =toDoService.addTodo(todo);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }
}
