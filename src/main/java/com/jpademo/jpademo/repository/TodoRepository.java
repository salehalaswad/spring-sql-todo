package com.jpademo.jpademo.repository;

import com.jpademo.jpademo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface TodoRepository extends JpaRepository<Todo,Integer> {

}
