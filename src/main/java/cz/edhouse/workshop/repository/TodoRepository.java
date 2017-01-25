package cz.edhouse.workshop.repository;

import cz.edhouse.workshop.entity.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Frantisek Spacek
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface TodoRepository extends CrudRepository<Todo, Integer> {

    @Override
    List<Todo> findAll();

    List<Todo> findAllByCompletedIsTrue();
}
