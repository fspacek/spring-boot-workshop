package cz.edhouse.workshop.service;

import cz.edhouse.workshop.entity.Todo;
import java.util.List;

/**
 *
 * @author Frantisek Spacek
 */
public interface TodoService {

    List<Todo> getAll(boolean completed);

    Todo save(Todo todo);

    Todo complete(int id);

    void delete(int id);
}
