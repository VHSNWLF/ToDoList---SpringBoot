package com.vhsn.todolist.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vhsn.todolist.Model.Todo;
import com.vhsn.todolist.Repository.TodoRepository;

import lombok.Data;

@Service
@Data
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    
    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }
    public List<Todo> update(Todo todo, Long id){
        todoRepository.deleteById(id);
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
