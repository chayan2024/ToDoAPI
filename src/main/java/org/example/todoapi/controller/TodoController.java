package org.example.todoapi.controller;
import java.util.List;

import org.example.todoapi.dto.ToDoDTo;
import org.example.todoapi.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private ToDoService toDoService;

    // Build Add TOdo REST API

    @PostMapping
    public ResponseEntity<ToDoDTo> addTodo(@RequestBody ToDoDTo todo) {
        ToDoDTo savedDto =toDoService.addTodo(todo);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

   @GetMapping("{id}")
    public ResponseEntity<ToDoDTo> getTodo(@PathVariable("id") long id){
        ToDoDTo toDoDTo=toDoService.getTodoById(id);
        return new ResponseEntity<>(toDoDTo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ToDoDTo>> getAllToDOs(){
        List<ToDoDTo> toDoDTos=toDoService.getAllTodos();
        return ResponseEntity.ok(toDoDTos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") long id){
        toDoService.deleteTodo(id);
        return ResponseEntity.ok("TODo successfully deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<ToDoDTo> updateTodo(@PathVariable("id") long id, @RequestBody ToDoDTo todo){
        ToDoDTo updatedTodo = toDoService.updateTodo(id, todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @PatchMapping("{id}/completed")
    public ResponseEntity<ToDoDTo> isCompleted(@PathVariable("id") long id){
        ToDoDTo toDoDTo=toDoService.completeTodo(id);
        return ResponseEntity.ok(toDoDTo);
    }

}
