package cz.edhouse.workshop.service;

import cz.edhouse.workshop.entity.Todo;
import cz.edhouse.workshop.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAll(boolean completed) {
        return completed ? todoRepository.findAllByCompletedIsTrue() : todoRepository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo complete(int id) {
        final Todo todo = todoRepository.findOne(id);
        todo.setCompleted(true);
        return todoRepository.save(todo);
    }

    @Override
    public void delete(int id) {
        todoRepository.delete(id);
    }

}
