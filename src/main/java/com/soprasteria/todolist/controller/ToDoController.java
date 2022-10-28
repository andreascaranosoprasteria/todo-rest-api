package com.soprasteria.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.todolist.controller.repository.ToDoRepository;
import com.soprasteria.todolist.model.ToDo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ToDoController {

	@Autowired
	ToDoRepository repository;

	// ritorna lista delle tasks
	@GetMapping("/todo")
	public List<ToDo> getAllTasks() {
		return (List<ToDo>) repository.findAll();
	}

	// aggiunge una task
	@PostMapping("/add")
	public ToDo createTask(@RequestBody ToDo element) {
		return repository.save(element);
	}

	// cerca task per id
	@GetMapping("/todo/{id}")
	public ToDo getTaskById(@PathVariable(value = "id") int id) {
		Optional<ToDo> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		else
			return new ToDo();
	}

	// elimina task per id
	@DeleteMapping("/todo/delete/{id}")
	public void deleteTaskById(@PathVariable(value = "id") int id) {
		repository.deleteById(id);
	}

	
	//cambio descrizione alla task
	@PutMapping("/todo/update-description/{id}") 
	public ToDo updateTask(
			@PathVariable (value = "id") int id,
			@RequestBody ToDo todo) {
		Optional<ToDo> t=repository.findById(id);
		if(t.isPresent()) {
			ToDo t1=t.get();
			t1.setDescription(todo.getDescription());
			return repository.save(t1);
		} else
			return null;
	}
	
	//dichiaro come fatto la task
	@PutMapping("/todo/mark-done/{id}") 
	public ToDo markAsDone(
			@PathVariable (value = "id") int id) {
		Optional<ToDo> t=repository.findById(id);
		if(t.isPresent()) {
			ToDo t1=t.get();
			t1.setDone(true);
			return repository.save(t1);
		} else
			return null;
	}
	

}
