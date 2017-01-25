package cz.edhouse.workshop.web;

import cz.edhouse.workshop.entity.Todo;
import cz.edhouse.workshop.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getAll(boolean completed) {
        return todoService.getAll(completed);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Todo update(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") int id) {
        todoService.delete(id);
    }
}
