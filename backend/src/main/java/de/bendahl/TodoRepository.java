package de.bendahl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository that handles all database access for the todo list items
 *
 * @author Benjamin Dahlmanns
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Transactional
    void deleteByDone(boolean done);
}
