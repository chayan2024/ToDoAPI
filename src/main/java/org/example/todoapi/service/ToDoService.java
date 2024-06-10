package org.example.todoapi.service;

import java.util.List;

import org.example.todoapi.dto.ToDoDTo;

public interface ToDoService {

    ToDoDTo addTodo(ToDoDTo todo);
    List<ToDoDTo> getAllTodos();
    ToDoDTo getTodoById(Long id);
    ToDoDTo updateTodo(Long id,ToDoDTo todo);
    void deleteTodo(Long id);
    ToDoDTo completeTodo(Long id);
}
