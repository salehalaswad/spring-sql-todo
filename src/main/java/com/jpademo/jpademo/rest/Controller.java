package com.jpademo.jpademo.rest;

import com.jpademo.jpademo.model.Todo;
import com.jpademo.jpademo.service.IService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    @Qualifier("todo") // because we have more than one Service that implements @IService
    private IService service; //code to the interface (always) :)


    @GetMapping("/todos")
    public List<Todo> getAll() {
        return service.findAll();
    }


    @RequestMapping(path = "/todos/{id}", method = RequestMethod.GET)
    public Todo getTodo(@PathVariable int id) {
        Todo todo = service.findById(id);
        if (todo == null)
            throw new RuntimeException("id not found => " + id);
        return todo;
    }


    @RequestMapping(path = "/todos", method = RequestMethod.POST)
    public Todo addTodo(@RequestBody Todo todo) {
        todo.setId(0); // this is to force a save of new item instead of update
        service.save(todo);
        return todo;
    }

    @RequestMapping(path = "/todos" , method = RequestMethod.DELETE)
    public void deleteTodo(@RequestBody LinkedHashMap<String, Integer> todo) {
        service.deleteById(todo.get("id"));
    }
}
