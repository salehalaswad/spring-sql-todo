package com.jpademo.jpademo.service;

import com.jpademo.jpademo.model.Todo;
import com.jpademo.jpademo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("todo") // because we have more than one Service that implements @IService
public class TodoService implements IService {
    @Autowired
   private TodoRepository todoDao;
    @Override
    public List<Todo> findAll() {
        return todoDao.findAll();
    }
    @Override
    public Todo findById(int id) {
        return todoDao.findById(id).orElse(null);
    }

    @Override
    public void save(Todo todo) {
      todoDao.save(todo);
    }

    @Override
    public void deleteById(int id) {
       todoDao.deleteById(id);
    }
}
