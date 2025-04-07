package com.vhsn.todolist.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vhsn.todolist.Model.Todo;
import com.vhsn.todolist.Service.TodoService;

import lombok.Data;


@RestController
@RequestMapping("/todos")
@Data
public class TodoController {
    @Autowired
    private TodoService todoService;
    
    @PostMapping("/create")
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }

    @GetMapping("/list")
    List<Todo> list(Todo todo){
        return todoService.list();
    }

    @PutMapping("/update/{id}")
    List<Todo> update(@RequestBody Todo todo, @PathVariable("id") Long id){
        return todoService.update(todo, id);
    }

    @DeleteMapping ("/delete/{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
