package org.example.todoapi.service;

import org.example.todoapi.dto.ToDoDTo;
import org.example.todoapi.entity.ToDo;

import java.util.List;

public interface ToDoService {

    ToDoDTo addTodo(ToDoDTo todo);
    List<ToDoDTo> getAllTodos();
    ToDoDTo getTodoById(Long id);
    ToDoDTo updateTodo(Long id,ToDoDTo todo);
    void deleteTodo(Long id);
    ToDoDTo completeTodo(Long id);
}
