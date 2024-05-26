package org.example.todoapi.service;

import org.example.todoapi.dto.ToDoDTo;
import org.example.todoapi.entity.ToDo;

import java.util.List;

public interface ToDoService {

    ToDoDTo addTodo(ToDoDTo todo);
    List<ToDoDTo> getAllTodos();

}
