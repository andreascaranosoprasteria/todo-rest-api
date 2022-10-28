package com.soprasteria.todolist.controller.repository;

import org.springframework.data.repository.CrudRepository;

import com.soprasteria.todolist.model.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Integer> {

}
