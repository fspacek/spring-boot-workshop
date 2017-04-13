package cz.edhouse.workshop.web;

import cz.edhouse.workshop.entity.Todo;
import cz.edhouse.workshop.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Frantisek Spacek
 */
@RestController
@RequestMapping("api/todo")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TodoResource {

    private final TodoService todoService;

    @Autowired
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<Todo> getAll(boolean completed) {
        return todoService.getAll(completed);
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping(path = "{id}")
    public Todo update(@PathVariable("id") int id, @RequestBody Todo todo) {
        todo.setId(id);
        return todoService.save(todo);
    }

    @PutMapping(path = "{id}/complete")
    public Todo complete(@PathVariable("id") int id) {
        return todoService.complete(id);
    }

    @PostMapping(path = "{id}")
    public void delete(@PathVariable("id") int id) {
        todoService.delete(id);
    }
}
