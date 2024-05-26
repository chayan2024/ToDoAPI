package org.example.todoapi.repository;

import org.example.todoapi.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDORepository extends JpaRepository<ToDo,Long> {

}
