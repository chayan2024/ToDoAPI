package org.example.todoapi.controller;

import lombok.AllArgsConstructor;
import org.example.todoapi.dto.ToDoDTo;
import org.example.todoapi.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   @GetMapping("{id}")
    public ResponseEntity<?> getTodo(@PathVariable("id") long id){
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
