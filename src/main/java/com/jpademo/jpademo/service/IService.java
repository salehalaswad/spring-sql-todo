package com.jpademo.jpademo.service;

import com.jpademo.jpademo.model.Todo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IService {
    List<Todo> findAll();
    Todo findById(int id);
    void save(Todo todo);
    void deleteById(int id);
}
