package com.vhsn.todolist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vhsn.todolist.Model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
