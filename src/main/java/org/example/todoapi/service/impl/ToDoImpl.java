package org.example.todoapi.service.impl;

import lombok.AllArgsConstructor;
import org.example.todoapi.dto.ToDoDTo;
import org.example.todoapi.entity.ToDo;
import org.example.todoapi.repository.ToDORepository;
import org.example.todoapi.service.ToDoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ToDoImpl implements ToDoService {

    private ToDORepository toDORepository;

    private ModelMapper modelMapper;

    @Override
    public ToDoDTo addTodo(ToDoDTo toDoDTo) {

        // Convert ToDoTo into TDO JPA entity

        ToDo todo = modelMapper.map(toDoDTo,ToDo.class);

        //TODO JPA Entity
        ToDo saveTodo=toDORepository.save(todo);

        // Convert saved Todo Jpa object  into TODODTo object

        ToDoDTo saveToDoDTo = modelMapper.map(saveTodo,ToDoDTo.class);

        return saveToDoDTo;
    }

    @Override
    public List<ToDoDTo> getAllTodos() {

        List<ToDo> todos = toDORepository.findAll();
        return  todos.stream().map((toDo) -> modelMapper.map(toDo,ToDoDTo.class)).collect(Collectors.toList());
    }

    @Override
    public ToDoDTo getTodoById(Long id) {
        ToDo todo= toDORepository.findById(id).orElseThrow(()->new RuntimeException("Not found with this Id"+id));
        return modelMapper.map(todo,ToDoDTo.class);
    }

    @Override
    public ToDoDTo updateTodo(Long id, ToDoDTo todo) {
        ToDo todoUpdate= toDORepository.findById(id).orElseThrow(()->new RuntimeException("Not found with this Id"+id));
        todoUpdate.setTitle(todo.getTitle());
        todoUpdate.setDescription(todo.getDescription());
        todoUpdate.setCompleted(todo.isCompleted());
        ToDo updatedTodo=toDORepository.save(todoUpdate);
        return modelMapper.map(updatedTodo,ToDoDTo.class);
    }

    @Override
    public void deleteTodo(Long id) {
        ToDo todo= toDORepository.findById(id).orElseThrow(()->new RuntimeException("Not found with this Id"+id));
        toDORepository.deleteById(id);
    }

    @Override
    public ToDoDTo completeTodo(Long id) {
        ToDo todo= toDORepository.findById(id).orElseThrow(()->new RuntimeException("Not found with this Id"+id));
        todo.setCompleted(true);
        ToDo updatedTodo=toDORepository.save(todo);
        return modelMapper.map(updatedTodo,ToDoDTo.class);
    }
}
