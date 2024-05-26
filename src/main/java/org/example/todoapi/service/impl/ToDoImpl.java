package org.example.todoapi.service.impl;

import lombok.AllArgsConstructor;
import org.example.todoapi.dto.ToDoDTo;
import org.example.todoapi.entity.ToDo;
import org.example.todoapi.repository.ToDORepository;
import org.example.todoapi.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToDoImpl implements ToDoService {

    private ToDORepository toDORepository;

    @Override
    public ToDoDTo addTodo(ToDoDTo toDoDTo) {

        //CONVERT TODODTO ENTITIY INTO TODO JOA ENTITY

        ToDo todo= new ToDo();
        todo.setTitle(todo.getTitle());
        todo.setDescription(todo.getDescription());
        todo.setCompleted(todo.isCompleted());

        // TODO JOA ENTITY
        ToDo saveTodo=toDORepository.save(todo);

        // CONVERT SAVED TODO JPA ENTITY ONJECT INTO TODODTO OBJECT

        ToDoDTo saveToDoDTo=new ToDoDTo();
        saveToDoDTo.setId(saveTodo.getId());
        saveToDoDTo.setTitle(saveTodo.getTitle());
        saveToDoDTo.setDescription(saveTodo.getDescription());
        saveToDoDTo.setCompleted(saveTodo.isCompleted());

        return saveToDoDTo;
    }

    @Override
    public List<ToDoDTo> getAllTodos() {
        return List.of();
    }
}
